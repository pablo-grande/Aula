$(document).ready(function(){

    var sellers = get_sellers();

    $("form").submit(function(e){
        e.preventDefault();
        var name = $("#login-name").val();
        if (sellers.indexOf(name) > -1) {
            localStorage.setItem("login-name",$("#login-name").val());
            window.location.href = "backend.html";
        }else{
            alert("Usuario incorrecto");
        }
    });
});

function get_sellers() {

    var people = [];

    $.get('XML/heladeros.xml', function (d) {

        $(d).find('heladero').each(function () {

            var $heladero = $(this);
            var nombre = $heladero.find("nombre").text();

            people.push(nombre);

        });

    });
    return people;
}