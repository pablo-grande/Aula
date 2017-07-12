#!/usr/bin/env python
from time import clock


def timing(func):
    """Decorator for timing

    Calculates how long does the function takes to execute
    and prints some useful information
    """
    def wrapper(*arg):
        t1 = clock()
        result = func(*arg)
        t2 = clock()
        f_name = func.__name__
        print("Excuted {} in {} seconds".format(f_name, t2 - t1))
        return result
    return wrapper


