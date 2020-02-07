
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

    printf("Enter name age and rate: ");
    scanf("%s %s %s", name, ageS, rateS);

   // int i = 0;
    int row = 0;
    while (strcmp(name, "xxx") != 0) /*Compares string with xxx*/
    {

    	sprintf(inputs_table[row], "%s %s %s", name, ageS, rateS);

    	int k = 0;
    	for (k = 0; k < strlen(name); k++){
    		name[k] = toupper(name[k]);
    	}
    	/*Does age conversion, adds 10, then to string*/
    	int age = atoi(ageS) + 10;
    	sprintf(ageS, "%d", age);

    	/*Does rate conversion, +50%, then to string*/
    	float rate = atof(rateS)*1.5;
    	sprintf(rateS, "%.2f", rate);

    	row++;
    	sprintf(inputs_table[row], "%s %s %s", name, ageS, rateS);
    	row++;

       /* read again using scanf(%s %s %s) */
		printf("Enter name age and rate: ");
		scanf("%s %s %s", name, ageS, rateS);

		//    	inputs_table[row][i] = name;
		//    	i++;
		//    	inputs_table[row][i] = ageS;
		//    	i++;
		//    	inputs_table[row][i] = rateS;
		//    	i++;


		//    	i=0;
		//    	row++;
		//    	inputs_table[row][i] = name;
		//    	i++;
		//    	inputs_table[row][i] = ageS;
		//    	i++;
		//    	inputs_table[row][i] = rateS;
		//    	i++;

    }

     printf("\nRecords generated in %s on %s %s\n", __FILE__, __DATE__, __TIME__);


    /* now display the input_table row by row */
     int j = 0;
	for (j = 0; j < row; j++){
		printf("row[%d]: %s\n", j, inputs_table[j]);
	}

     return 0;
}
