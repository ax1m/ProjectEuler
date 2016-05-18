#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define MEM 16
#define RANGE 100000
#define SRANGE 1000

bool isPandigital(int a, int b, int c, short **digs);
short * digits(long num);
short lgrtm(long num, short base);

int main(int argc, char **argv) {
	clock_t start = clock();
	static short *digs[RANGE];
	for(int i=0; i<RANGE; i++) digs[i] = digits(i);
	int *sum = (int *)calloc(MEM, sizeof(int));
	int sum_ = 0;
	for(int i=1; i<SRANGE; i++) {
		for(int j=1; j<RANGE/i; j++) {
			int cand = i*j;
			if(isPandigital(i, j, cand, digs)) {
				bool found = false;
				short k=0;
				while(sum[k]!=0) { if(sum[k] == i*j) found = true; k++; }
				if(!found) { sum[k] = cand; sum_ += cand; }
			}
		}
	}
	printf("%d\n", sum_);
	clock_t end = clock();
	printf("time elapsed = %fs\n", (float)(end-start)/CLOCKS_PER_SEC);
	return 0;
}

bool isPandigital(int a, int b, int c, short **digs) {
	bool f1, f2, f3, f4, f5, f6, f7, f8, f9;
	f1 = f2 = f3 = f4 = f5 = f6 = f7 = f8 = f9 = false;
	int nums[] = { a, b, c };
	for(int i=0; i<3; i++) {
		int num = nums[i];
		short len = lgrtm(num, 10);
		short *digs_ = digs[num];
		for(int j=0; j<len; j++) {
			short dig = digs_[j];
			switch(dig) {
				case 0: return false; break;
				case 1: if(f1) return false; else f1 = true; break;
				case 2: if(f2) return false; else f2 = true; break;
				case 3: if(f3) return false; else f3 = true; break;
				case 4: if(f4) return false; else f4 = true; break;
				case 5: if(f5) return false; else f5 = true; break;
				case 6: if(f6) return false; else f6 = true; break;
				case 7: if(f7) return false; else f7 = true; break;
				case 8: if(f8) return false; else f8 = true; break;
				case 9: if(f9) return false; else f9 = true; break;
			}
		}
	}
	return f1 && f2 && f3 && f4 && f5 && f6 && f7 && f8 && f9;
}

short * digits(long num) {
	static short *digs;
	short len = lgrtm(num, 10);
	digs = (short *)malloc(len*2);
	for(int i=0; num!=0; i++) {
		digs[len-(i+1)] = num % 10;
		num /= 10;
	}
	return digs;
}

short lgrtm(long num, short base) {
	short res = 0;
	for(short i=0; num!=0; i++) {
		num /= base;
		res++;
	}
	return res;
}