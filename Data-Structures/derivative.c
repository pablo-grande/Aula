#include <stdio.h>
#define LENGTH(x)  (sizeof(x) / sizeof((x)[0]))


/**
 * Simple auxiliary function to print array elements
 */
void print(double* array, int n){
	for (int i=0; i<n; i++)
		printf("%f ",array[i]);
	printf("\n");
}


/**
 * Calculates derivative of the elements of a given array
 * and copy its values into an auxiliary array
 */
void derivative(double* poly, int n, int r){
	printf("Derivative of ");
	print(poly, n);

	for (; r>0; r--)
		for (int i=n-1, j=0; i>=0; i--, j++)
			poly[i] *= j;

	printf("is ");
	print(poly,n);
	printf("\n");
}


int main(){
	double poly1[3] = {4.0,4.0,1.0};
	double poly2[2] = {6.0,4.0};

	derivative(poly1, LENGTH(poly1),2);
	derivative(poly2, LENGTH(poly2), 1);

	return 0;
}
