Tecnología Multimedia
=====================

# Práctica
Consiste en un ejemplo de web que utiliza tecnología XML, XSLT, HTML y Javascript para simular una página de servicios itinerantes.

# Teoría
Teoría de la asignatura

## XML
Tanto XML como HTML tienen sus orígenes en SGML (*Standard Generalized Markup Language*), que es un metalenguaje que nos permite definir la estructura de nuestros documentos. La definición de la estructura de un documento se hace mediante un DTD, definimos los elementos que contiene y cómo tienen que estar organizados para que sea correcto, por ejemplo un DTD podría definir la estructura de un documento HTML, por tanto, HTML es un tipo de documento SGML utilizado en web.

> XML **no es un tipo de documento SGML**, es una versión abreviada de este.

Con XML podemos definir nuestros propios documentos y etiquetas.

### DTD
En una DTD (Data Type Definition) se define la estructura de un documento XML, es decir, qué elementos conforman este documento y cómo están formados y relacionados.

En función de si un XML tiene asociado un DTD podemos determinar si el documento es:

1. Válido: que siguen las reglas de una DTD específica
2. Bien formado: que no necesariamente tiene un DTD, pero siguen las reglas XML al pie de la letra.

Un documento XML es bien formado si cumple las siguientes reglas:

1. Cumple la regla **document**:
   1. Contiene uno o más elementos
   2. Hay exactamente un elemento (raíz) del cual ninguna parte aparece en el contenido de ningún otro elemento.
   3. Para el resto de elementos, están bien delimitados por etiquetas de principio y final adecuadamente anidados.
2. Respeta todas las restricciones de buena formación dadas en la especificación.
3. Cada una de las entidades analizadas que se referencia directa o indirectamente en el documento está bien formada.

Además, los documentos XML bien formados tienen que cumplir con la corrección de sintaxis y restricciones de buena formación (*case sensitive, atributos entrecomillados, nombres de etiquetas iguales al principio y al final, etc*).

#### Elementos

* `#PCDATA`: Define un nodo vacío, sin hijos. Texto.
* Hijos: `<!ELEMENT XXX (AAA,BBB)>` XXX tiene dos hijos: AAA y BBB.
* `*`: El elemento aparece (una, ninguna, varias) veces.
* `+`: El elemento aparece (una, varias) veces.
* `?`: El elemento aparece (una, ninguna) vez.
* `|`: Selecciona uno de entre varios elementos. `<!ELEMENT BBB (CCC|DDD)>` El elemento BBB bien contiene un elemento CCC o un elemento DDD.

#### Atributos
Asocia pares de nombre-valor con elementos. Comienza con ATTLIST, seguido del nombre del elemento al que pertenece el atributo.
```
<!ATTLIST XXX
   aaa CDATA #REQUIRED //siempre presente
   bbb CDATA #IMPLIED //opcional
>
```
* `CDATA` puede contener cualquier carácter si se atiene a las reglas de formación.
* `NMTOKEN` Contiene letras, dígitos, '.', '-', '_' y ':'.
* `NMTOKENS` = NMTOKEN + espacio en blanco.

* `ID` contiene carácteres válidos en `NMTOKEN` y debe empezar por letra. Debe ser único.
* `IDREF` debe corresponder con el valor de algún atributo ID del documento.
* `IDREFS` puede corresponder a varios IDs.

### XSL
XML separa semántica y presentación de datos. La presentación de los datos se puede hacer mediante XSL, que controla dos componentes:

* Objetos que permiten aplicar información del formato a los elementos XML.
* Transformaciones XSL (XSLT), permite controlar el documento de salida y transformar los elementos XML en otras cosas. Por ejemplo, podemos pasar de XML a HTML.

## SVG
Scalable Vector Graphics. XML Graphics para la Web.
Es un lenguaje XML que permite expresar gráficos 2D de forma textual. Es un lenguaje vectorial.

### Beneficios
* No pierde calidad si se hace zoom o redimensiona.
* Ideal para ser impreso.
* Puede mostrarse de manera progresiva, no tiene que esperar que todo el documento esté cargado.
* Pueden ser indexados y buscados debido a que su contenido es XML.
* Pueden transformarse por hojas de estilo (CSS, XSL)
* Se puede integrar con varias tecnologías XML y del W3C.

