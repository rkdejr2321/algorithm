import sys
from collections import deque

N, M = map(int, sys.stdin.readline().split())
find_num_index = list(map(int, sys.stdin.readline().split()))
ans = 0
find_num = []

num_list = deque(list(range(1,N)))

for i in range(M):
    find_num.append(num_list[find_num_index[i]-1])
for i in range(M):
    num = find_num[i]
    count = 0
    if find_num_index[i] <= N //2:
        while True:
            if num_list[0] == num:
                num_list.popleft()
                ans += count
                break
            else:
                num_list.append(num_list.popleft())
                count += 1
    else:
        while True:
            if num_list[0] == num:
                num_list.pop()
                ans += count
                break
            else:
                num_list.appendleft(num_list.pop())
                count += 1

print(ans)