#!/usr/bin/env python
# -*- coding: utf-8 -*
__author__ = 'pablo'

import subprocess
import os
import matrix
import count
import sort
import random
from threading import Thread


threads = []
num_threads = 20


def my_function(another_function, param):
    """
    Llama a una función dada por parámetro (param1) y le pasa el segundo parámetro a la misma (param2)
    :param another_function:
    :param param:
    """
    another_function(param)


def thread_me(name, lim):
    """
    Dado un nombre de una función y un límite (o lista) este método crea un hilo con estos dos argumentos.
    El hilo llama a my_function, es inicializado e introducido a una lista de hilos.
    :param name:
    :param lim:
    """
    for j in range(num_threads):
        t = Thread(target=my_function, args=(name, lim))
        t.start()
        threads.append(t)


def benchmark():
    """
    Llama a la función thread_me pasando la función de carga deseada implementadas en las librerías de count, sort y matrix.
    En el caso de sort generaremos una lista de números aleatoria para que la ordene
    """
    # count
    thread_me(count.fact, 30)
    thread_me(count.fib, 30)

    # sort
    n = 1000
    list1 = []

    for i in range(0, n):
        list1.append(random.randint(0, n-1))

    thread_me(sort.sort, list1)
    thread_me(sort.merge_sort, list1)

    # matrix
    thread_me(matrix.m_sum, 20)
    thread_me(matrix.m_prod, 20)
    thread_me(matrix.m_times, 20)


def avg():
    results_files = ['fib', 'fact', 'sort', 'merge_sort', 'm_sum', 'm_prod', 'm_times' ]
    path = str(os.path.dirname(os.path.abspath(__file__))) + "/results"
    for result in results_files:
        # script en awk para calcular la media
        command = "awk < results_" + str(result) + \
                  " '{ sum += $3; n++ } END { if (n > 0) print  $1 \" : \" sum / n \" ms \"; }' >> " + path + ".txt "
        subprocess.call(command,shell=True)


if __name__ == "__main__":
    # Empezamos llamando a la función benchmark 3 veces para tomar muestras
    print "Iniciando Benchmark..."
    for i in range(0, 5):
        benchmark()
        # Reaper: finaliza los hilos empezados por la función benchmark()
        for t in threads:
            t.join()
        print "Terminando hilos"

    # finalmente, hacemos las medias de los archivos generados
    avg()
    print "Proceso finalizado. Consulte los resultados en \"results.txt\""
