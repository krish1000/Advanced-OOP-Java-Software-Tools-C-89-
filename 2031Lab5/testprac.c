/*
 * testprac.c
 *
 *  Created on: Oct. 24, 2019
 *      Author: krish
 */
#include <stdio.h>
#include <string.h>
//
//void clearArr (int *arr, int n){
//	int index;
//	printf("indexvalue%d\n", index);
//	while(index < n){
//		//printf("asdf: %d", arr[index]);
//		*(arr + index++) = 0;
//	}
//}


void clearArr (int arr[], int n){
	int index = 0;
	printf("indexvalsdasdue%d\n", index);
	while(index < n){
		//printf("asdf: %d", arr[index]);
		arr[index++] = 0;
	}
}

void testing(){
	int x;
	printf("\nx: %d",x);
}

void increSwap(int *a, int *b){
	*a *= 2;
	*b *= 2;

	swap(&a, &b);
}

void swap (int *a, int *b){
	int temp = *a;
	*a = *b;
	*a = temp;
}

int main(int argc, char **argv) {
	int x = 100;
	int y = 300;

	increSwap(&x, &y);//
	printf("%d %d", x, y);




//	int k[] = {1,5,3,2};
//	clearArr (k, 4);
//	int i = 0;
//	for (i = 0; i < 4; i++){
//		printf("%d", k[i]);
//	}

	//	int x = 2; int y = x << 2; int z = 1 << 2 + 1; int w = 3 & 1 << 2;
	//
	//	printf("%d %d %d %d", x,y,z,w);

		//1.3 could be error
	//	int x = 13, y = 10, z =10; int w = 2;
	//	y= ++x; z = x++; w *= y++;
	//	printf("\n%d %d %d %d", x,y,z,w);


	//	int x = -1; int y =5;
	//	printf("%d %d %d %d", x | y, x & y, x || y, x && y);
	//	printf("\n%d %d", x < y, !x);
	//


//
//	int  adsf = 343;
//	printf("\n%d", adsf);

//	int x = 1 << 3;
//	printf("%d", x);
	//testing();
//	int arr[] = {1,2,3,4,5,6}; int *ptr = &arr[0]; int i;

//	//*(arr + 2) = 0; //valid
//	printf("%d", asdf);
//	ptr = &asdf; //valid
//
//	printf("\n%d  %d\n", *ptr, asdf);

	//arr += 2; //notvalid

	// arr = &i; //invalid

//	printf("\n%d", ptr);
//	//ptr ++; // valid
//
//	// ptr = ptr * 3; //invalid
//	printf("\n%d\n", ptr);
//	int j = 0;
//	for (j = 0; j < 6; j++){
//		printf("%d", arr[j]);
//	}


//	int i, arr [] = {1,3,5,7,9,11};
//	int *p = arr;
//	printf("%p  %p\n", *(arr+5), *p);
//	for (i =0; i<3; i++){
//		printf("%p  %p\n", arr+i,p+i);
//	}


//	int i; int j;
//	int *p; int *q = &j;
//	p = &i;
//
//	*p = 100;
//	*q = 30;
//
//	p = q;
//	*q += 8000;
//	(*p) ++;
//
//	printf("%d-%d-%d-%d", i, j, *p, *q);
//	return 1;

//	char msg [] = "Hello World";
//	printf("%s-%d-%d\n", msg, sizeof msg, strlen(msg));
//	strcpy(msg, "Hi");
//	printf("%s-%d-%d\n", msg, sizeof msg, strlen(msg));

//	char le = 'D';
//
//	while (le <= 'G'){
//		printf("%d %c\n", le +2, le +2);
//		le++;
//	}

//	int a = 7, c = 4; float d = 1.2; int s = 1; int resu;
//	printf("x:%.3f y:%.3f\n", s*a/c*d, c/d*a*s);
//
//	resu = d/c*a*s;
//	printf("%d", resu);

//	int i; int *pInt = &i;
//	char c; char *pChar = &c;
//	double d; double *pDouble = &d;
//	printf("%p %p %p\n", pChar, pInt, pDouble);
//	printf("%p %p %p\n", pChar + 1, pInt + 1, pDouble + 1);
//
//	pInt++; pChar++; pDouble++;
//	printf("%p %p %p\n", pChar, pInt, pDouble);
//
//	pInt += 3; pChar +=3; pDouble +=3;
//	printf("%p %p %p\n", pChar, pInt, pDouble);

//	int i, arr[] = {17,3,58,10,126,22,43,456};
//	int *p = arr; int *q;
//	printf("%p  %d\n", arr+3, *(arr+3));
//	printf("%p  %d\n", p+4, *(p+4));
//	p++;
//	printf("%p  %d\n", p+3, *(p+3));
//	q = arr + 5;
//	printf("%p  %d\n", q, *(q));
//	printf("%d  %d  %d\n", q-p, p-arr, p < q);
//	(*p)++; *(q+1) -= 10;
//	for (i = 0; i < sizeof(arr)/sizeof(int); i++){
//		printf("%d ", *(arr+i));
//	}
//	int arr[] = {1,2,3,4,5,6}; int *ptr = &arr[0]; int i;
//	i = ptr - arr + 1;
	//i = ptr + arr;
//
//	char arr[0];
////	print("%d", )
////	int x = 5UL;
//	printf("%d", x);

//	int x = 5;
//	int y = 1;
//	int *ptr = &x;
//	*ptr= x++;
	//printf("X;%d    y:%d", , y);

	return 0;
}
