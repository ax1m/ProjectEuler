from time import time

t0 = time()

print(sum([(sum([ord(c) - 64 for c in s]) in [int(0.5 * n * (n + 1)) for n in range(0, 21)]) for s in open("p042_words.txt").readline().replace("\"", "").split(",")]))

print(time() - t0)
