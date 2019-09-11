#include <stdio.h> // define EOF
/***************************************
* EECS2031B – Lab1 *
* Author: Manoharan, Krishaanth *
* Email: krish100@my.yorku.ca *
* eecs_username: krish100 *
* York Student #: 216463150
****************************************/
main(){
 int c;
 int count = 0;
 int lines = 0;

 c = getchar();
 while(c != EOF) /* no end of file*/
 {
	 //if(c == '\n'|| c== 'n'){
	 if(c == '\n'){ //if its new line
		 lines++;
	 } else {
		 count++; //include spaces and '\n'
	 }
	 c = getchar(); /* read next */
 }
 printf("# of chars: %d\n",count);
 printf("# of lines: %d\n",lines);

}
