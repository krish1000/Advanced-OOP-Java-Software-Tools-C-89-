/***************************************
* EECS2031B – Lab2 *
* Author: Manoharan, Krishaanth *
* Email: krish100@my.yorku.ca *
* eecs_username: krish100 *
* York Student #: 216463150
****************************************/
#include <stdio.h>

#define MAX_SIZE 20 /* added 20 idek */

int length(char arr[]);
int isQuit(char arr[]);
int indexOf(char arr[], char c);

int main() { /*added int infront of main*/

   char word[MAX_SIZE];
   char c;

   char helloArr[]  = "hello";

   printf("\"%s\" contains %d input characters, but the size of it is %d (bytes)\n", helloArr, length(helloArr), sizeof helloArr );

   /********** Fill in your code here. **********/
   while (isQuit(word) != 1)
     {
	   	   printf("\nEnter a word and a character separated by blank: ");
	   	   scanf("%s %c", word, &c);
	   	   if(isQuit(word) == 1){
	   		   break;
	   	   }
	   	   printf("Input word is \"%s\". Contains %d characters. Index of '%c' in it is '%d' \n", word, length(word), c, indexOf(word, c));
     }
   return 0; /* added return 0*/
}
/* counts the amount of letters in a char array*/
/* Can't use strlen*/
int length(char arr[])
{
	int count;
	//c = 0;
	count = 0;

	while (arr[count] != '\0'){
		count++;

	}

	/* ignore this
	int i = 0;
	for (i =0; i< 20; i++){
		if(c >= 'A' && c<= 'z'){

			count++;
		} else{
			break;
		}
	}
	*/
	return count;

}

int indexOf(char arr[], char c)
{
	int a = 0;
	int index = -1;
	while(a < length(arr)){
		if (c == arr[a]){
			index = a;
			return index;
		} else{
			a++;
		}
	}
	return index;
}


int isQuit (char arr[])
{
 //int i;
 if (arr[0]=='q' && arr[1]=='u' && arr[2]=='i' && arr[3]=='t') {
    return 1;
 }
 else{
    return 0;
 }
}
