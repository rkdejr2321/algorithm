import sys

N = int(sys.stdin.readline())
commands = sys.stdin.readline().split()
move = ['L','R','U','D']
x = 1
y = 1
dx = [0,0,-1,1]
dy = [-1,1,0,0]

for command in commands:
    for i in range(4):
        if command == move[i]:
            nx = x + dx[i]
            ny = y + dy[i]
    if nx < 1 or nx > N or ny < 1 or ny > N:
        continue
    x = nx
    y = ny

print(x,y)