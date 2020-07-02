
#include <stdio.h>
//#include <stdlib.h> //added

void setArr (int, int);

int * arr[10]; // array of 10 int pointers

int main(int argc, char *argv[])
{
     int i;

     setArr(0, -10);
     setArr(1, 100);
     setArr(2, 200);
     setArr(3, 300);
     setArr(4, 400);


     for(i=0; i<5;i++)
        printf("arr[%d] -*-> %d %d\n", i, *arr[i], **(arr+i) );   /* should be -10,100, 200,300,400 */
     return 0;
}

/* set arr[index], which is a pointer, to point to an integer of value v */
void setArr (int index, int v){


     int i = v;
     arr[index] = &i;

//	arr[index] = malloc(sizeof(int));
//	*arr[index] = v;
}

/* Write at the end of the program your explanation of the outputs
 *
 * This program compiles, but the output is incorrect:
 * arr[0] -*-> 400 400
   arr[1] -*-> -2 -2
   arr[2] -*-> -2 -2
   arr[3] -*-> -2 -2
   arr[4] -*-> -2 -2
 *
 * arr[index] stores the address of i, but just like setArr1
 * i becomes deallocated so the address value will be unintialized and point to
 * a random negative value such as -2. So once you call setArr and then it stores
 * the address of i, then once it finishes that method it will be deallocated and point
 * to a random address number (negative) in the main function. It maintains the last value
 * which is 400 because it does not get overidded.
 * Need some sort of malloc to store the value.
 */
