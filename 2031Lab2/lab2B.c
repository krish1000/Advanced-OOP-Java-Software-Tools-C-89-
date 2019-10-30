#include <stdio.h>

/***************************************
* EECS2031B – Lab2 *
* Author: Manoharan, Krishaanth *
* Email: krish100@my.yorku.ca *
* eecs_username: krish100 *
* York Student #: 216463150
****************************************/

/*
 * int c;
 * c = getchar();
 * while (c != EOF){
 * putchar(c);
 * c = getchar();
 * }
 */
int main(){
	int c;
	c = getchar();

	while (c != EOF){
		if(c >= 'a' && c <= 'z'){
			c = c - 32;
			putchar(c);
			c = getchar(); /* go to the next one */
		} else{
			putchar(c);
			c = getchar(); /* go to the next one */
		}

	}
}
