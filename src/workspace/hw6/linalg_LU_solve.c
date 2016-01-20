/*
 * linalg_LU_solve.c
 *
 *  Created on: Nov 4, 2013
 *      Author: dinhxuanvu
 */

#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include "linalg.h"

typedef double matrix;
typedef double vector;

/**********************************************************************/
/* finds the solution to the system Ax = b given the results of the   */
/* Elimination step of the in-place LU algorithm with prototype:	  */
/* int linalg_LU_decomp(matrix *A, vector *p, vector *b, vector *x)	  */
/**********************************************************************/
int linalg_LU_solve(matrix *A, vector *p, vector *b, vector *x)
{
	int i,j;
	int size = sizeof(p)/sizeof(p[0]);

	/* Forward substitution */
	for(i = 0; i < size-1; ++i)
	{
		for(j = i+1; j < size; ++j)
		{
			b[p[j]] = b[p[j]] - A[p[j]][i]*b[p[i]];
		}
	}

	x[size-1] = b[p[size-1]]/A[p[size-1]][size-1];

	/* Back substitution */
	for (i = size-2; i >= 0; i--)
	{
		x[i] = b[p[i]];
		for (j = i+1; j < size; ++j)
		{
			x[i] = x[i]-A[p[i]][j]*x[j];
		}
		x[i] = x[i]/A[p[i]][i];
	}

	return 0;
}
