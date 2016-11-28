from aes import *


class Node(object):
    """ A node is just an identifier and a hash key"""

    def __init__(self, node_id):
        self.__id = node_id
        self.__key = create_key()  # shared with KDC
        self.__key_dict = {}
        self.__messages = {}

    # below some general functions to interact with the object

    def __str__(self):
        return 'Id: {0}\nkey: {1}\nkey dictionary: {2}\nmessages: {3}'.format(
            self.__id, self.__key, self.__key_dict, self.__messages);


    def getSelfKey(self):
        return self.__key


    def getId(self):
        return self.__id


    def setKey(self, node_id, key):
        """
        Puts a key in a inner dictionary:
           id => node_Key
        """
        keys = self.__key_dict
        keys[node_id] = key


    def getKey(self, node_id):
        return self.__key_dict[node_id]

    #Now some functions to deal with the messages dictionary

    def putMessage(self, node_id, message):
        messages = self.__messages
        messages[node_id] = message


    def sendMessage(self, message, node):
        """
        Encrypt a message with the session key
        and put it in the message dictionary of the other node
        """
        key = self.getKey(node.getId())
        encrypted = encrypt(key,message)
        node.putMessage(self.getId(),encrypted)


    def getMessage(self,node):
        """Retrieves a message of a given node and decrypts it with the key"""
        node_id = node.getId()
        key = self.getKey(node_id)
        message = self.__messages[node_id]
        return decrypt(key,message)
