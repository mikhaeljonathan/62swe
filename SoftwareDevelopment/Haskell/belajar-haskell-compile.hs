import Data.List
import System.IO

main = do
	putStrLn "What's your name?"
	name <- getLine
	putStrLn ("Helo " ++ name)

