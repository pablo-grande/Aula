

typedef struct node{
	int element;
	struct node* lc;
	struct node* rc;
}node;


typedef struct tree{
	node* root;
}tree;


/**
 * Tree constructor
 */
tree* t_empty();


/**
 * Node constructor
 */
node* n_empty();


/**
 * Traverse the tree from root and prune it
 *
 * Moves to all the tree leaves (nodes without children)
 * and deletes them
 */
tree* t_prune(node* root);


/**
 * Creates a new leaf with given element
 */
node* new_node(int element);
