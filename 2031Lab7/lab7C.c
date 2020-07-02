

#include <stdio.h>
#include <stdlib.h>

struct ints
{
   int data1;
   int data2;
};

struct intPtr {
   int data;
   int * ptr;
};


struct intArr {
   int data;
   int arr[3];
};


main()
{
  printf("----------- simple struct --------------\n");
  struct ints a = {32,4};
  struct ints b;
  // print the two members of a;
  printf("a: %d %d\n", ...);
  //print the two members of b;
  printf("b: %d %d\n", ...);

  a.data1 = 100;
  b = a;
  // print the two members of a;
  printf("a: %d %d\n",  ...);
  //print the two members of b;
  printf("b: %d %d\n", ...);

  b.data1 = 700; // change b.data1
  //use scanf to change b.data2
  printf("Enter value for b.data2: ");
  scanf("%d", &b.data2);

  // print the two members of a again;

  // print the two members of b again;


  printf("------- struct with pointer member -----------------\n");
  struct intPtr xx;
  xx.data = 5;
  int c = 100;   xx.pp = &c;

  struct intPtr yy = xx;
  // print xx's data, pointer value, and pointee value
  printf("xx: %d %p %d\n", xx.data, xx.ptr, *xx.ptr);

  //print yy's data, pointer value, and pointee value
  .....

  // set the pointee of yy's pointer to be 10000;
  *yy.ptr = 10000;
  printf("c: %d\n", c);
  //print xx's data, pointer value, and pointee value

  //print yy's data, pointer value, and pointee value


  printf("------- struct with array member ------------------\n");

  struct intArr tt = {2, {100,200}};

  // set tt's arr member's 2nd element to be 400;

  //print tt's data element, as well as array elements
  printf("%d [%d %d]", ....)


}

