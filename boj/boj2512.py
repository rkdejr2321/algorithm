import sys

N = int(sys.stdin.readline())
budgets = list(map(int, sys.stdin.readline().split()))
M = int(sys.stdin.readline())

start = 0
end = max(budgets)
result = 0

while(start <= end):
    total = 0
    mid = (start + end) // 2
    total=sum([min(mid, ask) for ask in budgets])

    if total > M:
        end = mid - 1
    else:
        result = mid
        start = mid + 1
    
print(result)

