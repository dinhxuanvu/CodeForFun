/*
 * linalg_LU_decomp.c
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
	int rescale[];

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
