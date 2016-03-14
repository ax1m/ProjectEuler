from time import time

t0 = time()

triangleNums = [int(0.5 * n * (n + 1)) for n in range(0, 21)]

string = ""

with open("p042_words.txt") as file:
	string = file.readline()

words = string.replace("\"", "").split(",")

res = 0

for word in words:
	if sum([ord(char) - 64 for char in word]) in triangleNums:
		res += 1

print(res)

print(time() - t0)
