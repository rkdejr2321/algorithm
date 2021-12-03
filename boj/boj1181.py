import sys

word_list = []
N = int(sys.stdin.readline())
for _ in range(N):
    word_list.append(sys.stdin.readline().strip())
word_list = list(set(word_list))
word_list.sort(key = lambda x : (len(x), x))
for word in word_list:
    print(word)

