from itertools import combinations
import sys

N, M = map(int, sys.stdin.readline().split())
num_list = list(map(int, sys.stdin.readline().split()))
all_list = sorted(list((combinations(num_list,3))))
big = 0
for x in all_list:
    temp = sum(x)
    if(big < temp <= M):
        big = temp
print(big)