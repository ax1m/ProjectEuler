import Data.List

perms = (sort (permutations "0123456789"))

main = print (perms !! 999999)
