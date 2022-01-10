import sys

N = int(sys.stdin.readline())
array = []

for i in range(N):
    grade = sys.stdin.readline().strip().split()
    array.append([grade[0],grade[1]])

array.sort(key= lambda x : x[1])

for student in array:
    print(student[0], end=' ')