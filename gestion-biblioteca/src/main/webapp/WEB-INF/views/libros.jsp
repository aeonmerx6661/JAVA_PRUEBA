<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lista de Libros</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <h2 class="mt-5">Lista de Libros</h2>
    <table class="table mt-3">
        <thead>
        <tr>
            <th>ID</th>
            <th>Titulo</th>
            <th>ISBN</th>
            <th>Autores</th>
            <th>Editoriales</th>
        </tr>
        </thead>
        <tbody id="books-table">
        <!-- Aquí se llenarán los datos -->
        </tbody>
    </table>
</div>

<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<script>
    // Usar Axios para hacer la solicitud GET
    axios.get('http://localhost:8080/api/libros')  // Ajusta la URL según corresponda
        .then(function(response) {
            // Obtener los datos de la respuesta
            const libros = response.data;

            // Verificar si los datos están vacíos
            if (libros.length === 0) {
                // Si no hay datos, mostramos un mensaje
                const tbody = document.getElementById('books-table');
                const noDataRow = document.createElement('tr');
                const noDataCell = document.createElement('td');
                noDataCell.setAttribute('colspan', '5');
                noDataCell.textContent = 'No hay datos disponibles.';
                noDataRow.appendChild(noDataCell);
                tbody.appendChild(noDataRow);
                return;
            }

            // Verificar los datos en la consola
            console.log(libros);

            // Obtener el tbody de la tabla
            const tbody = document.getElementById('books-table');

            // Recorrer los libros y agregar filas
            libros.forEach(function(libro) {
                // Crear una nueva fila
                const row = document.createElement('tr');

                // Crear las celdas (td) para cada libro
                const cellId = document.createElement('td');
                cellId.textContent = libro.id;
                row.appendChild(cellId);

                const cellTitle = document.createElement('td');
                cellTitle.textContent = libro.titulo;
                row.appendChild(cellTitle);

                const cellIsbn = document.createElement('td');
                cellIsbn.textContent = libro.isbn;
                row.appendChild(cellIsbn);

                const cellAuthors = document.createElement('td');
                // Crear un string con los nombres de los autores
                const authorsList = libro.autores.map(author => author.nombre).join(', ');
                cellAuthors.textContent = authorsList;
                row.appendChild(cellAuthors);

                const cellEditorials = document.createElement('td');
                // Crear un string con los nombres de las editoriales
                const editorialsList = libro.editoriales.map(editorial => editorial.nombre).join(', ');
                cellEditorials.textContent = editorialsList;
                row.appendChild(cellEditorials);

                // Agregar la fila al tbody
                tbody.appendChild(row);
            });
        })
        .catch(function(error) {
            console.error('Error al cargar los datos:', error);
            // En caso de error, agregar un mensaje al tbody
            const tbody = document.getElementById('books-table');
            const errorRow = document.createElement('tr');
            const errorCell = document.createElement('td');
            errorCell.setAttribute('colspan', '5');
            errorCell.textContent = 'Error al cargar los datos.';
            errorRow.appendChild(errorCell);
            tbody.appendChild(errorRow);
        });
</script>
</body>
</html>
