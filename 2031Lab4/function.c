/***************************************
* EECS2031B – Lab4 *
* Author: Manoharan, Krishaanth *
* Email: krish100@my.yorku.ca *
* eecs_username: krish100 *
* York Student #: 216463150
****************************************/
#include <stdio.h>

#define MY_PRINT(x,y,z)  printf("running average is %d / %d = %.3f\n", x,y,z)

// define global variables and a function
int sum;
int count = 1;

void r_avg(void)
{
	double resu = sum/ (double)count;
	MY_PRINT(sum, count, resu);
	count++;
}
