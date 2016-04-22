/**
 * Created by RnzPol on 18/04/2016.
 */
/*****************++PLANTILLA DE LOS BOTONES******************************/
var superAdministrador=0,administrador=1,socio=2;
var accionesXElemento=[
    ["Reservar","Anular","Modificar"],//usuario:SuperAdministrador
    ["Reservar","Anular","Modificar"],//usuario:Administradio
    ["Reservar","Anular"]];//usuario:Socio
var accionAgregar=[["Agregar"],//usuario:SuperAdministrador
    [],//usuario:Administradio
    []];//usuario:Socio
var actualUsuario;
function reservar(){alert("Reservar");event.preventDefault();}
function anular(){alert("Anular");event.preventDefault();}
function modificar(){alert("Modificar");event.preventDefault();}


function agregar(){alert("Agregar");event.preventDefault();}
var funciones=[reservar,anular,modificar];
function agregarBotonesAListas(accionesXElemento,funciones,tipoUsuario){
    var nroAcciones=accionesXElemento[tipoUsuario].length;
    /*var divBotones=$('<div>').attr({class: 'social-box rght-box'}).appendTo($(".panel-body")[1]);*/
    /*------------------append el div <div class="social-box rght-box">---- -*/
    var divBotones=$('<div>').attr({
        class: 'social-box botonesAcciones'
    }).appendTo(".panel-body");

    /*-----------------<label class="accionLista"><label>Modificar</label></label>&nbsp; */
    /****** <div class="col-sm-offset-4 col-sm-5">
     <input type="submit" tabindex="3" value="Registrar" class="btn btn-primary"/>

     <input type="submit" tabindex="3" value="Cancelar" class="btn btn-primary"/>
     </div>
*/
     for(var i=0;i<divBotones.length;i++)
        for (var j = 0; j < nroAcciones; j++) {
            var b = $('<input>').attr({
                type: 'submit',
                tabindex:"3",
                value:accionesXElemento[tipoUsuario][j],
                class:"btn-primary rght-box accionLista"
            }).appendTo(divBotones[i]);
            b[0].onclick=funciones[j];
        }
}
function agregarBotonAgregar(accionAgregar,agregar,tipoUsuario){
    if(accionAgregar[tipoUsuario].length!=0){
        var b=$('<span>').attr({
            class: 'pull-right',
            id:'accionAgregar'
        }).append('<input type="submit" tabindex="3" value="+ Agregar" class="btn btn-primary"/>').appendTo("#topMostrar");
        b[0].onclick=agregar();
    }
}
function eliminarBotones(){
    $("#accionAgregar").remove();
    $(".botonesAcciones").remove();
}
function cambiarDeUsuario(nuevoUsuario){
    if(nuevoUsuario==actualUsuario)return;
    actualUsuario=nuevoUsuario;
    eliminarBotones();
    agregarBotonAgregar(accionAgregar,agregar,nuevoUsuario);
    agregarBotonesAListas(accionesXElemento,funciones,nuevoUsuario);
}

function mostrarNext5(){
    var elementos=$(".list-group > .list-group-item")
    for(var i=0,j=0;j<5 && i<elementos.length;i++){
        if($(elementos[i]).hasClass("hidden") && elementos[i].getAttribute("id")!="botonMostrarMas"){
            $(elementos[i]).removeClass("hidden");j++;
        }
    }
    if(elementos.hasClass("hidden")==false)
        $("#botonMostrarMas").addClass("hidden");
}