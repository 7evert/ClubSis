/**
 * Created by RnzPol on 18/04/2016.
 */
/*****************++PLANTILLA DE LOS BOTONES******************************/
var administrador=0,socio=1;
var accionesXElemento=[
    /*ver,editar,eliminar,reservar,registrar*/
    //["Reservar","Anular","Modificar"],//usuario:SuperAdministrador
    ["Ver","Reservar","Editar","Eliminar"],//ADIMINISTRADOR
    //["Reservar","Anular","Modificar"],//usuario:Administradio
    ["Ver","Reservar"]];//usuario:Socio
var accionAgregar=[["Registrar"],//usuario:ADMINISTRADOR
    []];//usuario:Socio
var actualUsuario;
/*
 function Ver(){alert("Ver");event.preventDefault();}
 function Editar(){alert("Editar");event.preventDefault();}
 function Eliminar(){alert("Elimianr");event.preventDefault();}
 function Reservar(){alert("Reservar");event.preventDefault();}




 function Agregar(){alert("Agregar");event.preventDefault();}
 var funciones=[Ver,Editar,Eliminar,Reservar];*/
function agregarBotonesAListas(accionesXElemento,funciones,tipoUsuario){
    var nroAcciones=accionesXElemento[tipoUsuario].length;
    /*var divBotones=$('<div>').attr({class: 'social-box rght-box'}).appendTo($(".panel-body")[1]);*/
    /*------------------append el div <div class="social-box rght-box">---- -*/
    var divBotones=$('<div>').attr({
        class: 'panel-more1 social-box botonesAcciones'
    }).appendTo(".panel-body");

    /*-----------------<label class="accionLista"><label>Modificar</label></label>&nbsp; */
    /****** <div class="col-sm-offset-4 col-sm-5">
     <input type="submit" tabindex="3" value="Registrar" class="btn btn-primary"/>

     <input type="submit" tabindex="3" value="Cancelar" class="btn btn-primary"/>
     </div>
     */
    for(var i=0;i<divBotones.length;i++)
        for (var j = 0; j < nroAcciones; j++) {
            if((accionesXElemento[tipoUsuario][j]!="Suspender")|| (accionesXElemento[tipoUsuario][j]=="Suspender" && divBotones[i].parentElement.getAttribute("estado")!="INHABILITADO")){
                var b = $('<button>').attr({
                    /*type: 'submit',*/
                    tabindex: "3",
                    value: accionesXElemento[tipoUsuario][j],
                    class: "btn btn-primary rght-box accionLista"
                }).html(accionesXElemento[tipoUsuario][j]).appendTo(divBotones[i]);
                b[0].onclick = funciones[j];
            }
        }
}
function agregarBotonAgregar(accionAgregar,agregar,tipoUsuario){
    if(accionAgregar[tipoUsuario].length!=0){
        var b=$('<span>').attr({
            class: 'pull-right',
            id:'accionAgregar',
            style:'width:108px;'
        }).append('<input tabindex="3" value=\"'+accionAgregar[tipoUsuario]+'\" class="btn btn-primary rght-box accionLista" style="width:108px;margin-right:10px;">').appendTo("#topMostrar");
        b[0].onclick=agregar;
    }
}
function eliminarBotones(){
    $("#accionAgregar").remove();
    $(".botonesAcciones").remove();
}
function cambiarDeUsuario(nuevoUsuario,Agregar,funciones){
    if(nuevoUsuario==actualUsuario)return;
    actualUsuario=nuevoUsuario;
    eliminarBotones();
    agregarBotonAgregar(accionAgregar,Agregar,nuevoUsuario);
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