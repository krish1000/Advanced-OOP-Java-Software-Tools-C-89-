/***************************************/
#include <stdio.h>
//#include <stdlib.h> //added


void setArr (int, int);

int * arr[10]; // array of 10 int pointers, global variable

int main(int argc, char *argv[])
{
     int i;

     setArr(0, -10);
     setArr(1, 100);
     setArr(2, 200);
     setArr(3, 300);
     setArr(4, 400);

     for(i=0; i<5;i++)
         printf("arr[%d] -*-> %d %d\n", i, *arr[i], **(arr+i));  /* should be -10, 100, 200, 300, 400 */

     return 0;
}

/* set arr[index], which is a pointer, to point to an integer of value v */
void setArr (int index, int v){


     int i = v;
     * arr[index] = i;

//	int * i = malloc(sizeof(int));
//	*i = v;

//	arr[index] = malloc(sizeof(int));
//	*arr[index] = v;

}

/* Write at the end of the program your explanation of the outputs
 *
 * This program compiles, but it outputs nothing in console. (b/c crashes)
 * When the program calls setArr, int i is initialized to be equal to v
 * and then the pointer arr[index] points to i, this is the issue
 * Once the program exits setArr, int i becomes deallocated so basically
 * pointer arr[index] points to nothing because int i is basically deleted/deallocated (gone)
 * So each time setArr is called at every index, the array is pointing to will be nothing
 * Thus once you  try to print it, nothing is printed because pointer is pointing to nothing thus crashes the program.
 * Need some sort of malloc to store the value.
 */
