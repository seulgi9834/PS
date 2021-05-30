plate=[]
s=input()
sum=0
for i in s:
    plate.append(i)
num=len(plate)
for t in range(0,num):
    if(t==0):
        sum+=10
    else:
        if(plate[t]==plate[t-1]):
            sum+=5
        else:
            sum+=10
print(sum)
