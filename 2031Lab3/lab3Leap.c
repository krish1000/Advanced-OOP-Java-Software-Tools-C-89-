/***************************************
* EECS2031B – Lab3 *
* Author: Manoharan, Krishaanth *
* Email: krish100@my.yorku.ca *
* eecs_username: krish100 *
* York Student #: 216463150
****************************************/
#include <stdio.h>

int isLeap(int year);

int main(){
	int input;
 /*IMPORTTANNTNTNTNTNTNNT PUTTING NEG NUMBER STILL CHECKS LEAP YEAR */
	while(input >=0){
		printf("Enter a year: ");
		scanf("%d", &input);
		if (input >= 0){
			if (isLeap(input) == 1) {
				printf("Year %d is a leap year\n\n", input);
			} else if (isLeap(input) == 0){
				printf("Year %d is not a leap year\n\n", input);
			}
		} else {
		return 0;
		}
	}
	return 0;
}

/* Acts like a boolean statement*/
int isLeap(int year){
	if( year % 100 == 0 ){
		if (year % 400 == 0){
			return 1;
		}
		return 0;
	} else if ( year % 4 == 0 || year % 400 == 0){
		return 1;
	}
	return 0;
}

