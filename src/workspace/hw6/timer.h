/*
 * Provides various macros to use when doing a timing analysis of the program.
 * Allow one to create, Start, Stop, and Print various timers.
 */
#ifndef _TIMERS_H
#define _TIMERS_H

#if defined(EN_TIME)

#include <stdio.h>
#include <time.h>
#ifdef WARNING_MSG
	#warning Timers enabled! Execution could be adversly affected.
#endif

/*Define the Number of Loops to run when Timing*/
#ifndef TIMED_LOOP_COUNT
#define TIMED_LOOP_COUNT 10000
#endif

/* Declare a Timer Structure*/
#define DECLARE_TIMER(A) \
		struct{clock_t Start;\
		clock_t Stop;\
		clock_t Elapsed;\
		int State;} A = {0,0,0,0}

/*Start a Timer with the given Name A*/
#define START_TIMER(A){ \
		if(A.State==1) \
		fprintf(stderr,"Error, running timer "#A" started.\n");\
		A.State=1;\
		A.Start=clock();\
		}
/* Reset the Given Timer*/
#define RESET_TIMER(A) { A.Elapsed = 0 }

/* Stop the Given Timer */
#define STOP_TIMER(A){\
		A.Stop=clock();\
		if(A.State == 0)\
		fprintf(stderr,"Error, stopped timer "#A" stopped again.\n");\
		else\
		A.Elapsed+= A.Stop-A.Start;\
		A.State=0;\
}
/* Print the Given Timer as well as the time per loop */
#define PRINT_TIMER(A){\
		if(A.State==1)\
		STOP_TIMER(A);\
		printf("Time Per Calculation: %f ms\n", (double)(A.Stop-A.Start)/\
				(double)(CLOCKS_PER_SEC)/(double)(TIMED_LOOP_COUNT)*1000.0);\
}
/* Start a timed loop. Macro will allow the user to run the calculation multiple times when
   timing, but only once when EN_TIME is not defined */

#define START_TIMED_LOOP(I) \
		do{ unsigned TIME_LOOP_INDEX = I;\
		do
/*End the Timed Loop */
#define END_TIMED_LOOP()\
		while(TIME_LOOP_INDEX-- > 1); \
		}while(0)

#else
/*When EN_TIME is not defined, the macros will disappear*/
#define DECLARE_TIMER(A)
#define START_TIMER(A)
#define RESET_TIMER(A)
#define STOP_TIMER(A)
#define PRINT_TIMER(A)
#define START_TIMED_LOOP(I)
#define END_TIMED_LOOP()
#endif


#endif
