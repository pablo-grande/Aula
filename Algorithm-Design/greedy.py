#!/usr/bin/env python
from text import letter_counter


class Node(object):
    def __init__(self, left_child=None, right_child=None, value=None, letter=None):
        self.__left = left_child
        self.__right = right_child
        self.__val = value
        self.__letter = letter
        

    @property
    def left_child(self):
        return self.__left

    @property
    def right_child(self):
        return self.__right

    @property
    def value(self):
        return self.__val
    
    @property
    def letter(self):
        return self.__letter

    def __len__(self):
        if self.left_child is None and self.right_child is None:
            return 1
        return max(1 + len(self.left_child), 1 + len(self.right_child))

    def __repr__(self):
        str = ""
        if self.letter is not None:
            str = "({} {})".format(self.value, self.letter)
        if self.left_child is not None:
            str += "{}".format(self.left_child)
        if self.right_child is not None:
            str += "{}".format(self.right_child)
        
        return str


def codify(tree, codes):
    """Recursively traverse the tree
    
    Visit every node and take not of every left (0) and right (1) child or value
    
    Params:
    A fully formed binary tree
    A list of codes to append each code
    """        
    
    if tree.left_child is None and tree.right_child is None:
        #we hit a leaf
        codes.append(tree.letter)
    
    if tree.left_child is not None:
        codes.append(0)
        codify(tree.left_child, codes)
    
    if tree.right_child is not None:
        codes.append(1)
        codify(tree.right_child, codes)


def Huffman():
    def build_nodes(node_list):
        """Sort elements and returned as nodes
        
        The node list will be sorted by cardinality and also all nodes will be
        created
        
        Params:
        node_list is a list of unordered tuples
        
        Returns:
        A list of ordered Nodes
        """
        node_list.sort(key=lambda x: x[1], reverse=True)
        return list(map(lambda x: Node(letter=x[0], value=x[1]), node_list))


    def build_tree(node_list):
        """Follow Huffman algorithm to create the tree

        Given a list of sorted nodes get the least two and create and inner node
        with the nodes as children.
        Reintroduce the new node with new value into the list and sort it.
        Repeat until we have just one node, at that point we will have a root and children
        nodes creating a tree

        Params:
        node_list, reverse ordered values of the nodes
        """
        while len(node_list) > 1:
            #get two minor nodes from list
            right_child, left_child = nodes.pop(), nodes.pop()
            new_value = right_child.value + left_child.value
            #create inner node with them
            node = Node(left_child, right_child, new_value)
            #return it to the list of nodes
            node_list.append(node)
            node_list.sort(key=lambda x: x.value, reverse=True)
            
        return node_list.pop()


    #transform every node_list into a Node
    nodes = build_nodes(letter_counter())
    tree = build_tree(nodes)
    print(tree)
    
    codes = []
    codify(tree, codes)
    print(codes)


def ShannonFano():
    def separate(node_list):
        """Finds best separation of cardinalities

        Given a list of nodes, sums progressively its cardinalities and tries to
        find the minimum difference of the first half and the second half.
        
        Params:
        node_list: It is a list of nodes ordered by cardinality

        Returns:
        recursively calls itself and builds a list of lists of optimal separations
        """
        #exit condition
        if len(node_list) == 1:
            return node_list

        #get into a list all the cardinalities
        card = [node[1] for node in node_list]

        #initialization
        best_difference, best_index = sum(card), 0
        i = 0

        #we need to traverse until half of the list (two halves)
        while i <= len(card)/2:
            new_difference = abs(sum(card[:i]) - sum(card[i:]))

            #save best index and difference if better than previous one
            if (new_difference < best_difference):
                best_difference, best_index = new_difference, i
            i+=1

        first_half, second_half = node_list[:best_index], node_list[best_index:]
        #recursive call with a brand new list of nodes
        return [separate(first_half), separate(second_half)]


    def build_tree(node_list):
        if len(node_list) == 1:
            letter, value = node_list.pop()
            return Node(value=value, letter=letter)
        right_child, left_child = node_list.pop(), node_list.pop()
        return Node(build_tree(left_child), build_tree(right_child))


    node_list = sorted(letter_counter(), key=lambda x: x[1], reverse=True)
    tree = build_tree(separate(node_list))
    print(tree)

    codes=[]
    codify(tree, codes)
    print(codes)
    


if __name__ == '__main__':
    Huffman()
    ShannonFano()
    
    
