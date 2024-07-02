%fact
loves(romeo, juliet).

%rule
loves(juliet, romeo) :- loves(romeo, juliet).

male(albert).
male(bob).
male(charlie).
male(donnie).

female(alice).
female(betsy).
female(clara).

%:- is the same like if

happy(albert).
happy(alice).

happy(bob).
happy(bill).
with_albert(alice).

runs(albert) :-
	happy(albert).

dances(alice) :-
	happy(alice),
	with_albert(alice).

does_alice_dance :- dances(alice),
	write('When Alice is happy and with Albert she dances').

swims(bob) :-
	happy(bob),
	near_water(bob).

%----------------

swims(bill) :-
	happy(bill).

swims(bill) :-
	near_water(bill).



parent(albert, bob).
parent(albert, betsy).
parent(albert, bill).

parent(alice, bob).
parent(alice, betsy).
parent(alice, bill).

parent(bob, charlie).
parent(bob, clara).

get_grandchild :-
	parent(albert, X),
	parent(X, Y),
	write('Alberts grandchild is '),
	write(Y), nl.

get_grandparent :-
	parent(X, Y),
	parent(Y, charlie),
	format('~w ~s grandparent ~n', [X, "is the"]).

brother(bob, bill).

%axioms
grand_parent(X, Y) :-
	parent(Z, X),
	parent(Y, Z).

kill(pein, jiraya).
hates(naruto, X) :- kill(X, jiraya).

%case
what_grade(5) :-
	write('Go to kindergarten').

what_grade(6) :-
	write('Go to 1st grade').

what_grade(Other) :-
	Grade is Other - 5,
	format('Go to grade ~w', [Grade]).

%structure
owns(albert, pet(cat, olive)).

customer(tom, smith, 20.55).
customer(sally, smith, 120.55).

get_cust_bal(FName, LName) :-
	customer(FName, LName, Bal),
	write(FName), tab(1),
	format('~w owes us $~2f ~n', [LName, Bal]).

vertical(line(point(X, Y), point(X, Y2))).
horizontal(line(point(X, Y), point(X2, Y))).

%trace
warm_blooded(penguin).
warm_blooded(human).

produce_milk(penguin).
produce_milk(human).

have_feathers(penguin).
have_hair(human).

mammal(X) :-
	warm_blooded(X),
	produce_milk(X),
	have_hair(X).

%recursion
related(X, Y) :-
	parent(X, Y).
%doesnt work

related(X, Y) :-
	parent(X, Z),
	related(Z, Y).

%math
is_even(X) :-
	Y is X//2,
	X =:= 2 * Y.

% sqrt, sin, cos, tan, asin, acos, atan, atan2, sinh, asinh, acosh, atanh, log, log10, exp, pi, e

%io
say_hi :-
	write('What is your name? '),
	read(X),
	write('Hi '),
	write(X).

fav_char :-
	write('What is your favorite character? '),
	get(X),
	format('The Ascii value of ~w is ', [X]),
	put(X), nl.

%loop
count_to_10(10) :-
	write(10), nl.

count_to_10(X) :-
	write(X), nl,
	Y is X + 1,
	count_to_10(Y).

%guessing game
guess_num :- loop(start)

%the answer is 15
loop(15) :- write('You guessed it!').

loop(X) :-
	X \= 15,
	write('Guess a number: '),
	read(Guess),
	write(Guess),
	write(' is not the number'), nl,
	loop(Guess).
