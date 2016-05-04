/**
 * Created by RnzPol on 18/04/2016.
 */

/************SCRIPT PARA LLENAR LOS DATOS DINAMICAMENTE*******************/
var imagenSedes=[
    "/img/Instalaciones/campoFutbolSintectico.jpg",
    "/img/Instalaciones/campoBasketball.jpg",
    "/img/Instalaciones/campogolf.jpg",
    "/img/Instalaciones/campoLosaVoleyball.jpg",
    "/img/Instalaciones/campoLosaFulbito.jpg",
    "/img/Instalaciones/mesabillar.jpg",
    "/img/Instalaciones/campoBasketball.jpg",
    "/img/Instalaciones/campogolf.jpg",
    "/img/Instalaciones/campoLosaVoleyball.jpg",
    "/img/Instalaciones/campoLosaFulbito.jpg"
];
var tituloBongalow=["Campo de 1 Fultbol Sintetico","Campo 2 de Basketball","Campo 1 de Golf","Campo 3 de Voley",
    "Campo 2 de Fulbito","Mesa 1 de Billar","Campo 3 de Basketball","Campo 2 de Golf","Campo 1 de Voley",
    "Campo 4 de Fulbito"];
var sedesBungalows=[["Chorrillos"],["Playa"],["Chorrillos"],["Chosica"],["Chorrillos"],["Chorrillos"],["Chorrillos"],["Chorrillos"],["Chorrillos"],["Chorrillos"]];
var precioBungalow=[80.00,100.00,120.00,140.00,160.00,80.00,100.00,120.00,140.00,160.00];
var capacidad=[14,10,12,14,16,8,10,12,14,16];
var disponibilidad=[
    ["Martes 6:00 pm - 10:00 pm","Sabado 8:00 am - 10:00 am","Viernes 8:00 pm - 10:00 pm","Domingo 9:00 am - 4:00 pm"],
    ["Miercoles 8:00 am - 10:00 am"],
    ["Martes 6:00 pm - 10:00 pm","Domingo 9:00 am - 4:00 pm"],
    ["Martes 6:00 pm - 10:00 pm","Jueves 8:00 pm - 10:00 pm","Domingo 9:00 am - 4:00 pm"],
    ["Viernes 8:00 pm - 10:00 pm","Domingo 9:00 am - 4:00 pm"],
    ["Domingo 9:00 am - 4:00 pm"],
    ["Viernes 8:00 pm - 10:00 pm","Domingo 9:00 am - 4:00 pm"],
    ["Lunes 6:00 pm - 10:00 pm","Domingo 8:00 am - 10:00 am","Viernes 8:00 pm - 10:00 pm","Sabado 9:00 am - 4:00 pm"],
    ["Martes 6:00 pm - 10:00 pm","Sabado 8:00 am - 10:00 am","Viernes 8:00 pm - 10:00 pm","Domingo 9:00 am - 4:00 pm"],
    ["Martes 6:00 pm - 10:00 pm","Sabado 8:00 am - 10:00 am","Viernes 8:00 pm - 10:00 pm","Domingo 9:00 am - 4:00 pm"]]
var referencia=[
    "Al costado del Aparcamiento",
    "En frente a la piscina",
    "Cerca a los bugnalows",
    "Al costado del Aparcamiento",
    "En frente a la piscina",
    "Cerca a los bugnalows",
    "Al costado del Aparcamiento",
    "En frente a la piscina",
    "Cerca a los bugnalows",
    "Al costado del Aparcamiento"
]

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
    b[0]=retornaImagenProveeder(i);
    b[1]=retornaPanelInfo(i);
    b[2]=retornCaracteristicas(i);
    for(var j=0;j<b.length;j++)
        panel.append(b[j]);
    return panel;
}

function retornaImagenProveeder(i){
    return $('<div></div>').attr({
        class: 'panel-more1 imagenBungalow',
    }).append($('<img />').attr({
        src:imagenSedes[i],
        style:"height:150px;position:relative;top:50px;"
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
    b[3]=$('<h3></h3>').html('Referencia: ' + referencia[i]);

    for(var j=0;j<b.length;j++)
        panelInfo.append(b[j]);
    return panelInfo;
}
function retornaTitulo(t){
    return $('<h1></h1>').append($("<strong></strong>").html(t));
}
function retornaSedes(sedes){
    if(sedes.length==0)return $('<p></p>').html("No disponible");
    else {
        var parrafo=$('<p></p>');
        for(var i=0;i<sedes.length;i++){
            parrafo.append($("<span></span>").attr({class:"bg-info"}).html(sedes[i]));
        }
        return parrafo;
    }
}

function retornCaracteristicas(i){
    var caracteristicas=$('<div></div>').attr({
        class: 'panel-more1',
        style: "padding-left: 2em;"
    });
    var b=new Array();
    b[0]=$("<h1></h1>").html("Precio: S/. "+precioBungalow[i]);
    b[1]=$("<h2></h2>").html("Capacidad: "+capacidad[i]+" personas");
    b[2]=disponibilidadInstalacion(i);
    for(var j=0;j<b.length;j++)
        caracteristicas.append(b[j]);
    return caracteristicas;
}

function disponibilidadInstalacion(index){
    var masCaracteristicas=$('<div class="col-sm-offset-3 col-sm-12"></div>');
    var b=new Array();
    b[0]=$("<h2></h2>").html("\tDisponibilidad:");
    b[1]=$("<ul></ul>");
    for(var i=0;i<disponibilidad[index].length;i++)
        b[1].append($("<li></li>").append($("<span></span>").html(disponibilidad[index][i])));
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