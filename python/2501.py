N,K=map(int, input().split())
dNn=0
dN=[]
for i in range(1,N+1):
    if(N%i==0):
        dN.append(i)
        dNn=dNn+1
if(dNn<K):
    print(0)
else:
    print(dN[K-1])
"""
list assignment index out of range 오류가 계속 나왔다.
빈 리스트인데 0번에 데이터를 넣으려고 해서 발생
append()로 해결
"""
