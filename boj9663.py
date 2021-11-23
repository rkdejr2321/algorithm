import sys

def check(n):
    for i in range(n):
        if queen[i] == queen[n] or abs(queen[i] - queen[n]) == n - i:
            return False
    return True

def Nqeens(n):
    global count
    if n == N:
        count = count + 1
    else:
        for i in range(N):
            queen[n] = i
            if check(n):
                Nqeens(n+1)
            
N = int(sys.stdin.readline())
count = 0
queen = [0] * N
Nqeens(0)
print(count)