# PC/UVa IDs: 110104/706
def get_d(digit):
    d = {
        '0': (1, 1, 0, 1, 1, 1, 1),
        '1': (0, 0, 0, 0, 0, 0, 0),
        '2': (1, 0, 1, 1, 1, 0, 1),
        '3': (1, 0, 1, 0, 1, 0, 1),
        '4': (0, 1, 1, 0, 0, 0, 1),
        '5': (1, 1, 1, 0, 0, 1, 1),
        '6': (1, 1, 1, 1, 1, 1, 1),
        '7': (1, 0, 0, 0, 0, 0, 0),
        '8': (1, 1, 1, 1, 1, 1, 1),
        '9': (1, 1, 1, 0, 0, 1, 1),
    }
    return d[digit]

def solve(digit, size):
    d = get_d(digit)
    top = ' ' + '-' * size + ' ' if d[0] else ' ' * (size + 2)
    upper = '|' + ' ' * size + '|' if d[1] and d[2] else ' ' * (size + 2)
    middle = ' ' + '-' * size + ' ' if d[3] else ' ' * (size + 2)
    lower = '|' + ' ' * size + '|' if d[4] and d[5] else ' ' * (size + 2)
    bottom = ' ' + '-' * size + ' ' if d[6] else ' ' * (size + 2)

    return [top, upper, middle, lower, bottom]

import sys

ip = sys.stdin.read().strip().splitlines()
for line in ip:
    s, n = line.split()
    s = int(s)
    n = n.strip()
    
    if s == 0 and n == '0':
        break
    
    lcd = []
    for digit in n:
        digit_lcd = solve(digit, s)
        if lcd:
            lcd = [line + ' ' for line in lcd] 
        for i in range(len(digit_lcd)):
            if i < len(lcd):
                lcd[i] += digit_lcd[i]
            else:
                lcd.append(digit_lcd[i])
    for line in lcd:
        print(line)
    print()  