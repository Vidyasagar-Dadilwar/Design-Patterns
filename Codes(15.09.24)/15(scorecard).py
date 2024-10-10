import sys
from collections import defaultdict

def ttime(solved, total_time, penalties):
    return total_time + sum(penalties[i] for i in solved)

def uteam(parts, num, problem, time, verdict):
    if num not in parts:
        parts[num] = {'total_time': 0, 'solved': set(), 'penalties': [0] * 10}    
    team = parts[num]    
    if verdict == "C":
        if problem not in team['solved']:
            team['solved'].add(problem)
            team['total_time'] += time
    elif verdict == "I":
        if problem not in team['solved']:
            team['penalties'][problem] += 20

def fteam(num, team):
    return f"{num} {len(team['solved'])} {ttime(team['solved'], team['total_time'], team['penalties'])}"

input = sys.stdin.read
data = input().strip().splitlines()

cases = int(data[0])
index = 1
for _ in range(cases):
    parts = defaultdict(lambda: {'total_time': 0, 'solved': set(), 'penalties': [0] * 10})    
    while index < len(data) and data[index].strip() != "":
        parts = data[index].strip().split()
        num = int(parts[0])
        problem = int(parts[1])
        time = int(parts[2])
        verdict = parts[3]
        uteam(parts, num, problem, time, verdict)
        index += 1    
    sorted_teams = sorted(parts.items(), key=lambda t: (-len(t[1]['solved']), ttime(t[1]['solved'], t[1]['total_time'], t[1]['penalties']), t[0]))    
    for num, team in sorted_teams:
        print(fteam(num, team))    
    if index < len(data):
        print()    
    index += 1