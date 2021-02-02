from flask import Flask

app = Flask(__name__)

@app.route('/', methods=['GET','POST'])
def test():
    return "Connected"

@app.route('/table', methods=['GET','POST'])
def table():
    return "Table"

@app.route('/office', methods=['GET','POST'])
def office():
    return "Office"

@app.route('/bar', methods=['GET','POST'])
def bar():
    return "Bar"

@app.route('/Toilet', methods=['GET','POST'])
def toilet():
    return "Toilet"

@app.route('/Kitchen', methods=['GET','POST'])
def toilet():
    return "Kitchen"

@app.route('/exit_door', methods=['GET','POST'])
def toilet():
    return "Exit door"

app.run(host="0.0.0.0", port=5000, debug=True)
