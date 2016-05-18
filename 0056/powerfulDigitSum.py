def digitSum(number):
	return sum(map(int, str(number)))

max = 0

for a in range(1, 100):
	for b in range(1, 100):
		pow = digitSum(a ** b)
		if pow > max:
			max = pow

print(max)
