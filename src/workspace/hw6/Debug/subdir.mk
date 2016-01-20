################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
C_SRCS += \
../hw6.c \
../linalg.c \
../linalg_LU_decomp.c \
../linalg_LU_solve.c \
../unpack_plu.c 

OBJS += \
./hw6.o \
./linalg.o \
./linalg_LU_decomp.o \
./linalg_LU_solve.o \
./unpack_plu.o 

C_DEPS += \
./hw6.d \
./linalg.d \
./linalg_LU_decomp.d \
./linalg_LU_solve.d \
./unpack_plu.d 


# Each subdirectory must supply rules for building sources it contributes
%.o: ../%.c
	@echo 'Building file: $<'
	@echo 'Invoking: GCC C Compiler'
	gcc -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@:%.o=%.d)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '


