#include <stdbool.h>
#define MAX 255


/**
 * A Stack will be defined by:
 * - its top index
 * - array of memory to store elements
 */
typedef struct stack{
	int top;
	char data[MAX];
}stack;


/**
 * Creates a new stack
 * Returns: 
 *		A new stack initilized with top to -1
 */
stack* new_stack(); 


/**
 * Pushes an element into the stack
 * Args:
 *		stack: to push the new element
 *		element: the element to be pushed
 */
void push(stack* s, char p);


/**
 * Gets the last element of the stack
 * and updates the top of the stack
 *
 * Args:
 *		stack: to retrieve the last element
 *
 *	Returns:
 *		element: gets the element pointed by top
 */
char pop(stack* s);


/*
 * Checks if the stack is empty by comparing top with -1
 *
 * Args:
 *		stack: to check its top
 *
 *	Returs:
 *		boolean: wheter top of the stack is -1 or not
 */
bool is_empty(stack* s);


/**
 * Auxiliary function.
 * Uses pop() to print every element of the stack and
 * leaves the stack empty
 *
 * Args:
 *		stack: to use pop() with it
 */
void dump(stack* s);
