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

@app.route('/toilet', methods=['GET','POST'])
def toilet():
    return "Toilet"

@app.route('/kitchen', methods=['GET','POST'])
def Kitchen():
    return "Kitchen"

@app.route('/exit', methods=['GET','POST'])
def exit():
    return "Exit door"

if __name__ == "__main__":
    app.run(host="0.0.0.0", port=5000, debug=True)
