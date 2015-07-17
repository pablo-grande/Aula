$(document).ready(function () {

    set_flavours();
    localStorage.setItem('format',"bola(s)");

    //Hacemos un fade los formatos
    var format_select = $(".selectable");
    format_select.fadeTo('fast',0.33);

    //Si un formato es clickado, entonces
    //desmárcalo y marca a los otros.
    format_select.click(function(){
        check_fade($(this));
    });

    //Si clickamos en un formato entonces
    //desmarca los otros dos.
    $("#cucurucho").click(function(){
        unselect($("#polo"),$("#tarrina"));
    });

    $("#tarrina").click(function(){
        unselect($("#cucurucho"),$("#polo"));
    });

    $("#polo").on('click', function () {

        unselect($("#cucurucho"),$("#tarrina"));
	//Si marcamos un polo, entonces actualizamos el formato
        localStorage.setItem('format',"polo(s)");
	
	//Y escondemos la selección de bolas
        if ($(".bolas").is(':visible')) {
            $(".bolas").hide();

        } else {
            $(".bolas").show();
        }
    });

    //Si hemos terminado, entonces recogemos los datos introducidos.
    $('#confirm').click(function(){
        var item = 0;
	//Recorremos todos los sabores
        $("#sabores").find('article').each(function(){
            var ice_value = $(this).find('input').val();
	//Si ha sido marcado, entonces lo guardamos en el Storage
            if (ice_value) {
                var flavour = $(this).find('.nombre-sabor').text();
                var command = [flavour,ice_value];
                localStorage.setItem('sabor_cantidad'+item,command);
                item += 1;
            }
        });
        localStorage.setItem('total_helados',item);
    });

    //Esto es la funcionalidad del filtro con xsl
    $("#filter_confirm").click(function(){
        var filter_value = $("#filter_text").val()
        if (filter_value) {
            $("#sabores").load("filter.php?sabor=" + filter_value);
        }else{
            set_flavours();
        }
    });

});

//Funciones auxiliares

//Deselecciona los ids del parámetro
function unselect(id1,id2){
    id1.removeClass('clicked');
    id1.fadeTo("slow",0.33);
    id2.removeClass('clicked');
    id2.fadeTo("slow",0.33);
}

function check_fade(e){
    if (e.hasClass("clicked")) {
        e.fadeTo("slow", 0.33);
        e.removeClass("clicked");
    } else {
        e.fadeTo("slow", 1);
        e.addClass("clicked");
    }
}

//Carga los sabores
function set_flavours() {

    $.get('XML/sabores.xml', function (d) {

        $(d).find('sabor').each(function () {

            var sabor = $(this);
            var nombre = sabor.find("nombre").text();
            var imageurl = sabor.find('img').text();
            var precio = sabor.find('precio').text();

            var html = '<article>';
            html += '<div class="col-sm-6 col-md-2">';
            html += '<div class="thumbnail">';
            html += '<img src="' + imageurl + '" alt="' + nombre + '">';
            html += '<div class="caption centered">';
            html += '<header><h3 class="nombre-sabor">' + nombre + '</h3><span class="precio"></span></header>';
            html += '<p class="bolas"><span>Quiero </span><input type="number" name="quantity" min="0" max="7"> bolas</p>';
            html += '</div>';
            html += '</div>';
            html += '</div>';
            html += '</article>';

            $('#sabores').append(html);

        });

    });
}
