/*
 * linalg.c
 *
 *  Created on: Nov 4, 2013
 *      Author: dinhxuanvu
 */

 /*********************************************************
 * Linear Algebra Module
 * Rev: 10/24/2013,  Juan C. Cockburn  (jcck@ieee.org)
 *********************************************************/

#include <math.h>
#include "linalg.h"

/* Allocate memory space for matrix, all at once */
MatElement **matrix_alloc(int nr, int nc) {
  int i;
  MatElement *ptr;
  MatElement **A;

  A = malloc( nr * sizeof(MatElement *));    /* array of ptrs   */
  ptr = calloc( nr*nc, sizeof(MatElement) ); /* matrix elements */
  for (i=0; i<nr; i++)             /* set row pointers properly */
    A[i] = ptr + nc*i;
  return A;
}

/* Release memory used by matrix */
void matrix_free(MatElement **A) {
  free(A[0]);
  free(A);
}

/* Print matrix elements */
void matrix_print(MatElement **A, char * format, int nr, int nc) {
  int i,j;
  for (i=0; i<nr; ++i) {
    for (j=0; j<nc; ++j)
	  printf(format, A[i][j]);
  putchar('\n');
  }
  putchar('\n');
}

/* Create and Identity Matrix */
MatElement **matrix_identity(int n) {
  int i;
  MatElement **A=matrix_alloc(n, n);
  for (i=0; i<n; ++i)
    A[i][i] = (MatElement) 1;
  return A;
}

/**********************************************************************/
/* Function implements the in-place Gaussian Elimination process with */
/* partial pivoting with prototype:									  */
/* int linalg_LU_decomp(matrix *A, vector *p)	                      */
/**********************************************************************/
int linalg_LU_decomp(matrix *A, vector *p)
{
	int i,j;
	int index;
	int temp;
	int pivot;
	int current;
	int size;
	int ratio;
	int exchange;
	int rescale[5];

	size = sizeof(p)/sizeof(p[0]);
	rescale[size];
	index = 0;
	pivot = 0;
	current = 0;
	ratio = 0;
	exchange = 0;

	/* Initialize the pivot vector */
	for (i = 0; i < size; ++i)
	{
		p[i] = i;
	}

	/* Calculate the ratio factors */
	for (i = 0; i < size; ++i)
	{
		temp = 0;
		for (j = 0; j < size; ++j)
		{
			if (fabs(A[i][j]) > temp)
			{
				temp = fabs(A[i][j]);
			}
			rescale[i] = temp;
		}
	}

	/* Find the pivot */
	for (j = 0; j < size; ++j)
	{
		pivot = 0;
		for (i = j; i < size; ++i)
		{
			temp = fabs(A[p[i]][j])/rescale[p[i]];
			if (temp > pivot)
			{
				pivot = temp;
				current = i;
			}
		}

		/* Update the index vector */
		exchange = p[j];
		p[j] = p[current];
		p[current] = exchange;

		/* Add the lower triangle U to the matrix */
		for (i = j+1; i < size; ++i)
		{
			ratio = A[p[i]][j]/A[p[j]][j];
			A[p[i]][j] = ratio;

			/* Update the elements for matrix */
			for (current = j+1; current < size; ++current)
			{
				A[p[i]][current] = A[p[i]][current] - ratio*A[p[j][current]];
			}
		}
	}
	return 0;
}

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

/**********************************************************************/
/* Function unpacks the matrices L, U and P and prints them. 		  */
/**********************************************************************/
void unpack_plu(matrix *A, vector *p)
{
	int i, j;
	int temp;
	temp = 0;

	int size = sizeof(p)/sizeof(p[0]);

	/* Print the matrix L */
	for (i = 0; i < size; i++) {
		for (j = 0; j < size; j++)
			if (j < i)
				printf("%3d", A[i][j]);
			else if (j == i)
				printf("%3d", 1);
			else
				printf("%3d", 0);
		printf("\n");
	}


	/* Print the matrix U */
	for (i = 0; i < size; i++) {
		for (j = 0; j < size; j++)
			if (j >= i)
				printf("%3d", A[i][j]);
			else
				printf("%3d", 0);
		printf("\n");
	}

	/* Print the matrix P */
	for (i = 0; i < size; i++) {
		temp = p[i];
		for (j = 0; j < size; j++)
			if (j == temp)
				printf("%3d", 1);
			else
				printf("%3d", 0);
		printf("\n");
	}
}
