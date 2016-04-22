/**
 * Created by RnzPol on 18/04/2016.
 */

/************SCRIPT PARA LLENAR LOS DATOS DINAMICAMENTE*******************/
var imagenProveeder=[
    "img/Proveeder/blank-profile.jpg",
    "img/Proveeder/blank-profile.jpg",
    "img/Proveeder/blank-profile.jpg",
    "img/Proveeder/blank-profile.jpg",
    "img/Proveeder/blank-profile.jpg",
    "img/Proveeder/blank-profile.jpg",
    "img/Proveeder/blank-profile.jpg",
    "img/Proveeder/blank-profile.jpg",
    "img/Proveeder/blank-profile.jpg",


];
var tituloBongalow=["Renzo","Prov. B","Prov. C","Prov. D","Prov. E.",
    "Prov F.","Prov G.","prov. h.","Prov iojaois","King Charles"];
var sedesBungalows=[[],[],[],[],[],[],[],[],[],[]];
var telephoneNumbers=[90021906,1204021408,190212,90129016,90129020,9021806,8080128,128080,80016,2808000];
var precioBungalow=[80.00,100.00,120.00,140.00,160.00,80.00,100.00,120.00,140.00,160.00];
var caracteristicasBungalows=[
    ["Member since: 01/04/2016 ","email@user.com","","",""],
    ["Member since: 01/04/2016 ","email@user.com","","",""],
    ["Member since: 01/04/2016 ","email@user.com","","",""],
    ["Member since: 01/04/2016 ","email@user.com","","",""],
    ["Member since: 01/04/2016 ","email@user.com","","",""],
    ["Member since: 01/04/2016 ","email@user.com","","",""],
    ["Member since: 01/04/2016 ","email@user.com","","",""],
    ["Member since: 01/04/2016 ","email@user.com","","",""],
    ["Member since: 01/04/2016 ","email@user.com","","",""],
    ["Member since: 01/04/2016 ","email@user.com","","",""]];

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
        src:imagenProveeder[i]
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
 //   b[3]=$('<h3></h3>').html('Member since : 01/04/2016 ');
    b[4]=retornaTelephone(telephoneNumbers[i]);
    for(var j=0;j<b.length;j++)
        panelInfo.append(b[j]);
    return panelInfo;
}
function retornaTitulo(t){
    return $('<h1></h1>').append($("<strong></strong>").html(t));
}
function retornaSedes(sedes){
    if(sedes.length==0)return $('<p></p>').html("Proveeder ID");
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
    var masCaracteristicas=$('<div class="col-sm-offset-3"></div>');
    var b=new Array();
    b[0]=$("<h2></h2>").html("\tDetails:");
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