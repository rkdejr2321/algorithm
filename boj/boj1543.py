import sys

document = list(sys.stdin.readline().strip())
word = list(sys.stdin.readline().strip())
count = 0
while len(document) >= len(word):
    if word == document[:len(word)]:
        count += 1
        del document[:len(word)]
    else:
        del document[0]

print(count)