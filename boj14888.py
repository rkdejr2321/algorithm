import sys

def backTracking(n,num,add, sub, mul, div):
    global max_num, min_num
    if n == N:
        max_num = max(max_num,num)
        min_num = min(min_num, num)
        return
    if add > 0:
        backTracking(n+1,num + arr[n],add - 1, sub, mul, div)
    if sub > 0:
        backTracking(n+1,num - arr[n],add, sub -1, mul, div)
    if mul > 0:
        backTracking(n+1,num * arr[n],add, sub, mul - 1, div)
    if div > 0:
        backTracking(n+1,int(num // arr[n]),add, sub, mul, div - 1)        
        
N  = int(sys.stdin.readline())
max_num = -1e9
min_num = 1e9

arr = list(map(int, sys.stdin.readline().split()))
math = list(map(int, sys.stdin.readline().split()))

backTracking(1,arr[0],math[0],math[1],math[2],math[3])
print(max_num)
print(min_num)

