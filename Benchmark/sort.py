#!/usr/bin/env python
# -*- coding: utf-8 -*

from timing import *


@print_timing
def sort(bad_list):
    """
    Dada una lista desordenada (bad_list) la ordena utilizando el programa por defecto de python
    :param bad_list:
    """
    bad_list.sort()


# merge sort
@print_timing
def merge_sort(bad_list):
    """
    Dada una lista desordenada, aplica merge sort para ordenarla
    :param bad_list:
    """
    merge_sort_r(bad_list, 0, len(bad_list) -1)


# merge sort recursivo
def merge_sort_r(bad_list, first, last):
    if first < last:
        sred = (first + last)/2
        merge_sort_r(bad_list, first, sred)
        merge_sort_r(bad_list, sred + 1, last)
        merge(bad_list, first, last, sred)


# merge "de verdad"
def merge(list2, first, last, sred):
    aux = []
    i = first
    j = sred + 1
    while i <= sred and j <= last:
        if list2[i] <= list2[j]:
            aux.append(list2[i])
            i += 1
        else:
            aux.append(list2[j])
            j += 1
    while i <= sred:
        aux.append(list2[i])
        i += 1
    while j <= last:
        aux.append(list2[j])
        j += 1
    for k in range(0, last - first + 1):
        list2[first + k] = aux[k]