### Sistema de coordenadas
El área del dibujo es infinita. Podemos establecer el tamaño del viewport (área en la que estamos interesados) utilizando los atributos height y width de svg y cuyo origen de coordenadas comienza en el punto (0,0) de la pantalla, siendo este la esquina superior izquierda.

### Estilos
Se pueden usar reglas de CSS para definir propiedades del objeto. Vienen definidas por el tag "style".
```
style="fill:color"; Define el color de la figura.
style="opacity:número decimal"; Define el valor de la opacidad de la figura.
style="stroke-width:número"; Define el ancho del contorno.
style="stroke:color"; Define el color del contorno.
```

### Geometría
Existen varias formas predefinidas en svg.
"x" e "y" desplazamiento del objeto respecto al origen de coordenadas. 
"width" y "height" ancho y alto del objeto.


style="stroke-opacity:número decimal"; Define el valor de la opacidad del contorno.
#### Rectángulo
```
<svg width="400" height="110">
  <rect width="300" height="100" 
   style="fill:rgb(0,0,255); stroke-width:3; stroke:rgb(0,0,0)" />
</svg>
```
"rx" y "ry" redondean las esquinas del objeto.

#### Círculo
```
<svg height="100" width="100">
  <circle cx="50" cy="50" r="40" 
   stroke="black" stroke-width="3" fill="red" />
</svg>
```
"cx" y "cy" definen la "x" y la "y" de las coordenadas del centro del círculo respecto al punto (0,0) (esquina superior izquierda).
En este ejemplo los elementos relacionados con el estilo de la figura se ponen directamente como atributos. Si usáramos el tag de "style" sería:
```
<svg height="100" width="100">
  <circle cx="50" cy="50" r="40" 
   style="stroke:black; stroke-width:3; fill:red" />
</svg>
```

#### Elipse
```
<svg height="140" width="500">
  <ellipse cx="200" cy="80" rx="100" ry="50"
  style="fill:yellow; stroke:purple; stroke-width:2" />
</svg>
```
"cx" y "cy" son el centro de la figura, como en el círculo. "rx" y "ry" definen el radio horizontal y el vertical respectivamente.

#### Line
```
<svg height="210" width="500">
  <line x1="0" y1="0" x2="200" y2="200" 
   style="stroke:rgb(255,0,0);stroke-width:2" />
</svg>
```
"x1" y "x2" representan respectivamente el inicio y el final de la línea en el eje x, "y1" y "y2" representan lo mismo en el eje y.

#### Polygon
```
<svg height="210" width="500">
  <polygon points="200,10 250,190 160,210" 
   style="fill:lime;stroke:purple;stroke-width:1" />
</svg>
```
El atributo "points" define el "x" e "y" de cada esquina del polígono. Este tiene 3 esquinas, una cuarta componente en el atributo "points" creará un polígono de cuatro esquinas.

#### Polyline
Crea cualquier forma que consiste en líneas rectas
```
<svg height="200" width="500">
  <polyline points="20,20 40,25 60,40 80,120 120,140 200,180"
  style="fill:none;stroke:black;stroke-width:3" />
</svg>
```
El atributo "points" define los puntos de la línea.

### Elementos disponibles
#### G
El elemento G se utiliza como contenedor para agrupar distintos objetos para después poder realizar sobre ellos acciones de forma global.
```
<svg width="500" height="400">
  <g opacity="0.2">
    <rect x="100" y="100" width="100" height="100"
     fill="red" />
    <rect x="150" y="150" width="100" height="100"
     fill="blue" />
  </g>
  <rect x="200" y="200" width="100" height="100" 
   fill="navy" />
</svg>
```
El grupo G define una opacidad de 0.2 sobre los rectángulos que contiene.
#### Referencias
Las referencias dentro de SVG permiten la reutilización de distintas definiciones de objetos en cualquier punto del documento. Así, podemos definir filtros u otras propiedades de ajuste gráfico de forma general dentro del documento y aplicarlas dinámicamente vía scripting. Esto se consigue aplicando un ID sobre el tag y llamándolo en el elemento deseado.
```
<linearGradient id="MyGradient">
</linearGradient>
<rect style="fill:url(#MyGradient)"/>
```
#### USE
Cualquier elemento gráfico de tipo SYMBOL, G, USE u otros elementos pueden potencialmente ser considerados como patrones y ser susceptibles de reutilizarse mediante la utilización de USE.
```
<svg width="10cm" height="3cm" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink">
  <defs>
    <rect id="MyRect" width="60" height="10"/>
  </defs>
  <rect x="0.1" y="0.1" width="99.8" height="29.8"
   fill="none" stroke="blue" stroke-width="0.2" />
  <use x="20" y="10" xlink:href="#MyRect" />
</svg>
```

