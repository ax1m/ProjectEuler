grid :: [[Integer]]
grid = [1 | x <- [1..]] : [(1 : zipWith (+) (grid !! y) (tail (grid !! (y-1)))) | y <- [1..]]

gridPath :: Int -> Int -> Integer
gridPath x y = grid !! y !! x