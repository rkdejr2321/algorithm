import sys

def checkList(list):
    tmp = list[0]
    for i in range(1,len(list)):
        if list[i] < tmp:
            return False
        tmp = list[i]
    return True

def dfs():
    if len(arr) == M:
        print(' '.join(map(str,arr)))
        return
    for i in range(1,N+1):
        arr.append(i)
        if checkList(arr):
            dfs()
        arr.pop()
arr = []
N, M = map(int, sys.stdin.readline().split())

dfs()