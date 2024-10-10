def decode(s):
    decoded = []
    for char in s:
        if char != ' ':
            if char == '1':
                decoded.append('`')
            elif char in '23456789':
                decoded.append(chr(ord(char) - 1))
            elif char == '0':
                decoded.append('9')
            elif char == '-':
                decoded.append('0')
            elif char == '=':
                decoded.append('-')
            elif char == 'W':
                decoded.append('Q')
            elif char == 'E':
                decoded.append('W')
            elif char == 'R':
                decoded.append('E')
            elif char == 'T':
                decoded.append('R')
            elif char == 'Y':
                decoded.append('T')
            elif char == 'U':
                decoded.append('Y')
            elif char == 'I':
                decoded.append('U')
            elif char == 'O':
                decoded.append('I')
            elif char == 'P':
                decoded.append('O')
            elif char == '[':
                decoded.append('P')
            elif char == ']':
                decoded.append('[')
            elif char == '\\':
                decoded.append(']')
            elif char == 'S':
                decoded.append('A')
            elif char == 'D':
                decoded.append('S')
            elif char == 'F':
                decoded.append('D')
            elif char == 'G':
                decoded.append('F')
            elif char == 'H':
                decoded.append('G')
            elif char == 'J':
                decoded.append('H')
            elif char == 'K':
                decoded.append('J')
            elif char == 'L':
                decoded.append('K')
            elif char == ';':
                decoded.append('L')
            elif char == '\'':
                decoded.append(';')
            elif char == 'X':
                decoded.append('Z')
            elif char == 'C':
                decoded.append('X')
            elif char == 'V':
                decoded.append('C')
            elif char == 'B':
                decoded.append('V')
            elif char == 'N':
                decoded.append('B')
            elif char == 'M':
                decoded.append('N')
            elif char == ',':
                decoded.append('M')
            elif char == '.':
                decoded.append(',')
            elif char == '/':
                decoded.append('.')
        else:
            decoded.append(' ')
    return ''.join(decoded)

while True:
    s = input()
    if s == "":
        break
    print(decode(s))