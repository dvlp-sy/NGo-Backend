import os
import threading
import requests
from flask import Flask, request, jsonify
from dotenv import load_dotenv


app = Flask(__name__)

lock = threading.Lock()

def getLevel(query, high, mid, low) :
    response = requests.get(f"http://news-server-02:8002/getLevel?category={query}")
    if (response.status_code == 200) :
        data = response.json()
        newsList = data["news"]
        
        high.append(newsList[0])
        mid.append(newsList[len(data)//2])
        low.append(newsList[len(data)-1])

@app.route("/selectNews", methods=["GET"])
def select_news() :
    high = []
    mid = []
    low = []

    thread_1 = threading.Thread(target=getLevel, args=(100, high, mid, low))
    thread_2 = threading.Thread(target=getLevel, args=(101, high, mid, low))
    thread_3 = threading.Thread(target=getLevel, args=(102, high, mid, low))
    thread_4 = threading.Thread(target=getLevel, args=(103, high, mid, low))
    thread_5 = threading.Thread(target=getLevel, args=(105, high, mid, low))

    thread_1.start()
    thread_2.start()
    thread_3.start()
    thread_4.start()
    thread_5.start()

    thread_1.join()
    thread_2.join()
    thread_3.join()
    thread_4.join()
    thread_5.join()

    

    ### Logic




    return jsonify(
        {
            "high" : high,
            "mid" : mid,
            "low" : low
        }
    )
    
### Run Flask
if __name__ == "__main__" :
    port = int(os.environ.get("PORT", 8003))
    app.run(host="0.0.0.0", port=port)