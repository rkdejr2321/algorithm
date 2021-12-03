import sys
from collections import deque

N = int(sys.stdin.readline())
card = deque(list(range(1,N+1)))

while len(card) > 1:
    card.popleft()
    tmp = card.popleft()
    card.append(tmp)

print(*card)