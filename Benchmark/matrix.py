#!/usr/bin/env python
# -*- coding: utf-8 -*

import random
import numpy
from timing import *


def col(dim=3):
    """
    Crea las columnas de la matriz. Dada una dimensión la tupla contendrá valores aleatorios no menores de 1000 ni mayores de 10000000
    :param dim:
    :return:
    """
    column = []
    for i in range(0, dim):
        column.append(random.randint(1000, 10000000))
    return tuple(column)


def matrix(dim):
    """
    Dada una dimensión crea un conjunto de columnas de dicha dimensión
    :param dim:
    :return: Matriz de dimensión dim x dim
    """
    row = []
    for i in range(0, dim):
        row.append(col(dim))
    return numpy.matrix(tuple(row))


# A continuación distintos métodos que implementan la estructura de la matriz cuadrada

@print_timing
def m_prod(dim):
    return matrix(dim)*matrix(dim)


@print_timing
def m_sum(dim):
    return matrix(dim)+matrix(dim)


@print_timing
def m_times(dim):
    return matrix(dim) ^ matrix(dim)
