
#include <stdio.h>
#include<stdlib.h>
#include<string.h>

void printArr(int*, int);

int main() {
	char *p;
	int n, i;

	int *my_array; /**NEW PLACEMENT**/

	printf("# of elements in int array: ");
	scanf("%d", &n);
	/*p = malloc(n*sizeof(int)); /**Changed**/
	/*int *my_array; ORGINAL PLACEMENT */
	my_array = malloc(n * sizeof(int));
	if (my_array == NULL) {
		printf("Memory allocation failed. Bye!\n");
		exit(0);
	}

	*my_array = -10;
	for (i = 1; i < n; i++)
		*(my_array + i) = i * 100;

	printArr(my_array, n); /*ORIGINAL*/
	/*printArr(p, n); */

	printf("\n");

	p = malloc(6 * sizeof(char));
	strcpy(p, "hello");
	printf("%s %d\n", p, strlen(p));
	*(p + 2) = 'X';
	printf("%s\n", p);

	return 0;
}

/* print the first n elements of int array arr */
void printArr(int *arr, int n) {
	int i = 0;
	for (i = 0; i < n; i++) {
		printf("[%d]: %d\n", i,  *(arr + i));
	}

}
