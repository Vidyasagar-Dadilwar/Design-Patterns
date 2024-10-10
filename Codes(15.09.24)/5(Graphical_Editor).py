# PC/UVa IDs: 110105/10267

def imgs(m, n):
    return [['O' for _ in range(m)] for _ in range(n)]

def clrImgs(image):
    for row in image:
        for j in range(len(row)):
            row[j] = 'O'

def col(image, x, y, c):
    image[y - 1][x - 1] = c

def vertical(image, x, y1, y2, c):
    for y in range(y1 - 1, y2):
        image[y][x - 1] = c

def horizontal(image, x1, x2, y, c):
    for x in range(x1 - 1, x2):
        image[y - 1][x] = c

def rect(image, x1, y1, x2, y2, c):
    for y in range(y1 - 1, y2):
        for x in range(x1 - 1, x2):
            image[y][x] = c

def fill(image, x, y, new_color):
    original_color = image[y - 1][x - 1]
    if original_color == new_color:
        return
    stack = [(x - 1, y - 1)]
    while stack:
        cx, cy = stack.pop()
        if 0 <= cx < len(image[0]) and 0 <= cy < len(image):
            if image[cy][cx] == original_color:
                image[cy][cx] = new_color
                stack.append((cx + 1, cy))
                stack.append((cx - 1, cy))
                stack.append((cx, cy + 1))
                stack.append((cx, cy - 1))

def save(image, name):
    print(name)
    for row in image:
        print(''.join(row))

import sys
image = []
m, n = 0, 0

for line in sys.stdin:
    command = line.strip().split()
    if not command:
        continue
    
    cmd = command[0]
    if cmd == 'I':
        m, n = int(command[1]), int(command[2])
        image = imgs(m, n)
    elif cmd == 'C':
        clrImgs(image)
    elif cmd == 'L':
        x, y, c = int(command[1]), int(command[2]), command[3]
        col(image, x, y, c)
    elif cmd == 'V':
        x, y1, y2, c = int(command[1]), int(command[2]), int(command[3]), command[4]
        vertical(image, x, y1, y2, c)
    elif cmd == 'H':
        x1, x2, y, c = int(command[1]), int(command[2]), int(command[3]), command[4]
        horizontal(image, x1, x2, y, c)
    elif cmd == 'K':
        x1, y1, x2, y2, c = int(command[1]), int(command[2]), int(command[3]), int(command[4]), command[5]
        rect(image, x1, y1, x2, y2, c)
    elif cmd == 'F':
        x, y, c = int(command[1]), int(command[2]), command[3]
        fill(image, x, y, c)
    elif cmd == 'S':
        name = command[1]
        save(image, name)
    elif cmd == 'X':
        break