import sys

def binary_search(array, target, start, end):
    while start <= end:
        mid = (start + end) // 2
        if array[mid] == target:
            return mid
        elif array[mid] > target:
            end = mid - 1
        else:
            start = mid + 1
    return None

N = int(sys.stdin.readline())
parts_num = list(map(int, sys.stdin.readline().split()))

M = int(sys.stdin.readline())
check_num = list(map(int, sys.stdin.readline().split()))

parts_num.sort()

for i in check_num:
    result = binary_search(parts_num,i,0,N-1)
    if result == None:
        print('no',end=' ')
    else:
        print('yes',end=' ')