## XSL-FO
XSL es un lenguaje para escribir hojas de estilo que consta de dos partes:

* XSLT, que es un lenguaje de transformación, mediante el cual se puede transformar un documento XML en otro XML.

* XSL-FO, un lenguaje de formateo, que no es más que un vocabulario XML para especificar objetos de formateo (FO). Mediante los objetos de formateo (Formatting Objects -FO-) y sus propiedades podemos describir cómo se van a visualizar los componentes de un documento
```
<?xml version="1.0" encoding="ISO-8859-1"?>
  <fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
    <fo:layout-master-set>
      <fo:simple-page-master master-name="simple"
         page-height="29.7cm"
         page-width="21cm"
         margin-top="1cm"
         margin-bottom="2cm"
         margin-left="2.5cm"
         margin-right="2.5cm">

      <fo:region-body margin-top="3cm"/>
      <fo:region-before extent="3cm"/>
      <fo:region-after extent="1.5cm"/>

      </fo:simple-page-master>
    </fo:layout-master-set>

    <fo:page-sequence master-reference="simple">
      <fo:flow flow-name="xsl-region-body">
        <fo:block font-size="18pt"
           font-family="sans-serif"
           line-height="24pt"
           space-after.optimum="15pt"
           text-align="center"
           padding-top="3pt">
           Aqui va el texto escrito o generado de forma dinámica
        </fo:block>
        <fo:block font-size="12pt"
          font-family="sans-serif"
          line-height="15pt"
          space-after.optimum="3pt"
          text-align="justify">
          Hola este es mi primer XSL-FO.
        </fo:block>
      </fo:flow>
    </fo:page-sequence>
</fo:root>
```
### Formato
Los FO están divididos formalmente en cuatro tipo de áreas rectangulares:

* Contenedores

* Bloques

* Líneas

* "inclusiones" (inline-areas). 

Un **contenedor** (container area) es la estructura de más alto nivel. Puede ser colocada en coordenadas precisas dentro del área que lo contiene. Puede contener otros contenedores, así como secuencias de bloques y de espacios a visualizar. 

Un **bloque** (block area) representa una estructura a nivel de bloque, como un párrafo o un apartado de una lista. Los bloques son colocados secuencialmente dentro del contenedor que los incluye. A su vez, los bloques pueden contener líneas, espacios a visualizar, una imagen y otros bloques.

Una **línea** (line area) hace referencia a cada línea de texto dentro de un bloque.

Las **inclusiones** (inline areas) son partes de una línea, como por ejemplo cada carácter, la referencia a una nota al pie o una expresión matemática. Cada inclusión puede contener otras inclusiones o inclusiones de espacio. 

### Propiedades
#### Páginas patrón
El elemento raíz de un FO es `fo:root`. Este elemento contiene un `fo:layout-master-set` y cero o más `fo:pagesequence`.

El `fo:layout-master-set` es un contenedor para las diferentes `fo:master-page` que vayan a usarse en el documento. Cada master page permite definir el patrón para una página.

#### Simple master pages
Se representan con `fo:simple-page-master`, las cuales pueden estar incluidas en un `fo:layout-master-set`. Definen el aspecto de cada página patrón especificando los tamaños de sus regiones.

