import sys

def dfs():
    if len(a) == M:
        print(' '.join(map(str,a)))
        return
    for i in range(1,N+1):

        a.append(i)
        dfs()
        a.pop()
a = []
ans = []
N, M = map(int, sys.stdin.readline().split())

dfs()