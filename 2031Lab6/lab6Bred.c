#include <stdlib.h>
#include <string.h>
#include <stdio.h>

void exchange2D(char inputs[][50]);
void print2D(char arr[][50], int n);

int main(int argc, char **argv) {
	char *peepee[1];
	peepee[0] = "pooopoo";
	peepee[1] = "adsasds";
	printf("%s", *(peepee + 2));
//	char inputs[30][50];
//	int current_row = 0;
//
//	printf("Sizeof: %d \n", sizeof(inputs));
//
//	printf("Enter String: ");
//	fgets(inputs[current_row++], 50, stdin);
//
//	while (strcmp(inputs[current_row -1], "xxx\n") != 0) { //DONT FORGET \n is added to x
//
//		printf("Enter String: ");
//		fgets(inputs[current_row++], 50, stdin);
//
//	}
//
//	//exchange row 0 and row1 in main()
//	//then send array to function exchange()
//	print2D(inputs, current_row);
//
//	char temp[50]; //REMEMMERBRERRRRRRRRRRRRRRRRRRRRRRRRRRR THIS
//	strcpy(temp, inputs[0]);
//	strcpy(inputs[0],inputs[1]);
//	strcpy(inputs[1], temp);
//
//	exchange2D(inputs);
//	print2D(inputs, current_row);
}
////swaps 3rd row of the array with that in 4th row,
////and swaps the record in the 5th row with that in the 6th row.
////assume the argument 2d array has atleast 6rows
//void exchange2D(char inputs[][50]) {
//	char temp[50]; //REMEMMERBRERRRRRRRRRRRRRRRRRRRRRRRRRRR THIS
//	strcpy(temp, inputs[2]);
//	strcpy(inputs[2],inputs[3]);
//	strcpy(inputs[3], temp);
////
//		strcpy(temp, inputs[4]);
//		strcpy(inputs[4],inputs[5]);
//		strcpy(inputs[5], temp);
//}
//
//void print2D(char arr[][50], int n) {
//	int i = 0;
//	for(i = 0; i < n-1; i++){
//		printf("[%d]: this is input [%d], %s", i, i, arr[i]);
//	}
//	printf("\n");
//}
