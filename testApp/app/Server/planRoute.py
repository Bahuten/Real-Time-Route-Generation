import jsonify
import math
import threading

class Room(object):
    def __init__(self,x,y):
        self.x = x
        self.y = y
        self.coord = []

    def get_pos(self):
        return self.x,self.y

    def get_coords(self):
        return self.coord

class Navigator(Room):
    def __init__(self, x, y):
        self._map = {}
        self.owned = []
        self._curPath = None
        self._goals = []

        def astar(self, start, target, heuristic=None):
            room = Room(10,10)
            if start not in self._map:
                return None
            if start == target:
                return [start]
            if heuristic is None: heuristic = lambda x, y: math.sqrt((x[0]-y[0])**2+(x[1]-y[1])**2)
            explored = set()
            expanded = {heuristic(start, target): {start: [start]}}
            while len(expanded) > 0:
                  bestPath = min(expanded.keys())
                  nextExpansion = expanded[bestPath]
                  if target in nextExpansion:
                    return nextExpansion[target]
                  nextNode = nextExpansion.popitem()
                  while len(nextExpansion) > 0 and nextNode[0] in explored:
                        nextNode = nextExpansion.popitem()
                  if len(nextExpansion) == 0:
                     del expanded[bestPath]
                  if nextNode[0] not in explored:
                     explored.add(nextNode[0])
                     expansionTargets = [node for node in self._map[nextNode[0]].items() if node[0] not in explored]
                     while len(expansionTargets) > 0:
                           expTgt = expansionTargets.pop()
                           estimatedDistance = bestPath-heuristic(nextNode[0],target)+expTgt[1]+heuristic(expTgt[0],target)
                           if estimatedDistance in expanded:
                              expanded[estimatedDistance][expTgt[0]] = nextNode[1]+[expTgt[0]]
                           else:
                              expanded[estimatedDistance] = {expTgt[0]: nextNode[1]+[expTgt[0]]}
            return None

def heuristic(x, y):
    x1, y1 = x
    x2, y2 = y
    return abs(x1 - x2) + (y1 - y2)

def planRoute(start, end, grid):
    count = 0
    explore = PriorityQueue()
    explore.put((0, count, start))
    came_from = {}
    g_score = {spot: float("inf") for row in grid for spot in row}
	g_score[start] = 0
	f_score = {spot: float("inf") for row in grid for spot in row}
	f_score[start] = heuristic(start.get_pos(), end.get_pos())

    open_set_hash = {start}

	while not explore.empty():
		current = explore.get()[2]
		open_set_hash.remove(current)

		for neighbor in current.neighbors:
			temp_g_score = g_score[current] + 1

			if temp_g_score < g_score[neighbor]:
				came_from[neighbor] = current
				g_score[neighbor] = temp_g_score
				f_score[neighbor] = temp_g_score + heuristic(neighbor.get_pos(), end.get_pos())
				if neighbor not in open_set_hash:
					count += 1
					explore.put((f_score[neighbor], count, neighbor))
					open_set_hash.add(neighbor)
	return False
