/********************************************************************/
/* Applied Programming - Root Finding			                    */
/* This program solves a equation using three different methods:    */
/* Bisection, Newtow & Secant								        */
/* Created: Vu X. Dinh, October 28, 2013					        */
/********************************************************************/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>
#include "rootfinding.h"

#define MAX_ITERATION 1000

/********************************************************************/
/* Bisection Method													*/
/* Find the root of a scalar nonlinear function using the 			*/
/* bisection method				                            		*/
/********************************************************************/

double bisection( func1arg f, double a, double b, double tol , int verb)
{
	double x;
	int counter = 0;
	double lower;
	double upper;
	double result;

	if (a < b)
	{
		lower = a;
		upper = b;
	}
	else
	{
		lower = b;
		upper = a;
	}

	result = upper;
	x = (upper - lower)/2;

	while (fabs((upper)-f(x)) >= tol && counter <= MAX_ITERATION)
	{

		if (verb == 1) {
			printf("Lower: %f Upper: %f Result: %f", lower, upper, result);
		}

		counter++;
		if(f(x)*f(upper) <= 0)
		{
			lower = x;
		}
		else if (f(x)*f(lower) < 0)
		{
			upper = x;
		}

		x = (upper-lower)/2;
		result = 0.5*(f(upper)-f(lower));
	}

	printf("Number of iteration: %d \n", counter);
	return result;
}

/********************************************************************/
/* Newton Method						                            */
/* Find the root of a scalar nonlinear function using the 			*/
/* Newton method				                            		*/
/********************************************************************/

double newton ( func1arg f, func1arg df, double x0, int Nmax, double tol, int verb)
{

	double y0;
	double yp;

	double x1;

	int counter = 0;

	x1 = x0;

	while (fabs(x1) >= tol && counter <= Nmax) {

		if (verb == 1) {
			printf("f(x): %f df(x): %f Result: %f", y0, yp, x1);
		}

		counter++;
		y0 = f(x0);

		yp = df(x0);

		x1 = x0 - (y0/yp);
	}

	printf("Number of iteration: %d \n", counter);
	return x1;
}

/********************************************************************/
/* Secant Method						                            */
/* Find the root of a scalar nonlinear function using the 			*/
/* secant method				                            		*/
/********************************************************************/

double secant ( func1arg f, double x0, double x1, double tol, int Nmax, int verb)
{
	double pivot1 = x0;
	double pivot2 = x1;

	double x;

	int counter = 0;

	while (fabs(x1) >= tol && counter <= Nmax) {

		if (verb == 1) {
			printf("Pivot 1: %f Pivot 2: %f Result: %f", pivot1, pivot2, x);
		}

		x = pivot1 - (f(pivot1)*((pivot1-pivot2)/(f(pivot1)-f(pivot2))));

		pivot2 = pivot1;

		pivot1 = x;
		counter++;
	}

	printf("Number of iteration: %d \n", counter);
	return x;
}
