L, P=map(int, input().split())
N=map(int,input().split())
N=list(N)
total=L*P
F=[]
for i in range(0,5):
    num=N[i]-total
    F.append(num)

for r in range (0,5):
    print(F[r], end = ' ')
