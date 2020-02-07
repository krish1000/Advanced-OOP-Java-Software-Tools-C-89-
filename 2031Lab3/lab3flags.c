/***************************************
* EECS2031B – Lab3 *
* Author: Manoharan, Krishaanth *
****************************************/
#include <stdio.h>

#define SIZE 16
void printBinary(short int);

/*counting digits*/

int main () {
  int c, i,index;
  short flags = 0;
  printf("flags: ");printBinary(flags); printf("\n\n");

  //added temp to hold the actual digit num
  int temp = 0;
  while ((c = getchar()) != EOF){
	  /*if c is a digit with numerical value x, turn bit x of flags on
	   * Added dis part:*/
   if (c >= '0' && c<= '9'){
	   temp = c - '0';
	   flags = flags | (1<< temp);
	   /* moves 1 to the left of temp spaces
	    * and checks if flags has that number on, it will keep it
	    * and add the new num on the binary ting
	    */
   }
  }
  printf("\nflags: "); printBinary(flags); printf("\n");
  // output  method 1
  for(i=0; i<=9; i++)  {
    int check = flags & (1 << i);   // is bit i is on? 0 or 1
    if ( check )  // check == 1
      printf("%d: %s\n", i, "yes");
    else printf("%d: %s\n", i, "no");
  }

  // output2  method 2
  printf("------------------\n");
  for(i=0; i<=9; i++)  {
    if ( (flags >> i) & 1)  // if bit i is on
       printf("%d: yes\n", i);
    else printf("%d: no\n", i);
  }

 return 1;


 }

void printBinary(short int n ){
   //printf("binary: ");
   int cou = SIZE-1;
   int k[SIZE]={0};

   while (n) {
      if (n & 1)
         k[cou]=1; //printf("1");
      else
         k[cou]=0; //printf("0");

      n >>= 1;
      cou--;
   }
   int i=0;
   for(; i< SIZE;i++)
   {
      printf("%d", k[i]);
      if ((i+1)%8==0)
      {
         printf(" ");
      }
   }
}
