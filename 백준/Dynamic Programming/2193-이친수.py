import sys


def sol():
    dp[1] = 1

    for i in range(2, n+1):
        dp[i] = dp[i-1] + dp[i-2]


n = int(sys.stdin.readline().strip())
dp = [0 for _ in range(n + 1)]
sol()
print(dp[n])
