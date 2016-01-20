Vu Dinh
Makefile Instruction
Homework 5

1. make hw5.o: To compile hw5.c to generate the object file hw5.o
2. make rootfinding.o: To compile rootfinding.c to generate the object file rootfinding.o
3. make hw5: To compile all object file to generate the execution file hw5
4. make bisection: To use bisection method to find root of a function
5. make newton: To use new method to find root of a function
6. make secant: To use secant method to find root of a function
7. make clean: To clean all auxiliary files

Note: The makefile could be changed to perform root finding method:
a. TOL for tolerance error.
b. A for lower bounce for bisection method
c. B for upper bounce for bisection method
d. X01 for first initial guess for Newton method
e. X02 for second initial guess for Newton method
f. X11 for first initial guess for second method
g. X12 for second initial guess for Newton method
h. VERB is for flag
