/***************************************
* EECS2031B – Lab 5 *
* Author: Krishaanth, Manoharan*
* Email: krish100@my.yorku.ca *
* eecs_num: krish100 *
* Yorku #: 216463150
****************************************/
#include <stdio.h>


#include <math.h>

//....

double my_pow(double, double);

int main(int argc, char *argv[])
{
   int base, power;
   printf("enter base and power: ");
   scanf("%d %d", &base, &power);
   //total = base;
   while (base != -100){
        double res = pow(base, power);
        double res2 = my_pow(base, power);
        printf("pow:    %.4f\n", res);
        printf("my_pow: %.4f\n", res2);


         //....
        printf("enter base and power: ");
        scanf("%d %d", &base, &power);

    }
    return 0;
}

// this function should be RECURSIVE
// should not use any loop here

double my_pow(double base, double p){
	if (p == 0){
		return 1;
	} else if (p == 1){
		return base;
	} else if (p > 1){
		return base*my_pow(base, p - 1);
	} else if (p == -1){
		return 1/base;
	} else if (p< -1){
		return ((1/base)*my_pow(base, p + 1));
	}

}



//double my_pow(double base, double p)
//{
//	//int total;
////	if (p == 0){
////		return total;
////
////	}
//	if(p>0) {
//		total += base*base;
//		//printf("\npoo: %f", base);
//		if ((p-1) == 0){
//			return total;
//		}
//		my_pow(base, p-1);
//	} else if (p < 0) {
//		total += base/base;
//		if (p+1 == 0){
//			return total;
//		}
//		my_pow(base, p+1);
//	}
//	return 1;
//}
