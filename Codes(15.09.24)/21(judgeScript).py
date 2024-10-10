import sys
def solve(n):
    ip = []
    for _ in range(n):
        ip.append(sys.stdin.readline())
    return ''.join(ip)

temp = 0
while True:
    n = int(sys.stdin.readline().strip())
    if n == 0:
        break
    src = solve(n)
    dst = solve(int(sys.stdin.readline().strip()))
    temp += 1
    print(f"Run #{temp}: ", end="")
    if src == dst:
        print("Accepted")
    else:
        src = ''.join(filter(str.isdigit, src))
        dst = ''.join(filter(str.isdigit, dst))
        if src == dst:
            print("Presentation Error")
        else:
            print("Wrong Answer")