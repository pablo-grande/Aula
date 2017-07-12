#!/usr/bin/env python
# -*- coding: utf-8 -*
from random import choice, randrange
from timer import timing
from sys import argv
import substrings
from string import ascii_lowercase as letters

@timing
def naive(pattern, text):
    return substrings.naive(pattern, text)


@timing
def rabin_karp(pattern, text):
    return substrings.rabin_karp(pattern, text)


def test(num_character):
    #generate random text
    text = ''.join(choice(letters) for _ in range(num_character))
    #generate random pattern to seach of length 3
    limit = int(len(text)/2)
    ran = randrange(1,limit)
    pattern = text[ran:ran+limit]
    print('Trying to find "{}"\ninto text:\n{}\n'.format(pattern, text))
    print(naive(pattern, text))
    print(rabin_karp(pattern, text))
    print('\n=============\n')



if __name__ == '__main__':
    #get random text of 10 characters
    test(10)
    #get random text of 26 characters
    test(26)


