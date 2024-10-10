# PC/UVa IDs: 110103/10137,

def solve(n, l):
    total = sum(l)
    avg = total / n
    
    give = 0.0
    receive = 0.0

    for expense in l:
        if expense < avg:
            give += int((avg - expense) * 100) / 100.0
        elif expense > avg:
            receive += int((expense - avg) * 100) / 100.0
    
    return max(give, receive)

while True:
    n = int(input())
    if n == 0:
        break
    
    l = [float(input()) for _ in range(n)]
    
    result = solve(n, l)
    
    print(f"${result:.2f}")