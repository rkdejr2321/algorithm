import sys

N = int(sys.stdin.readline())
count = 0

coins = [500,100,50,10]

for coin in coins:
    count += N // coin
    N = N % coin
print(count) 