#### Page secuences
Cada documento generado con FO debe tener una o más `fo:pagesequence`, cada una de las cuales a su vez tiene: 
* Una `fo:sequencespecification` (indicando el orden en que las páginas patrón son usadas). 
* Cero o más `fo:static-content` con texto a incluir en todas las páginas.
* Un `fo:flow` con datos que se incluirán en cada página.

#### Flows, contenido dinámico
El objeto `fo:flow`ubica el contenido de la página, dicho contenido está compuesto por el objecto `fo:block` (u otros elementos).

#### Static, contenido estático
Los `fo:static-content` sirven para especificar contenido que aparecerá en todas las páginas, pudiendo contener internamente los mismos contenidos que un `fo:flow`.
```
<fo:static-content flow-name="region-after">
   <fo:block>(C) GeNeura 2001</fo:block>
</fo:static-content> 
```
#### Numeración
Un `fo:page-sequence` tiene atributos relativos a la numeración pero para poner el número de página como tal hemos de incluir el `fo:page-number` dentro de un `fo:block`, `fo:inline` o algo similar.
```
<fo:page-sequence initial-page-numer="5" format="i">
  <fo:static-content flow-name="xsl-before">
    <fo:block text-align-last="centered" fontsize="12pt">
      <fo:page-number/>
    </fo:block>
  </fo:static-content>
</fo:page-sequence> 
```

## XQuery
```
<!--"books.xml"-->
<?xml version="1.0" encoding="UTF-8"?>

<bookstore>

<book category="COOKING">
  <title lang="en">Everyday Italian</title>
  <author>Giada De Laurentiis</author>
  <year>2005</year>
  <price>30.00</price>
</book>

<book category="CHILDREN">
  <title lang="en">Harry Potter</title>
  <author>J K. Rowling</author>
  <year>2005</year>
  <price>29.99</price>
</book>

<book category="WEB">
  <title lang="en">XQuery Kick Start</title>
  <author>James McGovern</author>
  <author>Per Bothner</author>
  <author>Kurt Cagle</author>
  <author>James Linn</author>
  <author>Vaidyanathan Nagarajan</author>
  <year>2003</year>
  <price>49.99</price>
</book>

<book category="WEB">
  <title lang="en">Learning XML</title>
  <author>Erik T. Ray</author>
  <year>2003</year>
  <price>39.95</price>
</book>

</bookstore>
```

XQuery usa funciones para extraer datos de un documento XML. XQuery utiliza expresiones Path para navegar a través de los elementos del documento.

### Funciones y expresiones Path
`doc('books.xml')` Carga el documento XML. `docs('docs.xml')/bookstore/book/title` selecciona todos los elementos "title" del documento.

### Predicados
XQuery utiliza predicados para limitar los datos extraídos de un documento XML. Por ejemplo:

* `doc('books.xml')/bookstore/book[price<30]` -> Libros cuyo precio sea inferior a 30.
* `doc('books.xml')/bookstore/book[price<30]/title` -> Títulos de libros cuyo precio sea inferior a 30.

### FLWOR
FLWOR es un acrónimo para "For, Let, Where, Order by, Return".

La expresión equivalente a `doc('books.xml')/bookstore/book[price<30]/title` -> Títulos de libros cuyo precio sea inferior a 30 sería
```
for $x in doc('books.xml')/bookstore/book
where $x/price < 30
order by $x/title
return $x/book/title
```

### XQuery + HTML
Presentar los resultado en una lista
```
<ul>
{
for $x in doc('books.xml')/bookstore/book
where $x/price < 30
order by $x/title
return <li>$x/book/title</li>
}
</ul>
```
Nos da:
```
<ul>
<li><title lang="en">Everyday Italian</title></li>
<li><title lang="en">Harry Potter</title></li>
<li><title lang="en">Learning XML</title></li>
<li><title lang="en">XQuery Kick Start</title></li>
</ul>
```

Podemos eliminar el tag de `<title>` de la siguiente forma:
```
<ul>
{
for $x in doc("books.xml")/bookstore/book/title
order by $x
return <li>{data($x)}</li>
}
</ul>
```
### Condicionales
```
for $x in doc('books.xml')/bookstore/book
return if ($x/@category == 'children')
then <child>{data($x/title)}</child>
else <adult>{data($x/title)}</adult>
```
