import sys

def binSearch(target):
    length = len(A)
    lt, rt = 0, length - 1

    while lt <= rt:
        mid = (lt+rt) // 2
        if target == A[mid]:
            return True
        if target < A[mid]:
            rt = mid - 1
        elif target > A[mid]:
            lt = mid + 1

def sol():
    A.sort()

    for i in range(M):
        result = binSearch(nums[i])
        if result:
            print(1)
        else:
            print(0)
    return

N = int(sys.stdin.readline())
A = list(map(int, sys.stdin.readline().split()))
M = int(sys.stdin.readline())
nums = list(map(int, sys.stdin.readline().split()))

sol()
