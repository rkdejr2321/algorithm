import sys

T = int(sys.stdin.readline())
for _ in range(T):
    array = [0] * 11
    array[0] = 1
    array[1] = 2
    array[2] = 4
    N = int(sys.stdin.readline())
    for i in range(3, N+1):
        array[i] = array[i-1] + array[i-2] + array[i-3]
    print(array[N-1])
