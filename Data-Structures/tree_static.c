#include "stdlib.h"
#include "stddef.h"
#include "stdio.h"
#include "string.h"
#include "tree_static.h"


tree* t_new(){
	tree* t = (tree*) malloc(sizeof(tree));
	if (t == NULL){
		printf("ERROR: No available memory for new tree");
		exit(-1);
	}
	memset(t->nodes, -1, sizeof(tree));
	t->num_elements = 0;
	return t;
}


int t_insert_left(tree* t, int index, int element){
	//left child = 2*i + 1
	int left_index = 2*index + 1;
	t->nodes[left_index] = element;
	t->num_elements++;
	return left_index;
}


int t_insert_right(tree* t, int index, int element){
	//right child = 2*i + 2
	int right_index = 2*index + 2;
	t->nodes[right_index] = element;
	t->num_elements++;
	return right_index;
}


int t_height(tree *t, int index){
	//if it has no left and right children
	int left_child = 2*index + 1;
	int right_child = 2* index + 2;
	if (t->nodes[left_child] == 0 && t->nodes[right_child] == 0)
		return 1;
	return 1 + max(t_height(t, left_child), t_height(t, right_child));
}


void print(tree* t){
	for (int i = 0; i < t->num_elements; i++)
		printf("%d \n",t->nodes[i]);
}


int main(){
	tree* t = t_new();

	//initialize some tree
	for (int i=0; i<4; i++)
		t_insert_left(t,i,i+1);

	print(t);

	return 0;
}


