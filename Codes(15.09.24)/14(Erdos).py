import re
from collections import deque, defaultdict

ERDOS = "Erdos, P."

def add(graph, names):
    for curr_name in names:
        if curr_name not in graph:
            graph[curr_name] = set()
        for name in names:
            if curr_name != name:
                graph[curr_name].add(name)

def gnames(ip):
    npat = re.compile(r'[\w^.,]+,\s*(\w\.)+\s*[,:]')
    return [ip[m.start():m.end()-1].strip() for m in npat.finditer(ip)]

def ans(graph):
    q = deque([ERDOS])
    visited = set()
    result = {ERDOS: 0}

    while q:
        current = q.popleft()
        depth = result[current]
        for i in graph.get(current, []):
            if i not in visited:
                visited.add(i)
                q.append(i)
                result[i] = depth + 1
    return result
import sys
input = sys.stdin.read
data = input().strip().splitlines()

n = int(data[0])
index = 1
results = []
for sce in range(1, n + 1):
    p, q = map(int, data[index].split())
    index += 1
    
    graph = defaultdict(set)
    for _ in range(p):
        paper = data[index].strip()
        names = gnames(paper)
        add(graph, names)
        index += 1
    enum = ans(graph)
    
    results.append(f"sce {sce}")
    for _ in range(q):
        name = data[index].strip()
        en = enum.get(name, "infinity")
        results.append(f"{name} {en}")
        index += 1
print("\n".join(results))