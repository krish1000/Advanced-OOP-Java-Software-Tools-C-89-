/*
 * lab3leapr.c
 *
 *  Created on: Oct. 9, 2019
 *      Author: krish
 */

#include <stdlib.h>
#include <stdio.h>

int isLeap(int year);

int main(int argc, char **argv) {
	int year = 0;
	printf("Enter a year: ");
	scanf("%d", &year);

	while (year > 0) {
		if (isLeap(year)){
			printf("Year %d is a leap year\n", year);
		} else {
			printf("Year %d is not a leap year\n", year);
		}

		printf("Enter a year: ");
		scanf("%d", &year);
	}

	return 0;
}

int isLeap(int year) {
	int poo = 0;
	if (year % 4 == 0 && year % 100 != 0) {
		poo = 1;
	} else if (year % 400 == 0) {
		poo = 1;
	}
	return poo;
}
