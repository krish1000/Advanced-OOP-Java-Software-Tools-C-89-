/***************************************
* EECS2031B – Lab4 *
****************************************/
#include <stdio.h>

#define MY_PRINT(x,y,z)  printf("running average is %d / %d = %.3f\n", x,y,z)


void r_avg(int, int);


int main(int argc, char *argv[])
{

      int input; int count=0; int sum=0;
      //double resu;

      printf("Enter number (-1 to quit):  ");
      scanf("%d", &input);

      while(input != -1)
      {
    	  sum += input;

//          resu = r_avg(sum, count);
//          My_PRINT(sum, count, resu);
    	  count++;
    	  r_avg(sum, count);
          /* read again */
          printf("\nEnter number (-1 to quit):  ");
          scanf("%d", &input);

       }

       return 0;
}

void r_avg(int sum, int count)
{

   double resu = sum/ (double)count;
   MY_PRINT(sum, count, resu);
}
