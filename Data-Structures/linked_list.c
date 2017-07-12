#include <stddef.h>
#include <stdlib.h>
#include <stdio.h>

#include "linked_list.h"



list *new_list(){
	list *l = (list*) malloc(sizeof(list));
	if (l == NULL){
		printf("ERROR: No available memory for new list");
		exit(-1);
	}
	return l;
}


node *new_node(float coef, int exp){
	node *n = (node*) malloc(sizeof(node));
	if (n == NULL){
		printf("ERROR: No available memory for new node");
		exit(-1);
	}
	n->coef = coef;
	n->exp = exp;
	n->next = NULL;
	return n;
}


void print(list *l){
	node *aux = l->head;
	printf("[\n");
	printf("\tHEAD :----------.\n");
	while (aux != NULL){
		printf("\t----------------'\n");
		printf("\t'-> coef: %f\n", aux->coef);
		printf("\t    exp: %d", aux->exp);
		printf("\t$\n");
		aux = aux->next;
	}
	
	printf("\tNULL <----------'\n");
	printf("]\n\n");
}


void append(list *list, node *tail){
	//if our list is empty put node as a tail
	if (list->tail == NULL){
		list->tail = tail;
	}else{
		/* to append at the end, put the new node
		 * as next element from the tail and update tail
		 */
		list->tail->next = tail;
		list->tail = tail;
	}
	//if out list is empty, then head = tail
	if (list->head == NULL){
		list->head = list->tail;
	}
}


list *add(list *poly1, list *poly2){
	list *poly3 = new_list();
	node *p1 = poly1->head;
	node *p2 = poly2->head;

	//while there are nodes to check
	while (p1 != NULL && p2 != NULL){
		if (p1->exp == p2->exp){
			append(poly3, new_node(p1->coef + p2->coef, p1->exp));
			//move to the next
			p1 = p1->next;
			p2 = p2->next;
		//check exponent differences to order the new polynom
		}else if(p1->exp > p2->exp){
			append(poly3, new_node(p1->coef, p1->exp));
			p1 = p1->next;
		}else{
			append(poly3, new_node(p2->coef, p2->exp));
			p2 = p2->next;
		}
	}

	//check remaining cases for both polynoms
	while(p1 != NULL){
		append(poly3, new_node(p1->coef, p1->exp));
		p1 = p1->next;
	}

	while(p2 != NULL){
		append(poly3, new_node(p2->coef, p2->exp));
		p2 = p2->next;
	}
	
	return poly3;
}


int main(){
	//initiate lists
	list *l1 = new_list();
	list *l2 = new_list();
	//
	//append nodes
	append(l1, new_node(5, 5));
	append(l1, new_node(4, 4));
	append(l1, new_node(3, 3));
	append(l1, new_node(2, 2));
	append(l1, new_node(1, 1));
	printf("Printing L1\n");
	print(l1);

	append(l2, new_node(2,5));
	append(l2, new_node(2,2));
	printf("Printing L2\n");
	print(l2);

	list *l4 = add(l1,l2);
	printf("Result\n");
	print(l4);

	return 0;
}
