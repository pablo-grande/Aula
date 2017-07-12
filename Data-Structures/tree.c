#include "stdio.h"
#include "stdlib.h"
#include "stddef.h"
#include "tree.h"


node* n_empty(){
	node* n = (node*) malloc(sizeof(node));
	if (n == NULL){
		printf("ERROR: No available memory for new list");
		exit(-1);
	}
	return n;
}


tree* t_empty(){
	tree* t = (tree*) malloc(sizeof(tree));
	if (t == NULL){
		printf("ERROR: No available memory for new tree");
		exit(-1);
	}
	t->root = n_empty();
	return t;
}


node* new_node(int element){
	node* child = n_empty();
	child->element = element;
	child->lc = NULL;
	child->rc = NULL;
	return child;
}


tree* t_prune(node* root){
	if (root->rc == NULL && root->lc == NULL)
		//if it has no children, then it's a leave
		free(root);
		return NULL;
	//check every possible branch of the tree
	if (root->lc != NULL)
		return t_prune(root->lc);
	if (root->rc != NULL)
		return t_prune(root->rc);
}


int main(){
	tree* t = t_empty();
	node* r = t->root;
	r->lc = new_node(1);
	r->rc = new_node(2);
	t = t_prune(t->root);
}


