import sys
from collections import deque

MAX = 1000000
lengths = [0] * MAX

def get(index, surplus):
    if index < MAX:
        return lengths[index]
    return surplus.get(index, 0)

def set(index, value, surplus):
    if index < MAX:
        lengths[index] = value
    else:
        surplus[index] = value

def initialize_collatz():
    surplus = {}
    lengths[1] = 1
    for i in range(2, MAX):
        stack = deque()
        n = i
        length = 2
        while n != 1:
            stack.append(n)
            prev = get(n, surplus)
            if prev > 0:
                length = prev
                break
            n = n // 2 if n % 2 == 0 else n * 3 + 1
        while stack:
            set(stack.pop(), length, surplus)
            length += 1

initialize_collatz()
for line in sys.stdin:
    line = line.strip()
    if not line:
        break
    x = list(map(int, line.split()))
    a, b = x[0], x[1]
    max_length = max(lengths[min(a, b):max(a, b) + 1])
    print(f"{a} {b} {max_length}")