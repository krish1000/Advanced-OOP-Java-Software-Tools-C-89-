/***************************************
* EECS2031B – Lab2 *
* Author: Manoharan, Krishaanth *
* Email: krish100@my.yorku.ca *
* eecs_username: krish100 *
* York Student #: 216463150
****************************************/
#include <stdio.h>

/*Should use DEFINE for 10 instead, e.g #define SIZE 10;*/
int main(){
	int k[10] = {0};
	int c;
	int temp;

	c = getchar(); /*REMEMBER THIS IS LOWERCASE getchar*/

	while(c != EOF){
		//scanf ("%s", msg);
		if(c >= '0' && c<= '9'){
			temp = c - '0';
			k[temp]++;
		}
		c = getchar();
	}

	int j=0;
	for (j=0; j < 10; j++){
		printf("[%d]: %d \n", j, k[j]);
	}
	return 0;
}
