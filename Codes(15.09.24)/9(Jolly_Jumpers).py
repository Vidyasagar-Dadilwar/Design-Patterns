# PC/UVa IDs: 110201/10038,

def solve(seq):
    n = seq[0]
    if n == 1:
        return "Jolly"
    diff = set(abs(seq[i] - seq[i + 1]) for i in range(1, n))
    res = set(range(1, n))    
    if diff == res:
        return "Jolly"
    else:
        return "Not jolly"

import sys

for line in sys.stdin:
    seq = list(map(int, line.split()))
    print(solve(seq))