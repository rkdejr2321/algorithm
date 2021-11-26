import sys

N, K = map(int, sys.stdin.readline().split())
num = list(str(sys.stdin.readline().strip()))

num = list(map(int,num))
pop_count = 0

for i in range(K):
    num.remove(min(num))
    pop_count += 1

for i in range(N-K):
    print(num[i], end = "")