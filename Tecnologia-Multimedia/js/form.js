$(document).ready(function(){
	$("#seller-name").text(sessionStorage.getItem('seller-name'));

    var list = $(".list-group-item");
    var abstract = $("#abstract");
    var precio = 0;

    var iterator = parseInt(localStorage.getItem('total_helados'));
    for (var i=0; i<iterator; i++){

        var list2 = list.clone();

        var helado = localStorage.getItem('sabor_cantidad'+i).split(',')[0];
        var cantidad = localStorage.getItem('sabor_cantidad'+i).split(',')[1];
        var format = localStorage.getItem('format');

        precio += parseInt(cantidad);
        if (i==0){
            list.text("Helado de "+helado+", "+cantidad+" "+format);
        }else{
            abstract.append(list2);
            list2.text("Helado de "+helado+", "+cantidad+ " "+format);
        }
    }

    //en nuestro caso y para facilitar las cosas todos los helados valen 1€
    //si quisieramos cambiar este hecho, tan solo habria que almacenar el precio también.
    $("#price").text(precio+' €');

});