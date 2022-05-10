N = int(input())
A = list(map(int, input().split()))
B = list(map(int, input().split()))

sum = 0

# A.sort(reverse=True)
# b = sorted(B)

# for i in range(N):
#     sum += A[i] * b[i]


for i in range(N):
    sum += min(A) * max(B)
    A.pop(A.index(min(A)))
    B.pop(B.index(max(B)))

print(sum)

