getNthFibo :: Int->Int
getNthFibo 1 = 0
getNthFibo 2 = 1
getNthFibo n = getNthFibo (n-1) + getNthFibo (n-2)

main :: IO()
main = do
   print ("Enter the number of terms to be generated:")
   input1 <- getLine
   let n = (read input1 :: Int)
   let fiboSeries = map getNthFibo [1..n]
   print ("The first "++ show n ++ " terms in the Fibonacci series are:")
   print (fiboSeries)
