#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>

#define SIZE 10
int my_atoi (char c[]);

int main(){
  int a,b;
  char arr [SIZE];

  printf("Enter a postive number or 'quit': " );
  scanf("%s", arr);
  while(strcmp(arr, "quit") != 0)
  {
    printf("%s", arr);

    a = atoi(arr);
    printf("atoi:    %d (%#o, %#X)\t\t%d\t\t%d\n", a,a,a, a*2, a*a);

    b = my_atoi(arr);
    printf("my_atoi: %d (%#o, %#X)\t\t%d\t\t%d\n", b,b,b, b*2, b*b);


    printf("Enter a postive number or 'quit': " );
      scanf("%s", arr);

  }

  return 0;

}

/* convert an array of digit characters into a decimal int */

/* textbook did scan from left to right.
 Here you should scan from right to left. This is a little complicated but more straightforward */

int my_atoi (char c[])
{
	int i =0;
	int total = 0;
	int counter = 0;
	for (i = strlen(c); i > 0; i--){
//		if (c[i] == '\0'){
//			return total;
//		} else if (i == 0){
//			total += total + c[i] - '0';
		//printf("total: %d", strlen(c));
			total +=  (c[i-1] - '0')*pow(10,counter);
//			printf("total: %d", total);
//			printf("c value: %d", (c[i-1] - '0'));
//			printf("poo: %d", (c[i] - '0')*pow(i,10));
			counter++;
	}

	return total;

}
