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
        if (jqXHR.status === 401) {
            alert("Redirigiendo a mi-login.html...");
            var preLoginInfo = JSON.stringify({method: 'GET', url: '/'});
            Cookies.set('restsecurity.pre.login.request', preLoginInfo);
            window.location = '/mi-login.html';
        }
        else {
            alert("Mascapo, tenemos un problema...");
        }
    });
});