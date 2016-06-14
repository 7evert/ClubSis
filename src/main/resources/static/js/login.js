/**
 * Created by Sebastian on 13-Jun-16.
 */
$(function() {
    $('#formulario-login').submit(function(event) {
        event.preventDefault();
        alert("Estoy submiteando");
        //var datos = $('#formulario-login').serialize();
        var datos = 'username=' + $('#username').val() + '&password=' + $('#password').val();
        console.log(datos);
        $.ajax({
            data: datos,
            timeout: 1000,
            type: 'POST',
            url: '/login' // viene con el Spring Security
        }).done(function(data, textStatus, jqXHR){
            var preLoginInfo = JSON.parse(Cookies.get('dashboard.pre.login.request'));
            window.location = preLoginInfo.url;
        }).fail(function(jqXHR, textStatus, errorThrown) {
            alert("MASCAPO TE EQUIVOCASTE DE CLAVE");
        });
    });
});