from node import Node
from kdc import *
from aes import *

# Initialize a KDC and two nodes
# add every node to the list
kdc = KDC('KDC')

a = Node('A')
putNode(a)
b = Node('B')
putNode(b)

# Put all node keys inside KDC and choose a key for every node
# to share with KDC
for node in node_list:
    kdc.setKey(node.getId(), node.getSelfKey())
    node.setKey(kdc.getId(), node.getSelfKey())


def default(message):
    """This is a default communication between a KDC and two nodes (a and b)."""

    a_id = a.getId()
    b_id = b.getId()
    kdc_id = kdc.getId()
    a.setKey(b_id, create_key()) # Set a session key for b

    # Tell KDC that 'a' wants to talk to 'b' using a session key
    session_key = a.getKey(b_id)
    print "{0} wants to send {1} this message: \"{2}\"".format(a_id, b_id, message)
    print "with session key = {0}".format(session_key)

    kdc_key = a.getKey(kdc_id)
    # encrypt a message for kdc with kdc and a list [key_of_b, session_key]
    kdc_message = encrypt(kdc_key, ','.join([b_id,session_key]))
    print "{0}'s sends a encrypted message to kdc".format(a_id)
    kdc.connect(a, kdc_message)

    # Now 'a' is ready to talk to 'b'
    print "{0} is ready to send a encrypted message to {1}".format(a_id, b_id)
    a.sendMessage(message, b)
    decrypted_message = b.getMessage(a)
    print "{0} gets {1}'s message: {2}".format(b_id, a_id, decrypted_message)
