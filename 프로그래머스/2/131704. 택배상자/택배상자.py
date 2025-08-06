def solution(order):
    answer = 0
    idx = 0
    now = order[idx]
    stack = []
    
    for box in range(1, len(order)+1):
        if box == now: # 직접 실을 때
            answer += 1
            idx += 1
            if idx < len(order):
                now = order[idx]
        else:
            stack.append(box)
        
        while stack and idx < len(order) and stack[-1] == now:
            stack.pop()
            answer += 1
            idx += 1
            if idx < len(order):
                now = order[idx]
            
    return answer