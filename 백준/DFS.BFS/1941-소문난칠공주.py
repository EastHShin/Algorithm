import sys
from collections import deque

dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]

count = 0


def bfs():
    visited = [[True] * 5 for _ in range(5)]
    for idx in arr:
        visited[idx // 5][idx % 5] = False
    q = deque()
    idx = arr[0]
    x = idx // 5
    y = idx % 5
    q.append([x, y])
    cnt = 0
    visited[x][y] = True

    while q:
        x, y = q.popleft()
        cnt += 1

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or nx >= 5 or ny < 0 or ny >= 5:
                continue

            if not visited[nx][ny]:
                q.append([nx, ny])
                visited[nx][ny] = True
    return cnt == 7


def dfs(depth, S, Y, idx):
    global count

    if depth == 7 and S >= 4:
        if bfs():
            count += 1
        return

    if Y >= 4 or depth > 7 or idx >= 25:
        return

    x = idx // 5
    y = idx % 5

    arr.append(idx)
    if board[x][y] == 'Y':
        dfs(depth + 1, S, Y + 1, idx + 1)
    elif board[x][y] == 'S':
        dfs(depth + 1, S + 1, Y, idx + 1)
    arr.pop()
    dfs(depth, S, Y, idx + 1)


board = []
arr = []

for i in range(5):
    board.append(sys.stdin.readline().strip())
dfs(0, 0, 0, 0)
print(count)
