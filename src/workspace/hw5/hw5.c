/********************************************************************/
/* Applied Programming - Root Finding			                    */
/* This main function to test the rootfinding.					    */
/* Bisection, Newtow & Secant								        */
/* Created: Vu X. Dinh, October 28, 2013					        */
/********************************************************************/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>
#include "timer.h"
#include "rootfinding.h"

DECLARE_TIMER(myTimer);

/********************************************************************/
/* Original Function					                            */
/********************************************************************/
double originalFunction (double x) {
	return 0.76*x*sin((3*x)/5.2)*tan(x/4.7) + 2.9*(x+2.5)*sin(0.39*(1.5+x));
}

/********************************************************************/
/* Derivative Function					                            */
/********************************************************************/

double derivativeFunction (double x) {
	return 1.131*(2.5641*sin(0.39*(x+1.5))+(x+2.5)*cos(0.39*(x+1.5))+0.387676*x*cos(0.576923*x)*tan(0.212766*x)
			+sin(0.576923*x)*(0.671972*tan(0.212766*x)+0.142973*x*pow(1/cos(0.212766*x),2)));
}

/********************************************************************/
/* Main program to solve a equation.	                            */
/********************************************************************/
int main(int argc, char *argv[]) {

	char *method = argv[1];
	char *bisec = "bisection";
	char *newtonStr = "newton";
	char *secantStr = "secant";

	double x0;
	double x1;
	double tol;
	int flag;
	double root ;
	int max = 1000;

	DECLARE_TIMER(myTimer);
	START_TIMER(myTimer);

	/* Print title and version of program */
		printf("Find root equation: \n");

		/* Check for enough command line arguments */
		if (argc >= 5) {

			if (strcmp(method, bisec) == 0) {
				tol = atof(argv[2]);
				x0 = atof(argv[3]);
				x1 = atof(argv[4]);
				flag = atoi(argv[5]);

				root = bisection(originalFunction, x0, x1, tol, flag);
			}
			else if (strcmp(method, newtonStr) == 0) {
				tol = atof(argv[2]);
				x0 = atof(argv[3]);
				flag = atoi(argv[4]);

				root = newton (originalFunction, derivativeFunction, x0, max, tol, flag);
			}
			else if (strcmp(method, secantStr) == 0) {
				tol = atof(argv[2]);
				x0 = atof(argv[3]);
				x1 = atof(argv[4]);
				flag = atoi(argv[5]);

				root = secant(originalFunction, x0, x1, tol,  max, flag);
			}
			else
				root = 0.0;

			printf("Root: %f \n", root);

		} /* if argc */

		else {
			/* Too few command line arguments */
			printf("Usage: %s a b c d c\n", argv[0]);
			return 0;
		} /* else argc */

	STOP_TIMER(myTimer);
	PRINT_TIMER(myTimer);

	return 0; /* successful execution */
} /* main() */
