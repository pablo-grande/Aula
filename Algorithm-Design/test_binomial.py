#!/usr/bin/env python
import unittest
from binomial_heap import Node
from binomial_heap import Tree, insert
from binomial_heap import Heap


class TestNode(unittest.TestCase):

    def test_create(self):
        key = 1
        node = Node(key)
        self.assertEqual(node.key, key)


    def test_parenthood(self):
        child = Node(key=2)
        parent = Node(key=1)
        parent.left_child = child

        self.assertEqual(child.parent, parent)
        self.assertEqual(child, parent.left_child)


class TestTree(unittest.TestCase):

    def test_create(self):
        grandson = Node(2)
        son = Node(1)
        son.left_child = grandson
        root = Node(0)
        root.left_child = son

        #since we have 3 nodes, that should give a t(non-binomial) tree of lenght 2
        tree = Tree(root)

        self.assertEqual(len(tree), 2)


    def test_insert(self):

        #tree of k=0
        k = 0
        tree_1 = Tree(Node(0))
        tree_2 = Tree(Node(1))
        self.assertEqual(len(tree_1), k)
        self.assertEqual(len(tree_2), k)

        #tree of k=1
        k = 1
        new_tree = insert(tree_1, tree_2)
        self.assertEqual(len(new_tree), k)

        root = new_tree.root
        #check if the insertions where done correctly
        #tree_1 should be parent of tree_2
        self.assertEqual(root, tree_1.root)
        self.assertEqual(root.left_child, tree_2.root)

        #testing insertion of trees of diferent k
        another_tree = Tree(Node(0))
        try:
            failed_tree = insert(another_tree, new_tree)
        except ValueError:
            self.assertTrue(True, msg="Order of trees differ")

        #tree of k = 2
        k = 2
        k0_tree = Tree(Node(0))
        k0_tree_1 = Tree(Node(1))
        k1_tree = insert(k0_tree, k0_tree_1)

        k0_tree = Tree(Node(2))
        k0_tree_1 = Tree(Node(3))
        k1_tree_1 = insert(k0_tree, k0_tree_1)

        k2_tree = insert(k1_tree, k1_tree_1)
        self.assertEqual(len(k2_tree), k)


class TestHeap(unittest.TestCase):

    def test_create(self):

        #k1 tree
        k0_tree = Tree(Node(2))
        k0_tree_1 = Tree(Node(3))
        k1_tree = insert(k0_tree, k0_tree_1)
        k = len(k1_tree)

        h = Heap([k1_tree])
        #we have only one tree in heap
        self.assertEqual(len(h), 1)
        #this tree is the one at k position in heap (1)
        self.assertEqual(h[k], k1_tree)
        #this tree is of k=1
        self.assertEqual(k, len(h[k]))


    def test_append(self):
        k0_tree = Tree(Node(2))
        k0_tree_1 = Tree(Node(3))

        h = Heap()
        h.append(k0_tree)
        h.append(k0_tree_1)

        #as result we should have 1 tree of k=1
        self.assertEqual(len(h), 1)
        heap_tree = h[1]
        self.assertEqual(len(heap_tree), 1)

        #append new tree
        new_tree = Tree(Node(0))
        h.append(new_tree)
        #we should have 2 trees
        self.assertEqual(len(h), 2)
        #and the new one must be of k=0
        #first order of the heap must be 0
        self.assertEqual(new_tree, h[0])

        #append new tree of k=0
        another_tree = Tree(Node(0))
        h.append(another_tree)
        #at this stage k0 + k0 = k1
        #but there was a k1 before, so k1+k1 = k2
        self.assertEqual(len(h), 1)
        self.assertEqual(len(h[2]), 2)


    def test_remove_minimal(self):
        k0_1 = Tree(Node(2))
        k0_2 = Tree(Node(3))

        h = Heap()
        h.append(k0_1)
        h.append(k0_2)
        #at this point we have a tree in heap of k=1

        smallest = Tree(Node(7))
        h.append(smallest)
        lowest_tree = h.remove_minimal()
        #check if it was the smallest tree
        self.assertEqual(smallest, lowest_tree)
        
    def test_remove_minimal_w_siblings(self):
        #try with a tree with siblings
        n = Node(0)
        lc = Node(1)
        n.left_child = lc
        lc.sibling = Node(2)

        minimal = Tree(n)

        #now we will create tree of k=2
        k0 = Tree(Node(3))
        k0_1 = Tree(Node(4))
        k1 = insert(k0, k0_1)

        k0 = Tree(Node(5))
        k0_1 = Tree(Node(6))
        k1_2 = insert(k0, k0_1)
        k2 = insert(k1,k1_2)

        #build and check our minimal tree in heap
        h = Heap([minimal,k2])
        min_heap = h.remove_minimal()
        self.assertEqual(min_heap, minimal)

        #and what should be left is a heap with two trees of k=1 and k=2
        k_list = [1,2]
        self.assertEqual(k_list, list(h.orders))



unittest.main()


