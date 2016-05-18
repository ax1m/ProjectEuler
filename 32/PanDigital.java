public class PanDigital {

	private static final int MEM = 16;
	private static final int RANGE = 100000;
	private static final int SRANGE = 1000;

	private static short[][] digs = new short[RANGE][];
	
	public static void main(String[] args) {
		long t0 = System.nanoTime();
		for(int i=0; i<RANGE; i++) digs[i] = digits(i);
		int[] sum = new int[MEM];
		int sum_ = 0;
		for(int i=1; i<SRANGE; i++) {
			for(int j=1; j<RANGE/i; j++) {
				int cand = i*j;
				if(isPandigital(i, j, cand)) {
					boolean found = false;
					short k=0;
					while(sum[k]!=0) { if(sum[k] == i*j) found = true; k++; }
					if(!found) { sum[k] = cand; sum_ += cand; }
				}
			}
		}
		System.out.print(String.format("%d\n", sum_));
		System.out.println("time elapsed = " + (System.nanoTime()-t0)/1000000000d);
	}
	
	public static boolean isPandigital(int a, int b, int c) {
		boolean f1, f2, f3, f4, f5, f6, f7, f8, f9;
		f1 = f2 = f3 = f4 = f5 = f6 = f7 = f8 = f9 = false;
		int nums[] = { a, b, c };
		for(int i=0; i<3; i++) {
			int num = nums[i];
			short len = lgrtm(num, (short)10);
			short[] digs_ = digs[num];
			for(int j=0; j<len; j++) {
				short dig = digs_[j];
				switch(dig) {
					case 0: return false;
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
	
	public static short[] digits(long num) {
		short len = lgrtm(num, (short)10);
		short[] digs = new short[len];
		for(int i=0; num!=0; i++) {
			digs[len-(i+1)] = (short)(num % 10);
			num /= 10;
		}
		return digs;
	}
	
	public static short lgrtm(long num, short base) {
		short res = 0;
		for(short i=0; num!=0; i++) {
			num /= base;
			res++;
		}
		return res;
	}
}