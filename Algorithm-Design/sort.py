#!/usr/bin/env python
from random import choice


def insertion(elements):
    """Insertion Sort alogrithm

    Given a list of elements, sorts them using the Insertion Sort:
    Compares every element with the previous ones and finds the correct position
    to place it.

    Parameters
    elements: List of elements to be sorted

    Returns
    list of sorted elements
    """
    for i in range(1,len(elements)):
        key = elements[i]
        index = i
        #traverse every previous member of the list
        while index > 0 and elements[index-1] > key:
            elements[index] = elements[index-1]
            index = index-1
        #place key in new founded position
        elements[index] = key
    
    return elements


def merge(elements):
    """Merge Sort algorithm

    Uses merge sort recursively to sort a list of elements

    Parameters
    elements: List of elements to be sorted

    Returns
    list of sorted elements
    """
    def list_merge(a, b):
        """Actual "merge" of two lists

        Compares every member of a list and returns a new list with
        sorted elements

        Parameters
        a, b: Lists of elements to be sorted

        Returns
        list of sorted elements
        """
        #initialize some values
        len_a = len(a)
        len_b = len(b)
        a_i = b_i = 0
        c = []
        
        for i in range(len_a + len_b):
            #check which element is the smaller
            #and place it into c list
            if a_i < len_a and b_i < len_b:
                if a[a_i] < b[b_i]:
                    c.append(a[a_i])
                    a_i = a_i+1
                else:
                    c.append(b[b_i])
                    b_i = b_i+1
            else:
                #when we are done with one list append pending values of the other one
                if a_i == len_a:
                    # append all pending b values into c
                    return c + b[b_i:]
                if b_i == len_b:
                    # same as above but with a values
                    return c + a[a_i:]


    length = len(elements)
    if length <= 1:
        #ending condition
        return elements

    half = int(length/2)

    #recursive call for both halfs of elements
    #divide and conquer
    return list_merge(merge(elements[:half]), merge(elements[half:]))


def quicksort(elements):
    """Quicksort Algorithm

    1. Pick an element called pivot from the array
    2. Put every element smaller than the pivot at the left and the greater
    at the right side (partitioning)
    3. Repeat 2 and 3 until no more elements are found
    
    Parameters
    elements: List of elements to be sorted

    Returns:
    list of sorted elements
    """
    #exit condition
    if len(elements) <= 1:
        return elements

    pivot = choice(elements)
    #partition
    left = []
    right = []
    equals = []
    for e in elements:
        if e < pivot:
            left.append(e)
        elif e > pivot:
            right.append(e)
        else:
            equals.append(e)

    return quicksort(left) + equals + quicksort(right)


def counting(elements, k):
    """Counting Sort Algorithm

    Fill an array with the number of times that a number appears in given elements
    Traverse the array and fill up a new one with the same length, for every element
    different from 0 move its value to the new array, decrement the value by one and
    continue until 0

    Parameters
    elements: List of elements to be sorted
    k: Maximum range of values of our elements

    Returns:
    list of sorted elements
    """
    aux = [0] * (k+1)

    #load the accounting of all elements
    for e in elements:
        aux[e] += 1

    new_aux = [0] * len(elements)
    i = 0
    #traverse aux array
    for j in range(len(aux)):
        while aux[j] > 0:
            #if we have some element here
            #move its index to the new array
            new_aux[i] = j
            i+=1 #this will keep new_aux moving
            aux[j] -= 1
            #decrement aux[j] in order to move the correct
            #amount to new_aux

    return new_aux


def radix(elements):

    #casting functions
    to_int = lambda x: list(map(int, x))
    to_str = lambda x: list(map(str, x))


    def merge(keys, elements):
        """Gives a list of merged values between keys and another list

        Given a set of keys it finds it in another list. 
        Gets the second element of the other list and appends it 
        to a new one if was not appended before

        Parameters:
        keys, a set of ordered keys ['0', '1', '2'...]
        elements, a set of lists of lists [['k','value'],...]

        Returns:
        A merged list with keys of the set of keys and values from second list
        """
        merge = []
        for k in keys:
            for e in elements:
                if k == e[0] and [k, e[1]] not in merge:
                    merge.append([k, e[1]])
        return merge


    def shift(elements, i):
        """Puts as first element of the list the 'i'th element starting from last
        of the second value

        Example: i = 1
            [['3','123'],..]  --> 1st element from last is 3

        Parameters:
        elements, a set of elements of the form [['k', 'value'],...]
        i, index that indicates how many positions to shift

        Returns:
        keys of the newly shifted list ('i'th element of second values)
        elements of the list
        """
        keys = []
        for e in elements:
            e[0] = e[1][-i]
            keys.append(e[0])

        return keys, elements


    def prepare(elements):
        """Prepares a list of elements for radix sort

        Selects max length of integers.
        For every number in list transforms it by putting x 0s
        in font of it
        x being difference between length of integers in number and
        max length of integers found
        
        Params:
        a set of integers

        Returns:
        a transformed list of lists of strings that has the form of ['key','value']
        max_length founded
        """
        #tells quantity of integers of number itself
        int_len = lambda x: len(str(x))

        #select longest length
        max_length = 0
        for e in elements:
            if int_len(e) > max_length:
                max_length = int_len(e)

        #puts x 0s in front of a number
        transform = lambda x: '0'* (max_length - int_len(x)) + str(x)

        stuffed = list(map(transform, elements))
        formatted = [['' ,x] for x in stuffed]

        return formatted, max_length


    values, max_length = prepare(elements)


    for i in range(1,max_length+1):
        keys, values = shift(values, i)
        #use counting sort for sorting our values
        #to do it first we need to convert our keys to int
        #and return it as str
        sorted_keys = to_str(counting(to_int(keys), 9))
        #reorganize our new keys with previous values
        #this will sort the list progressively
        sorted_elements = merge(sorted_keys, values)

    #unpack elements from formatted structure
    return [int(x[1]) for x in sorted_elements]


