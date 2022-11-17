import sys
from collections import deque

dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]


def countAroundSea(x, y):
    count = 0
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        if nx < 0 or ny < 0 or nx >= N or ny >= M:
            continue
        if sea[nx][ny] == 0:
            count += 1
    return count

def bfs(x, y, visited):
    q = deque()
    q.append([x, y])

    while q:
        x, y = q.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or ny < 0 or nx >= N or ny >= M:
                continue
            if sea[nx][ny] > 0 and not visited[nx][ny]:
                q.append([nx, ny])
                visited[nx][ny] = True

def isSeperated(visited):
    count = 0
    for i in range(N):
        for j in range(M):
            if sea[i][j] > 0 and not visited[i][j]:
                visited[i][j] = True
                bfs(i, j, visited)
                count += 1
                if count > 1:
                    return True
    return False


def sol():
    count = 0

    while iceburg:
        count += 1
        iceburgLen = len(iceburg)
        removeIceburg = []
        ibList = list(iceburg.keys())
        for idx in range(iceburgLen):
            i, j = ibList[idx]
            reducingCount = countAroundSea(i, j)
            iceburg[(i, j)] -= reducingCount
            if iceburg[(i, j)] <= 0:
                removeIceburg.append([i, j])

        for r, c in removeIceburg:
            sea[r][c] = 0
            iceburg.pop((r, c))
        visited = [[False] * M for _ in range(N)]
        if isSeperated(visited):
            return count
    return 0


N, M = map(int, input().split())
sea = []
iceburg = {}

for i in range(N):
    sea.append(list(map(int, sys.stdin.readline().split())))
    for j in range(M):
        if sea[i][j] > 0:
            iceburg[(i, j)] = sea[i][j]
print(sol())
