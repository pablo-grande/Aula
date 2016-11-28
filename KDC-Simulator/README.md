KDC-Simulator
=============

El propósito de este proyecto es ilustrar el funcionamiento básico de un _Key Distribution Center_ (KDC) mediante encriptado AES.

## Uso
Se puede utilizar mediante el script `main.py` pasándole un mensaje por parámetro.
Por defecto el mensaje es "message" y los nodos tienen como identificadores 'A'
y 'B', para cambiar esto último habría que modificar las primeras línea del script
`policy.py`.

También se pueden utilizar las entidades de la misma forma que
el script de `policy.py` con la consola de Python:
```
> python
>>> from node import *
>>> from kdc import *
>>> ...
```

## Entidades
El simulador utiliza esta entidades para relizar una comunicación simple. Son un conjunto de clases que pueden ser modificadas junto con el script de políticas para implementar otras estrategias de validación más complejas.

### Node
Este es el elemento principal, consiste en __un identificador__, una __clave__, un __diccionario de claves__ y una __lista de mensajes recibidos__.  
Un nodo pretende conectarse a otro nodo utilizando la clave que contiene en su diccionario de claves, una vez establecida la clave de sesisón (proporcionada por un nodo especial) pueden pasarse mensajes cifrados.

### KDC
Este es un nodo especial. Permite actualizar el diccionario de claves de los nodos que pretendan establecer conexión.

### AES
Implementación sencilla del sistema de encriptado AES mediante la librería Crypto de Python.  
Contiene los métodos necesarios para generar una clave de forma aleatoria y encriptado y desencriptado de mensajes mediante una clave.

### policy.py
Este script permite juntar todas las entidades anteriormente comentadas. El propósito de este script es mostrar el funcionamiento de los nodos con el kdc, de manera muy directa.  
La idea es utilizar este archivo para ir ampliando la complejidad de la comunicación entre los nodos y el kdc, junto con modificaciones de estas clases.  
#### default()
Esta función muestra de manera directa una comunicación encriptada simple entre dos nodos y el kdc.
