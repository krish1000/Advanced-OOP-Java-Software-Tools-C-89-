
/* Passing an array to a function. */


#include <stdio.h>

#define MAX 20


int largest(int * x);
void display(int *arr);

int main(int argc, char *argv[])
 {
	int array[MAX], count;

	/* Input MAX values from the keyboard. */
	int i;  count=0;

	while ( scanf("%d", &i) != EOF){
	    *(array + count) = i; // store in array[count]
	    count++;
	}

	/**ADDED CODE**/
	/*Adding a token to the end of the array to show the end slot for the other methods*/
	*(array +count) = -1;

	/* Call the function and display the return value. */
	printf("Inputs: ");
	display(array);



	printf("\nLargest value: %d\n", largest(array));

	return 0;
 }

 /* display a int array */

 void display(int *arr)
 {
	 int i = 0;
	 for (i = 0; i < MAX; i ++){
		 if (*(arr + i) < 0){
			 break;
		 }
			 printf("%d ", *(arr+i));
	 }
 }

/* Function largest() returns the largest value */
 /* in an integer array */

int largest(int * arr)
{
	 /*I could have added largest method to display but prof wanted it to be seperate*/
	int max = *(arr);
	int i = 0;
	for (i = 0; i < MAX; i ++){
		if (*(arr + i) < 0){
			return max;
		} else if (*(arr + i) > max){
			max = *(arr + i);
		}
	}
	return max;
}
