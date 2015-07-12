$(document).ready(function(){

    $("button").click(function(){
        //http://techslides.com/save-file-with-ajax-and-php
        $.ajax({
            url: 'save_valuation.php',
            type: 'POST',
            dataType: "json",
            data: {
                message: $('textarea').val(),
                rating: $(this).text(),
                to: sessionStorage.getItem('seller-name')
            }
        });
        alert("Le agradecemos su valoración");
    });

});
