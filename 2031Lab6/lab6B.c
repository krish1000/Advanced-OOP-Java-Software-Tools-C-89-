/***************************************
* EECS2031B – Lab 6 *
* Author: Krishaanth, Manoharan*
* Email: krish100@my.yorku.ca *
* eecs_num: krish100 *
* Yorku #: 216463150
****************************************/
#include <stdio.h>
#include <string.h>

void print2D(char  af[][50], int n);
void exchange2D(char inputz[][50]);

int main(int argc, char **argv) {

	char inputs[30][50];
	int current_row = 0;

	printf("sizeof inputs: %d\n", sizeof(inputs));

	printf("\nEnter string: ");
	fgets(inputs[current_row++], 50, stdin);

	char temp1[1][50];
	while(strcmp(inputs[current_row - 1], "xxx\n") != 0){
		//sprintf(temp1[0], "%s", inputs[current_row-1]);
		//sprintf(inputs[current_row-1], "this is input  %d, %s", current_row -1, temp1[0]);

		printf("Enter string: ");
		fgets(inputs[current_row++], 50, stdin);

		//dont need this:
		//*(inputs[current_	1] + strlen(inputs[current_row -1]) + 1) = '\0';
	}

	printf("\n");
	print2D(inputs, current_row-1);
	//swap 1st row and 2nd row in main
	char temp[1][50];
//	*temp = *(inputs);
//	*(inputs) = *(inputs + 1);
//	*(inputs + 1) = *temp;
	//temp[0][50] = inputs[0][50];

	sprintf(temp[0], "%s", inputs[0]);
	sprintf(inputs[0], "%s", inputs[1]);
	sprintf(inputs[1], "%s", temp[0]);

//	inputs[0] = inputs[1];
//	inputs[1] = temp[0][50];

	printf("\n== after swapping =\n");
	exchange2D(inputs);
	print2D(inputs, current_row-1);
}

void exchange2D(char inputs[][50]){
	//swaps 3rd with 4th row and 5th with 6th, assume at least 6 rows
	char temp[1][50];
	sprintf(temp[0], "%s", inputs[2]);
	sprintf(inputs[2], "%s", inputs[3]);
	sprintf(inputs[3], "%s", temp[0]);

	sprintf(temp[0], "%s", inputs[4]);
	sprintf(inputs[4], "%s", inputs[5]);
	sprintf(inputs[5], "%s", temp[0]);

}


void print2D(char af[][50], int n){
	int i = 0;
	for(i = 0; i < n; i++){
		//printf("\n[%d]: this is input %d, %s", i, i, af[i]);
		printf("[%d]: %s", i, af[i]);
	}
}
