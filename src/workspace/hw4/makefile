# Make file to test QuadraticSolver program
#
# Revised: Vu Dinh (10/16/2013)

SOURCE= QuadraticSolver.c
SOURCEOLD= QuadraticSolver2.c
PROGD= QSDD
PROGF= QSFT
PROGOLD= QSOLD
RESULT= results.txt

# Compipler and Directives
CC= gcc
CFLAGS= -Wall -std=c99 -pedantic
LIBS= -lm


.SILENT:

QSD:
	$(CC) $(CFLAGS) -DD -o $(PROGD) $(SOURCE) $(LIBS)
QSF:
	$(CC) $(CFLAGS) -o $(PROGF) $(SOURCE) $(LIBS)
QSO:
	$(CC) $(CFLAGS) -o $(PROGOLD) $(SOURCEOLD) $(LIBS)

RUNQSD:
	$(MAKE) RESULTS ARGS="QSDD"
	
RUNQSF:
	$(MAKE) RESULTS ARGS="QSFT"
	
RUNQSO:
	$(MAKE) RESULTS ARGS="QSOLD"

clean:
	-rm -rf *.o

RESULTS: 
	echo "------- Running Program -------" 	> $(RESULT)
	echo "a) a=1,b=−10^5,c=1:" 		>> $(RESULT)
	./${ARGS} 1 -1e5 1   			>> $(RESULT)
	echo "b) a=6×10^30,b=5×10^30,c=−4×10^30:" >> $(RESULT)
	./${ARGS} 6e30 5e30 -4e30  		>> $(RESULT)
	echo "c) a = 10^−30,b = −10^30,c = 10^30:" >> $(RESULT)
	./${ARGS} 1e-30 -1e30 1e30   		>> $(RESULT)
	echo "d) a=10^-5,b=10^5,c=-10^-10:" 	>> $(RESULT)
	./${ARGS} 1e-5 1e5 1e-10   		>> $(RESULT)
	echo "e) a=-10^-10,b=−10^20,c=1:" 	>> $(RESULT)
	./${ARGS} -1e-10 -1e20 1   		>> $(RESULT)
	echo "------- Ending Program -------" 	>> $(RESULT)

