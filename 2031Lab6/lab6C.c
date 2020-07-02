

#include <stdio.h>
#include <string.h>
#define SIZE 9

void exchangeParr(char*[]);
void printParr(char*[], int);
void printParr2(char**, int);

main() {

	char *inputs[SIZE] = { "this is input 0, giraffes",
			"this is input 1, zebras", "this is input 2, monkeys",
			"this is input 3, kangaroos" };

	char arr1[] = "this is input 4, do you like them?";
	char arr2[] = "this is input 5, yes";
	char arr3[] = "this is input 6, thank you";
	char arr4[] = "this is input 7, you're welcome";
	char arr5[] = "this is input 8, bye";

	inputs[4] = arr1;
	inputs[5] = arr2;
	inputs[6] = arr3;
	inputs[7] = arr4;
	inputs[8] = arr5;

	printf("sizeof char*: %d, sizeof pointer array: %d\n\n", sizeof(char*),
			sizeof inputs);

	// display the array by calling printParr
	printParr(inputs, sizeof(inputs) / sizeof(inputs[0]));
	printf("\n");

	// swap pointee of first and second element pointers
	char *temp[1];
	*temp = *inputs;
	*inputs = *(inputs + 1);
	*(inputs + 1) = *temp;

	// call exchangeParr() to swap some other 'rows';
	exchangeParr(inputs);

	printf("\n== after swapping ==\n");
	printf("===========================\n");

	// display the swapped array by calling printParr()
	printParr(inputs, sizeof(inputs) / sizeof(inputs[0]));
	// display the swapped array again by calling printParr2()
	printf("\n");
	printParr2(inputs, sizeof(inputs) / sizeof(inputs[0]));
	printf("\n");
}

void printParr2(char **arr, int n) {
	int i = 0;
	for (i = 0; i < n; i++) {
		printf("\n[%d] -*-> %s", i, *(arr+i));
	}
}

void exchangeParr(char *inputs[]) {
	char *temp[1];
	*temp = *(inputs + 2);
	*(inputs + 2) = *(inputs + 3);
	*(inputs + 3) = *temp;

	*temp = *(inputs + 4);
	*(inputs + 4) = *(inputs + 5);
	*(inputs + 5) = *temp;
}

void printParr(char *arr[], int n) {
	int i = 0;
	for (i = 0; i < n; i++) {
		printf("\n[%d] -*-> %s", i, *(arr+i));
	}
}

