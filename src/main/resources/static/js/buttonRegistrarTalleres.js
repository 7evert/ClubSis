/**
 * Created by CesarJoseRoberto on 21/05/2016.
 */

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
