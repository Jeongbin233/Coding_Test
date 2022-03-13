def sol(N):
    answer = 0
    coin = [500,100,50,10]
    count = N
    for c in coin:
        answer += count//c
        count %= c
    """    count = count - count//c*c"""
    return answer

print(sol(1260))    # answer: 6

