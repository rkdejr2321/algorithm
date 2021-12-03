import sys

def dfs():
    if len(arr) == M:
        print(' '.join(map(str,arr)))
        return
    for i in range(1,N+1):
        if i in arr:
            continue
        arr.append(i)
        dfs()
        arr.pop()
arr = []
ans = []
N, M = map(int, sys.stdin.readline().split())

dfs()