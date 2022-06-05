n = int(input())
dice = list(map(int, input().split()))

# 1, 2, 3면이 보이는 주사위 개수 세기
side1 = 4*(n-2)*(n-1) + (n-2)**2
side2 = 4*(n-2) + 4*(n-1)
side3 = 4
# 주사위에서 마주보는 면 중 작은 것 저장하는 리스트
min_li = []

if n == 1:
    print(sum(dice) - max(dice))

else:
    # 주사위의 마주보는 면을 쌍으로 만들고 그 중 작은 애 뽑아 저장
    # (마주 보는 애는 인접하지 않으므로 동시에 보일 수 없음)
    min_li.append(min(dice[0], dice[5]))
    min_li.append(min(dice[1], dice[4]))
    min_li.append(min(dice[2], dice[3]))
    min_li.sort()

    min1 = side1 * min_li[0]
    min2 = side2 * (min_li[0] + min_li[1])
    min3 = side3 * (min_li[0] + min_li[1] + min_li[2])

    s = min1 + min2 + min3
    print(s)


