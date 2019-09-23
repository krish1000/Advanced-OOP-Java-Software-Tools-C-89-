/***************************************
* EECS2031B – Lab2 *
* Author: Manoharan, Krishaanth *
* Email: krish100@my.yorku.ca *
* eecs_username: krish100 *
* York Student #: 216463150
****************************************/
#include <stdio.h>

int isDigit(char c);

int main(){
	const int  big = -10000;
	int input1 = 0;
	int input2 = 0;
	int temp = 0;
	int sum = 0;

	while (input1 != big){
		printf("Enter an integer and a character separated by blank: ");
		scanf("%d %c", &input1, &input2);

		if(input1 == big){
		}else if (isDigit(input2) == 1){
			temp = input2 - '0';
			sum = input1 + temp;
			printf("Character '%d' represents a digit. Sum of %d and %d is %d\n\n", temp, input1, temp, sum);
		} else {
			printf("Character '%c' does not represent a digit\n\n", input2);
		}
	}
	/*if c = integer pass it, if it isnt then output C is not a digit.
	 *
	 */
	return 0;
}

int isDigit(char c){
	/*
	 * or use if (c >= '0' && c<= '9')
	 * if (c >= 48 && c<= 57)
	 *
	 */
	if (c >= '0' && c<= '9'){
		return 1;
	}
	return 0;
}

/* Boolean doesn't exist in C
 * ANSI-C uses 0 to represent false, and non zero for true.
 */
