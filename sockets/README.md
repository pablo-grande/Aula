# Sockets

Client sends to Server contents of a file and gets:
* number of each vowel in the text
* number of consonants
* number of digits
* number of special characters
* number of line breaks
* how many times a given word appears in text


## Server
```
usage: server.py [-h] [-p PORT]

optional arguments:
  -h, --help            show this help message and exit
  -p PORT, --port PORT  port to accept connection
  -i IP, --ip IP        ip to accept connection
```

## Client
```
usage: client.py [-h] [-w WORD] [-p PORT] [-e] file

positional arguments:
  file                  path of the file you want to send to server

optional arguments:
  -h, --help            show this help message and exit
  -w WORD, --word WORD  word you want to count into the text
  -p PORT, --port PORT  port to connect to server
  -i IP, --ip IP        ip to accept connection
```
