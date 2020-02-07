
#include <stdio.h>
#include <string.h>
#include <ctype.h>
#include <stdlib.h>

#define ROWS 20
#define COLUMNS 30

int main(int argc, char *argv[])
{
     char input_table[ROWS][COLUMNS];

     /*addometing*/
     char name[10];
     int age;
     float rate;

     int current_row = 0;

     printf("Enter name age and rate: ");
     fgets(input_table[current_row], 30, stdin);   // add a /n

     /*Added so we can put it in while loop*/
     sscanf(input_table[current_row], "%s %d %f", name, &age, &rate);

     while(strcmp(name, "xxx") != 0)
     {
	 /* need to 'tokenize' the current input */
    	 sscanf(input_table[current_row], "%s %d %f", name, &age, &rate);
    	 //fputs(input_table[current_row], input_table[current_row]);
    	 //printf("rate : %fasdf", rate);
	 /*************/
    	 int k = 0;
    	 for (k = 0; k < strlen(name); k++){
    		 name[k] = toupper(name[k]);
    	 }

    	 age += 10;

    	 rate *= 1.5;

    	 current_row++;
    	 sprintf(input_table[current_row], "%s %d %.2f\n", name, age, rate);
    	 current_row++;
        // read again
    	 printf("Enter name age and rate: ");
    	 fgets(input_table[current_row], 30, stdin);   // add a /n
    	 sscanf(input_table[current_row], "%s %d %f", name, &age, &rate);

     }

     printf("\nRecords generated in %s on %s %s\n", __FILE__, __DATE__, __TIME__);
     /* now display the input_table row by row */
     int j = 0;
     	for (j = 0; j < current_row; j++){
     		printf("row[%d]: %s", j, input_table[j]);
     	}
     return 0;
}

//     int x = 0;
//     for(x = 0; x <= 30; x++){
//    	 if(input_table[current_row[x]] == '\n'){
//    		 input_table[current_row[x]] = '\0';
//    		 break;
//    	 }
//     }


