#include <stdio.h>
/***************************************
* EECS2031B – Lab1 *
* Au
****************************************/

float sum(float i, float j); // declaring sum method

int main(){
	float x, y, su;
	printf("Enter two float numbers separated by ##: ");
	scanf("%f##%f", &x, &y);
	su = sum(x,y); //can't have sum before scan for some reason
	printf("%f + %f = %f\n", x, y, su);
	return 0;
}

/* function definition */
float sum (float i, float j){
	return i+j;
}
