N=int(input())
P=list(map(int,input().split()))
score=0
total=0
for i in range(0,N):
    if(P[i]==1):
       score=score+1
       total=total+score
    else:
        score=0
print(total)
        
