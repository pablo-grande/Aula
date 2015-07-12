# -*- coding: utf-8 -*-

import socket  
import sys  
import struct
import time
import re
import os


def save_on_file(path,content):
    f = open(path,'w')
    f.write(content)
    f.close()

def parse_document(path):
    '''
    Obre el document donat i cerca conicidències
    amb l'expressió regular, al nostre cas seràn imatges
    retorn els paths de les imatges
    '''
    objectes=[]

    f = open(path,'r')
    doc = f.read()
    #Expressió regular per agafar els objectes imbricats
    reg_exp = '<img.*?src="(?!http)\/*(?P<path>[^"]+)"'
    for m in re.findall(reg_exp, doc):
        objectes.append(m)

    return objectes
 

def socket_send(the_socket,message):
    '''
    Aquest programa fa un sendall al socket creat amb un missatge específic
    '''
    try :
        #El request de la petició GET té aquesta forma
        request = 'Accept: text/xml,application/xml,application/xhtml+xml,'
        request += 'text/html;q=0.9,text/plain;q=0.8,video/x-mng,image/png,' 
        request += "image/jpeg,image/gif;q=0.2,text/css,*/*;q=0.1\r\n"
        request += "Accept-Language: en-us, en;q=0.50\r\n"
        request += "Accept-Charset: ISO-8859-1, utf-8;q=0.66, *;q=0.66\r\n"
        request += "Keep-Alive: 300\r\n"
        request += "Connection: keep-alive\r\n"
        request += "Referer: $referer\r\n"
        request += "Cache-Control: max-age=0\r\n"
        GET_request = "GET /"+message+" HTTP/1.1\r\nHost: "+host+"\r\n"+request+"\r\n"
        print GET_request
        the_socket.sendall(GET_request)
    except socket.error:
        #Send failed
        print 'Send failed'
        sys.exit()
 
    print 'Missatge enviat satisfactoriament'

 
def recv_timeout(the_socket,timeout=2):
    '''
    Aquesta funció fa que la conexió sigui persistent i que
    si rebem alguna cosa la tractem sense que doni timeout.
    '''
    the_socket.setblocking(0)
     
    total_data=[];
    data='';
     
    #començam
    begin=time.time()
    while 1:
        #si ja hem rebut dades i ens hem passat de temps, aturam
        if total_data and time.time()-begin > timeout:
            break
         
        #si no tenim dades, esperam el doble
        elif time.time()-begin > timeout*2:
            break
         
        try:
            data = the_socket.recv(8192)
            if data:
                total_data.append(data)
                #change the beginning time for measurement
                begin=time.time()
            else:
                #sleep for sometime to indicate a gap
                time.sleep(0.1)
        except:
            pass
     
    #ajuntam les dades obtingudes
    return ''.join(total_data)


#====Programa principal====

#Demanam entrada i port a l'usuari
if (len(sys.argv) < 3):
    print 'ERROR! Els arguments han de ser: <host> <port>'
    sys.exit()
host = sys.argv[1]
port = int(sys.argv[2])
 
try:
    #cream un socket especificat a l'estructura de sockets de python
    #INET = IPv4, de tipus stream
    s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
except socket.error:
    print 'Error al crear el socket'
    sys.exit() #si no aconseguim crear el socket, sortim del sistema
     
print 'Socket creat satisfactoriament'

try:
    remote_ip = socket.gethostbyname( host ) #resolem l'ip del host creat
 
except socket.gaierror:
    #si no l'hem pogut resoldre, llavors també sortim
    print 'No s\'ha pogut resoldre la ip'
    sys.exit()
 
#connectam el socket a l'ip i el port especificat
s.connect((remote_ip , port))
 
print 'Socket conectat a ' + host + ' amb ip ' + remote_ip

#enviam el missatge al servidor, en aquest cas volem l'index.html (/)

socket_send(s,'')
response = recv_timeout(s)

#escrivim la resposta al fitxer
file_name = 'index.html'
#Capçalera
save_on_file(file_name+".txt",response.split('\r\n\r\n')[0])
#Fitxer html
save_on_file(file_name,response.split('\r\n\r\n')[1])

print "Resposta de la petició al fitxer "+file_name

#anem a cercar els objectes imbricats
results = parse_document(file_name)
for m in results:
    print "objecte trobat: "+str(m)
    #tornam a fer una petició amb la ruta del nou objecte
    socket_send(s,m)
    response = recv_timeout(s)    

    #crea els directoris on ficar els objectes
    paths = m.split('/')[:-1]
    for p in paths:
        if not os.path.exists(p):
            os.makedirs(p)
        #guardam l'imatge trobada i la capçalera per separat.
        #d'aquesta forma podrem visualitzar l'imatge correctament també.

        #Capçalera
        save_on_file(m+".txt",response.split('\r\n\r\n')[0])
        #Imatge
        save_on_file(m,response.split('\r\n\r\n')[1])
        

#tancam el socket
s.close()
