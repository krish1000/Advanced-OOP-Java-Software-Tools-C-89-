#include <stdio.h>
#include <string.h>
#include <ctype.h>
#include <stdlib.h>


#define ROWS 20
#define COLUMNS 30

int main(int argc, char *argv[])
{
    char inputs_table [ROWS][COLUMNS];
    char name[10]; char ageS[10]; char rateS[10];

    int counter = 0;
    int age;
    float rate;

    printf("Enter name age and rate: ");
    scanf("%s %s %s", name, ageS, rateS);

    while (strcmp(name, "xxx") != 0)
    {
	   sprintf(inputs_table[counter], "%s %s %s", name, ageS, rateS);
		counter++;

		name[0] = toupper(name[0]);

		age = atoi(ageS) + 10;

		rate = atof(rateS)*1.5;

		sprintf(inputs_table[counter], "%s %d %.2f", name, age, rate);
		counter++;
       /* read again using scanf(%s %s %s) */
	 printf("Enter name age and rate: ");
	 scanf("%s %s %s", name, ageS, rateS);

    }

     printf("\nRecords generated in %s on %s %s\n", __FILE__, __DATE__, __TIME__);

    /* now display the input_table row by row */
	int i = 0;
     for(i = 0; i <counter; i++){
    	 printf("\n%s", inputs_table[i]);
     }

     return 0;
}
