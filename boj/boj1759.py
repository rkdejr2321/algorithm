import sys
from itertools import combinations

L, C = map(int,sys.stdin.readline().split())
pwd = list(sys.stdin.readline().strip().split())
pwd.sort()
ans = list(combinations(pwd,L))
for x in ans:
    consonant = 0
    vowel = 0
    tmp = list(x)
    for i in "aeiou":
        if i in tmp:
            vowel += 1
    if L - vowel >= 2 and vowel >= 1:
        print(''.join(tmp))
