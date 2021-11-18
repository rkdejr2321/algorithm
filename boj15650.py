import sys

def dfs():
    tmp = sorted(a)
    if len(a) == M and tmp not in ans:
        print(' '.join(map(str,tmp)))
        ans.append(list(tmp)) #깊은 복사 사용
        return
    for i in range(1,N+1):
        if i in a:
           continue
        a.append(i)
        dfs()
        a.pop()
a = []
ans = []
N, M = map(int, sys.stdin.readline().split())

dfs()