factorials = [1]

def factorial(n):
    while len(factorials) < n:
        factorials.append(factorials[-1] * (len(factorials) + 1))
    return factorials[n-1]

def digitFactSum(n):
    return sum(map(factorial, [int(dig) for dig in str(n)]))
