fibonacci(0, 0) :- !.
fibonacci(1, 1) :- !.
fibonacci(N, Value) :-
    N1 is N - 1, fibonacci(N1, Value1),
    N2 is N - 2, fibonacci(N2, Value2),
    Value is Value1 + Value2.

main :-
    N = 10,
    fibonacci(N, Result),
    write('Fibonacci of '), write(N), write(' is '), write(Result), nl.

