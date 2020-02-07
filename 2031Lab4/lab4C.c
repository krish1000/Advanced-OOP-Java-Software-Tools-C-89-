
#include <stdio.h>
#include <string.h>
#include <math.h>
#include <ctype.h>
/*Add someting*/

#define SIZE 10
#define SIZE2 40

int main(int argc, char *argv[])
{

     char input[SIZE2];
     char name[SIZE];
     /*Add someting*/
     int age;
     float rate;

     char resu[SIZE2], resu2[SIZE2];

     printf("Enter name, age and rate (or \"exit\"): ");
     fgets(input, 40, stdin);
     while (strcmp(input, "exit\n") != 0) //added this not sure if it works
     {
       //output original input using two functions.
       printf("%s", input);  // no \n needed
       fputs(input, stdout);

       /*Separates the string into it's variables*/
       sscanf(input, "%s %d %f", name, &age, &rate);

       /*Makes first letter capital*/
       name[0] = toupper(name[0]);
       rate = rate*2; /*Doubles rate*/
       age += 10;	  /*Adds 10 to age*/

       /*gets floor and ceiling value for rate, then becomes an int*/
       int floor1 = floor(rate);
       int ceil1 = ceil(rate);
       /*sprintf to put a string into the array */
       sprintf(resu, "%s-%d-%.3f-[%d,%d]", name, age, rate, floor1, ceil1);

       /*How would I use string copy for this*/
       //sprintf(resu2, "\n%s", resu);

       printf(resu);
//       printf(resu2);

       /*Put what you want to copy 2nd*/
       strcpy(resu2, resu);
       printf("\n%s", resu2);

       /* use fgets to read again */

       printf("\nEnter name, age and rate (or \"exit\"): ");
       fgets(input, 40, stdin);
     }
      return 0;
}
