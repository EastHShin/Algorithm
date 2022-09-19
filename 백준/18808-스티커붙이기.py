def fun():
    for i in range(len(sticker)):
        find(i)

def find(k):
    cnt = 0
    while cnt < 4:
        for i in range(len(notebook)):
            for j in range(len(notebook[0])):
                if i + len(sticker[k]) > len(notebook) or j + len(sticker[k][0]) > len(notebook[i]):
                    continue
                if canAttach(i, j, k):
                    attach(i, j, k)
                    return

        cnt += 1
        rotate(k)
    return


def canAttach(r, c, k):
    for i in range(r, r + len(sticker[k])):
        for j in range(c, c + len(sticker[k][0])):
            if notebook[i][j] == 1 and sticker[k][i - r][j - c] == 1:
                return False
    return True


def attach(r, c, k):
    for i in range(r, r + len(sticker[k])):
        for j in range(c, c + len(sticker[k][0])):
            if sticker[k][i-r][j-c] == 1:
                notebook[i][j] = 1



def rotate(k):
    rowLen = len(sticker[k])
    colLen = len(sticker[k][0])
    tmp = [[0] * rowLen for _ in range(colLen)]
    for i in range(rowLen):
        for j in range(colLen):
            tmp[j][rowLen-1-i] = sticker[k][i][j]
    sticker[k] = tmp


N, M, K = map(int, input().split())
notebook = [[0] * M for _ in range(N)]
sticker = []
for i in range(K):
    R, C = map(int, input().split())
    sticker.append([])
    for j in range(R):
        sticker[i].append(list(map(int, input().split())))

fun()
ans = 0
for note in notebook:
    ans += note.count(1)
print(ans)
