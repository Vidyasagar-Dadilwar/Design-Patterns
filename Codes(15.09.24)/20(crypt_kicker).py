import sys
from collections import defaultdict

class CryptKickerII:
    PANGRAM = "the quick brown fox jumps over the lazy dog"
    PANGRAM_SPACES = PANGRAM.replace(" ", ".")
    
    def __init__(self):
        self.mapping = [0] * 128
        self.pangram_pattern = self.get_pattern(self.PANGRAM)

    def get_pattern(self, word):
        return [word.index(c) for c in word]

    def compare(self, a, b):
        return len(a) == len(b) and sum(abs(a[i] - b[i]) for i in range(len(a))) == 0

    def is_pangram(self, input_str):
        line = " ".join(filter(bool, input_str.strip().split()))
        return (self.compare(self.pangram_pattern, self.get_pattern(line)) and
                line.replace(" ", ".").lower() == self.PANGRAM_SPACES)

    def decrypt(self, input_lines):
        self.mapping = [0] * 128
        output = []
        encrypted_pangram = next((line for line in input_lines if self.is_pangram(line)), "")
        
        if not encrypted_pangram:
            output.append("No solution.")
            return output

        for i in range(len(encrypted_pangram)):
            self.mapping[ord(encrypted_pangram[i])] = self.PANGRAM[i]

        for line in input_lines:
            decrypted_line = ''.join((chr(self.mapping[ord(c)]) if c != ' ' else c) for c in line)
            output.append(decrypted_line)

        return output

input_data = sys.stdin.read().strip().splitlines()
n = int(input_data[0].strip())
index = 2  
crypt_kicker = CryptKickerII()
for _ in range(n):
    input_lines = []
    while index < len(input_data) and input_data[index].strip():
        input_lines.append(input_data[index].strip())
        index += 1
    
    decrypted_lines = crypt_kicker.decrypt(input_lines)
    print("\n".join(decrypted_lines))
    
    if index < len(input_data) - 1:  
        print()
    
    index += 1  