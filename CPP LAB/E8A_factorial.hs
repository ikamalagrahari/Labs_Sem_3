factorial :: Int -> Int
factorial 0 = 1
factorial n = n * factorial (n-1)

main :: IO ()
main = do
   input1 <- getLine
   let num = (read input1 :: Int)
   print (factorial num)
