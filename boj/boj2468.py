import sys
import copy
sys.setrecursionlimit(15000)

N = int(sys.stdin.readline())
graph = []
ans = []

for i in range(N):
    graph.append(list(map(int,sys.stdin.readline().split())))

def dfs(x,y,water):
    if x < 0 or x >= N or y < 0 or y >= N:
        return False
    if safe_area[x][y] > water and safe_area != -1:
        safe_area[x][y] = -1
        dfs(x-1,y,water)
        dfs(x+1,y,water)
        dfs(x,y-1,water)
        dfs(x,y+1,water)
        return True
    return False

water = 0
while water <= max(max(graph)):
    count = 0
    visit = [[0] * N for _ in range(N)]
    safe_area = copy.deepcopy(graph)
    for i in range(N):
        for j in range(N):
            if dfs(i,j,water) == True:
                count += 1
    ans.append(count)
    water += 1
   
print(max(ans))