import sys
from types import resolve_bases

N, M = map(int, sys.stdin.readline().split())
graph = []
visited = [[0] * M for i in range(M)]
for i in range(N):
    graph.append(list(map(int,sys.stdin.readline().strip())))

def dfs(x,y):
    if x < 0 or x >= N or y < 0 or y >= M:
        return False
    if graph[x][y] == 0 and visited[x][y] == 0:
         visited[x][y] = 1
         dfs(x-1,y)
         dfs(x+1,y)
         dfs(x,y-1)
         dfs(x,y+1)
         return True
    return False

count = 0
for i in range(N):
    for j in range(M):
        if dfs(i,j) == True:
            count += 1

print(count) 