all: linked_list stack derivative tree tree_static

linked_list: linked_list.h
	gcc -Wall -o linked_list linked_list.c

derivative:
	gcc -Wall -o derivative derivative.c

stack: stack.h
	gcc -Wall -o stack stack.c

clean:
	rm linked_list stack derivative hash
tree: tree.h
	gcc -Wall -o tree tree.c

tree_static: tree_static.h
	gcc -Wall tree_static.c -lm -o tree_static 

clean:
	rm linked_list stack derivative tree tree_static
