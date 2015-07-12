Pràctica de xarxes
====================
Crear un socket per a fer peticions a una plana web. Torna `index.html` i objectes imbricats.
##Client
Tota la pràctca es troba a l'arxiu `client.py`
Per a executar-lo primer s'ha d'executar el programa anterior, després només cal fer:
```
python client.py <direcció_web> <port>
```
El resultat es redirigeix a un fitxer index.html

##Ports
A Linux una bona manera de sebre informació dels ports es la comanda:
```
netstat -lntu
```
[Més info](http://superuser.com/questions/529830/get-a-list-of-open-ports-in-linux)

##Proves

La prova s'ha fet intentant executar el socket damunt la web www.firefox.cat i intentant accedir per port 80. Els paràmetres son:
```
python client.py www.firefox.cat 80
```
Com a resultat ens torna el fitxer `index.html` i al mateix directori on s'hagi executat el programa guarda els objectes.
