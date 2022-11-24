import sys

# 백트래킹 풀이 시간초과

# def dfs(depth, sum, r, c):
#     global res
#     if depth == n:
#         res = max(res, sum)
#         return
#
#     dfs(depth+1, sum + arr[r+1][c], r+1, c)
#     dfs(depth+1, sum + arr[r+1][c+1], r+1, c+1)
#

def sol():
    dp[0][0] = arr[0][0]
    for r in range(1, n):
        for c in range(len(arr[r])):
            if c == 0:
                dp[r][c] = dp[r-1][c] + arr[r][c]
            elif c == len(arr[r])-1:
                dp[r][c] = dp[r-1][c-1] + arr[r][c]
            else:
                dp[r][c] = max(dp[r-1][c-1], dp[r-1][c]) + arr[r][c]


n = int(sys.stdin.readline().strip())
arr = []
dp = [[0]*n for _ in range(n)]

for i in range(n):
    arr.append(list(map(int,sys.stdin.readline().split())))

sol()
res = max(dp[n-1])
print(res)
