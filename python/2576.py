total=0
count=0
small=0
for i in range (7):
    num=int(input())
    if num%2==1:
        total+=num
        count+=1
        if count==1:
            small=num
        else:
            if num<small:
                small=num
if count==0:
    print(-1)
else:
    print(total)
    print(small)

        
