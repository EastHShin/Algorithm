import sys

def dfs(start, depth, nums):
    if M == depth:
        print(nums)
        return

    for i in range(start+1, N+1):
        if not visited[i]:
            visited[i] = True
            dfs(i, depth + 1, nums + " " + str(i))
            visited[i] = False


N, M = map(int, sys.stdin.readline().split())
visited = [False for _ in range(N+1)]

for i in range(1, N+1):
    visited[i] = True
    dfs(i, 1, str(i))
    visited[i] = False
