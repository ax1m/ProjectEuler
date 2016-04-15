#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int isPrime(int number) {
	for(int i=2; i<(sqrt(abs(number))+1); i++) {
		if(number%i == 0) return 0;
	}
	return 1;
}

int func(int a, int b, int n) {
	return ((int)pow(n, 2)) + (a*n) + b;
}

int main() {
	unsigned int maxPrimes = 0;
	int maxA = 0;
	int maxB = 0;
	for(int a=-999; a<1000; a++) {
		for(int b=-999; b<1000; b++) {
			unsigned int n = 0;
			unsigned int primes = 0;
			while(isPrime(func(a, b, n++))) primes++;
			if(primes>maxPrimes){
				maxPrimes = primes;
				maxA = a;
				maxB = b;
				printf("New max found\na = %d, b = %d\ngives %d consecutive primes\n", a, b, primes);
			}
		}
	}
	printf("a = %d, b = %d\ngives %d consecutive primes\n", maxB, maxB, maxPrimes);
	return 0;
}