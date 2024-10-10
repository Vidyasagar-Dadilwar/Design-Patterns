# PC/UVa IDs: 110203/10050

def solve(N, P, hartals):
    losts = set()  
    for h in hartals:
        for day in range(h, N + 1, h): 
            if day % 7 != 6 and day % 7 != 0:  
                losts.add(day)
    
    return len(losts)

for _ in range(int(input())):
    N = int(input()) 
    P = int(input())  
    hartals = [int(input()) for _ in range(P)]  
    result = solve(N, P, hartals)
    print(result)