fun main() {
    //Creacion del gestor
    val gestor = GestorBiblioteca(Catalogo(),RegistroPrestamos(), UtilidadesBiblioteca(), GestorEstados())

    //Creacion de los libros
    val libro1 = Libro("hola","2020","aventura")
    val libro2 = Libro("que","2020","aventura")
    val libro3 = Libro("tal","2020","aventura")

    // Agregando los libros
    gestor.agregarAlCatalogo(libro1)
    gestor.agregarAlCatalogo(libro2)
    gestor.agregarAlCatalogo(libro3)

    // Registrando los prestamos
    gestor.registrarPrestamo(libro1)
    gestor.registrarPrestamo(libro2)

    // Devolviendo los libros
    gestor.devolverLibro(libro2)
    gestor.devolverLibro(libro3)

    // Printeando los estados de los libros
    println("*** TODOS ***")
    val todos = gestor.retornarTodos()
    todos.forEach { println(it) }

    println("\n*** PRESTADOS ***")
    val prestados = gestor.retornarPrestados()
    prestados.forEach { println(it) }

    println("\n*** DISPONIBLES ***")
    val disponibles = gestor.retornarDisponibles()
    disponibles.forEach { println(it) }

}