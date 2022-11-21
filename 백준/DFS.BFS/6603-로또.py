import sys


def dfs(idx, depth, nums):
    if depth == numOfLotto:
        print(' '.join(res))
        return

    for i in range(idx, K):
        res.append(nums[i])
        dfs(i+1, depth+1, nums)
        res.pop()


numOfLotto = 6
res = []

while True:
    input = sys.stdin.readline()
    if input == '0\n':
        break

    nums = list(map(str, input.split()))
    K, S = int(nums[0]), nums[1:]
    dfs(0, 0, S)
    print()
