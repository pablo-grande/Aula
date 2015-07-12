/**
 * Created by pablo on 26/05/15.
 */
$(document).ready(function(){

    set_stores();

    $('body').on('click','td.seller',function(){
        var name = $(this).text();
        var desc = $(this).next().text();
        var store = $(this).next().next().text();

        $("#seller-name").text(name);
        $("#seller-store").text(store);
        $("#seller-section").removeClass('hidden');
        $("#chat").removeClass('hidden');
        $("#confirm").removeClass('hidden');

        $("#seller-jpg").attr('src','img/heladeros/'+name.split(' ')[0].toLowerCase()+'.png');

        sessionStorage.setItem('seller-name',name);
        set_valuations(name);

        var addressed_to = name.toLowerCase().replace(' ','_');
        getXML(addressed_to);

        $("#chat-form").submit(function(e){
            e.preventDefault();
            //http://techslides.com/save-file-with-ajax-and-php
            addComent(addressed_to,$("#send-message").val());
        });

    });
});

function set_valuations(who) {

    $.get('XML/heladeros.xml', function (d) {

        var valoracion = "";

        $(d).find('heladero').each(function () {

            var heladero = $(this);
            var nombre = heladero.find('nombre').text();

            if (nombre == who){
                    heladero.find('rating').each(function(){
                    valoracion = $(this).text();
                });
            }

        });

        $(".alert").each(function () {
            if ($(this).attr('id') == valoracion.split(':')[0]) {
                $(this).text(valoracion);
                $(this).removeClass('hidden');
            }
        });

    });
}

function set_stores(){

  $.get('XML/heladeros.xml', function(d){

      $(d).find('heladero').each(function(){

          var $heladero = $(this);
          var nombre = $heladero.find("nombre").text();
          var imageurl = $heladero.find('img').text();
          var descripcion = $heladero.find('bio').text();
          var tienda = $heladero.find('heladeria').text();

          var html = '<tr>';
          html +=   '<td class="seller"><a href="#">'+nombre+'</a></td>';
          html +=   '<td class="description">'+descripcion+'</td>';
          html +=   '<td class="store">'+tienda+'</td>';
          html += '</tr>'

          $('#heladeros').append(html);

        });

    });

}



var xmlDoc;

function getXML(who) {
    var req;
    if (window.XMLHttpRequest) {
        req = new XMLHttpRequest();
    } else {
        req = new ActiveXObject("Microsoft.XMLHTTP");
    }
    req.open("GET","chats/"+who+".xml", true);
    req.onreadystatechange = function () {
        if (req.readyState == 4 && req.status == 200) {
            xmlDoc = req.responseXML;
            console.log(xmlDoc);
            parseXML();
        }
    };
    req.send();
}

function parseXML() {
    document.getElementById('chat-body').innerHTML = '';
    var content = xmlDoc.getElementsByTagName("p");
    for (var i = 0; i < content.length; i++) {
        var coment =xmlDoc.getElementsByTagName("p")[i].childNodes[0].nodeValue;
        document.getElementById('chat-body').innerHTML += '<p>' + coment +'</p>';
    }
}

function saveXML(who) {
    var req;
    if (window.XMLHttpRequest) {
        req = new XMLHttpRequest();
    } else {
        req = new ActiveXObject("Microsoft.XMLHTTP");
    }
    req.open("POST", "save_chats.php?filename=chats/"+who+".xml", true);
    req.send(xmlDoc);
}

function addComent(who,content) {
    var coment = xmlDoc.createElement("p");
    xmlDoc.getElementsByTagName("llistacomentaris")[0].appendChild(coment);
    coment.htm
    coment.innerHTML =  'cliente: '+content ;

    parseXML();
    saveXML(who);
}
