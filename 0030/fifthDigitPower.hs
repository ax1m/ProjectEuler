digs :: (Integral n) => n -> [n]
digs 0 = []
digs x = digs (div x 10) ++ [mod x 10]

fifthDigPow :: (Integral n) => n -> n
fifthDigPow x = sum (map (^5) (digs x))

main = print (sum [x | x <- [2..(sum [i^5 | i <- [1..10]])], x == (fifthDigPow x)])