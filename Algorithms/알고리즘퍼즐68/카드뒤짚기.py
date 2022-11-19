
N = 100
cards = [False]*N

# 2~N까지 뒤짚음
for i in range(2, N+1):
    j = i-1 
    while j < len(cards):
        cards[j] = not cards[j] # 카드가 False인 경우 not을 만나 True 바뀌어 할당.
        j += i

# 뒷면이 위를 향한 카드를 출력
for i in range(0, N):
    if not cards[i]:
        print(i + 1)
    
