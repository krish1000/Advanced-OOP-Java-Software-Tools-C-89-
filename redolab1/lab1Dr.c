#include <stdio.h>

float sum (float, float);

int main()
{
//   float x =2.2, y=3.3;
//   float su= sum(x,y);
	float i, j;
	printf("Enter two float numbers seperated by ##: ");
	scanf("%f##%f", &i, &j);
	printf("\n%f and %f = %f\n", i,j, sum(i,j));

	return 0;

}

/* function definition */
float sum (float i, float j){
   return i+j;
}
