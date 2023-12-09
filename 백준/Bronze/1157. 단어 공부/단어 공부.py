import sys

a = list(sys.stdin.readline().strip().upper())
alpha_list = list(set(a))
max = a.count(alpha_list[0])
temp = alpha_list[0]

for i in range(1,len(alpha_list)):
    if(a.count(alpha_list[i]) > max):
        max = a.count(alpha_list[i])
        temp = alpha_list[i]
    elif(a.count(alpha_list[i]) == max):
        temp = '?'

print(temp)
