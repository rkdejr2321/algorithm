import sys

N = int(sys.stdin.readline())
xy_list = []
for _ in range(N):
    x, y = map(int, sys.stdin.readline().split())
    xy_list.append([x,y])

xy_list.sort(key= lambda x : (x[0], x[1]))
for ans in xy_list:
    print(ans[0], ans[1])



