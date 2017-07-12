#!/usr/bin/env python
from random import randrange
from timer import timing
from sys import argv
import sort


SIZE = 10000 #10k
RANGE = 10


@timing
def insertion(elements):
    return sort.insertion(elements)


@timing
def merge(elements):
    return sort.merge(elements)


@timing
def quicksort(elements):
    return sort.quicksort(elements)


@timing
def counting(elements,k):
    return sort.counting(elements,k)


@timing
def radix(elements):
    return sort.radix(elements)


if __name__ == '__main__':
    if len(argv) == 2:
        SIZE = int(argv[1])

    print('Sorting {} random integers...'.format(SIZE))
    elements = [randrange(1, RANGE) for _ in range(SIZE)]
    print(insertion(elements), '\n')
    print(merge(elements), '\n')
    print(quicksort(elements), '\n')
    c_elements = [2,7,8,0]
    print('{} (with {} elements)\n'.format(counting(c_elements, RANGE), len(c_elements)))
    print(radix(elements), '\n')


