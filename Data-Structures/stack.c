#include <stdlib.h>
#include <stdio.h>
#include <string.h>

#include "stack.h"


stack* new_stack(){
	 stack* s = (stack*) malloc(sizeof(stack));
	 s->top = -1;
	 return s;
}

void push(stack* s, char p){ 
	s->data[++s->top] = p;
}


char pop(stack* s){
	if (s->top == -1){
		printf("Bad use");
		exit(-1);
	}
	return s->data[s->top--];
}


bool is_empty(stack* s){ 
	return s->top == -1;
}


void dump(stack* s){
	while (s->top > -1)
		printf("'%c' (%d)\n", pop(s), s->top);
	printf("\n");
}


/*
 * BODY
 */
char open_parens[3] = {'{','[','('};
char close_parens[3] = {'}',']',')'};


/**
 * Auxiliary function.
 * Checks whether an element in inside an array
 *
 * Args:
 *		val: the element to check
 *		array: the array to check if the element is in it
 *		size: size of the array
 *
 * Returns:
 *		boolean: whether val is in array
 */
bool in_array(char val, char* array, int size){
	for (int i=0; i<size; i++)
		if (val == array[i])
			return true;
	
	return false;
}


/**
 * Check if the element is an open parenthesis
 *
 * Uses in_array() to check if the value belongs to the
 * open_parens array
 *
 * Args:
 *		val: character to check
 *
 * Return:
 *		boolean: whether the value belongs to open_parens or not
 */
bool in_open_parens(char val){ 
	return in_array(val, open_parens, sizeof(open_parens)); 
}


/**
 * Check if the element is an close parenthesis
 *
 * Uses in_array() to check if the value belongs to the
 * close_parens array
 *
 * Args:
 *		val: character to check
 *
 * Return:
 *		boolean: whether the value belongs to close_parens or not
 */
bool in_close_parens(char val){ 
	return in_array(val, close_parens, sizeof(close_parens)); 
}


/**
 * Returns if the parenthesis are equivalent
 *
 * The order of the parenthesis matter, the array of both set of
 * brackets has the same index for pair of brackets.
 *		index of '{' is equal to index of '}' in its arrays
 *	This function checks if the element is array paired.
 *
 *	Args:
 *		open: the open bracket symbol
 *		close: the close bracket symbol
 *
 *	Returns:
 *		boolean: whether the symbols are paired or not
 */
bool is_pair(char open, char close){
	int open_index = 0;
	int close_index = 0;

	for (; close_index<sizeof(close_parens); close_index++)
		if (close_parens[close_index] == close)
			break;
	
	for (; open_index<sizeof(open_parens); open_index++)
		if (open_parens[open_index] == open)
			break;

	return open_index == close_index;
}


/**
 * Tells us if an expression with brackets if well formed
 *
 * Accumulates into a stack any bracket element (defined in previous arrays)
 * Later, uses the stack to check if the parenthesis are matched.
 * If they are, the stack will be empty and the expression will be well formed
 *
 * Args:
 *		expr: an String of an expression
 *
 *	Returns:
 *		boolean: whether it's well formed or not
 */
bool isValid(char* expr){
	stack* s = new_stack();
	
	for (int i=0, j=strlen(expr); i<j; i++){
		char elem = expr[i];

		if(in_open_parens(elem)){
			push(s, elem);
		}else if(in_close_parens(elem)){
			if (!is_pair(pop(s), elem))
				return false;
		}
	}

	return is_empty(s);
}


int main(){
	char* good_expr = "{[a+b]*(c+d)}";
	char* bad_expr = "{[a+b]*[c+d)}";

	printf("Expresion '%s' ", good_expr);
	if (isValid(good_expr))
		printf("is valid\n");
	else
		printf("is not valid\n");
	
	printf("Expresion '%s' ", bad_expr);
	if (isValid(bad_expr))
		printf("is valid\n");
	else
		printf("is not valid\n");

	return 0;
}


