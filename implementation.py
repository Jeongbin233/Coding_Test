N = int(input())
moving = input().split()

x = 1
y = 1

for i in moving:
    if y < N and i == 'R':
        y += 1
    elif y > 1 and i == 'L':
        y -= 1
    elif x > 1 and i == 'U':
        x -= 1
    elif x < N and i == 'D':
        x += 1

print(x, y)