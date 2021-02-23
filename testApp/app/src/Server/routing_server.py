from flask import Flask, jsonify
import numpy as np
from json import loads, dumps
app = Flask(__name__)

@app.route('/route', methods=['GET', 'POST'])
def route():
    restuarant = [[0, 1, 0, 0, 0, 0],
                  [0, 1, 0, 0, 0, 0],
                  [0, 1, 0, 1, 0, 1],
                  [0, 1, 0, 0, 0, 0],
                  [0, 0, 0, 0, 1, 0]]
    cost = 1
    start = readJSON(JSON)[0]
    end = readJSON(JSON)[1]
    route = _AStarSearch(restuarant, cost, start, end)
    print('\n'.join([''.join(["{:" ">3d}".format(item) for item in row]) for row in route]), '\n')
    #return jsonify({"path:", [0,0,0,0]})
    return dumps(path)

@app.route('/', methods=['GET','POST'])
def connect():
    return 'connected'

class Node:
    def __init__(self, parent, position):
        self.parent = parent
        self.position = position
        self.gCost = 0
        self.hCost = 0
        self.fCost = 0

    def __eq__(self, other):
        return self.position == other.position


Coordinates = {'A': [0, 0], 'B': [0, 2], 'C': [0, 3], 'D': [0, 4], 'E': [0, 5],
               'F': [1, 0], 'G': [1, 2], 'H': [1, 3], 'I': [1, 4], 'J': [1, 5],
               'K': [2, 0], 'L': [2, 2], 'M': [2, 4], 'N': [3, 0], 'O': [3, 2],
               'P': [3, 3], 'Q': [3, 4], 'R': [3, 5], 'S': [4, 0], 'T': [4, 1],
               'U': [4, 2], 'W': [4, 3], 'X': [4, 5]}
JSON = '{ "start": "C", "end": "O"}'
path = []

def readJSON(s):
    data = loads(s)
    for i in Coordinates.keys():
        if data["start"] == i:
            st = Coordinates[i]
    for j in Coordinates.keys():
        if data["end"] == j:
            en = Coordinates[j]
    return st, en

def _AStarSearch(restuarant, cost, start, end):
    start_node = Node(None, tuple(start))
    end_node = Node(None, tuple(end))
    start_node.gCost = start_node.hCost = start_node.fCost = 0
    end_node.gCost = end_node.hCost = end_node.fCost = 0
    unvisited_list = []
    visited_list = []
    unvisited_list.append(start_node)
    iterations = 0
    max_iterations = (len(restuarant) // 2) ** 10
    move = [[-1, 0],
            [0, -1],
            [1, 0],
            [0, 1]]
    rows, cols = np.shape(restuarant)
    while len(unvisited_list) > 0:
        iterations += 1
        current_node = unvisited_list[0]
        current_index = 0
        for index, item in enumerate(unvisited_list):
            if item.fCost < current_node.fCost:
                current_node = item
                current_index = index
        if iterations > max_iterations:
            return route_calculated(current_node, restuarant)
        unvisited_list.pop(current_index)
        visited_list.append(current_node)
        pathFinding(current_node.position)
        if current_node == end_node:
            return route_calculated(current_node, restuarant)
        adjacent_nodes = []
        for position in move:
            node_position = (current_node.position[0] + position[0], current_node.position[1] + position[1])
            if (node_position[0] > (rows - 1) or node_position[0] < 0 or node_position[1] > (cols - 1) or node_position[
                1] < 0):
                continue
            if restuarant[node_position[0]][node_position[1]] != 0:
                continue
            new_node = Node(current_node, node_position)
            adjacent_nodes.append(new_node)
        for adj in adjacent_nodes:
            if len([visited_adj for visited_adj in visited_list if visited_adj == adj]) > 0:
                continue
            adj.gCost = current_node.gCost + cost
            adj.hCost = (((adj.position[0] - end_node.position[0]) ** 2) + (
                    (adj.position[1] - end_node.position[1]) ** 2))
            adj.fCost = adj.gCost + adj.hCost
            if len([i for i in unvisited_list if adj == i and adj.gCost > i.gCost]) > 0:
                continue
            unvisited_list.append(adj)

def route_calculated(current_node, restuarant):
    route = []
    rows, cols = np.shape(restuarant)
    result = [[-1 for i in range(cols)] for j in range(rows)]
    current = current_node
    while current is not None:
        route.append(current.position)
        current = current.parent
    route = route[::-1]
    count = 0
    for i in range(len(route)):
        result[route[i][0]][route[i][1]] = count
        count += 1
    return result

def pathFinding(node):
    n = nodeID(node)
    return path.append(n)

def nodeID(n):
    node = list(n)
    for key, item in Coordinates.items():
        if node == item:
            return key

if __name__ == "__main__":
    app.run(host="0.0.0.0", port=5000, debug=True)