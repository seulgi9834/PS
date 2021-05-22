#include<stdio.h>
int main() {
	char S[1000000];
	int zero_count=0;
	int one_count = 0;
	scanf("%s", S);
	for (int i = 0; S[i] != '\0'; i++) {
		if (S[i] == '0'&&S[i + 1] == '1')
			zero_count += 1;
		else if (S[0] == '1')
			zero_count += 1;
	}
	for (int i = 0; S[i] != '\0'; i++) {
		if (S[i] == '1'&&S[i + 1] == '0')
			one_count += 1;
		else if (S[0] == '0')
			one_count += 1;
	}
	if (zero_count <= one_count) {
		printf("%d", zero_count);
	}
	if (zero_count >= one_count) {
		printf("%d", one_count);
	}
	
}