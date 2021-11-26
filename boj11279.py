import sys
import heapq as hq

N = int(sys.stdin.readline())
heap = []
for _ in range(N):
    num = int(sys.stdin.readline())
    if num == 0:
        if len(heap) == 0:
            print(0)
        else:
             print(abs(hq.heappop(heap)))
    else:
        hq.heappush(heap,-num)

