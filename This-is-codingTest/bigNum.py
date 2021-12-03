import sys

N, M, K = map(int, sys.stdin.readline().split())
num_list = list(map(int,sys.stdin.readline().split()))

num_list.sort(reverse=True)

first = num_list[0]
second = num_list[1]

ans = 0
count = 0
while True:
    for _ in range(K):
        if M == 0:
            break
        ans += first
        M -= 1
    if M == 0:
        break
    ans += second
    M -= 1

print(ans)
    