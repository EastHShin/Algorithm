import sys

def dfs(depth, s):
    if depth == M:
        print(' '.join(s))
        return

    for i in range(1, N+1):
        dfs(depth+1, s + str(i))

def sol():
    for i in range(1, N+1):
        dfs(1, str(i))

N, M = map(int, sys.stdin.readline().split())
sol()
