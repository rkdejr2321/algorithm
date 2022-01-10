import sys

N, M = map(int, sys.stdin.readline().split())

tteok = list(map(int, sys.stdin.readline().split()))

start = 0
end = max(tteok)
result = 0

while start <= end:
    total = 0
    mid = (start + end) // 2

    for x in tteok:
        if x > mid:
            total += x - mid
    if total < M:
        end = mid - 1
    else:
        result = mid
        start = mid + 1

print(result)