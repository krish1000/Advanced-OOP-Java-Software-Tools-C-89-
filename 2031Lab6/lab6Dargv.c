/***************************************
 * EECS2031B – Lab 6 *
 * Author: Krishaanth, Manoharan*
 * Email: krish100@my.yorku.ca *
 * eecs_num: krish100 *
 * Yorku #: 216463150
 ****************************************/
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int getSum(char *[], int n);
int getDiff(char **, int n);

int main(int argc, char **argv) {
	printf("There are %d arguments (excluding \"%s\")\n", argc-1, *(argv));

	if(strcmp(*(argv+1), "sum") == 0){
		int i = 2;
		printf("%s ", *(argv + i));
		for(i = 3; i < argc; i++){
			printf("+ %s ", *(argv +i));
		}
		printf("\n= %d\n", getSum(argv, argc));
	} else {
		int i = 2;
		printf("%s ", *(argv + i));
		for(i = 3; i < argc; i++){
			printf("- %s ", *(argv +i));
		}
		printf("\n= %d\n", getDiff(argv, argc));
	}
}

int getSum(char *x[], int n){

	int i = 2;
	int total = 0;
	for(i = 2; i<n; i ++){
		total += atoi(*(x + i));
	}
	return total;
}

int getDiff(char **x, int n){

	int i = 2;
	int total = atoi(*(x+2));
	for(i = 3; i<n; i ++){
		total -= atoi(*(x + i));
	}
	return total;
}
