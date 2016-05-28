/**
 * Created by Luis on 21/04/2016.
 */
//Variables globales
var Notificaciones = (function () {
    return {
        type: {WARN: 'warning', ERROR: 'error', INFO: 'information', SUCCESS: 'success'},
        showNoty: function (message, type, modal) {
            if (!type) {
                type = Notificaciones.type.INFO;
            }
            noty({text: message, type: type, killer: true, maxVisible: 1, timeout: 4000, modal: modal ? modal : false});
        },
        showError: function (message, modal, timeout) {

            noty({text: message, type: Notificaciones.type.ERROR, killer: true, maxVisible: 1, timeout: timeout?timeout:3000, modal: modal ? modal : false});
        },
        showProcesando: function (message) {
            //Esta sera modal, ya que cuando traigamos datos del post json o desde el controlador sera una llamamada AJAX y entonces desactivara la ventana modal
            noty({text: (message ? message : 'Procesando... Espere un momento...'), type: Notificaciones.type.INFO, killer: true, maxVisible: 1, modal: true});
        },
        hideAll: function () {
            $.noty.closeAll();
        }
    };
})();
