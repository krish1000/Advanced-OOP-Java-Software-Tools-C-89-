/***************************************
 * EECS2031B – Lab 7 *
 * Author: Krishaanth, Manoharan*
 * Email: krish100@my.yorku.ca *
 * eecs_num: krish100 *
 * Yorku #: 216463150
 ****************************************/
#include <stdio.h>
#include <stdlib.h> //added

void setArr (int, int);

int * arr[10]; // array of 10 int pointers, global variable

int main(int argc, char *argv[])
{
     int i;

     int a=-10, b=100, c=200,d=300,e=400;
     int *pA = &a;

     arr[0] = pA;
     arr[1] = &b;
     arr[2] = &c;
     arr[3] = &d;
     arr[4] = &e;

     for(i=0; i<5;i++)
         printf("arr[%d] -*-> %d %d\n", i, *arr[i], **(arr+i));  /* should be -10, 100, 200, 300, 400 */

     return 0;
}

void setArr (int index, int v){

	arr[index] = malloc(sizeof(int));
	*arr[index] = v;
}
