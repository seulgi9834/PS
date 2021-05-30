T=int(input())
A,B,C=0,0,0
if(T//300>=1):
    A=T//300
    T-=(A*300)
if(T//60>=1):
    B=T//60
    T-=(B*60)
if(T//10>=1):
    C=T//10
    T-=(C*10)
if(T>=1):
    sum=-1
    print(sum)
else:
    print("%d %d %d"%(A,B,C))

    
