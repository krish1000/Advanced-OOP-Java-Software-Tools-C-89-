/***************************************
* EECS2031B – Lab3 *
* Author: Manoharan, Krishaanth *
****************************************/

#include <stdio.h>
#include <string.h>

#define SIZE 12
int isQuit(char str[]); //substring charat etc

int main (){
   char str[SIZE];
   int i;
   for(i=0; i<SIZE; i++)
      printf("[%d] %c %d\n",i,str[i], str[i]);
    printf("\n");


   scanf("%s", str);

   while ( ! isQuit(str)){
    for(i=0; i<SIZE; i++)
      printf("[%d] %c %d\n",i,str[i], str[i]);

    printf("%s  %d  %d\n\n", str, sizeof str,strlen(str));

    scanf("%s", str); // read again
  }

   return 0;
}

int isQuit(char str[])
{
  if (str[0]=='q' && str[1]=='u' && str[2]=='i' && str[3]=='t' && str[4]=='\0')
     return 1;
  return 0;
}
