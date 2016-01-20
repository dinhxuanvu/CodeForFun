/*
 * hw6.c
 *
 *  Created on: Nov 8, 2013
 *      Author: dinhxuanvu
 */

#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include "linalg.h"
#include "timer.h"

/********************************************************************/
/* Main program to solve a matrix.		                            */
/********************************************************************/
int main(int argc, char *argv[]) {

	/*FILE *file;*/
	int i, j;
	int row, col;
	double p[] = {'0','1','2','3','4'};
	double b[] = {'1','2','3','2','1'};
	double x[] = {'1','1','1','1','1'};

    MatElement** A = matrix_alloc(5,5);

    for(i = 0; i < 3; i++) {
    	for(j = 0; j < 3; j++) {
    		A[i][j] = i+j;
    	}
    }

	DECLARE_TIMER(myTimer);
	START_TIMER(myTimer);

	/* Print title and version of program */
		printf("Find solution of matrix: \n");

		/* Check for enough command line arguments */
		if (argc >= 2)
		{
			/*file = fopen(argv[1], "r");

			if (file) {
				while (fscanf(file, "%i %i \n", &row, &col) != EOF) {

				}
				fclose(file);
			}
			else {
				printf("Can't open the file.");
				exit(1);
			}*/

			linalg_LU_decomp(A, &p);
			linalg_LU_solve(A, &p, &b, &x);
			unpack_plu(A, &p);

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


