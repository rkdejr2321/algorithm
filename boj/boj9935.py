import sys

arr = list(sys.stdin.readline().strip())
bomb = sys.stdin.readline().strip()
stack = []

lastword = bomb[-1]

for word in arr:
    stack.append(word)
    if word == lastword and ''.join(stack[-len(bomb):]) == bomb:
        del stack[-len(bomb):]
    
answer = ''.join(stack)
if len(answer) == 0:
    print("FRULA")
else:
    print(answer)




