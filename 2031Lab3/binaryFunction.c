#include <stdio.h>

#define SIZE 32


void printBinary(int n ){
        printf("binary: ");
        int cou = SIZE-1;
        int k[SIZE]={0};

        while (n) {
             if (n & 1)
                  k[cou]=1; //printf("1");
             else
                  k[cou]=0; //printf("0");

             n >>= 1;
             cou--;
        }
        int i=0;
        for(; i< SIZE;i++)
        {
            printf("%d", k[i]);
            if ((i+1)%8==0)
            {
                printf(" ");
            }
        }

}
