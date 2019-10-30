/***************************************
* EECS2031B – Lab 5 *
* Author: Krishaanth, Manoharan*
* Email: krish100@my.yorku.ca *
* eecs_num: krish100 *
* Yorku #: 216463150
****************************************/

#include <stdio.h>

/**
 * ADDED string.h NOT SURE IF WE ARE ALLOWED TO USE
 */
#include <string.h>

#define SIZE 40

void printReverse(char*);
int isPalindrome(char*);

int main() {
	int result;
	char c;
	int i;
	int count = 0;
	char arr[SIZE];

	fgets(arr, SIZE, stdin);
	while (strcmp(arr, "quit\n") != 0) {
		arr[strlen(arr) - 1] = '\0'; // remove the trailing \n
		// print backward
		/**TESTING**/
		//printf("\npoo: %c", *(arr+1));
		/********************/
		printReverse(arr);

		if (isPalindrome(arr))
			printf("\nIs a palindrome.\n\n");
		else
			printf("\nNot a palindrome.\n\n");

		// ...
		fgets(arr, SIZE, stdin);
	}
	return 0;
}

int isPalindrome(char *str){
	int i = 0;
	int lengthcounter = strlen(str)- 1;
	for (i = 0; i < strlen(str)-1; i++){
		if (lengthcounter == 0 || lengthcounter == 1){
			return 1;
		} else if (*(str+i) == *(str + lengthcounter)){
			lengthcounter--;
		} else {
			return 0;
		}
	}
	return 1;
}

// assume the \n was already removed manually

void printReverse(char * str){
	int i = 0;
	for (i = strlen(str) - 1; i >= 0; i--){
		printf("%c", *(str+ i));
	}
}


//tried recursive but gave up
//int isPalindrome(char *str) {
//	//printReverse(str);
//	//print reverse into temp arr and compare if equal
//	if (strlen(str) == 0 || strlen(str) == 1){
//		return 1;
//	} else {
//		char front = *str;
//		char end = *(str + strlen(str) - 1);
//
//		if (front != end){
//			return 0;
//		} else {
//			*str = null;
//			isPalindrome()
//		}
//	}
//
//	return 1;
//}


//tried recursive got confused
//void printReverse(char * str) {
//	if (strlen(str) == 0) {
//
//	} else {
//		char c = *(str + strlen(str)-1);
//		printf("%c",c);
//		printReverse((str+1));
//		printf("'len: %d'", strlen(str));
//	}
//
//
//}
//
//void printReverse(char *str) /*maybe try recursive?*/
//{
//	int i = 0;
//	int countdown = strlen(str) - 1;
//	char firstchar = *(str);
//
//	for (i = 0; i < strlen(str); i++) {
////		*str[i] = *str[countdown--];
//		*(str + i) = *(str + countdown);
//		//printf("\nTING: letter: %c |counter: %d |strlen: %d", *(str+i), countdown, strlen(str));
//		if (countdown != -1) {
//			printf("%c", *(str + i));
//		} else {
//			*(str + (strlen(str) - 1)) = firstchar; //puts the first character at the end
//			printf("%c", firstchar);
//		}
//		countdown--;
//	}
//	*(str + (strlen(str) - 1)) = firstchar; //puts the first character at the end
//}
