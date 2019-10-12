/*
 * lab1Br.c
 *
 *  Created on: Oct. 8, 2019
 *      Author: krish
 */
#include <stdlib.h>
#include <stdio.h>

int main(int argc, char **argv) {
	int m, d, y;
	printf("Enter month, day and year separated by spaces: ");
	scanf("%d %d %d", &m, &d, &y);

	printf("The input '%d %d %d' is reformatted as %d/%d/%d and %d-%d-%d\n", m,
			d, y, y, m, d, y, m, d);

	return 0;
}
