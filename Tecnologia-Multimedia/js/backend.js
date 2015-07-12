$(document).ready(function() {

    set_valuations();

    $("#seller-name").val(localStorage.getItem("login-name"));
    var addressed_to = $("#seller-name").val().toLowerCase().replace(' ','_');

    getXML(addressed_to);

    $("#chat-form").submit(function(e){
        e.preventDefault();
        //http://techslides.com/save-file-with-ajax-and-php
        addComent(addressed_to,$("#send-message").val());
    });
});

function set_valuations() {

    $.get('XML/heladeros.xml', function (d) {

        var valoracion = "";

        $(d).find('heladero').each(function () {

            var heladero = $(this);
            var nombre = heladero.find('nombre').text();

            if (nombre == localStorage.getItem('login-name')){
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
    coment.innerHTML =  who+': '+content ;

    parseXML();
    saveXML(who);
}


