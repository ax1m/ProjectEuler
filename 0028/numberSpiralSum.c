#include <stdio.h>
#include <stdlib.h>

int main(int argc, char** argv) {
	int range;
	unsigned int sum = 0;
	unsigned int increment = 1;
	if(argc == 1) {
		range = 1001;
	} else {
		range = atoi(argv[1]);
	}
	sum += increment;
	for(int i=2; i<range; i+=2) {
		for(int j=0; j<4; j++) {
			increment += i;
			sum += increment;
		}
	}
	printf("Final sum = %d\n", sum);
	return 0;
}