#!/usr/bin/env python


def text_content(filename='text.txt'):
    content = ""
    with open(filename, 'r') as f:
        for line in f:
            content += line
    f.closed
    return content


def letter_counter(filename='text.txt'):
    from collections import Counter
    from re import findall

    c = Counter()
    # read file line by line and add its letters to counter
    with open(filename, 'r') as f:
        for line in f:
            words = [w.lower() for w in findall('[a-zA-Z]+', line)]
            for w in words:
                # transform for into letters
                c.update(list(w))
    f.closed

    return list(dict(c).items())

