#!/usr/bin/env python
# -*- coding: utf-8 -*

import time
import os

path = str(os.path.dirname(os.path.abspath(__file__))) + "/results_"


def print_timing(func):
    """
    Print_timing crea una función que llamada por otra función indica cuanto ha tardado esta
    :param func:
    :return:
    """

    def wrapper(*arg):
        """
        La función pasada por parámetro es contailizada por la diferencia de los tiempos t1 y t2.
        Muestra el resultado de esta diferencia en milisegundos en un fichero de datos: "results.dat"
        :param arg:
        :return:
        """
        t1 = time.clock()
        res = func(*arg)
        t2 = time.clock()
        f = open(path+str(func.func_name), 'a')
        f.write('%s : %0.3fms' % (func.func_name, (t2-t1)*1000.0)+'\n')
        f.close()
        return res
    return wrapper
