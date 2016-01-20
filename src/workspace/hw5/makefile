# -----------------------------------------------------------------------
# Makefile for GNU/Linux system (tested on Ubuntu 12.04)
# Compiles and Tests Rootfinding Module
# Revised, J.C. Cockburn 3/7/2014
# Edited: Vu Dinh 10/08/2014
# -----------------------------------------------------------------------

## for GCC
CC = gcc
CFLAGS = -Wall -ansi
LFLAGS = -lm

## Testing Parameters - modify as needed
TOL= 1e-10
# Bisection
A=
B=
# Newton
X01= 
X02=
# Secant
X11=
X12=
# VERB=1 (print partial results)
VERB=1

## !!!!!!!!!!! WARNING, for indentation use one TAB, not spaces
## Main "body" of makefile.

hw5: rootfinding.o hw5.o
	$(CC) $(CFLAGS) -o hw5 rootfinding.o hw5.o $(LFLAGS)
	
rootfinding.o: rootfinding.c rootfinding.h
	$(CC) $(CFLAGS) -c rootfinding.c
	
hw5.o: hw5.c
	$(CC) $(CFLAGS) -c hw5.c
	
## Testing, you may want to redirect to output to a file
bisection: hw5
	$(X01) $(X11) $(VERB)
	$(X02) $(X12) $(VERB)
	$(X01) $(VERB)
	$(X02) $(VERB)
	
secant: hw5

newton: hw5
	./hw5 bisection $(TOL) $(A) $(B) $(VERB)
	./hw5 secant $(TOL)
	./hw5 secant $(TOL)
	./hw5 newton $(TOL)
	./hw5 newton $(TOL)
	
## Cleaning auxiliary files
clean:
	rm -f *.o
