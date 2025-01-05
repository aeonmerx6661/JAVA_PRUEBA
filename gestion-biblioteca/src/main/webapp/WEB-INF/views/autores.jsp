<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lista de Autores</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <h2 class="mt-5">Lista de Autores</h2>
    <table class="table mt-3">
        <thead>
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Nacionalidad</th>
        </tr>
        </thead>
        <tbody id="authors-table">
        <!-- Aquí se llenarán los datos -->
        </tbody>
    </table>
</div>

<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<script>
    // Usar Axios para hacer la solicitud GET
    axios.get('http://localhost:8080/api/autores')
        .then(function(response) {
            // Obtener los datos de la respuesta
            const autores = response.data;

            // Verificar si los datos están vacíos
            if (autores.length === 0) {
                // Si no hay datos, mostramos un mensaje
                const tbody = document.getElementById('authors-table');
                const noDataRow = document.createElement('tr');
                const noDataCell = document.createElement('td');
                noDataCell.setAttribute('colspan', '3');
                noDataCell.textContent = 'No hay datos disponibles.';
                noDataRow.appendChild(noDataCell);
                tbody.appendChild(noDataRow);
                return;
            }

            // Verificar los datos en la consola
            console.log(autores);

            // Obtener el tbody de la tabla
            const tbody = document.getElementById('authors-table');

            // Recorrer los autores y agregar filas
            autores.forEach(function(author) {
                // Crear una nueva fila
                const row = document.createElement('tr');

                // Crear las celdas (td) para cada autor
                const cellId = document.createElement('td');
                cellId.textContent = author.id;
                row.appendChild(cellId);

                const cellName = document.createElement('td');
                cellName.textContent = author.nombre;
                row.appendChild(cellName);

                const cellNationality = document.createElement('td');
                cellNationality.textContent = author.nacionalidad;
                row.appendChild(cellNationality);

                // Agregar la fila al tbody
                tbody.appendChild(row);
            });
        })
        .catch(function(error) {
            console.error('Error al cargar los datos:', error);
            // En caso de error, agregar un mensaje al tbody
            const tbody = document.getElementById('authors-table');
            const errorRow = document.createElement('tr');
            const errorCell = document.createElement('td');
            errorCell.setAttribute('colspan', '3');
            errorCell.textContent = 'Error al cargar los datos.';
            errorRow.appendChild(errorCell);
            tbody.appendChild(errorRow);
        });
</script>
</body>
</html>
