#!/usr/bin/env python
# -*- coding: utf-8 -*


def naive(pattern, text):
    step = len(pattern)
    for i in range(len(text) - step + 1):
        found = True
        for j in range(step):
            if text[i+j] != pattern[j]:
                found = False
                break

        if j == step-1 and found:
            return (i,j+1)

    return None


def _hash(text):
    #provide prime number for hash
    hash_value = 3
    result = 0
    for key, value in enumerate(text):
        result += ord(value) * hash_value**key
    return result


def rabin_karp(pattern, text):
    step = len(pattern)
    h_pattern = _hash(pattern)

    for i in range(len(text) - step + 1):
        sub_text = text[i:i+step]
        #first compare if hashes are same, then will compare sub_text with pattern
        if h_pattern == _hash(sub_text):
            if sub_text == pattern:
                return (i,i+step)

    return None


