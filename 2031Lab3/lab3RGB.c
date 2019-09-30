/***************************************
* EECS2031B – Lab3 *
* Author: Manoharan, Krishaanth *
* Email: krish100@my.yorku.ca *
* eecs_username: krish100 *
* York Student #: 216463150
****************************************/
#include <stdio.h>

/*
 * TO COMPILE MULTIPLE FILES TOGETHER DO:
 * gcc lab3RGB.c binaryFunction.c
 * and also declare the function in binaryFunction in lab3RGB
 */
#define AlphaValue 100
void printBinary(int n );

int main() {

  int r, g,b;
  unsigned int rgb_pack;
  int r_unpack, g_unpack,b_unpack;
  int alpha = AlphaValue;

  printf("enter R value (0~255): ");
  scanf("%d",&r);
  printf("enter G value (0~255): ");
  scanf("%d",&g);
  printf("enter B value (0~255): ");
  scanf("%d",&b);

  while(! (r<0 || g<0 || b <0) )
  {
     printf("A: %d\t", alpha);  printBinary(alpha); printf("\n");
     printf("R: %d\t", r);  printBinary(r); printf("\n");
     printf("G: %d\t", g);  printBinary(g); printf("\n");
     printf("B: %d\t", b);  printBinary(b); printf("\n");

     /* IMPORTANT:
      * ALWAYS MAKE SURE TO CLEAR THE RGBPACK
      * OR ELSE IT WILL GENERATE A RANDOM BINARY!!!
      * REEEEEeeeeeeeeeeeeeeeeeeeeeee
      * Does packing:
      */
     rgb_pack = rgb_pack & 0;
     rgb_pack = rgb_pack | (alpha << 24);
     rgb_pack = rgb_pack | (r << 16);
     rgb_pack = rgb_pack | (g << 8);
     rgb_pack = rgb_pack | (b);


     //printf("\nPacked: value %d\t", rgb_pack); printBinary(rgb_pack);printf("\n");
     printf("\nPacked:\t"); printBinary(rgb_pack);printf(" (%d)\n", rgb_pack);
     printf("\nUnpacking  ......\n");

    /* you could just reprint the original nums
     * But in this case we have to use rgb_pack
     * Does unpacking */

     r_unpack = (rgb_pack >> 16) & 0377; /* 0377 is hexadec, for 8 1's in binary*/
     g_unpack = (rgb_pack >> 8) & 0377;
     b_unpack = (rgb_pack) & 0377;


     printf("R: "); printBinary(r_unpack); printf(" (%d, %#o, %#X)\n", r_unpack, r_unpack, r_unpack);
     printf("G: "); printBinary(g_unpack); printf(" (%d, %#o, %#X)\n", g_unpack, g_unpack, g_unpack);
     printf("B: "); printBinary(b_unpack); printf(" (%d, %#o, %#X)\n", b_unpack, b_unpack, b_unpack);
     printf("------------------------------------\n");

     /* read again */
     printf("\nenter R value: ");
     scanf("%d",&r);
     printf("enter G value: ");
     scanf("%d",&g);
     printf("enter B value: ");
     scanf("%d",&b);

  }

}
