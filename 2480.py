a, b, c=map(int, input().split())
if(a==b==c):
    money=10000+a*1000
elif((a==b)or(b==c)or(c==a)):
    if(a==b):
        money=1000+a*100
    elif(b==c):
        money=1000+b*100
    elif(c==a):
        money=1000+c*100
else:
    big=a
    if(big<b):
        big=b
    if(big<c):
        big=c
    money=big*100
print(money)
