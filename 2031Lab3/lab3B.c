/***************************************
* EECS2031B – Lab3 *
* Author: Manoharan, Krishaanth *
* Email: krish100@my.yorku.ca *
* eecs_username: krish100 *
* York Student #: 216463150
****************************************/

/* IMPORTANT*** ASSUMING ALL INPUTS ARE VALID
 * a.k.a all char arrays are INTEGERS!
 */
#include <stdio.h>

#define SIZE 10

/**declaring methods */
int my_atoi (char c[]); /*added dis */
int length (char arr[]);
int isQuit(char arr[]);
int power(int base, int n); /*helper function*/

int main(){
  int a,b;
  char arr [SIZE];

  while(isQuit(arr) != 1)  //you could try strcmp() command
    {
	  	  printf("Enter a postive number or 'quit': " );
	  	  scanf("%s", arr);
	  	/* While loop used to be here*/
	  	  if(isQuit(arr) == 1) {
	  		  return 0;
	  		  /* if return 0  doesn't work try break;*/
	  	  }
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
	/*Takes he length of the char array, subtracts by 1, cuz it makes it a higher index */
	int length1 = length(c) -1 ;
	int i = 0; /*declaring for loop*/
	int x = 0; /*declaring for final num*/
	while (c[i] != '\0'){
		if(c[i] == '\0'){
			return x;
		}
		/*Re-adds original num then takes power of each increasing base 10
		  then multiplies to the char value subtracted by 0, assuming
		  everything is an integer value, (minus 48) to get integer value */
		x = x +  power(10, i)*(c[length1] - '0');
		length1--;
		i++;
	}
	/*
	for (i = length1; i > 0; i--){
		x
	}
	*/
	return x;
}

/*Made powerfunction cuz math.pow isn't allowed*/
int power(int base, int n){
	int i = 1;
	int x = base;
	if (n == 0){
		return 1;
	} else if (n == 1) {
		return base;
	}
	for(i = 1; i<n; i++){
		x *= base;
	}
	return x;
}

/* took from lab2E.c */
int length(char arr[])
{
	int count;
	count = 0;

	while (arr[count] != '\0'){
		count++;
	}
	return count;
}

/* try using strcmp() after; quit function taken from lab2E.c */
int isQuit (char arr[])
{
 if (arr[0]=='q' && arr[1]=='u' && arr[2]=='i' && arr[3]=='t') {
    return 1;
 }
 else{
    return 0;
 }
}

