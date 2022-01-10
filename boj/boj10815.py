import sys

def binary_search(arr,target,start,end):
    while start <= end:
        mid = (start + end) // 2
        if arr[mid] == target:
            return 1
        elif arr[mid] > target:
            end = mid - 1
        else:
            start = mid + 1
    return 0

N = int(sys.stdin.readline())
cards = list(map(int, sys.stdin.readline().split()))
cards.sort()
M = int(sys.stdin.readline())
find_card = list(map(int, sys.stdin.readline().split()))
ans = []

for i in find_card:
    ans.append(binary_search(cards,i,0,N-1))

print(*ans)


