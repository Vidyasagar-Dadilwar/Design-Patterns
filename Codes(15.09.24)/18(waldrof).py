class WheresWaldorf:
    def __init__(self, n, m, table):
        self.n = n
        self.m = m
        self.table = table
        self.directions = [(1, 0), (-1, 0), (0, 1), (0, -1), 
                           (1, 1), (-1, -1), (-1, 1), (1, -1)]

    def find(self, word):
        for i in range(self.n):
            for j in range(self.m):
                for di, dj in self.directions:
                    if self.check(di, dj, i, j, word):
                        return [i + 1, j + 1]
        return None

    def check(self, di, dj, i, j, word):
        pos = 0
        while (0 <= i < self.n and 0 <= j < self.m and 
               pos < len(word) and self.table[i][j] == word[pos]):
            j += dj
            i += di
            pos += 1
        return pos == len(word)

import sys
input = sys.stdin.read
data = input().strip().splitlines()

cases = int(data[0].strip())
index = 1
results = []

for _ in range(cases):
    if index >= len(data): break
    nm = list(map(int, data[index].strip().split()))
    n, m = nm[0], nm[1]
    index += 1
    
    table = [data[index + i].strip().lower() for i in range(n)]
    index += n
    
    words_count = int(data[index].strip())
    index += 1
    
    words = [data[index + i].strip().lower() for i in range(words_count)]
    index += words_count
    
    ww = WheresWaldorf(n, m, table)
    for word in words:
        result = ww.find(word)
        results.append(" ".join(map(str, result)) if result else "")
    
    if _ < cases - 1:
        results.append("")  # Blank line between cases

print("\n".join(results))