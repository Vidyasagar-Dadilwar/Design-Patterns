from collections import deque, defaultdict
def adja(a, b):
    if len(a) != len(b):
        return False
    diffCnt = sum(1 for x, y in zip(a, b) if x != y)
    return diffCnt == 1
def getGraph(dict):
    graph = defaultdict(set)
    dict = sorted(set(dict), key=len)    
    grouped = defaultdict(list)
    for word in dict:
        grouped[len(word)].append(word)
    for word in dict:
        for candidate in grouped[len(word)]:
            if adja(word, candidate):
                graph[word].add(candidate)
    return graph
def find(graph, fromw, tow):
    if fromw.lower() == tow.lower():
        return [fromw, tow]
    queue = deque([fromw])
    visited = {fromw}
    parent = {fromw: fromw}
    while queue:
        curr_word = queue.popleft()
        for adja_word in graph[curr_word]:
            if adja_word not in visited:
                visited.add(adja_word)
                queue.append(adja_word)
                parent[adja_word] = curr_word
                if tow in parent:
                    path = []
                    curr = tow
                    while curr != fromw:
                        path.append(curr)
                        curr = parent[curr]
                    path.append(fromw)
                    return path[::-1]  
    return None
dict = []
while True:
    line = input().strip()
    if line == "":
        break
    dict.append(line)
graph = getGraph(dict)
line = 0
while True:
    ip = input().strip()
    if ip == "":
        break
    if line > 0:
        print()
    fromw, tow = ip.split()
    result = find(graph, fromw, tow)
    if result is None:
        print("No solution.")
    else:
        print("\n".join(result))
    line += 1