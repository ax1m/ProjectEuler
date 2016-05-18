pascalTriangle :: [[Integer]]
pascalTriangle = [1 | n <- [1..]] : [(1 : zipWith (+) (pascalTriangle !! i) (tail (pascalTriangle !! (i-1)))) | i <- [1..]]

main :: IO ()
main = print (pascalTriangle !! 20 !! 20)