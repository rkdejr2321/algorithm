import sys

T = int(sys.stdin.readline())

for _ in range(T):
    N = int(sys.stdin.readline())
    arr = []
    count = 1
    for _ in range(N):
        arr.append(list(map(int,sys.stdin.readline().split())))
    arr.sort(key= lambda x : x[0])

    applicant = arr[0][1]
    for i in range(1,N):
        if applicant > arr[i][1]:
            count += 1
            applicant = arr[i][1] 
    print(count)

    