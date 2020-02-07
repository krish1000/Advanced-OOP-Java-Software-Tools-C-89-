/***************************************
* EECS2031B – Lab4 *
* Author: Manoharan, Krishaanth
****************************************/
#include <stdio.h>

#define MY_PRINT(x,y,z)  printf("running average is %d / %d = %.3f\n", x,y,z)

void r_avg(int);

int main(int argc, char *argv[])
{

   int input;
   printf("Enter number (-1 to quit): ");
   scanf("%d", &input);

   while (input != -1){
        r_avg(input);

        printf("\nEnter number (-1 to quit): ");
        scanf("%d", &input);
    }

    return 0;
}

void r_avg(int input)
{
	static int count = 1;
	static int sum = 0;

	sum+= input;
	double resu = sum/ (double)count;
	MY_PRINT(sum, count, resu);
	count++;

}
