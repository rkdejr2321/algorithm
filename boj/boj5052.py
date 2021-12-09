import sys

T = int(sys.stdin.readline())

for _ in range(T):
    N = int(sys.stdin.readline())
    arr = []
    for _ in range(N):
        arr.append(sys.stdin.readline().strip())
    arr.sort()
    for i in range(N-1):
        if arr[i] == arr[i+1][0:len(arr[i])]:
            print("NO")
            break
    else:
        print("YES")

        