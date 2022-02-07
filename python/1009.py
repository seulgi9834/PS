n=int(input())
for i in range (0,n):
    a=0
    b=0
    total=1
    a,b=map(int, input().split())
    for r in range(0,b):
        total*=a
        total%=10
    if(total==0):
        print(10)
    else:
        print(total)
