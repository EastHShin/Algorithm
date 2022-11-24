import sys


def sol():
    dp[1] = 1
    if n < 2:
        return
    dp[2] = 3

    for i in range(3, n + 1):
        dp[i] = (dp[i - 1] + dp[i - 2] * 2) % 10007


n = int(sys.stdin.readline().strip())
dp = [0 for _ in range(n + 1)]
sol()
print(dp[n])
