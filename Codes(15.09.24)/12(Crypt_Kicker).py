# PC/UVa IDs: 110204/843, 

def decrypt(n, d1, encry):
    def backtrack(index, mapping, mapp):
        if index == len(ewords):
            return True
        word = ewords[index]
        wlen = len(word)
        for tmp in d1:
            if len(tmp) != wlen:
                continue
            tmpMap = {}
            tmpMapp = {}
            for c, d in zip(word, tmp):
                if c in mapping:
                    if mapping[c] != d:
                        break
                if d in mapp:
                    if mapp[d] != c:
                        break
                tmpMap[c] = d
                tmpMapp[d] = c
            else:
                mapping.update(tmpMap)
                mapp.update(tmpMapp)
                if backtrack(index + 1, mapping, mapp):
                    return True
                for c in tmpMap:
                    del mapping[c]
                for d in tmpMapp:
                    del mapp[d]
        return False
    results = []
    for line in encry:
        ewords = line.split()
        mapping = {}
        mapp = {}
        if backtrack(0, mapping, mapp):
            dline = []
            for word in ewords:
                dword = ''.join(mapping[c] for c in word)
                dline.append(dword)
            results.append(' '.join(dline))
        else:
            results.append('*' * sum(len(word) for word in ewords) + ' ' * (len(ewords) - 1))

    return results

import sys
input = sys.stdin.read
data = input().splitlines()
n = int(data[0]) 
d1 = data[1:n + 1]  
encry = data[n + 1:] 
results = decrypt(n, d1, encry)
for result in results:
    print(result)