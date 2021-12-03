import sys

def fibonaci(n):
    if n < 3:
        return 1
    else:
        return fibonaci(n-1) + fibonaci(n-2)

N = int(sys.stdin.readline())
print(fibonaci(N))