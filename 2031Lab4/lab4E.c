/***************************************
* EECS2031B – Lab4 *
* Author: Manoharan, Krishaanth *
* Email: krish100@my.yorku.ca *
* eecs_username: krish100 *
* York Student #: 216463150
****************************************/
#include <stdio.h>
#include <string.h>
#include <ctype.h>
#include <stdlib.h>

int main(){

	/*Declaring age and age2, 10 and 100, respectively*/
	int age = 10;
	int age2 = 100;

	int *ptr = &age; /*pointer ptr points to age's address*/

	/*Print age, both via age(direct access),
	 * and via pointer ptr (indirect access)*/
	printf("age: %d %d", age, *ptr);

	/*Changes value of age to 14 using ptr*/
	*ptr = 14;

	/*Print age, both via age(direct access),
	 * and via pointer ptr (indirect access)*/
	printf("\nage: %d %d", age, *ptr);

	int *ptr2;
	ptr2 = &age2; /*ptr2 points to age2*/

	*ptr2 = *ptr; /*ptr2(age2) gets ptr's value (age1)*/

	/*Print age2, both via age2(direct access),
	* and via pointer ptr (indirect access)*/
	printf("\nage2: %d %d", age2, *ptr2);

	ptr2 = ptr; /*ptr2 (&age2) gets ptr's address (&age)*/

	printf("\nptr2's pointee: %d", *ptr2); /*Output ptr2's value*/
	printf("\nage: %d %d %d", age, *ptr, *ptr2); /*Output all age values*/

	(*ptr2)--; /*Decreases ptr2's value by 1*/
	printf("\nage: %d %d %d\n", age, *ptr, *ptr2); /*Output all age values*/

	/*Prints address of all 3 tings*/
	printf("%p %p %p\n", &age, ptr, ptr2);

}
