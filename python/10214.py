test=int(input())
for i in range (0,test):
    y_total=0
    k_total=0
    for r in range (0,9):
        y,k=map(int,input().split())
        y_total+=y
        k_total+=k
    if(y_total>k_total):
        print("Yonsei")
    elif(k_total>y_total):
        print("Korea")
    else:
        print("Draw")
