import sys

N, K = map(int, sys.stdin.readline().split())
count = 0
for i in range(N+1):
    for j in range(60):
        for k in range(60):
            if i < 10:
                h = '0'+str(i)
            else:
                h = str(i)
            if j < 10:
                m = '0'+str(j)
            else:
                m = str(j)
            if k < 10:
                s = '0'+str(k)
            else:
                s = str(k)
            if str(K) in h + m + s:
                count += 1

print(count)