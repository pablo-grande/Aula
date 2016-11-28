#!/usr/bin/env python

from policy import default
import sys

if __name__ == '__main__':
    input_message = "message" # default message

    # getting param message
    if len(sys.argv) > 1:
        # sys.argv[0] = program's name, sys.argv[1] = actual argument
        input_message = sys.argv[1]

    default(input_message)
