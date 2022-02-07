num=int(input())
name=list(input())
name_len=len(name)
for i in range(0,num-1):
    subname=list(input())
    for r in range(0,name_len):
        if name[r]!=subname[r]:
            name[r]='?'
print("".join(name))
