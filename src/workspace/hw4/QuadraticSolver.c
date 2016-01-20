/********************************************************************/
/* Vu Dinh							    							*/
/* vxd9797@rit.edu                                                  */
/* Homework 4                                                       */
/*                                                                  */
/* Program to compute the roots of a quadratic polynomial           */
/* p(x) = a*x.2 + b*x + c                                           */
/* The program reads the coefficients from the command line as      */
/* a b c in that order, then it echoes the polynomial equation,     */
/* and prints the real or complex roots.                            */
/* Last Update: Juan C. Cockburn 8/27/2013 (juan.cockburn@rit.edu)  */
/********************************************************************/

/* Standard Libraries */
#include <stdio.h>
#include <stdlib.h>
#include <tgmath.h> /* c99 standard library */


/* Macros */
#define COEFF_A (2)
#define COEFF_B (1)
#define COEFF_C (0)

/* Macro for double and float type define*/
#ifdef D
	typedef double data_type;
#else
	typedef float data_type;
#endif

/* Functions */
int main(int argc, char *argv[]) {

	char Version[] = "v2.0e"; /* String with Version of the program */
	int Index; /* Loop index variable */
	int RC = 0; /* Return code for OS */
	data_type Coefficients[COEFF_A + 1]; /* Vector of Polynomiaol Coefficientss */
	data_type Discriminant; /* Indicates real or complex roots */
	data_type Root_1, Root_2; /* Real roots of equation */
	data_type Real, Imaginary; /* Complex roots of equation */

	/* Print title and version of program */
	printf("Quadratic Solver, version %s\n", Version);

	/* Check for enough command line arguments */
	if (argc >= 4) {
		for (Index = 2; Index >= 0; Index--) {
			Coefficients[Index] = atof(argv[3 - Index]);
		} /* for Index */

		/* Show user equation to be solved (for verification) */
		printf("Equation to be solved: %gx.2 + %gx + %g = 0\n",
				Coefficients[COEFF_A], Coefficients[COEFF_B],
				Coefficients[COEFF_C]);

		/* Calculate discriminant */
		Discriminant = Coefficients[COEFF_B] * Coefficients[COEFF_B]
				- 4.0 * Coefficients[COEFF_A] * Coefficients[COEFF_C];

		/* Check for real or complex roots */
		if (Discriminant < 0.0) { /* Complex conjugate roots */
			Real = -Coefficients[COEFF_B] / (2.0 * Coefficients[COEFF_A]);
			Imaginary = sqrt(-Discriminant) / (2.0 * Coefficients[COEFF_A]);

			/* Print complex roots */
			printf("The quadratic has complex roots: %f +/- j%f\n", Real,
					Imaginary);
		} /* if Discriminant */

		else { /* Real roots */

			Root_1 = ((-Coefficients[COEFF_B])/(2*Coefficients[COEFF_A]))
					+ (abs(Coefficients[COEFF_B]/(2*Coefficients[COEFF_A]))
					*sqrt(1-((4*Coefficients[COEFF_A]*Coefficients[COEFF_C])
					 /(Coefficients[COEFF_B]*Coefficients[COEFF_B]))));

			Root_2 = (1/Root_1)*(Coefficients[COEFF_C]/Coefficients[COEFF_A]);

			/* Print real roots */
			printf("The quadratic has real roots: %f and %f\n", Root_1, Root_2);
		} /* else Discriminant */
	} /* if argc */

	else {
		/* Too few command line arguments */
		printf("Equation: a x.2 + b x + c = 0 \n");
		printf("Usage: %s a b c\n", argv[0]);
		RC = -1; /* Invocation error: return -1 to the OS */
	} /* else argc */

	return (RC);
} /* main () */
