from collections import deque

dx = [1, 2, 2, 1, -1, -2, -2, -1]
dy = [-2, -1, 1, 2, -2, -1, 1, 2]

def sol(l, x, y, gx, gy, arr):
    q = deque()
    q.append([x, y])
    if x == gx and y == gy:
        return 0

    while q:
        x, y = q.popleft()

        for i in range(8):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or ny < 0 or nx >= l or ny >= l:
                continue
            if arr[nx][ny] == 0:
                q.append([nx, ny])
                arr[nx][ny] = arr[x][y] + 1
    return arr[gx][gy]


tc = int(input())

for _ in range(tc):
    l = int(input())
    x, y = map(int, input().split())
    gx, gy = map(int, input().split())
    arr = [[0]*l for _ in range(l)]
    print(sol(l, x, y, gx, gy, arr))

