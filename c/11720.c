#include<stdio.h>
int main() {
	char num[100];
	int total=0;
	int n=0;
	scanf("%d", &n);
	scanf("%s", num);
	for (int i = 0; i < n; i++) {
		total += num[i]-'0';
	}
	printf("%d\n", total);
}