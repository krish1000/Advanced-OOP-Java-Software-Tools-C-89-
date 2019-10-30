#include <stdio.h>

#define SIZE 10
main(){
  int a; short b; char c; double d;
  int * pInt  = &a;
  short * pShort = &b;
  char * pChar = &c;
  double * pDouble = &d;

  printf("\tchar*(%d)\tshort*(%d)\tint*(%d)\t\t\tdouble*(%d)\n", sizeof(char), sizeof(short), sizeof(int), sizeof(double));
  printf("======================================================================\n");
  printf("p:\t%p\t%p\t%p\t%p\n", pChar, pShort,pInt, pDouble);

  printf("p+1:\t%p\t%p\t%p\t%p\n", pChar+1, pShort+1,pInt+1, pDouble+1);

  printf("p+2:\t%p\t%p\t%p\t%p\n", pChar+2, pShort+2,pInt+2, pDouble+2);

  pInt += 4;  pShort += 4; pChar += 4; pDouble +=4;
  printf("p+=4:\t%p\t%p\t%p\t%p\n", pChar, pShort,pInt, pDouble);

  pInt++; pShort++; pChar ++; pDouble++;
  printf("p++:\t%p\t%p\t%p\t%p\n", pChar, pShort,pInt, pDouble);

  pInt -= 2;  pShort -= 2; pChar -= 2; pDouble -=2;
  printf("p-=2:\t%p\t%p\t%p\t%p\n", pChar, pShort,pInt, pDouble);

  printf("\n================================");
  printf("======================\n");
  printf("================================");
  printf("======================\n");

  int arr[] = {0,100,200,300,400,500,600,700,800,900}, i;
  int *ptr0 = &arr[0];
  int *ptr  = arr;
  printf("&arr[0]: %p   arr: %p\n", &arr[0],arr);
  printf("ptr0:    %p   ptr: %p\n\n",  ptr0, ptr);

  printf("\t\t&arr[i]\t\tarr+i\t\t\tptr0+i\t\tptr+i");

  printf("\n======================================");
  printf("========================================");

  /* Print the addresses of each array element. */
  for (i= 0; i< SIZE; i++)
      printf("\nElement[%d]:\t%p\t%p\t%p\t%p", i, &arr[i], arr+i, ptr0+i,ptr+i);

  printf("\n======================================");
  printf("========================================\n\n");

   /* Print the value of each array element. */
  printf("\t\tarr[i]\t\t*(arr+i)\t*(ptr0+i)\t\t*(ptr+i)");
  printf("\n======================================");
  printf("========================================");
  for (i = 0; i < SIZE; i++)
     printf("\nElement[%d]:\t%d\t\t%d\t\t%d\t\t\t%d", i, arr[i],-1,-1,-1); // complete the code here

  printf("\n======================================");
  printf("========================================\n");


  int x = 100, y=200;
  int *p = &x;
  int **pp = &p;
  printf("x:%d\ty:%d\t*p:%d\t**pp:%d\n", x, y, *p, **pp);
  (**pp) --;
  printf("x:%d\ty:%d\t*p:%d\t**pp:%d\n", x, y, *p, **pp);

  p = &y;
  (**pp) --;
  printf("x:%d\ty:%d\t*p:%d\t**pp:%d\n", x, y, *p, **pp);


  return 0;


}
