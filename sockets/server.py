import socket
import argparse
from TextCount import *
import threading


def get_message(client):
    """Message treatment

    Receives message from client and treats it with TextCount library.
    After treatment sends back TextCount results (text statistics) and closes client connections

    Args:
        client: The client socket
    """
    # get chunks of message and build a full message
    full_message = ""
    message = client.recv(params['recv']).decode('utf-8')
    while message:
        full_message += message
        # keep receiving
        message = client.recv(params['recv']).decode('utf-8')

    # upack options
    aux = full_message.split('-----OPTIONS-----\nWORD: ')
    word, text = aux[1].split('\n-----END OPTIONS-----\n')

    # analyze text
    text_count = TextCount(text)
    
    results = {}
    results.update({"vowels": text_count.vowels})
    results.update({"consonants": text_count.consonants})
    results.update({"digits": text_count.digits})
    results.update({"blanks": text_count.blanks})
    results.update({"line_breaks": text_count.line_breaks})
    results.update({"special": text_count.special})
    
    if word:
        results.update({word: text_count.word(word)})

    # send back results
    client.send(str(results).encode('utf-8'))
    print("{} has exited".format(client.getpeername()))
    client.close()


# create menu
parser = argparse.ArgumentParser()
parser.add_argument("-p", "--port", help="port to accept connection", type=int)
parser.add_argument("-i", "--ip", help="ip to accept connection", type=str)
args = parser.parse_args()


params = {
    'port': 5000,
    'recv': 256,
    'ip': ''
    }

if args.port:
    params['port'] = args.port
if args.ip:
    params['ip'] = args.ip

# create the socket
server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

try:
    server.bind((params['ip'], params['port']))
    server.listen(10)

    info = "Server listening on port {}".format(params['port'])
    if args.ip:
        info += " and ip {}".format(params['ip'])
    print(info)

    while True:
        client, _ = server.accept()
        print("{} has entered".format(client.getpeername()))

        # make a thread for each client
        thread = threading.Thread(target=get_message, args=(client, ))
        # make thread parent dependent
        thread.setDaemon(True)
        thread.start()

except KeyboardInterrupt:
    print("\nFinishing connection")

finally:
    print("Closing socket")
    server.close()

