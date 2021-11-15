import sys

N = int(sys.stdin.readline())
arr = []
ans = []
cnt = 0
for _ in range(N):
    weight, height = map(int, sys.stdin.readline().split())
    arr.append([weight, height])  

for i in range(N):
    tmp1 = arr[i]
    for j in range(N):
        tmp2 = arr[j]
        if(tmp1[0] < tmp2[0] and tmp1[1] < tmp2[1]):
            cnt += 1 
    ans.append(cnt+1)
    cnt = 0

for num in ans:
    print(num)