data = []

with open("p018_data.txt") as file:
	data = [list(map(int, line.split(" "))) for line in file.readlines()]

paths = [[int(dig) for dig in bin(perm)[2:].rjust(14, "0")] for perm in range(2**14)]

sums = [sum([data[i][sum(path[:i])] for i in range(15)]) for path in paths]

print(max(sums))
