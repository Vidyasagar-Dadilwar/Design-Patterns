import sys

LINE_WIDTH = 72

def tokenize(input_text):
    output = []
    block = []
    pos = 0

    while pos < len(input_text):
        if input_text[pos] == ' ':
            while pos < len(input_text) and input_text[pos] == ' ':
                block.append(input_text[pos])
                pos += 1
            output.append(''.join(block))
            block = []
        elif input_text[pos] == '\n':
            output.append("\n")
            pos += 1
        else:
            while pos < len(input_text) and input_text[pos] != ' ' and input_text[pos] != '\n':
                block.append(input_text[pos])
                pos += 1
            output.append(''.join(block))
            block = []

    if block:
        output.append(''.join(block))

    return output

def flush(line, output, newline):
    if len(line) > 1 and line[-1].startswith(" "):
        line.pop()

    line_str = ''.join(line)
    output.append(line_str + ("\n" if newline else ""))
    line.clear()

def format_text(tokens):
    output = []
    line = []
    i = 0

    while i < len(tokens):
        curr_length = sum(len(x) for x in line)
        token = tokens[i]

        if token.startswith(" "):
            line.append(token)
        elif token == "\n":
            if i + 1 < len(tokens):
                next_token = tokens[i + 1]
                if next_token == "\n" or next_token.startswith(" ") or not line or (len(line) == 1 and line[0].startswith(" ")):
                    flush(line, output, True)
                elif curr_length + len(next_token) <= LINE_WIDTH:
                    line.append(" ")
                    line.append(next_token)
                    i += 1
                else:
                    flush(line, output, True)
            else:
                line.append(token)
        elif curr_length == 0 and len(token) > LINE_WIDTH:
            line.append(token)
            if i + 1 < len(tokens):
                flush(line, output, True)
                i += 1
        else:
            if curr_length + len(token) > LINE_WIDTH:
                flush(line, output, True)
            line.append(token)
        i += 1

    if line:
        flush(line, output, False)

    return ''.join(output)

input_text = sys.stdin.read()
print(format_text(tokenize(input_text)))
