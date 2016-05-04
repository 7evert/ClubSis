/**
 * Created by Luis on 09/04/2016.
 */
/*Esto permitirá la funcionalidad del hover del menu y tambien la recarga de codigo html dentro de otro html*/
$(function(){
    console.log("Entro");
    menuDesplegable();
    $("#entrar").click(function() {
        alert( "Handler for .click() called." );
    });
    $("#head").load("common/head.html");
    $("#headerPrincipal").load("common/headerPrincipal.html");
    $("#headerUsuario").load("common/headerUsuario.html");
    $("#headerAdministrador").load("common/headerAdministrador.html");
    $("#footer").load("common/footer.html");
});

function menuDesplegable() {
    $(document).ready(function () {
        $(".dropdown").hover(
            function () {
                $('.dropdown-menu', this).not('.in .dropdown-menu').stop(true, true).slideDown("5000");
                $(this).toggleClass('open');
                console.log("Entro al principal222.js");
            },
            function () {
                $('.dropdown-menu', this).not('.in .dropdown-menu').stop(true, true).slideUp("5000");
                $(this).toggleClass('open');
            }
        );
    });
}