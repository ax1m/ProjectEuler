import sys

cMem = {}

def collatz(n):
	return n//2 if n%2 == 0 else 3*n + 1

def cChain(n):
	if n in cMem:
		return cMem[n]
	else:
		res = [1] if n == 1 else cChain(collatz(n)) + [n]
		cMem[n] = res
		return res

def main(args):
	lens = [0] + [len(cChain(n)) for n in range(1, int(args[1]) + 1)]
	max_ = max(lens)
	print("Longest chain: {}\nfor input: {}".format(max_, lens.index(max_)))

main(sys.argv)
