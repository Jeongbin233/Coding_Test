N, M = map(int, input().split())
ice = []
for i in range(N):
    ice.append(list(map(int, input())))


def dfs(x, y):
    global N, M
    if x < 0 or x >= N or y < 0 or y >= M:
        return False
    if ice[x][y] == 0:
        ice[x][y] = 1
        dfs(x-1, y)
        dfs(x, y-1)
        dfs(x+1, y)
        dfs(x, y+1)
        return True
    return False

count = 0
for i in range(N):
    for j in range(M):
        if dfs(i, j) == True:
            count += 1

print(count)