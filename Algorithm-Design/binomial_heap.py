#!/usr/bin/env python


class Node(object):
    def __init__(self, key):
        self.__key = key
        self.__parent = None
        self.__left_child = None
        self.__sibling = None


    def __lt__(self, node):
        """Making nodes sortable"""
        return self.key < node.key


    @property
    def key(self):
        return self.__key


    @key.setter
    def key(self, key):
        self.__key = key


    @property
    def left_child(self):
        return self.__left_child


    @left_child.setter
    def left_child(self, left_child):
        self.__left_child = left_child
        if left_child.parent is None:
            left_child.parent = self


    @property
    def parent(self):
        return self.__parent


    @parent.setter
    def parent(self, parent):
        self.__parent = parent


    @property
    def sibling(self):
        return self.__sibling


    @sibling.setter
    def sibling(self, sibling):
        self.__sibling = sibling


    def __repr__(self):
        return '(key: "{}")'.format(self.key)


    def more(self):
        """More info about the node"""
        node = 'N: (\n\tkey: "{}"\n\tdeg: "{}'.format(self.key, len(self))
        if self.parent is not None:
            node += '\n\tparent: "{}"'.format(self.parent.key)
        if self.siblings is not None:
            node += '\n\tsibling: "{}"'.format(self.sibling)
        if self.left_child is not None:
            node += '\n\tleft child: "{}"'.format(self.left_child.key)

        return node + '\n)'



class Tree(object):
    def __init__(self, root):
        self.__root = root


    def __lt__(self, tree):
        """Making trees sortable"""
        return self.root < tree.root


    def __len__(self):
        """Returns order of the tree

        The order of the tree will be given by the
        degree of the leftmost child
        """
        order = 0
        node = self.__root
        #traverse childs until last
        while node.left_child is not None:
            node = node.left_child
            order += 1
        return order


    @property
    def root(self):
        return self.__root


    def __repr__(self):
        return 'T: (root: {}\norder: {})'.format(self.root, len(self))



class Heap(object):
    def __init__(self, trees=[]):
        self.__trees = {}

        #load tree list into a dicionary
        #key: degree of tree, value: tree itself
        for tree in trees:
            order = len(tree)
            self.__trees[order] = tree


    def __len__(self):
        return len(self.__trees.keys())


    def __getitem__(self, item):
        return self.__trees[item]


    @property
    def orders(self):
        return self.__trees.keys()


    def remove_minimal(self):
        """Remove the smallest element of heap

        Select smallest root of al trees.
        Deletes that key and appends the new trees (if any)
        to the trees dictionary

        Returns:
        the minimal tree now out of the heap
        """
        min_order = min(self.__trees.keys())
        min_tree = self.__trees.pop(min_order)

        """
        now we have the smallest tree
        we must rearrenge the heap by removing the root
        and allocating its subtrees into the heap again

        create trees from left child and travel siblings
        append those trees to heap
        """

        #get 1st generation siblings
        left_child = min_tree.root.left_child
        if left_child:
            children = []
            children.append(Tree(left_child))
            while left_child.sibling:
                sibling = left_child.sibling
                child_tree = Tree(sibling)
                children.append(child_tree)
                left_child = sibling

            #put the children again into heap
            for tree in children:
                self.append(tree)

        return min_tree


    def append(self, tree):
        """Appends a new tree in the heap

        A new tree wants to go in:
        1. Check order of this tree
        2. If there is no tree with that order, just append
        3. If there is another tree with same order, merge (insert())
        4. Take account of the merged trees and remove them from dictionary
        5. Repeat
        """
        order = len(tree)
        if order not in self.__trees.keys():
            self.__trees[order] = tree
        else:
            #invalid state, merge trees of same order
            new_tree = insert(tree, self.__trees[order])
            #after the insertion we have a new tree of new order
            #so we need to remove the previous order
            self.__trees.pop(order)
            #and see if we have any other trees with same order in our heap
            self.append(new_tree)


    def __repr__(self):
        return str(self.__trees)



def build_heap(trees):
    return heapify(Heap(trees))


def remove_minimal(heap):
    minimal = heap.trees[0]
    for tree in heap.trees:
        if tree.root < minimal.root:
            minimal = tree

    tmp = minimal.sub_trees
    heap.remove(minimal)
    merge(heap, tmp)


def heapify(tree):
    """Rearrange a heap to maintain the heap property

    key of the root node must be more extreme than its children's key.
    In case the root key is not more extreme, swap it with the most extreme child's key
    and heapify child's subtree
    """
    root = tree.root
    min_root = root
    for child in root.children:
        #if our child key is less than the root, save new minimum and swap
        if child.key < root.key:
            min_root = child
            child.key, root.key = root.key, child.key

    return heapify(min_root)


def insert(tree_1, tree_2):
    """Inserts one tree into another

    Check if the order of trees is the same
    After that, put the highest root as left most child
    of the lowest root

    Parameters:
    tree_1, tree_2: Trees to compare and join

    Returns:
    tree with lowest root key
    """

    if len(tree_1) != len(tree_2):
        raise ValueError

    root_1, root_2 = tree_1.root, tree_2.root

    if root_1 < root_2:
        if root_1.left_child is not None:
            #put previous left child as sibling
            root_2.sibling = root_1.left_child
        root_1.left_child = root_2
        return tree_1
    else:
        if root_2.left_child is not None:
            root_1.sibling = root_2.left_child
        root_2.left_child = root_1
        return tree_2


