N = int(input())
num = range(60)
count = 0
for i in range(N+1):
    for j in num:
        for k in num:
            if '3' in str(i) + str(j) + str(k):
                count += 1

print(count)
