let estudiantes = [];

function agregar() {
    let nombre = document.getElementById("nombre").value;
    let edad = document.getElementById("edad").value;
    let nota = document.getElementById("nota").value;

    if (nombre === "" || edad === "" || nota === "") {
        alert("Completa todos los campos");
        return;
    }

    estudiantes.push({ nombre, edad, nota });

    mostrar();

    document.getElementById("nombre").value = "";
    document.getElementById("edad").value = "";
    document.getElementById("nota").value = "";
}

function mostrar() {
    let tabla = document.getElementById("tablaEstudiantes");
    tabla.innerHTML = "";

    estudiantes.forEach((e, index) => {
        tabla.innerHTML += `
        <tr>
            <td>${e.nombre}</td>
            <td>${e.edad}</td>
            <td>${e.nota}</td>
            <td>
                <button onclick="editar(${index})">Editar</button>
                <button onclick="eliminar(${index})">Eliminar</button>
            </td>
        </tr>`;
    });
}

function editar(index) {
    let nuevoNombre = prompt("Nuevo nombre:", estudiantes[index].nombre);
    let nuevaEdad = prompt("Nueva edad:", estudiantes[index].edad);
    let nuevaNota = prompt("Nueva nota:", estudiantes[index].nota);

    estudiantes[index] = {
        nombre: nuevoNombre,
        edad: nuevaEdad,
        nota: nuevaNota
    };

    mostrar();
}

function eliminar(index) {
    estudiantes.splice(index, 1);
    mostrar();
}
