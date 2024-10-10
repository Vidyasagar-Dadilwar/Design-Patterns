from collections import Counter
import sys

def solve(line1, line2):
    count1 = Counter(line1)
    count2 = Counter(line2)

    longest = []
    for char in count1.keys() & count2.keys(): 
        min_count = min(count1[char], count2[char])
        longest.append(char * min_count)

    return ''.join(sorted(longest)) 

input = sys.stdin.read
data = input().strip().splitlines()
for i in range(0, len(data), 2):
    line1 = data[i].strip()
    line2 = data[i + 1].strip()
    result = solve(line1, line2)
    print(result)