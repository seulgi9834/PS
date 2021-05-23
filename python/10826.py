"""
#재귀 사용-> 런타임 에
def fibo(n):
    if(n==0):
        sum=0
        return sum
    elif(n==1):
        sum=1
        return sum
    else:
        sum=fibo(n-1)+fibo(n-2)
        return sum
"""
n=int(input())
a,b,final=0,1,0
for i in range(0,n):
    if (n==0):
        final=0
    elif(n==1 or n==2):
        final=1        
    else:
        a,b=b,a+b
        final=a
print(final)

