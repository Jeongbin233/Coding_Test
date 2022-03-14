N, M, K = map(int, input().split()) #map(적용 함수 , 적용 값(list, tuple) #int(): data type int로 바꿔줌
n = sorted(list(map(int, input().split())), reverse=True) #input 받으면 string 됨 -> map으로 int 만들고 list 생성
answer = 0
count = 1
for i in range(M):
    if count > K:
        answer += n[1]
        count = 1
    else:
        answer += n[0]
        count += 1
print(answer)

# M=0일때?