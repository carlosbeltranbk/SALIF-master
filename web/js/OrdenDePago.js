var conceptosOrdenDePago = [];
var cadena ="";
function agregarConcepto(idCuentasContables) {

    if (confirm('¿agregar concepto?')) {
        console.log("cuenta Agregada"+idCuentasContables);
        conceptosOrdenDePago.push(idCuentasContables);
        return true;
    } else {
        return false;
    }

}


function cargarIds() {
    for (var i = 0; i < conceptosOrdenDePago.length; i++) {
        if (i==0) {
            cadena+=conceptosOrdenDePago;
        }else{
            cadena+=","+conceptosOrdenDePago
        }
        document.getElementById("idsCuentasContables").value += "," + conceptosOrdenDePago[i];
    }
 

}
function mostrarIds() {
    for (var i = 0; i < conceptosOrdenDePago.length; i++) {
        if (i==0) {
            cadena+=conceptosOrdenDePago;
        }else{
            cadena+=","+conceptosOrdenDePago
        }
        document.getElementById("idsCuentasContables").value += "," + conceptosOrdenDePago[i];
    }
 

}

function cargarIdsConceptos() {
    var ids = document.getElementsByName("ids");
    for (var i = 0; i < ids.length; i++) {
        console.log("-> " + ids[i]);
        document.getElementById("idsCuentasContables").value += "," + ids[i].value;
    }
}
function quitarConcepto(idHabitacion) {
    conceptosOrdenDePago.deleteCount(idHabitacion);
}