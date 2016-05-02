/**
 * Created by RnzPol on 18/04/2016.
 */

/************SCRIPT PARA LLENAR LOS DATOS DINAMICAMENTE*******************/
var imagenBungalow=["img/Bungalows/TipoBungalows/1_Lorena.png",
    "img/Bungalows/TipoBungalows/2_Club.png",
    "img/Bungalows/TipoBungalows/3_Class.png",
    "img/Bungalows/TipoBungalows/4_king.png",
    "img/Bungalows/TipoBungalows/5_KingCharles.png",
    "img/Bungalows/TipoBungalows/1_Lorena.png",
    "img/Bungalows/TipoBungalows/2_Club.png",
    "img/Bungalows/TipoBungalows/3_Class.png",
    "img/Bungalows/TipoBungalows/4_king.png",
    "img/Bungalows/TipoBungalows/5_KingCharles.png"];
var tituloBongalow=["bungalow Lorena","bungalow club","bungalow Class","bungalow King","bungalow King Charles",
    "bungalow Lorena","bungalow club","bungalow Class","bungalow King","bungalow King Charles"];
var sedesBungalows=[["Chorrillos"],["Chorrillos"],["Chorrillos"],["Chorrillos"],["Chorrillos"],["Chorrillos"],["Chorrillos"],["Chorrillos"],["Chorrillos"],["Chorrillos"]];
var capacidadBungalow=[6,8,12,16,20,6,8,12,16,20];
var precioBungalow=[80.00,100.00,120.00,140.00,160.00,80.00,100.00,120.00,140.00,160.00];
var caracteristicasBungalows=[
    ["1 Habitacion Personal","2 Camarotes","1 Cocina","1 Sala","1 Baño"],
    ["1 Habitacion Personal","3 Camarotes","1 Cocina","1 Sala","2 Baños"],
    ["2 Habitaciones Personales","4 Camarotes","1 Cocina","1 Sala","2 Baños"],
    ["3 Habitaciones Personales","5 Camarotes","1 Cocina","2 Salas","2 Baños"],
    ["5 Habitaciones Personales","6 Camarotes","2 Cocinas","2 Salas","2 Baños"],
    ["1 Habitacion Personal","2 Camarotes","1 Cocina","1 Sala","1 Baño"],
    ["1 Habitacion Personal","3 Camarotes","1 Cocina","1 Sala","2 Baños"],
    ["2 Habitaciones Personales","4 Camarotes","1 Cocina","1 Sala","2 Baños"],
    ["3 Habitaciones Personales","5 Camarotes","1 Cocina","2 Salas","2 Baños"],
    ["5 Habitaciones Personales","6 Camarotes","2 Cocinas","2 Salas","2 Baños"]];

function retornaElementoLista(i){
    return $('<a></a>').attr({
        href:'#',
        class: 'list-group-item hidden',
    }).append(retornaPanel(i));
}

function retornaPanel(i){
    return $('<div></div>').attr({
        class: 'panel panel-default',
    }).append(retornaPanelBody1(i));
}

function retornaPanelBody1(i){
    var panel = $('<div></div>').attr({
        class: 'panel-body',
    });
    var b=new Array();
    b[0]=retornaImagenBungalow(i);
    b[1]=retornaPanelInfo(i);
    b[2]=retornCaracteristicas(i);
    for(var j=0;j<b.length;j++)
        panel.append(b[j]);
    return panel;
}

function retornaImagenBungalow(i){
    return $('<div></div>').attr({
        class: 'panel-more1 imagenBungalow',
    }).append($('<img />').attr({
        src:imagenBungalow[i]
    }));
}

function retornaPanelInfo(i){
    var panelInfo=$('<div></div>').attr({
        class: 'panel-info',
        style: "padding-left: 2em;"
    });
    var b=new Array();
    b[0]=retornaTitulo(tituloBongalow[i]);
    b[1]==$('<p></p>');
    b[2]=retornaSedes(sedesBungalows[i]);
    b[3]=$('<h3></h3>').html('Capacidad');
    b[4]=retornaCapacidad(capacidadBungalow[i]);
    for(var j=0;j<b.length;j++)
        panelInfo.append(b[j]);
    return panelInfo;
}
function retornaTitulo(t){
    return $('<h1></h1>').append($("<strong></strong>").html(t));
}
function retornaSedes(sedes){
    if(sedes.length==0)return $('<p></p>').html("No Sedes Disponibles");
    else {
        var parrafo=$('<p></p>');
        for(var i=0;i<sedes.length;i++){
            parrafo.append($("<span></span>").attr({class:"bg-info"}).html(sedes[i]));
        }
        return parrafo;
    }
}
function retornaCapacidad(capacidad){
    var cadena=(capacidad>1)?" Personas":" persona";
    return $('<h2></h2>').html(capacidad+cadena);
}


function retornCaracteristicas(i){
    var caracteristicas=$('<div></div>').attr({
        class: 'panel-more1',
        style: "padding-left: 2em;"
    });
    var b=new Array();
    b[0]=$("<h1></h1>").html("Precio: S/. "+precioBungalow[i]);
    b[1]=retornaMasCaracteristicas(i);
    for(var j=0;j<b.length;j++)
        caracteristicas.append(b[j]);
    return caracteristicas;
}

function retornaMasCaracteristicas(index){
    var masCaracteristicas=$('<div></div>');
    var b=new Array();
    b[0]=$("<h2></h2>").html("Caracteristicas:");
    b[1]=$("<ul></ul>");
    for(var i=0;i<caracteristicasBungalows[index].length;i++)
        b[1].append($("<li></li>").append($("<span></span>").html(caracteristicasBungalows[index][i])));
    for(var i=0;i<b.length;i++)
        masCaracteristicas.append(b[i]);
    return masCaracteristicas;
}

function retornaBotonMostrarMas(){
    var b = $('<a></a>').attr({
        href:'#',
        id:'botonMostrarMas',
        class: 'list-group-item'
    }).append($("<h4></h4>").html("<strong>Mostrar Mas</strong>"));
    b.on('click', function() {
        mostrarNext5();
        event.preventDefault();
    });
    return b;
}
function llenarListaBungalows(){
    var nroElementos=tituloBongalow.length;
    for(var i=0;i<nroElementos;i++)
        retornaElementoLista(i).appendTo("#listaBungalows");
    retornaBotonMostrarMas().appendTo("#listaBungalows");
}