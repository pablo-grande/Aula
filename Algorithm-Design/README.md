# Planning a company party

Professor Stewart is consulting for the president of a corporation that is planning a company
party. The company has a hierarchical structure; that is, the supervisor relation forms a tree
rooted at the president. The personnel office has ranked each employee with a conviviality
rating, which is a real number. In order to make the party fun for all attendees, the president
does not want both an employee and his or her immediate supervisor to attend.  
Professor Stewart is given the tree that describes the structure of the corporation, using the
left-child, right-sibling representation. Each node of the tree holds,
in addition to the pointers, the name of an employee and that employee's conviviality ranking. 
 
Describe an algorithm to make up a guest list that maximizes the sum of the conviviality
ratings of the guests. Analyze the running time of your algorithm.

## Data Structure
As the problem mentions, we need to build a tree composed by nodes. 

### Node
Each node will represent a member of the company and will contain:
* A name
* A points field where the ranking is stored
* Pointer to right sibling (same rank workers)
* Pointer to left child (first employee of lower rank)
* A promotion list, by default it is a list that contains the node itself

### Tree
The company will be represented by a tree which is simply a root node and some methods to print the party guests.

## Solution
Each node will retrieve its right sibling promotion list and add it to its own list. The node will do the same with its left child promotion list. In the latter case if the total points of the promotion list are greater or equal than the parent node, the node is removed from its own promotion list.  
That way we will have an updated list of guests in every level of the tree. The root will have the updates from all lower levels since it calls the method for its left child, and that will be the final guest list.

Promote [method](https://github.com/pabloriutort/Algorithm-Design/blob/master/party.py#L53-L82):
```
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
            self.promotion += sibling.promotion

        #call promote on left child
        if self.left_child is not None:
            lefty = self.left_child
            lefty.promote()
            children_score = sum([node.points for node in lefty.promotion])

            if (children_score > self.points):
                self.promotion.remove(self)
                self.promotion += lefty.promotion
```

