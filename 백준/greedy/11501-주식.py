import sys


def sol(nums):
    numLen = len(nums)
    res = 0
    max = 0
    for i in range(numLen-1, -1, -1):
        if nums[i] > max:
            max = nums[i]
        else:
            res += max - nums[i]

    return res


TC = int(input())

for i in range(TC):
    N = int(input())
    nums = list(map(int, sys.stdin.readline().split()))
    print(sol(nums))
