$(document).ready(function () {
    $("tr").on("click", "#deleteUser", function (e) {
        e.preventDefault();
        var cod = $(this).parent().find('#codigo').val();
        swal({
            title: "¿Estás seguro de eliminar?",
            text: "Una vez eliminado deberás agregar de nuevo",
            type: "warning",
            showCancelButton: true,
            confirmButtonClass: "btn-danger",
            confirmButtonText: "Sí, eliminar",
            cancelButtonText: "No, cancelar",
            closeOnConfirm: false,
            closeOnCancel: false
        }, function (isConfirm) {
            if (isConfirm) {
                eliminarUsuario(cod);
                swal("Eliminado", "El usuario se ha eliminado", "success");
                setTimeout(function () {
                    parent.location.href = "SvUsuarios?accion=listarUsuarios";
                }, 1800);
            } else {
                swal("Cancelado", "Cancelaste la eliminación", "error");
            }
        });
    });

    function eliminarUsuario(cod) {
        var url = "SvUsuarios?accion=eliminarUsuario&cod=" + cod;
        console.log("Eliminado");
        $.ajax({
            type: 'POST',
            url: url,
            async: true,
            success: function (r) {
                // Puedes agregar código para manejar la respuesta aquí
            }
        });
    }
});