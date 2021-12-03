import sys

location = sys.stdin.readline()
row = int(location[1])
column = int(ord(location[0]) - ord('a')) + 1
count = 0
move = [[-2,1],[-2,-1],[2,1],[2,-1],[-1,2],[-1,-2],[1,2],[1,-2]]

for i in range(8):
    nx = row + move[i][0]
    ny = column + move[i][1]
    if nx < 1 or nx > 8 or ny < 1 or ny > 8:
        continue
    count += 1

print(count)