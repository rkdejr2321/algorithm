import sys

member_list = []
N = int(sys.stdin.readline())
for _ in range(N):
    age, name = map(str, sys.stdin.readline().split())
    member_list.append([int(age),name])
member_list.sort(key = lambda x : x[0])
for info in member_list:
    print(info[0], info[1])
