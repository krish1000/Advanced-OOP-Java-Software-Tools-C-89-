/***************************************
* EECS2031B – Lab 6 *
* Author: Krishaanth, Manoharan*
* Email: krish100@my.yorku.ca *
* eecs_num: krish100 *
* Yorku #: 216463150
****************************************/
#include <stdio.h>
#include <string.h>

main(){

 /********** recap of pointer basics **********************/
 int a = 10;
 int *p = &a;
 printf("%d\n\n", *p ); // printee level

 char arr[]="hello";
 char *ptr = arr;  // = &arr[0]

 // different ways to pass the array to printf, at "pointer" level, not *arr, *ptr
 printf("%s %s %s\n", &arr[0], arr, ptr); // pointer level
 printf("%d %d %d\n", strlen(&arr[0]), strlen(arr), strlen(ptr));

 // passing sub-string
 printf("%s %s %s\n", &arr[2], arr+2, ptr+2); // pointer level
 printf("%d %d %d\n\n", strlen(&arr[2]), strlen(arr+2), strlen(ptr+2));

 //different ways to access arr[0]
 printf("%c %c %c\n", arr[0], *ptr, *arr); // pointee level

 //different ways to access arr[1]
 printf("%c %c %c\n", arr[1], *(ptr+1), *(arr+1) ); // pointee level

 //different ways to access arr[4]
 printf("%c %c %c\n\n", arr[4], *(ptr+4), *(arr+4) ); // pointee level



 /*********** array of poniters to int ***************************/

 int i=1; int j=3;  int k; int n;
 int * arrP[3];  // declare array of 3 (uninitilized) int pointers

 // different ways to initialize the pointers
 int * pi = &i;
 arrP[0]= pi;
 arrP[1]= &j;
 arrP[2]= &k;

// set value of k to be 5 via its pointer in array  arrP
 /*----------------------added------------------------*/
 **(arrP + 2) = 5;



 /*--------------------------------------------------*/

 /* print pointees of element pointers maintained in array arrP, using both array notation and pointer notation*/
 for (n=0; n<3; n++)  {// print elements ; should output 1 1, 3 3, 5 5
	 printf("%d %d\n",  *arrP[n],   **(arrP + n)  );  // printf("%d %d\n",  ? arrP[?],   ? arrP+ ?  );  // pointee level
 }

 // declare a pointer pp0 that points to the first element of arrP (what type is it);
 //  ? pp0 = arrP; // = &arrP[0]
int **pp0 = arrP;
// print pointees of element pointers maintained in array arrP, via pp0; should print 1, 3, 5
 for (n=0; n<3; n++) {
	 printf("%d\n",  **(pp0 + n )); // printf("%d\n",   ));  // pointee level
 }

/************ /***** array of char pointers, each pointer points to an char array ***********/
 char * planets[] = {"Mercury", "Venus", "Earth",
	                     "Mars", "Jupiter", "Saturn",
	                     "Uranus", "Neptune", "Pluto"};

 // print the pointee of the 1st element pointer of planets (i.e., string "Mercury") , using both array index notation i.e., planets[i] and pointer notation,
 printf("\n%s %s %d %d\n", planets[0], *(planets+0), strlen(planets[0]), strlen(*planets));

 // print the pointee of the 2nd element pointer (i.e., string "Venus"), using both array index notation  and pointer notation,
 printf("%s %s \n", planets[1], *(planets+1)); //strlen(planets[1]), strlen(*planets)
/**DIDNT ASK FOR STRINGLENGTH SO I LEFT IT OUT ***/
 // print the pointee of the 5th element pointer (i.e., string "Jupiter"), using both array index notation  and pointer notation,
 printf("%s %s \n", planets[4], *(planets+4));

 // print the pointee of the 6th element pointer (i.e., string "Saturn"), using both array index notation and pointer notation,
 printf("%s %s \n", planets[5], *(planets+5));

 // print the pointee of the 8th element pointer (i.e., string "Neptune"), using both array index notation  and pointer notation,
 printf("%s %s \n", planets[7], *(planets+7));

 // declare a pointer to point to the first element of planets;
  // ? pp = planets;    //  = &planets[0]
 char **pp = planets;
 // print the pointee of the 1st element pointer (i.e., string "Mercury") in the pointer array, via pp and using pointer notation,
 printf("\n%s %s\n", *(planets+0), *(pp + 0));

 // print the pointee of the 2nd element pointer (i.e., string "Venus"), via pp and using pointer notation,
 printf("%s %s\n", *(planets+1), *(pp + 1));

 // print the pointee of the 5th element pointer (i.e., string "Jupiter"), via pp and using pointer notation,
 printf("%s %s\n", *(planets+4), *(pp + 4));

 // print the pointee of the 6th element pointer (i.e., string "Saturn"), via pp and using pointer notation,
 printf("%s %s\n", *(planets+5), *(pp + 5));

 // print the pointee of the 8th element pointer (i.e., string "Neptune"), via pp and using pointer notation,
 printf("%s %s\n\n", *(planets+7), *(pp + 7));


  // Optional -- for those who love pointer to pointers :-)
  //Access characters in pointee array, using pointer notation
  printf("%c  %c  %c\n",*(planets[0]+0),  **planets,  **pp ); //  *( *(planets+0) +0)  *( *(pp+0) + 0)
  printf("%c  %c  %c\n",  *(planets[4]+3),  *(*(planets+4)+3),  *(*(pp+4)+3) );
  printf("%c  %c  %c\n", *(planets[6]+0),   *(*(planets+6)+0),  *(*(pp+6)+0) );
  printf("%c  %c  %c\n", *(planets[8]+4),   *(*(planets+8)+4),  *(*(pp+8)+4) );

}

