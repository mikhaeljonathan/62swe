addMe :: Int -> Int -> Int

addMe x y = x + y
sumMe x y = x + y -- can do float

addTuples :: (Int, Int) -> (Int, Int) -> (Int, Int)
addTuples (x, y) (x2, y2) = (x + x2, y + y2)

whatAge 16 = "You can drive"
whatAge 18 = "You can vote"
whatAge 21 = "You're an adult"
whatAge _ = "Nothing important"

factorial :: Int -> Int
factorial 0 = 1
factorial n = n * factorial (n - 1)

prodFact n = product [1..n]

-- Guards
isOdd :: Int -> Bool
isOdd n
    | n `mod` 2 == 0 = False
    | otherwise = True

isEven n = n `mod` 2 == 0

whatGrade :: Int -> String
whatGrade age
    | (age >= 5) && (age <=6) = "Kindergarten"
    | (age > 6) && (age <= 10) = "Elementary School"
    | otherwise = "Go to college"

-- where

batAvgRating :: Double -> Double -> String
batAvgRating hits atBats
    | avg <= 0.200 = "Terrible Batting Average"
    | avg <= 0.250 = "Average Player"
    | avg <= 0.280 = "Your doing pretty good"
    | otherwise = "You're a Superstar"
    where avg = hits / atBats

-- Pattern matching
getListItems :: [Int] -> String
getListItems [] = "Your list is empty"
getListItems (x:[]) = "Your line starts with " ++ show x
getListItems (a:ab) = "The 1st item is " ++ show a ++ " and the rest is " ++ show ab

getFirstItem :: String -> String
getFirstItem [] = "Empty string"
getFirstItem all@(x:xs) = "The first letter in " ++ all ++ " is " ++ [x]

-- Higher order function
times4 :: Int -> Int
times4 x = x * 4

listTimes4 = map times4 [1, 2, 3, 4, 5]

multBy4 :: [Int] -> [Int]
multBy4 [] = []
multBy4 (x:xs) = times4 x : multBy4 xs

areStringEq :: [Char] -> [Char] -> Bool
areStringEq [] [] = True
areStringEq (x:xs) (y:ys) = x == y && areStringEq xs ys
areStringEq _ _ = False

-- pass functon into function
doMult :: (Int -> Int) -> Int
doMult func = func 3

num3Times4 = doMult times4

-- currying
getAddFunc :: Int -> (Int -> Int)
getAddFunc x y = x + y
adds3 = getAddFunc 3

fourPlus3 = adds3 4
threePlusList = map adds3 [1,2,3,4,5]

-- lambda
dbl1To10 = map (\x -> x * 2) [1..10]

-- if
doubleEvenNumber y =
    if (y `mod` 2 /= 0)
        then y
        else y * 2

-- case
getClass :: Int -> String
getClass n = case n of
    5 -> "Go to kindergarten"
    6 -> "Go to elementary school"
    _ -> "Go away"
