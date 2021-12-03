import sys

N = int(sys.stdin.readline())
xPos = []
yPos = []

for _ in range(N):
    x,y = map(int, sys.stdin.readline().split())
    xPos.append(x)
    yPos.append(y)
xPos.append(xPos[0])
yPos.append(yPos[0])

first = 0
second = 0
for i in range(N):
    first += xPos[i] * yPos[i+1]
    second += xPos[i+1] * yPos[i]
ans = abs(first - second) / 2
print(round(ans,2))
