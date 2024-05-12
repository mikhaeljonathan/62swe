import Data.List -- to enable sort function

-- integer
minInt = minBound :: Int
always5 :: Int
always5 = 5

-- Double
bigFloat = 3.999999999 + 0.00000005

-- Strings
helloWorld :: String
helloWorld = "hello, " ++ "world"

-- Char
charA = 'A'

-- Float
always3 = 3 :: Int
sqrtOf3 = sqrt 3
sqrtOf3_2 = sqrt (fromIntegral always3)

-- Bool
trueAndFalse = True && False
trueOrFalse = True || False
notTrue = not(True)

-- List
primeNumbers = [3, 5, 7]
morePrimes = primeNumbers ++ [11, 13, 17, 19]
favNums = 2 : 7 : 21 : 66 : [] --to combine numbers to list
morePrimes2 = 2 : morePrimes
lenPrime = length morePrimes2
revPrime = reverse morePrimes2
isListEmpty = null morePrimes2
secondPrime = morePrimes2 !! 1 -- to access each element
firstPrime = head morePrimes2
lastPrime = last morePrimes2
first3Primes = take 3 morePrimes2
removedPrimes = drop 3 morePrimes2
maxPrime = maximum morePrimes2
minPrime = minimum morePrimes2

newList = [2, 3, 5]
prodPrimes = product newList

zeroToTen = [0..10]
evenList = [2,4..20]
letterList = ['A','C'..'Z']

-- we can create infinte list, because haskell is only generating the list if we need it (it's called lazy)
infinPow10 = [10,20..]
many2s = take 10 (repeat 2)
many3s = replicate 10 3
cycleList = take 10 (cycle [1,2,3,4,5])

listTimes2 = [x * 2 | x <- [1..10]]
listTimes3 = [x * 3 | x <- [1..10], x * 3 <= 20]
divisBy9N13 = [x | x <- [1..500], x `mod` 13 == 0, x `mod` 9 == 0]
divisBy5N7 = take 10 ([x | x <- [1..], mod x 5 == 0, mod x 7 == 0])

sortedList = sort [9, 4, 5, 2, 3]
sumOfLists = zipWith (+) [1, 2, 3, 4, 5] [6, 7, 8, 9, 10] -- check zipWith type with :t
listBiggerThan5 = filter (> 5) morePrimes
evensUpTo20 = takeWhile (<= 20) [2,4..]
multOfList = foldl (*) 1 [2,3,4,5]
multOfList2 = foldl (*) 1 []
multOfList3 = foldl (-) 0 [2,3,4,5]
multOfList4 = foldr (-) 0 [2,3,4,5]

-- list comprehension
pow3List = [3^n | n <- [1..10]]
multTable = [[x * y | y <- [1..10]] | x <- [1..10]]

-- Tuple
randTuple = (1, "Random Tuple")
bobSmith = ("Bob Smith", 52)
bobsName = fst bobSmith
bobsAge = snd bobSmith

names = ["Bob", "Mary", "Tom"]
addresses = ["123 Main", "234 North", "567 South"]
namesNAddress = zip names addresses -- see the type of zip function

