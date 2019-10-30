#include <stdio.h>
#include<string.h>

/***************************************
* EECS2031B – Lab2 *
* Author: Manoharan, Krishaanth *
* Email: krish100@my.yorku.ca *
* eecs_username: krish100 *
* York Student #: 216463150
****************************************/

#define SIZE 10 //on pdf its 20

int main () {

  /*int k[SIZE] = {3,5}; //MODIFIED */
	int k[SIZE] = {0}; /*MODIFIED again */
  int i=0;
  for (i=0; i< SIZE; i++)
    printf("k[%d]: %d\n", i, k[i]);


  char msg[]="Hello world";
  printf("\nmsg: %s\n", msg);
  printf("memory size of msg: %d (bytes)\n", sizeof(msg));
  printf("strlen of msg: %d\n", strlen(msg));
  /* your code here *******************************/
  int j=0;
  for (j=0; j <= strlen(msg); j++){
	  printf("msg[%d]: %d %c \n", j, msg[j], msg[j]);
  }
  /************************************************/
  char msg2[2*SIZE] = "Hello world";
  printf("\nmsg2: %s\n", msg2); /*this was msg, changed it */
  printf("memory size of msg2: %d (bytes)\n", sizeof(msg2));
  printf("strlen of msg2 : %d\n", strlen(msg2)); /*this was msg, i changed it */
  /* your code here *******************************/
  int b=0;
    for (b=0; b < 2*SIZE; b++){
  	  printf("msg2[%d]: %d %c \n", b, msg2[b], msg2[b]);
    }

  /************************************************/
  char msg3[2*SIZE];
  printf("\nEnter a string: ");
  scanf("%s",msg3); /* IMPORTANT for array chars you don't need & symbol infront of msg3, idek */
  printf("msg3: %s\n",msg3);
  printf("memory size of msg3: %d (bytes)\n", sizeof(msg3));
  printf("strlen of msg3: %d\n", strlen(msg3));
  /* your code here *******************************/
    int f=0;
      for (f=0; f < 2*SIZE; f++){
    	  printf("msg3[%d]: %d %c \n", f, msg3[f], msg3[f]);
      }

    /************************************************/


  return 0;
}
