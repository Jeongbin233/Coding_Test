N, M = map(int, input().split())
minimum = []
for i in range(N):
    L = list(map(int, input().split()))
    minimum.append(min(L))
print(max(minimum))