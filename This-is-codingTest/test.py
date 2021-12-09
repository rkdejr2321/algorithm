import sys
def solution(n):
    n = int(n)
    answer = 0
    for i in range(1,n+1):
        if n % i == 0:
            answer += i
    return answer
n = int(sys.stdin.readline())
print(solution(n))