
#include <stdio.h>
#include <stdlib.h>

void insertBegining(int);

struct node {
	int data;
	struct node *next;
};

struct node *head;

main()

{
	head = NULL;

	insertBegining(100);
	insertBegining(200);
	insertBegining(300);
	insertBegining(400);
	insertBegining(500);

	int i;
	struct node *cur;
	for (cur = head; cur != NULL; cur = cur->next)
		printf("%d ", cur->data);
	printf("\n");
}

/* ORIGINAL :
 * struct node newNode;
 newNode.data = dat;
 newNode.next = head;
 head = &newNode;
 *
 */

/*****ANSWER FOR D1****************
 *
 * Similiar to part1, because newNode is declared in a separate function
 * in inserBegining newNode is allocated, but once during runtime the program
 * moves out of insertBegining it will cause the program to deallocate newNode once
 * its back in main function. lab7D0 works because everything is initiated in the main function.
 * So it keeps/maintains those struct nodes. Meanwhile here it will get deallocated each time it runs and keeps
 * the final value which is 500. Because it doesn't get overidded by the other numbers since its last.
 *
 */
void insertBegining(int dat) {

	struct node * newNode;
	newNode = malloc(sizeof(struct node));
	newNode->data = dat;
	newNode->next = head;
	head = newNode;

	// no need for head malloc
//   struct node * newNode;
//   //newNode.data = dat;
//   newNode = malloc(sizeof(struct node));
//   struct node * headNode;
//   headNode = malloc(sizeof(struct node));
//   newNode->data = dat;
//
//   newNode->next = headNode;
//
//   headNode = &newNode;

}

