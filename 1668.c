#include<stdio.h>
int main() {
	int h[50];
	int num = 0;
	int big = 0;
	int count = 0;
	int lcount = 0;
	int rcount = 0;
	int t = 0;
	scanf("%d", &num);
	for (int i = 0; i < num; i++) {
		scanf("%d", &h[i]);
	}
	for (int i = 0; i < num; i++) {
		for (int r = 0; r < i; r++) {
			if (h[r] < h[i]) {
				count += 1;
			}
		}
		if (count == i) {
			lcount += 1;
		}
		count = 0;
	}


	for (int i = num-1; i >= 0; i--) {
		for (int r = num-1; r > i; r--) {
			if (h[r] < h[i]) {
				count += 1;
			}
		}

		if (count == t) {
			rcount += 1;
		}
		count = 0;
		t += 1;
	}
	printf("%d\n", lcount);
	printf("%d\n", rcount);

}