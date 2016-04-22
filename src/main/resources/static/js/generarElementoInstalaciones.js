/**
 * Created by RnzPol on 18/04/2016.
 */

/************SCRIPT PARA LLENAR LOS DATOS DINAMICAMENTE*******************/
var imagenSedes=[
    "img/Sedes/sedeA.jpg",
    "img/Sedes/sedeB.jpg",
    "img/Sedes/sedeC.jpg",
    "img/Sedes/sedeA.jpg",
    "img/Sedes/sedeB.jpg",
    "img/Sedes/sedeC.jpg",
    "img/Sedes/sedeA.jpg",
    "img/Sedes/sedeB.jpg",
    "img/Sedes/sedeC.jpg",
    "img/Sedes/sedeA.jpg"


];
var tituloBongalow=["Instalacion Lima","Instalacion Tarapoto","Instalacion MacchuPicchu","Instalacion Cusco","Instalacion Atlantis",
    "Instalacion Catolica","Instalacion Causa","Instalacion Isquierda","Instalacion Los Olivos","Instalacion MiraFlorres"];
var sedesBungalows=[[],[],[],[],[],[],[],[],[],[]];
var telephoneNumbers=[90021906,1204021408,190212,90129016,90129020,9021806,8080128,128080,80016,2808000];
var precioBungalow=[80.00,100.00,120.00,140.00,160.00,80.00,100.00,120.00,140.00,160.00];
var caracteristicasSedes=[
    ["150 Members ","email@sede.com","<br>","Contact Person: Senor Rodriguez"],
    ["150 Members ","email@sede.com","<br>","Contact Person: Senor Rodriguez"],
    ["150 Members ","email@sede.com","<br>","Contact Person: Senor Rodriguez"],
    ["150 Members ","email@sede.com","<br>","Contact Person: Senor Rodriguez"],
    ["150 Members ","email@sede.com","<br>","Contact Person: Senor Rodriguez"],
    ["150 Members ","email@sede.com","<br>","Contact Person: Senor Rodriguez"],
    ["150 Members ","email@sede.com","<br>","Contact Person: Senor Rodriguez"],
    ["150 Members ","email@sede.com","<br>","Contact Person: Senor Rodriguez"],
    ["150 Members ","email@sede.com","<br>","Contact Person: Senor Rodriguez"],
    ["150 Members ","email@sede.com","<br>","Contact Person: Senor Rodriguez"]]
var sedesAdresses=[
    "Adress 123 Lima",
    "Adress 456 Lima",
    "Adress 789 Lima",
    "Adress 101112 Lima",
    "Adress 131415 Lima",
    "Adress 161718 Lima",
    "Adress 192021 Lima",
    "Adress 2222324 Lima",
    "Adress 252627 Lima",
    "Adress 282930 Lima",
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
        src:imagenSedes[i]
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
    b[3]=$('<h4></h4>').html('Adress: ' + sedesAdresses[i]);
    b[4]=retornaTelephone(telephoneNumbers[i]);
    for(var j=0;j<b.length;j++)
        panelInfo.append(b[j]);
    return panelInfo;
}
function retornaTitulo(t){
    return $('<h1></h1>').append($("<strong></strong>").html(t));
}
function retornaSedes(sedes){
    if(sedes.length==0)return $('<p></p>').html("ID");
    else {
        var parrafo=$('<p></p>');
        for(var i=0;i<sedes.length;i++){
            parrafo.append($("<span></span>").attr({class:"bg-info"}).html(sedes[i]));
        }
        return parrafo;
    }
}
function retornaTelephone(telephoneNumbers){

    return $('<h2></h2>').html("Telefon: " + telephoneNumbers);
}


function retornCaracteristicas(i){
    var caracteristicas=$('<div></div>').attr({
        class: 'panel-more1',
        style: "padding-left: 2em;"
    });
    var b=new Array();
    //b[0]=$("<h1></h1>").html("Precio: S/. "+precioBungalow[i]);
    b[1]=retornaMasCaracteristicas(i);
    for(var j=0;j<b.length;j++)
        caracteristicas.append(b[j]);
    return caracteristicas;
}

function retornaMasCaracteristicas(index){
    var masCaracteristicas=$('<div class="col-sm-offset-3 col-sm-12"></div>');
    var b=new Array();
    b[0]=$("<h2></h2>").html("\tDetails:");
    b[1]=$("<ul></ul>");
    for(var i=0;i<caracteristicasSedes[index].length;i++)
        b[1].append($("<li></li>").append($("<span></span>").html(caracteristicasSedes[index][i])));
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