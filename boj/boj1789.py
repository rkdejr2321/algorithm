import sys

S = int(sys.stdin.readline())
sum = 0
ans = 0

if S == 1:
    print(1)
else:
    for i in range(1,S+1):
        sum += i
        ans += 1
        
        if sum > S:
            print(ans-1)
            break
