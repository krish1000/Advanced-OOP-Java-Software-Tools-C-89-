/***************************************
* EECS2031B � Lab4 *
* Author: Manoharan, Krishaanth *
* Email: krish100@my.yorku.ca *
* eecs_username: krish100 *
* York Student #: 216463150
****************************************/
#include <stdio.h>
extern void r_avg(void);
extern int sum;

int main(int argc, char *argv[])
{
    int input;
    printf("Enter number (-1 to quit): ");
    scanf("%d", &input);

    while(input != -1){
      sum += input;
      r_avg();

      // read again
      printf("\nEnter number (-1 to quit): ");
      scanf("%d", &input);

     }

     return 0;
}
