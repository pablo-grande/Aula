#include "math.h"
#define MAX 256


typedef struct tree{
	int num_elements;
	int nodes[MAX];
}tree;


/**
 * Creates a new tree
 *
 * Returns an empty tree with num_element intialized to 0
 */
tree* t_new();


/**
 * Inserts into a tree a new element.
 *
 * This method inserts elements sequentially into the tree,
 * therefore the tree will be complete
 */
int t_insert_left(tree* t, int index, int element);
int t_insert_right(tree* t, int index,  int element);


/**
 * Returns heigh of a given tree
 *
 * Since the tree is complete its height will be defined as:
 *		log2(number of elements)
 */
int t_height(tree* t, int index);


/**
 * Auxiliary function for printing a tree
 */
void print(tree* t);


/**
 * Auxiliary function. Returns max number of two given params
 */
int max(int x, int y){
	if (x > y)
		return x;
	return y;
}


