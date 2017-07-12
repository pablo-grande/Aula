#!/usr/bin/env python
# -*- coding: utf-8 -*

class Node(object):
    def __init__(self, name, points, left_child=None, sibling=None):
        self.__name = name
        self.__points = points
        self.__left_child = left_child
        self.__sibling = sibling
        self.__promotion = [self]

    @property
    def name(self):
        return self.__name

    @property
    def points(self):
        return self.__points

    @property
    def left_child(self):
        return self.__left_child

    @left_child.setter
    def left_child(self, left_child):
        self.__left_child = left_child

    @property
    def sibling(self):
        return self.__sibling

    @sibling.setter
    def sibling(self, sibling):
        self.__sibling = sibling

    @property
    def promotion(self):
        return self.__promotion

    @promotion.setter
    def promotion(self, promotion):
        self.__promotion = promotion


    def __repr__(self):
        str = '{} ({})'.format(self.name, self.points)
        if self.left_child is not None:
            str += ' lc={}'.format(self.left_child.name)
        if self.sibling is not None:
            str += ' sibling={}'.format(self.sibling.name)
        return str


    def promote(self):
        """Recursive function for updating the promotion lists

        Every node has a promotion list by default with the node itself as
        only element
        When this function gets called on a node, this will update its list with
        the sibling's list, then will do the same with the list of its left child.
        In the latter case if the total points of the promotion of the left child it's
        equal or higher than the node points it will get removed from the promotion
        list
        """
        #call promote on sibling and get its promotion values
        if self.sibling is not None:
            sibling = self.sibling
            sibling.promote()
            #print('Sibling is {}\nmy promotion: {}\nsibling\'s promotion: {}'.format(sibling, self.promotion, sibling.promotion))
            self.promotion += sibling.promotion

        #call promote on left child
        if self.left_child is not None:
            lefty = self.left_child
            lefty.promote()
            children_score = sum([node.points for node in lefty.promotion])
            #print("children score is ", children_score)

            if (children_score > self.points):
                self.promotion.remove(self)
                self.promotion += lefty.promotion


class Tree(object):
    def __init__(self, root):
        self.__root = root
        self.__root.promote()

    def party(self):
        return self.__root.promotion

    def __repr__(self):
        party = list(map(lambda x: (x.name, x.points), self.__root.promotion))
        return 'Party asistants: {}'.format(party)


