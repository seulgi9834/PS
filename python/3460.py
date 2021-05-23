T=int(input())
for i in range(0,T):
    P=int(input())
    a=0
    while(P!=0):
        n=P%2
        if(n==1):
            print(a,end=' ')
        a+=1
        P=P//2
    print("")    
