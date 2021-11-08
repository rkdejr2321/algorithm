import sys
from collections import Counter

N  = int(sys.stdin.readline())
num = []
for i in range(N):
    num.append(int(sys.stdin.readline()))

num.sort() 
avg = round(sum(num) / N)
print(avg)
mid = num[N//2]
print(mid)
cnt = Counter(num).most_common(2)
if N > 1:
    if cnt[0][1] == cnt[1][1]:
        print(cnt[1][0])
    else:
        print(cnt[0][0])
else:
    print(cnt[0][0])
span = max(num) - min(num)
print(span)