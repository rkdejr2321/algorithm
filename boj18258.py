import sys
from collections import deque

N = int(sys.stdin.readline())
arr = deque([])
for _ in range(N):
    word = sys.stdin.readline().split()
    command = word[0]
    
    if command == 'push':
        arr.append(word[1])
    elif command == 'front':
        if len(arr) == 0:
            print(-1)
        else:
            print(arr[0])
    elif command == 'back':
        if len(arr) == 0:
            print(-1)
        else:
            print(arr[-1])
    elif command == 'size':
        print(len(arr))
    elif command == 'empty':
        if len(arr) == 0:
            print(1)
        else:
            print(0)
    elif command == 'pop':
        if len(arr) == 0:
            print(-1)
        else:
            print(arr.popleft())

    
