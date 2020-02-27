
#include <stdio.h>
#include <string.h> /*not sure if we're allowed to use*/

#define SIZE 30

void sortArray(char *);

int main(int argc, char **argv) {
	/*can only use indexing for array declarations in main
	Use only pointers & pointer arithmetic to manipulate arrays*/
	char arr[SIZE];
	int i = 0;
	//char *ptr = arr;

	fgets(arr, SIZE, stdin);
	while (strcmp(arr, "quit\n") != 0) {
		*(arr + strlen(arr) -1) = '\0'; // remove the trailing \n

		sortArray(arr);

		printf("%s\n", arr);

		fgets(arr, SIZE, stdin);
	}
}

/*USING SELECTION SORT */
void sortArray(char * arr){
	int numOfElements = strlen(arr);
	int i = 0, j = 0;
	//char *ptr[] = *arr;
	char temp;

	int smallest = i;
	for (i = 0; i <= numOfElements-2; i++){
		smallest = i;
		for (j = i + 1;j <= numOfElements -1; j++ ){
			if (*(arr +j) < *(arr + smallest)){
				//printf("\nJ-%c  smallest-%c\n",arr[j], arr[smallest]);
				smallest = j;

			}
			//printf("-p");
		}
		//swap smallest with index i
		temp = *(arr + i);
		//printf("temp : %c\n", temp);
		*(arr + i) = *(arr + smallest);
		//printf("arr+i: %c\n", *(arr + i));
		*(arr + smallest) = temp;
	}
}
