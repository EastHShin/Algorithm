import sys

count = 0


def check():
    tmp = 0
    for i in range(N):
        if arr[i][0] <= 0:
            tmp += 1
    return tmp


def dfs(cur):
    global count
    if cur == N:
        count = max(count, check())
        return

    if arr[cur][0] <= 0:
        dfs(cur + 1)
    else:
        flag = False
        for i in range(N):
            if i == cur:
                continue

            if arr[i][0] > 0:
                arr[i][0] = arr[i][0] - arr[cur][1]
                arr[cur][0] = arr[cur][0] - arr[i][1]
                flag = True
                dfs(cur + 1)

                arr[i][0] = arr[i][0] + arr[cur][1]
                arr[cur][0] = arr[cur][0] + arr[i][1]
        if not flag:
            dfs(cur+1)


N = int(sys.stdin.readline().strip())
arr = []
depth = 0
visited = [False for _ in range(N)]
for _ in range(N):
    arr.append(list(map(int, sys.stdin.readline().split())))

dfs(0)
print(count)
