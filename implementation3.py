location = input()
row = int(location[1])
col = ord(location[0])-ord('a')+1
moving = [[2, 1], [2, -1], [-2, 1], [-2, -1], [1, 2], [1, -2], [-1, 2], [-1, -2]]
count = 0
for move in moving:
    #next = [row, col] + move
    next_row = row + move[0]
    next_col = col + move[1]
    if next_row >= 1 and next_row <= 8 and next_col >= 1 and next_col <= 8:
        count += 1
print(count)