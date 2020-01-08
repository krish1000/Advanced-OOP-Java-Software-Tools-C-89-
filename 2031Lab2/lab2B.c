#include <stdio.h>
/*
 * int c;
 * c = getchar();
 * while (c != EOF){
 * putchar(c);
 * c = getchar();
 * }
 */
int main(){
	int c;
	c = getchar();

	while (c != EOF){
		if(c >= 'a' && c <= 'z'){
			c = c - 32;
			putchar(c);
			c = getchar(); /* go to the next one */
		} else{
			putchar(c);
			c = getchar(); /* go to the next one */
		}

	}
}
