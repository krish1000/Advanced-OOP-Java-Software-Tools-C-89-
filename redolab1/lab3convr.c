/*
 * lab3convr.c
 *
 *  Created on: Oct. 9, 2019
 *      
 */

#include <stdio.h>

float calIntFloat(int op1, char operator, float op2);
float calIntInt(int op1, char operator, int op2);
float calFloatFloat(float op1, char operator, float op2);

int main() {

	int op1;
	float op2;
	char operator;
	float resu, resu2, resu3;

	// conversion in arithemetic
	printf("3.0*9/2/4=%f  9/2*3.0/4=%f  9*3/2*3.0/4=%f\n", 3.0 * 9 / 2 / 4,
			9 / 2 * 3.0 / 4, 9 / 2 * 3.0 / 4);

	// conversion in assignment
	float f = 3.96;
	float f2 = 3.03;
	int i = f;
	int j = f2;
	printf("i: %d  j: %d\n", i, j);

	printf("Enter poo: ");
	scanf("%d %c %f", &op1, &operator, &op2);

	while (op1 != -1 && op2 != -1) {
		printf("\nInput : '%d %c %f'", op1, operator, op2);

		resu = calIntFloat(op1, operator, op2);
		printf("\n%f (fun_IF)", resu);
		resu2 = calIntInt(op1, operator, op2);
		printf("\n%f (fun_II)", resu2);
		resu3 = calFloatFloat(op1, operator, op2);
		printf("\n%f (fun_FF", resu3);
	//	printf("Your input '%d %c %f' result in\n%f (fun_IF)\n%f (fun_II)\n%f (fun_FF)\n\n",op1, operator, op2, resu,resu2, resu3);
		printf("\nEnter poo: ");
		scanf("%d %c %f", &op1, &operator, &op2);
	}

	return 0;

}

float calIntFloat(int op1, char operator, float op2) {
	if (operator == '+') {
		return op1 + op2;
	} else if (operator == '-') {
		return op1 - op2;
	} else if (operator == '*') {
		return op1 * op2;
	} else {
		return op1 / op2;
	}

}

float calIntInt(int op1, char operator, int op2) {
	if (operator == '+') {
		return op1 + op2;
	} else if (operator == '-') {
		return op1 - op2;
	} else if (operator == '*') {
		return op1 * op2;
	} else {
		return op1 / op2;
	}
}

float calFloatFloat(float op1, char operator, float op2) {
	if (operator == '+') {
		return op1 + op2;
	} else if (operator == '-') {
		return op1 - op2;
	} else if (operator == '*') {
		return op1 * op2;
	} else {
		return op1 / op2;
	}
}

