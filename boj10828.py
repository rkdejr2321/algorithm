import sys

N = int(sys.stdin.readline())
arr = []

for _ in range(N):
    word = sys.stdin.readline().split()
    commend = word[0]

    if commend == "push":
        num = word[1]
        arr.append(num)
    elif commend == "pop":
        if len(arr) == 0:
            print(-1)
        else:
            print(arr[-1])
            arr.pop()
    elif commend == "size":
        print(len(arr))
    elif commend == "empty":
        if len(arr) > 0:
            print(0)
        else:
            print(1)
    elif commend == "top":
        if len(arr) == 0:
            print(-1)
        else:
            print(arr[-1])

    