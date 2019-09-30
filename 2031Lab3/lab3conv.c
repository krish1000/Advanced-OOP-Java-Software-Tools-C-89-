/***************************************
* EECS2031B – Lab3 *
* Author: Manoharan, Krishaanth *
* Email: krish100@my.yorku.ca *
* eecs_username: krish100 *
* York Student #: 216463150
****************************************/
#include <stdio.h>

float calIntFloat(int op1, char operator, float op2);
float calIntInt(int op1, char operator, int op2);
float calFloatFloat(float op1, char operator, float op2);

/*
 * Do you understand why results of the fun-IF and fun-FF are the same but both are different
 * from fun-II? Write a brief justification on the program file (as comments)
 *
 * Ans. The reason behind this is because for IF and FF the floating point will convert the
 * whole equation to a floating point so you keep decimals, because floating has a higher
 * precedence compared to integer.
 * So, for II since both are integers they will round down to Integer numbers.
 * Because integer don't have decimals.
 */
main(){

 int op1; float op2;  char operator;
 float resu, resu2, resu3;

 // conversion in arithemetic
 printf("3.0*9/2/4=%f  9/2*3.0/4=%f  9*3/2*3.0/4=%f\n", 3.0*9/2/4, 9/2*3.0/4, 9/2*3.0/4);

 // conversion in assignment
 float f  = 3.96;
 float f2 = 3.03;
 int i = f; int j = f2;
 printf("i: %d  j: %d\n", i, j);
 char c;

 while((f != -1) && (f2 != -1)){
	 printf("Enter operand_1 operator operand_2 seperated by blanks> ");
	 scanf("%f %c %f", &f, &c, &f2);
	 if ((f == -1) && (f2 == -1)){
		 return 0;
		 break;
	 }
	 printf("\nYour input '%f %c %f' result in", f, c ,f2);
	 printf("\n%f, (fun_IF)", calIntFloat(f, c, f2));
	 printf("\n%f, (fun_IF)", calIntInt(f, c, f2));
	 printf("\n%f, (fun_IF)\n", calFloatFloat(f, c, f2));
 }
 return 0;
}

float calIntFloat(int op1, char operator, float op2)
{
	if(operator == '+'){
		return (op1 + op2);
	} else if(operator == '-'){
		return (op1 - op2);
	} else if(operator == '*'){
		return (op1 * op2);
	} else if(operator == '/'){
		return (op1 / op2);
	}
	return 0; /*If none of the char are operators returning 0*/
}

float calIntInt(int op1, char operator, int op2)
{
	if(operator == '+'){
		return (op1 + op2);
	} else if(operator == '-'){
		return (op1 - op2);
	} else if(operator == '*'){
		return (op1 * op2);
	} else if(operator == '/'){
		return (op1 / op2);
	}
	return 0; /*If none of the char are operators returning 0*/
}

float calFloatFloat(float op1, char operator, float op2)
{
	if(operator == '+'){
		return (op1 + op2);
	} else if(operator == '-'){
		return (op1 - op2);
	} else if(operator == '*'){
		return (op1 * op2);
	} else if(operator == '/'){
		return (op1 / op2);
	}
	return 0; /*If none of the char are operators returning 0*/
}
