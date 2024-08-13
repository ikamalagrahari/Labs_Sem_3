import Control.Monad

type Board = [Int]

initialBoard :: Board
initialBoard = [5, 4, 3, 2, 1]

displayBoard :: Board -> IO ()
displayBoard = putStrLn . unlines . zipWith (\i row -> show i ++ ":" ++ replicate row '*') [1..]

isValidMove :: Board -> Int -> Int -> Bool
isValidMove board row starsToRemove =
  row >= 1 && row <= length board &&
  starsToRemove >= 1 && starsToRemove <= board !! (row - 1)

removeStars :: Board -> Int -> Int -> Board
removeStars board row starsToRemove =
  take (row - 1) board ++
  [board !! (row - 1) - starsToRemove] ++
  drop row board

isGameOver :: Board -> Bool
isGameOver = all (== 0)

nimGame :: Board -> IO ()
nimGame board = do
  displayBoard board
  unless (isGameOver board) $ do
    putStrLn "Enter the row number and the number of stars to remove (e.g., 2 3):"
    input <- getLine
    let [row, starsToRemove] = map read (words input)
    if isValidMove board row starsToRemove
      then nimGame (removeStars board row starsToRemove)
      else putStrLn "Invalid move! Try again."

main :: IO ()
main = nimGame initialBoard
