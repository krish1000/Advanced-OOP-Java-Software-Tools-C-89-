#include <stdio.h>
/***************************************
* EECS2031B – Lab1 *
* Author: Manoharan, Krishaanth *
* Email: krish100@my.yorku.ca *
* eecs_username: krish100 *
* York Student #: 216463150
****************************************/

float sum(float i, float j); // declaring sum method

int main(){
	float x, y, su;
	int n;
	printf("Enter the number of interactions: ");
	scanf("%d", &n); //remember to use & symbol
	//printf("%d", n);

	for(int i = 0; i<n;i++){
		printf("\nEnter two float numbers separated by ##: ");
		scanf("%f##%f", &x, &y);
		su = sum(x,y); //can't have sum before scan for some reason
		printf("%f + %f = %f\n", x, y, su);
	}
	return 0;
}

/* function definition */
float sum (float i, float j){
	return i+j;
}
