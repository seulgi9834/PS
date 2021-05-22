K,N,M=map(int, input().split())
total=K*N
if(total>M):
    money=total-M
else:
    money=0
print(money)
