<!DOCTYPE html>
<html>
    <head>
        <title>Reporte de Historial de Viajes</title>
    </head>
    <body>
        <h1>Reporte de Historial de Viajes Por Fecha</h1>
        <form  action="${pageContext.request.contextPath}/SvReporte" method="post" target="_blank">
            <input type="hidden" name="tipoReporte" value="exportarServiciosPorFecha">
            <label>Fecha Desde:</label>
            <input type="date" name="fechaDesde">
            <br><br>
            <label>Fecha Hasta:</label>
            <input type="date" name="fechaHasta">
            <br><br>
            <input type="submit" value="Buscar Historial">
        </form>

        <h1>Reporte de Historial de Viajes por ID de Pasajero</h1>
        <form action="${pageContext.request.contextPath}/SvReporte" method="post" target="_blank">
            <input type="hidden" name="tipoReporte" value="exportarHistorialPorPasajero">
            <label>ID Pasajero:</label>
            <input type="text" name="idPasajero">
            <br><br>
            <input type="submit" value="Generar Reporte">
        </form>

    </body>
</html>
