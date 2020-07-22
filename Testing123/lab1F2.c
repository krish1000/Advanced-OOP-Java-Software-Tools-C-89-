#include <stdio.h> // define EOF
/***************************************
* EECS2031B – Lab1 *
****************************************/
main(){
 int c;
 int count = 0;

 c = getchar();
 while(c != EOF) /* no end of file*/
 {
	 //if(c == '\n'|| c== 'n'){
	 if(c == '\n'){ // if its an enter(new line char) it will ignore and not count
	 } else {
		 count++; //include spaces and '\n'
	 }
	 c = getchar(); /* read next */
 }
 printf("# of chars: %d\n",count);

}
