import socket 
import argparse


# create menu
parser = argparse.ArgumentParser()
parser.add_argument("file", help="path of the file you want to send to server", type=str)
parser.add_argument("-w", "--word", help="word you want to count into the text", type=str)
parser.add_argument("-p", "--port", help="port to connect to server", type=int)
parser.add_argument("-i", "--ip", help="ip to connect to server", type=str)
args = parser.parse_args()


# prepare message to send
message = []
f = open(args.file, 'r')

message.append(args.word)


params = {
    'port': 5000,
    'recv': 256,
    'ip': '',
    }

if args.port:
    params['port'] = args.port
if args.ip:
    params['ip'] = args.ip

# create the socket
s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

try:
    s.connect((params['ip'], params['port']))

    # prepare options
    word = ""
    if args.word:
        word = args.word
    message = "-----OPTIONS-----\nWORD: " + word + "\n-----END OPTIONS-----\n"
    
    # send message
    message += f.read(params['recv'])
    while(message):
        s.send(message.encode('utf-8'))
        message = f.read(params['recv'])

    # signal server to stop listening for full message
    s.shutdown(socket.SHUT_WR)
    reply = s.recv(params['recv'])
    print("Server replied:\n{}".format(reply.decode('utf-8')))

finally:
    f.close()
    print("Closing socket")
    s.close()


