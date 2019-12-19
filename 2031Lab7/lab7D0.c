#include <stdio.h>
#include <stdlib.h>


struct node {
   int data;
   struct node * next;
};

struct node * head;

main()
{
   head = NULL;

   // add at begining
   struct node newNode;
   newNode.data = 100;
   newNode.next = head;
   head = &newNode;

   // add at begining
   struct node newNode2;
   newNode2.data = 200;
   newNode2.next = head;
   head = &newNode2;

   // add at begining
   struct node newNode3;
   newNode3.data = 300;
   newNode3.next = head;
   head = &newNode3;

   // add at begining
   struct node newNode4;
   newNode4.data = 400;
   newNode4.next = head;
   head = &newNode4;

   // add at begining
   struct node newNode5;
   newNode5.data = 500;
   newNode5.next = head;
   head = &newNode5;


   int i;
   struct node * cur;
   for(cur= head; cur != NULL; cur= cur->next)
      printf("%d ", cur->data);
   printf("\n");
}
