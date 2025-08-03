def solution(brown, yellow):
    answer = []
    total = yellow + brown
    for b in range(1, (total+1)//2):
        if(total / b) % 1 == 0:
            a = total/b
            if 2*a + 2*b == brown+4:
                return [a,b]
    return answer