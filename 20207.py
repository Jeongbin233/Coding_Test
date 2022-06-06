n = int(input())
schedule = [0] * 366
for i in range(n):
    start, end = map(int, input().split())
    for j in range(start, end+1):
        schedule[j] += 1

row = 0
col = 0
answer = 0
for i in range(1, len(schedule)):
    if schedule[i] != 0:
        col += 1
        row = max(row, schedule[i])
    else:
        answer += row * col
        row = 0
        col = 0
    # 만약 맨 마지막에 일정이 존재한다면 정답에 업데이트가 되지 않는다. 따라서 새로운 if문 생성
    if i == len(schedule)-1:
        answer += row * col
print(answer)



