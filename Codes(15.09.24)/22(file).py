import sys
def fit(frags, candidate):
    temp = frags.copy()
    for i in range(1, len(candidate)):
        if not temp:
            break
        prefix = candidate[:i]
        suffix = candidate[i:]
        temp = [x for x in temp if x.lower() != prefix.lower()]
        temp = [x for x in temp if x.lower() != suffix.lower()]
    return not temp
def restore(frags):
    frags.sort(key=len)
    largest = frags[-1]
    smallest = [x for x in frags if len(x) == len(frags[0])]
    
    for small in smallest:
        if fit(frags, largest + small):
            return largest + small
        elif fit(frags, small + largest):
            return small + largest
    return "Impossible"
n = int(sys.stdin.readline().strip())
sys.stdin.readline()  
results = []
for _ in range(n):
    frags = []
    while True:
        try:
            s = sys.stdin.readline().strip()
            if not s:
                break
            frags.append(s)
        except EOFError:
            break
    results.append(restore(frags))
    if _ < n - 1:
        results.append("")  
print("\n".join(results))