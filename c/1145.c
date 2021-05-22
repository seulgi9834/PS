#include<stdio.h>
int main() {
	int num[5];
	int count = 0;
	int mul = 0;
	for (int i = 0; i < 5; i++) {
		scanf("%d", &num[i]);
	}
	while (1) {
	    mul += 1;
		count = 0;
		for (int i = 0; i < 5; i++) {
			if (mul%num[i]==0)
				count += 1;
		}
		if (count >= 3)
			break;
	}
	printf("%d\n", mul);
}