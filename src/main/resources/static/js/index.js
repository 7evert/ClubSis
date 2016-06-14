/**
 * Created by Sebastian on 13-Jun-16.
 */
$(function() {
    $.ajax({
        type: 'GET',
        url: '/api/hola/mensaje'
    }).done(function(data, textStatus, jqXHR) {
        $("#mi-mensaje").html(data.message);
    }).fail(function(jqXHR, textStatus, errorThrown){
        alert("MASCAPOOOOOOOOOO, NO ESTÁS AUTENTICADO");
        var preLoginInfo = JSON.stringify({method: 'GET', url: '/'});
        Cookies.set('restsecurity.pre.login.request', preLoginInfo);
        window.location = '/login.html';
    });
});