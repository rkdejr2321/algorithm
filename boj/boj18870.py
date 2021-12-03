import sys

N = int(sys.stdin.readline())
ans = []
num_list = list(map(int, sys.stdin.readline().split()))
set_num_list = sorted(list(set(num_list)))

dic = {set_num_list[i] : i for i in range(len(set_num_list))}
for i in num_list:
    print(dic[i], end=" ")
