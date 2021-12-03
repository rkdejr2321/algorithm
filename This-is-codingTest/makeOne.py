import sys

N, K = map(int, sys.stdin.readline().split())
ans = 0
while N > 1:
    if N % K  == 0:
        N = N // K
        ans += 1
    else:
        N -= 1
        ans +=1

print(ans)