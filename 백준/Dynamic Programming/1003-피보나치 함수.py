import sys


def sol(num):
    dp[0][0] = 1
    dp[1][1] = 1

    for i in range(2, num + 1):
        dp[i][0] = dp[i - 1][0] + dp[i - 2][0]
        dp[i][1] = dp[i - 1][1] + dp[i - 2][1]


T = int(sys.stdin.readline().strip())
nums = []
for i in range(T):
    nums.append(int(sys.stdin.readline().strip()))

dp = [[0] * 2 for _ in range(41)]

maxNum = max(nums)
sol(maxNum)
for i in nums:
    print(str(dp[i][0]) + ' ' + str(dp[i][1]))
