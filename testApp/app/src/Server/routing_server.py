from flask import Flask, jsonify

app = Flask(__name__)

@app.route('/<start>/<end>', methods=['GET', 'POST'])
def route(start, end):
    coords = []
    a_star = _AStarSearch(start, end, coords)
    return jsonify({"coordinates": a_star})

def _AStarSearch(start, end, coords, h = None):
    map_view = [coords]
    if start not in map_view:
        return None
    if start == end:
        return [start]
    if h is None:
        h = heuristic(start, end)
    explored = set()
    expanded = {h: {start: [start]}}
    while len(expanded) > 0:
        best_path = min(expanded.keys())
        next_expansion = expanded[best_path]
        if end in next_expansion:
            return next_expansion[end]
        next_node = next_expansion.popitem()
        while len(next_expansion) > 0 and next_node[0] in explored:
            next_node = next_expansion.popitem()
        if len(next_expansion) == 0:
            del expanded[best_path]
        if next_node[0] not in explored:
            explored.add(next_node[0])
            expansion_ends = [node for node in map_view[next_node[0]].items() if node[0] not in explored]
            while len(expansion_ends) > 0:
                exp_ends = expansion_ends.pop()
                estimated_distance = best_path - h(next_node[0], end) + exp_ends[1] + h(exp_ends[0], end)
                if estimated_distance in expanded:
                    expanded[estimated_distance][exp_ends[0]] = next_node[1] + [exp_ends[0]]
                else:
                    expanded[estimated_distance] = {exp_ends[0]: next_node[1] + [exp_ends[0]]}
        return None

def heuristic(num, num2):
    n = int(num)
    n1 = int(num2)
    return abs(n1 + 5) ** abs(n - 5)

def Main():
    app.run(host="0.0.0.0", port=5000, debug=True)

@app.route('/route', methods=['GET', 'POST'])
def json():
    p = [1231, 124566, 98735]
    return jsonify({"points": p})

@app.route('/table', methods=['GET', 'POST'])
def table():
    return "Table"

@app.route('/office', methods=['GET', 'POST'])
def office():
    return "Office"

@app.route('/bar', methods=['GET', 'POST'])
def bar():
    return "Bar"

@app.route('/toilet', methods=['GET', 'POST'])
def toilet():
    return "Toilet"

@app.route('/kitchen', methods=['GET', 'POST'])
def kitchen():
    return "Kitchen"

@app.route('/exit', methods=['GET', 'POST'])
def exit_door():
    return "Exit door"

if __name__ == "__main__":
    Main()
