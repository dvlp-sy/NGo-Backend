import requests
import time
from config import NEWS_COOKIE
from flask import Flask, request, jsonify
from bs4 import BeautifulSoup
from selenium import webdriver
from selenium.webdriver.chrome.options import Options

app1 = Flask(__name__)

@app1.route("/getNews", methods=["GET"])
def get_news() :
    # 정치 = 100 | 경제 = 101 | 사회 = 102 | 생활/문화 = 103 | 과학 = 105
    query = request.args.get("category")

    header = {
            "Referer" : f"https://news.naver.com/section/{query}",
            "Cookie" : NEWS_COOKIE,
            "User-Agent" : "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/124.0.0.0 Safari/537.36"
        }
    
    if query :
        chrome_options = Options()
        chrome_options.add_argument("--headless") # 화면 표시 X
        chrome_options.add_argument(f"--user-agent={header['User-Agent']}")
        chrome_options.add_argument(f"--cookie={header['Cookie']}")
        chrome_options.add_argument(f"--referer={header['Referer']}")

        driver = webdriver.Chrome(options=chrome_options)

        data = driver.get(f"https://news.naver.com/section/{query}")
        time.sleep(3)

        urlList = []
        for i in range(1, 11) :
            html = driver.page_source
            soup = BeautifulSoup(html, "html.parser")
            ul_tag = soup.find("ul", id=lambda x: x and x.startswith('_SECTION_HEADLINE_LIST_'))
            key = ul_tag["id"].split('_')[-1]

            a_href = soup.select_one(f"#_SECTION_HEADLINE_LIST_{key} > li:nth-child({i}) > div > div > div.sa_text > a")
            if a_href != None :
                url = a_href.get("href")
                urlList.append(url)
            else :
                url = None

        newsList = []
        for url in urlList :
            response = requests.get(url)
            if response.status_code == 200 :
                html = response.text
                soup = BeautifulSoup(html, "html.parser")

                media = soup.select_one("#ct > div.media_end_head.go_trans > div.media_end_head_top._LAZY_LOADING_WRAP > a > img.media_end_head_top_logo_img.light_type._LAZY_LOADING._LAZY_LOADING_INIT_HIDE")
                if media != None :
                    media = media.get("alt")
                else :
                    media = ""
                
                editor = soup.select_one("#ct > div.media_end_head.go_trans > div.media_end_head_info.nv_notrans > div.media_end_head_journalist > a > em")
                if editor != None : 
                    editor = editor.text
                else :
                    editor = ""

                title = soup.select_one("#title_area > span")
                if title != None : 
                    title = title.text
                else :
                    title = ""

                summary = soup.find("strong", class_="media_end_summary")
                if summary != None :
                    summary = summary.get_text().replace('<br>', '\n')
                else :
                    summary = ""

                contents = soup.find("article", id="dic_area")
                if contents != None :
                    contents = contents.get_text()
                else :
                    contents = ""

                thumbnail = soup.find("img", id="img1")
                if thumbnail != None :
                    thumbnail = thumbnail["data-src"]
                else :
                    thumbnail = ""

                newsList.append(
                    {
                        "title" : title,
                        "summary" : summary,
                        "contents" : contents,
                        "media" : media,
                        "editor" : editor,
                        "thumbnail" : thumbnail
                    }
                )
                

        return jsonify(
            {
                "news" : newsList
            }
        )
    

### Run Flask
if __name__ == "__main__" :
    app1.run(port=8001, debug=True)