M=int(input())
N=int(input())
min=0
total=0
i=1
while i**2<=N:
    if(i**2>=M):
        total+=i**2
        if(min==0):
            min=i**2
    i+=1
if(min==0):
    print(-1)
else:
    print(total)
    print(min)
