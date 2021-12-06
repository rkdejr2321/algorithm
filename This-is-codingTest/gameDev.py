import sys

N, M = map(int, sys.stdin.readline().split())
visited = [[0] * M for _ in range(N)]
x, y, direction = map(int, sys.stdin.readline().split())
visited[x][y] = 1
dx = [-1,0,1,0]
dy = [0,1,0,-1]
arr = []
for i in range(N):
    arr.append(list(map(int,sys.stdin.readline().split())))

def turn_left():
    global direction
    direction -= 1
    if direction == -1:
        direction = 3
count = 1
turn_time = 0
while True:
    turn_left()
    nx = x + dx[direction]
    ny = y + dy[direction]
    if visited[nx][ny] == 0 and arr[nx][ny] == 0:
        x = nx
        y = ny
        count += 1
        turn_time = 0
        continue
    else:
        turn_time += 1
    if turn_time == 4:
        nx = x - dx[direction]
        ny = y - dx[direction]
        if arr[nx][ny] == 0:
            x = nx
            y = ny
        else:
            break
    turn_time = 0

print(count)
