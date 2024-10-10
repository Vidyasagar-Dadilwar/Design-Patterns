import sys

def calc(dice):
    dice.sort()
    tsum = sum(dice)
    points = [0] * 13
    cata = set()

    if len(set(dice)) == 2 and (dice.count(dice[0]) in {2, 3}): points[12], cata = 40, cata | {12}
    if max(dice) - min(dice) < 5 and len(set(dice)) == 5: points[11], cata = 35, cata | {11}
    if max(dice) - min(dice) < 4 and len(set(dice)) >= 4: points[10], cata = 25, cata | {10}
    if len(set(dice)) == 1: points[9], cata = 50, cata | {9}
    if max(dice.count(x) for x in dice) >= 4: points[8], cata = tsum, cata | {8}
    if max(dice.count(x) for x in dice) >= 3: points[7], cata = tsum, cata | {7}
    
    points[6], cata = tsum, cata | {6}
    for v in range(1, 7):
        if v in dice: points[v-1] = dice.count(v) * v; cata.add(v-1)

    return points, cata, tsum

def filt(cat, rnds):
    return [r for r in rnds if cat in r['cata']]

def total(solution):
    bonus = 35 if sum(solution[:6]) >= 63 else 0
    return [bonus, sum(solution) + bonus]

def solve(rnds):
    best_sol = [0] * 13
    best_res = [0, 0]
    
    for cat in range(12, 8, -1):
        dice = filt(cat, rnds)
        if dice:
            min_dice = min(dice, key=lambda x: x['tsum'])
            rnds.remove(min_dice)
            best_sol[cat] = min_dice['points'][cat]

    def srch(pos, rnds, solution):
        nonlocal best_sol, best_res
        if pos == -1:
            res = total(solution)
            if best_res[1] < res[1]: best_sol, best_res = solution[:], res[:]
            return
        for round in filt(pos, rnds):
            solution[pos] = round['points'][pos]
            rnds.remove(round)
            srch(pos - 1, rnds, solution)
            solution[pos] = 0
            rnds.append(round)
    srch(8, rnds, best_sol)
    return best_sol + best_res

idata = [list(map(int, line.split())) for line in sys.stdin if line.strip()]
rnds = [{'points': calc(dice)[0], 'cata': calc(dice)[1], 'tsum': calc(dice)[2]} for dice in idata]
res = solve(rnds)
print(' '.join(map(str, res)))