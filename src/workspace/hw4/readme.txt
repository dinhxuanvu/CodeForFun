Instructions how to use the makefile
Please read carefully and then use the proper command
Format: Command - Description

1. make QSD: To generate the object file to solve the quadratic equation using double precision (double).

2. make QSF: To generate the object file to solve the quadratic equation using single precision (float).

3. make QSO: To generate the object file to solve the quadratic equation using original solver with possible catastrophic cancellation and overflow.

4. make RUNQSD: To run the quadratic solver (with double precision) for five different test cases and save the results in results.txt file.

5. make RUNQSF: To run the quadratic solver (with single precision) for five different test cases and save the results in results.txt file.

6. make RUNQSO: To run the quadratic solver (possible cancellation and overflow) for five different test cases and save the results in results.txt file.

7. make clean: To clean the object files in the directory.

