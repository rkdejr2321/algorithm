import sys

N, M = map(int, sys.stdin.readline().split())
location = [int(sys.stdin.readline()) for _ in range(N)]
location.sort()
start = 1
end = location[-1] - location[0]
count = 0
while(start <= end):
    mid = (start + end) // 2
    current_house = location[0]
    count = 1
    for i in range(1,N):
        if location[i] >= mid + current_house:
            count += 1
            current_house = location[i]
    if count >= M:
        global ans
        start = mid + 1
        ans = mid
    else:
        end = mid - 1

print(ans)

