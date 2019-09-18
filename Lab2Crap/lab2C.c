#include <stdio.h>
#include<string.h>
/***************************************
* EECS2031B – Lab1 *
* Author: Manoharan, Krishaanth *
* Email: krish100@my.yorku.ca *
* eecs_username: krish100 *
* York Student #: 216463150
****************************************/

#define SIZE 10

int main () {

  int k[SIZE];
  int i=0;
  for (i=0; i< SIZE; i++)
    printf("k[%d]: %d\n", i, k[i]);


  char msg[]="Hello world";
  printf("\nmsg: %s\n", msg);
  printf("memory size of msg: %d (bytes)\n", sizeof(msg));
  printf("strlen of msg: %d\n", strlen(msg));
  /* your code here */

  char msg2[2*SIZE] = "Hello world";
  printf("\nmsg2: %s\n", msg);
  printf("memory size of msg2: %d (bytes)\n", sizeof(msg2));
  printf("strlen of msg2 : %d\n", strlen(msg));
  /* your code here */

  /*char msg3[2*SIZE];
  printf("\nEnter a string: ");
  scanf("%s",msg3);
  printf("msg3: %s\n",msg3);
  printf("memory size of msg3: %d (bytes)\n", sizeof(msg3));
  printf("strlen of msg3: %d\n", strlen(msg3));
*/

  return 0;
}
