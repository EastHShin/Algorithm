from collections import deque

dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]


def fire(bmap):
    fireSize = len(fireq)
    while fireSize:
        fa, fb = fireq.popleft()
        for i in range(4):
            nx = fa + dx[i]
            ny = fb + dy[i]
            if nx < 0 or ny < 0 or nx >= h or ny >= w:
                continue
            if bmap[nx][ny] == 0:
                fireq.append([nx, ny])
                bmap[nx][ny] = -1
        fireSize -= 1


def sol(visit, bmap, x, y, w, h):
    q = deque()
    q.append([x, y])
    while q:
        fire(bmap)
        qsize = len(q)
        while qsize:
            x, y = q.popleft()
            for i in range(4):
                nx = x + dx[i]
                ny = y + dy[i]

                if nx < 0 or ny < 0 or nx >= h or ny >= w:
                    return visit[x][y] + 1
                if bmap[nx][ny] == 0 and visit[nx][ny] == 0:
                    q.append([nx, ny])
                    visit[nx][ny] = visit[x][y] + 1
            qsize -= 1
    return -1


tc = int(input())

for _ in range(tc):
    w, h = map(int, input().split())
    b = []
    bmap = [[0] * w for _ in range(h)]
    visit = [[0] * w for _ in range(h)]
    fireq = deque()
    x, y = 0, 0
    for i in range(h):
        bw = input()
        b.append(bw)
        for j in range(w):
            if bw[j] == '#':
                bmap[i][j] = -2
            elif bw[j] == '*':
                bmap[i][j] = -1
                fireq.append([i, j])
            elif bw[j] == '@':
                x, y = i, j
    res = sol(visit, bmap, x, y, w, h)
    if res == -1:
        print('IMPOSSIBLE')
    else:
        print(res)
