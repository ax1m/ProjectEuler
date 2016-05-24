with open("numbers.txt") as file:
	numstrings = file.readlines()

total = sum(map(int, numstrings))

print(str(total)[:10])