/*
 * unpack_plu.c
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
