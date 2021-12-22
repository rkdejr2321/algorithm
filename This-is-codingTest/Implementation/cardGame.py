import sys

N, M = map(int, sys.stdin.readline().split())
ans = 0
for _ in range(N):
    num = list(map(int, sys.stdin.readline().split()))
    min_num = min(num)
    ans = max(min_num,ans)
print(ans)