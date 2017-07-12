#!/usr/bin/env python
import unittest
from party import Tree, Node


class TestHeight1(unittest.TestCase):

    def test_just_president(self):
        #create our company members
        frank = Node('Frank',10.0)
        seth = Node('Seth', 3.0)
        doug = Node('Doug', 4.0, sibling=seth)
        frank.left_child=doug

        company = Tree(frank)
        print(company)
        self.assertListEqual([frank], company.party())

    def test_not_president(self):
        #create our company members
        frank = Node('Frank',5.0)
        seth = Node('Seth', 3.0)
        doug = Node('Doug', 4.0, sibling=seth)
        frank.left_child=doug

        company = Tree(frank)
        print(company)
        self.assertListEqual([doug, seth], company.party())

class TestHeigh2(unittest.TestCase):

    def test_just_president(self):
        #create our company members
        frank = Node('Frank',10.0)
        seth = Node('Seth', 3.0)
        leann = Node('Leann', 4.0)
        aidan = Node('Aidan', 2.0, sibling=leann)
        doug = Node('Doug', 4.0, left_child=aidan, sibling=seth)
        frank.left_child=doug

        company = Tree(frank)
        print(company)
        self.assertListEqual([frank], company.party())

    def test_not_president(self):
        #create our company members
        frank = Node('Frank',10.0)
        seth = Node('Seth', 3.0)
        leann = Node('Leann', 5.0)
        aidan = Node('Aidan', 10.0, sibling=leann)
        doug = Node('Doug', 4.0, left_child=aidan, sibling=seth)
        frank.left_child=doug

        company = Tree(frank)
        print(company)
        self.assertListEqual([seth, aidan, leann], company.party())


class TestMoreNodes(unittest.TestCase):

    def test_10(self):
        #create our company members
        lucas = Node('Lucas', 8.0)

        leann = Node('Leann', 5.0)
        aidan = Node('Aidan', 10.0, sibling=leann)

        tom = Node('Tom', 2.0, left_child=lucas)
        seth = Node('Seth', 3.0, left_child=tom)
        doug = Node('Doug', 4.0, aidan, seth)

        jackie = Node('Jackie', 7.0)
        remy = Node('Remy', 4.0, sibling=jackie)
        frank = Node('Frank',4.0, doug, remy)

        claire = Node('Claire', 9.0, left_child=frank)

        company = Tree(claire)
        print(company)
        self.assertListEqual([remy, jackie, lucas, aidan, leann], company.party())


    def test_15(self):
        #create our company members
        zoe = Node('Zoe', 6.0)
        lucas = Node('Lucas', 8.0, sibling=zoe)
        tom = Node('Tom', 2.0, left_child=lucas)

        christina = Node('Christina', 7.0)
        rachel = Node('Rachel', 5.0)
        peter = Node('Peter', 6.0, christina, rachel)

        leann = Node('Leann', 5.0)
        aidan = Node('Aidan', 10.0, sibling=leann)
        seth = Node('Seth', 3.0, tom, aidan)
        doug = Node('Doug', 4.0, peter, seth)

        jackie = Node('Jackie', 7.0)
        remy = Node('Remy', 4.0, sibling=jackie)
        ed = Node('Ed', 9.0, sibling=remy)
        frank = Node('Frank',4.0, doug, ed)

        claire = Node('Claire', 9.0, left_child=frank)

        company = Tree(claire)
        print(company)
        self.assertListEqual([ed, remy, jackie, aidan, leann, lucas, zoe, rachel, christina], company.party())


unittest.main()


