#!/usr/bin/env python
# -*- coding: utf-8 -*

from timing import *


@print_timing
def fib(n):
    """
    Simple programa de fibonacci recursivo
    :param n:
    :return:
    """
    if n == 1:
        return 1
    else:
        return n + fib(n-1)


@print_timing
def fact(n):
    """
    Factorial recursivo
    :param n:
    :return:
    """
    if n == 0:
        return 1
    else:
        return n*fact(n-1)
