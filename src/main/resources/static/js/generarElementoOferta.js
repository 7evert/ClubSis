/**
 * Created by RnzPol on 21/04/2016.
 */

/************SCRIPT PARA LLENAR LOS DATOS DINAMICAMENTE*******************/
var titulOferta = ["2 Bungalows King x 1","Descuento Bungalow Class","1 Bungalow Gratis","3 Botellas de Vino","4 Cajas de Cerveza","1 Pollo Entero"]
var idOferta =["1234","1432","9752","6654","9182","0126"];
var descripcionOferta =["Esta oferta,te permite poder alquilar 2 Bungalows por el precio de 1, sin cargos extras.",
    "Esta oferta,te permite alquilar 1 Bungalow con descuento generoso.",
    "Esta oferta,te permite poder alquilar 1 Bungalow Sin costo",
    "Si ganas te regalaremos3 botellas de vino",
    "Si ganas te regalaremos 4 Cajas ed Cerveza",
    "Si ganas te regalaremos 1 Pollo entero para que comas con tu familia"];
var descuentoOferta =[60,30,100,80,60,25];
var tipoPagoOferta =["Efectivo","Efectivo","Efectivo","Efectivo","Efectivo","Efectivo"];
var fechaInicioOferta =["18/03/2016","18/03/2016","18/03/2016","18/03/2016","18/03/2016","18/03/2016"];
var fechaFinOferta =["18/05/2016","18/05/2016","18/05/2016","18/05/2016","18/05/2016","18/05/2016"];

function retornaElementoLista(i){
    return $('<a></a>').attr({
        href:'#',
        class: 'list-group-item hidden',
    }).append(retornaPanel(i));
}

function retornaPanel(i){
    return $('<div></div>').attr({
        class: 'panel panel-default',
    }).append(retornaPanelBodyOferta(i));
}

function retornaPanelBodyOferta(i){
    var panel = $('<div></div>').attr({
        class: 'panel-body',
    });
    var b=new Array();
    b[0]=retornaPanelInfoOfertas(i);
    b[1]=retornaPanelOfertasDescripcion(i);
    for(var j=0;j<b.length;j++)
        panel.append(b[j]);
    return panel;
}

function retornaPanelInfoOfertas(i){
    var panelInfo=$('<div></div>').attr({
        class: 'panel-info',
        style: "padding-left: 2em; width:250px;"
    });
    var b=new Array();
    b[0]=$('<h1></h1>').append($("<strong></strong>")).html("Oferta Nro. "+idOferta[i]);
    b[1]=$('<h1></h1>').append($("<strong></strong>")).html(titulOferta[i]);
    for(var j=0;j<b.length;j++)
        panelInfo.append(b[j]);
    return panelInfo;
}

function retornaPanelOfertasDescripcion(i){
    var descripcion=$('<div></div>').attr({
        class: 'panel-more1',
        style: "padding-left: 2em;"
    });
    var b=new Array();
    b[0]=retornaFechas(i);
    b[1]=$("<p></p>").html("<strong>Descripcion</strong><br> "+descripcionOferta[i]+"<br>"+
                        "Porcentaje de Descuento es del "+descuentoOferta[i]+"%");
    b[2]=$("<p></p>").html("<strong>Requisitos</strong><br> Tipo de Pago: "+tipoPagoOferta[i]);
    for(var j=0;j<b.length;j++)
        descripcion.append(b[j]);
    return descripcion;
}
function retornaFechas(i){
    var fechas=$('<div></div>');
    var b=new Array();
    var h4=$('<h4></h4>');
    b[0]=$('<strong></strong>').html("Fecha Inicio: "+fechaInicioOferta[i]);
    b[1]=$('<strong></strong>').attr({style:'visibility:hidden;'}).html("asdsad");
    b[2]=$('<strong></strong>').html("Fecha Fin: "+fechaFinOferta[i]);
    for(var j=0;j<b.length;j++)
        h4.append(b[j]);
    fechas.append(h4);
    return fechas;
}
function llenarListaOfertas(){
    var nroElementos=titulOferta.length;
    for(var i=0;i<nroElementos;i++)
        retornaElementoLista(i).appendTo("#listaBungalows");
    retornaBotonMostrarMas().appendTo("#listaBungalows");
}
