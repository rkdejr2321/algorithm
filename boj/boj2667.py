import sys

N = int(sys.stdin.readline())
graph = []
ans = []


for i in range(N):
    graph.append(list(map(int,sys.stdin.readline().strip())))

def dfs(x,y):
    global count
    if x < 0 or x >= N or y < 0 or y >= N:
        return False
    if graph[x][y] == 1:
        graph[x][y] = 0
        dfs(x-1,y)
        dfs(x+1,y)
        dfs(x,y-1)
        dfs(x,y+1)
        count += 1
        return True
    return False

count = 0
for i in range(N):
    for j in range(N):
        if dfs(i,j) == True:
            ans.append(count)
            count = 0
ans.sort()
print(len(ans))
for num in ans:
    print(num)