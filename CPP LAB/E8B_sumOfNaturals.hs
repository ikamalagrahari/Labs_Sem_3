sum_n :: [Integer] -> Integer
sum_n [] = 0
sum_n (x:xs) = x + sum_n xs


main :: IO ()
main = do
   let numbers = [1,2,3,4,5]
   print (sum_n numbers)
