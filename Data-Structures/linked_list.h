
/**
 * A node will be defined by:
 * - A coeficient
 * - An exponent, which tells the order
 * - A 'next' pointer will tell which is the next
 *   in the list
 */
typedef struct node{
	float coef;
	int exp;
	struct node *next;
}node;


/**
 * A list will be defined by 2 special nodes
 * - head: start of linked list, for traverse the list
 * - tail: end of linked list, for append to the list
 */
typedef struct list{
	struct node* head;
	struct node* tail;
}list;


/**
 * Initilizes an empty list
 */
list *new_list();


/**
 * Initilizes an empty node with the given values
 *
 * Args:
 *		coef and float: node definition
 */
node *new_node(float coef, int exp);


/**
 * Appends a node to a list
 *
 * Args:
 *		list: the list to append the new node
 *		tail: the new node to append
 */
void append(list *list, node *tail);


/**
 * Adds two lists together
 *
 * Gets every element of both lists and gives a new
 * ordered list by exponent criteria
 *
 * Args:
 *		poly1: first polynom
 *		poly2: second polynom
 *
 * Returns:
 *		A new polynom with ordered elements
 */
list *add(list *poly1, list *poly2);


/**
 * Prints in a fancy way a list
 *
 * Args:
 *		list: a list to print
 */
void print(list *list);
