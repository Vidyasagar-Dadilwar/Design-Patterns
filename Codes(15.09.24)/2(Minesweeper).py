# PC/UVa IDs: 110102/10189, 

def cnt(field, row, col, n, m):
    dir = [(-1, 0), (1, 0), (0, -1), (0, 1), (-1, -1), (-1, 1), (1, -1), (1, 1)]
    mineCnt = 0

    for dr, dc in dir:
        nr, nc = row + dr, col + dc
        if 0 <= nr < n and 0 <= nc < m and field[nr][nc] == '*':
            mineCnt += 1

    return mineCnt

def solve(field, n, m):
    result = []
    
    for i in range(n):
        l = []
        for j in range(m):
            if field[i][j] == '*':
                l.append('*')
            else:
                mineCnt = cnt(field, i, j, n, m)
                l.append(str(mineCnt))
        result.append("".join(l))
    
    return result

tmp = 0
while True:
    n, m = map(int, input().split())    
    if n == 0 and m == 0:
        break  
    tmp += 1
    field = [input().strip() for _ in range(n)]
    
    result = solve(field, n, m)
    if tmp > 1:
        print()  
    
    print(f"Field #{tmp}:")
    for row in result:
        print(row)