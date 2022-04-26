N, M = map(int, input().split())
x, y, now_direction = map(int, input().split())
full_map = []
for _ in range(N):
    detail_map = list(map(int, input().split()))
    full_map.append(detail_map)

# 반시계 방향이므로 북 서 남 동
direction = [0, 3, 2, 1]
# 순서대로 북, 서, 남, 동
moving = [[-1, 0], [0, -1], [1, 0], [0, 1]]
count = 1
next_direction = -1
turn_count = 0
full_map[x][y] = 2   # 처음 시작점은 방문했다고 함


for index, dir in enumerate(direction):
    if now_direction == dir:
        next_direction = direction[(index + 1) % 4]
        next_x = x + moving[(index + 1) % 4][0]
        next_y = y + moving[(index + 1) % 4][1]

        # 안 가본 육지면
        if full_map[next_x][next_y] == 0:
            now_direction = next_direction
            x = next_x
            y = next_y
            full_map[x][y] = 2  # 간 곳은 2로 표시
            count += 1
            turn_count = 0

        # 가보거나(2) 바다면
        elif turn_count < 4 and (full_map[next_x][next_y] == 2 or full_map[next_x][next_y] == 1):
            now_direction = next_direction
            turn_count += 1
            continue

        # 다 돌아봤는데 가본 칸일 때(turn_count = 4) 후진
        else:
            x = x - moving[index][0]
            y = y - moving[index][0]
            count += 1

print(count)

# 문제: 북으로 시작 안하면 망함.
# while문 사용해야함.