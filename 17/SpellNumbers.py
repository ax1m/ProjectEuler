ones = {
	1:"one",
	2:"two",
	3:"three",
	4:"four",
	5:"five",
	6:"six",
	7:"seven",
	8:"eight",
	9:"nine",
	10:"ten",
	11:"eleven",
	12:"twelve",
	13:"thirteen",
	14:"fourteen",
	15:"fifteen",
	16:"sixteen",
	17:"seventeen",
	18:"eighteen",
	19:"nineteen" 
}
tens = {
	2:"twenty",
	3:"thirty",
	4:"forty",
	5:"fifty",
	6:"sixty",
	7:"seventy",
	8:"eighty",
	9:"ninety"
}

def parseString(number):
	res = ""
	digs = [int(char) for char in str(number)[::-1]]
	if len(digs) == 4:
		res += ones[digs.pop()] + " thousand "
	if len(digs) == 3:
		hun = digs.pop()
		if hun != 0:
			res += ones[hun] + " hundred "
	rest = int("".join(map(str, digs[::-1])))
	if len(res) != 0 and rest != 0:
		res += " and "
	if rest < 20 and rest != 0:
		res += ones[rest]
	elif rest != 0:
		res += tens[digs.pop()]
		if digs[-1] != 0:
			res += " - " + ones[digs.pop()]
	return res

string = ""

for i in range(1, 1001):
	string += parseString(i)

print(len(string.replace(" ", "").replace("-", "")))