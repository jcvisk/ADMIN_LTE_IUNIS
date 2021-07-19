//Confirmación para guardar los datos
function validateSaved() {
  if (confirm('ESTAS SEGURO QUE DESEAS GUARDAR LOS DATOS?')) {
    return true;
  }
  return false;
};
//Confirmación para eliminar los datos
function validateRemoved() {
  if (confirm('ESTAS SEGURO QUE DESEAS ELIMINAR LOS DATOS?')) {
    return true;
  }
  return false;
};
//Confirmación para cerrar sesion
function validateLogout() {
  if (confirm('ESTAS SEGURO QUE DESEAS CERRAR SESIÓN?')) {
    return true;
  }
  return false;
};
//Confirmación para actualizar datos de usuario en sesion
function validateUserUpdate() {
  if (confirm('SI ACTUALIZAS LOS DATOS DE TU USUARIO SE CERRARÁ TU SESIÓN')) {
    return true;
  }
  return false;
};

/*-----------------------
Activar el modal de edicion y eliminacion
------------------------*/
function getParameter(parameterName){
  let parameters = new URLSearchParams(window.location.search);
  return parameters.get(parameterName);
}

if(getParameter("modal") == "true"){
  $("#formModal").modal();
}
if(getParameter("updPassModal") == "true"){
  $("#updatePasswordModal").modal();
}

/*-----------------------
Mostrar y ocultal password
------------------------*/
let boton = document.getElementById('mostrar');
let input = document.getElementById('userPassword');
boton.addEventListener('click', mostrarPass);
function mostrarPass(){
  if (input.type == "password"){
    input.type = "text";
    $('#mostrar').removeClass("fa-eye").addClass("fa-eye-slash");

  }else{
    input.type = "password";
    $('#mostrar').removeClass("fa-eye-slash").addClass("fa-eye");
  }
}
