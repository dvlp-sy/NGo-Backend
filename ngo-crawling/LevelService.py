from config import LEVEL_COOKIE
import requests
from flask import Flask, request, jsonify
import time
from bs4 import BeautifulSoup
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.common.action_chains import ActionChains

MAX_WAIT_TIME = 20

app2 = Flask(__name__)

def compare(n1, n2) :
    if n1["level"] > n2["level"] : 
        return True
    else :
        return False

def scroll_down(driver):
    driver.execute_script("window.scrollTo(0, 50);")

def waitClick(driver, xpath) :
    checkBox = WebDriverWait(driver, MAX_WAIT_TIME).until(
        EC.visibility_of_element_located((By.XPATH, xpath))
    )
    checkBox.click()

def fetchLevel(title, contents, driver) :
    url = "https://www.kread.ai/"

    data = driver.get(url)
    WebDriverWait(driver, MAX_WAIT_TIME)
    driver.maximize_window()

    waitClick(driver, '/html/body/header/button')
    waitClick(driver, '//*[@id="gnb"]/ul/li[2]/strong')
    waitClick(driver, '//*[@id="gnb"]/ul/li[2]/ul/li[1]/a')

    ### Form 작성
    driver.execute_script("window.scrollTo(0, 100)")
    check1 = driver.find_element(By.XPATH, '//*[@id="frm"]/fieldset/dl/dd[1]/div[5]/label')
    check2 = driver.find_element(By.XPATH, '//*[@id="frm"]/fieldset/dl/dd[2]/div[2]/label')
    check3 = driver.find_element(By.XPATH, '//*[@id="title"]')
    check4 = driver.find_element(By.XPATH, '//*[@id="contents"]')
    submit = driver.find_element(By.XPATH, '//*[@id="regSubmit"]')

    ActionChains(driver).move_to_element(check1).click(check1).perform()
    time.sleep(1)
    ActionChains(driver).move_to_element(check2).click(check2).perform()
    time.sleep(1)

    ActionChains(driver).move_to_element(check3).click(check3)
    time.sleep(3)
    ActionChains(driver).send_keys(title).perform()
    time.sleep(3)

    ActionChains(driver).move_to_element(check4)
    time.sleep(3)
    ActionChains(driver).send_keys(contents).perform()
    time.sleep(5)

    ActionChains(driver).move_to_element(submit).click().perform()
    time.sleep(10)

    
    
    

    '''
    driver.find_element(By.CSS_SELECTOR, "#frm > fieldset > dl > dd:nth-child(2) > div:nth-child(5) > label").click()
    time.sleep(1)
    driver.find_element(By.CSS_SELECTOR, "#frm > fieldset > dl > dd:nth-child(4) > div:nth-child(2) > label").click()
    time.sleep(1)
    

    '''
    
    ### Parsing Result
    html = driver.page_source
    soup = BeautifulSoup(html, "html.parser")

    return soup.select_one("#kreadScore").text


@app2.route("/getLevel", methods=["GET"])
def get_level() :
    # 정치 = 100 | 경제 = 101 | 사회 = 102 | 생활/문화 = 103 | 과학 = 105
    query = request.args.get("category")

    header = {
        "User-Agent" : "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/124.0.0.0 Safari/537.36",
        "Cookie" : LEVEL_COOKIE
    }

    chrome_options = Options()
    #chrome_options.add_argument("--headless") # 화면 표시 X
    chrome_options.add_argument(f"--user-agent={header['User-Agent']}")
    chrome_options.add_argument(f"--cookie={header['Cookie']}")

    driver = webdriver.Chrome(options=chrome_options)

    if query :
        result = []

        # getNews (by Category)
        url = f"http://localhost:8001/getNews?category={query}"
        response = requests.get(url)
        if response.status_code == 200 :
            data = response.json()

            # result 추출 및 level에 따른 내림차순 정렬
            newsList = data["news"]
            for news in newsList :
                title = news["title"]
                contents = news["contents"]
                level = fetchLevel(title, contents, driver)
                result.append(
                    {
                        "title" : title,
                        "contents" : contents,
                        "media" : news["media"],
                        "editor" : news["editor"],
                        "thumbnail" : news["thumbnail"],
                        "level" : level
                    }
                )
        
        return sorted(result, key=lambda x: x["level"])
    


### Run Flask
if __name__ == "__main__" :
    app2.run(port = 8002, debug=True)