from node import Node
from aes import *


class KDC(Node):

    def connect(self, transmitter, encrypted_message):
        """
        Given two nodes and a session key
        establish a connection from transmitter to receiver using session_key

        The node identity to send the message comes encrypted with
        its session key
        """
        print "\n\t=== Entering in KDC ==="
        transmitter_id = transmitter.getId()
        print "Decrypt {0}'s message".format(transmitter_id)
        decrypted_message = decrypt(self.getKey(transmitter_id), encrypted_message)
        # once message is decrypted, we need to retrieve the id and session key
        id_key = decrypted_message.split(',')
        print "Message decrypted: {0}".format(id_key)
        receiver_node = getNode(id_key[0])
        session_key = id_key[1]
        print "Receiver node is {0} and session key is {1}".format(receiver_node.getId(), session_key)

        # now sets in the receiver node the session key with the transmitter id
        receiver_node.setKey(transmitter_id,session_key)
        print "\t===== Leaving KDC =====\n"

# Initialize a node list.
# every node will be stored here
node_list = []

def putNode(Node):
    node_list.append(Node)

def getNode(id):
    """Find a node with its id"""
    for node in node_list:
        if node.getId() == id:
            return node
