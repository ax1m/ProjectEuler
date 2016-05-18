#include <stdio.h>

int main(int argc, char** argv) {
	int range;
	int sum = 0;
	if(argc == 1) {
		range = 1000;
	} else {
		range = atoi(argv[1]);
	}
	for(int i=0; i<range; i++) {
		if((i%3 == 0) || (i%5 == 0)) {
			sum += i;
		}
	}
	printf("Sum = %d\n", sum);
	return 0;
}