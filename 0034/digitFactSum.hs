digs :: Integer -> [Integer]
digs 0 = []
digs x = digs (div x 10) ++ [mod x 10]

fact_mem :: [Integer]
fact_mem = [factorial x | x <- [0..]]

factorial :: Integer -> Integer
factorial 0 = 1
factorial x = x * (fact_mem !! ((fromIntegral x) - 1))

factDigSum :: Integer -> Integer
factDigSum x = sum (map factorial (digs x))

list = [i | i <- [3..2540160], i == (factDigSum i)]

main = print (sum list)
