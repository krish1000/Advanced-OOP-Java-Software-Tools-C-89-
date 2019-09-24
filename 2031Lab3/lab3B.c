/***************************************
* EECS2031B – Lab3 *
* Author: Manoharan, Krishaanth *
* Email: krish100@my.yorku.ca *
* eecs_username: krish100 *
* York Student #: 216463150
****************************************/

#include <stdio.h>

#define SIZE 10


int my_atoi (char c[]); /*added dis */

int main(){
  int a,b;
  char arr [SIZE];

  printf("Enter a postive number or 'quit': " );
  scanf("%s", arr);
  while(   )
  {
    printf("%s", arr);

    a = atoi(arr);
    printf("atoi:    %d (%#o, %#X)\t\t%d\t\t%d\n", a,a,a, a*2, a*a);

    b = my_atoi(arr);
    printf("my_atoi: %d (%#o, %#X)\t\t%d\t\t%d\n", b,b,b, b*2, b*b);



  }

  return 0;

}

/* convert an array of digit characters into a decimal int */

/* textbook did scan from left to right.
 Here you should scan from right to left. This is a little complicated but more straightforward */

int my_atoi (char c[])
{


}
