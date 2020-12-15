from flask import Flask

app = Flask(__name__)

app.route('/', methods=['GET','POST'])
def test():
    return "Success"

app.run(host="0.0.0.0", port=5000, debug=True)
