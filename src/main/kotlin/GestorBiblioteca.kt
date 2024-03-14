/**
 * El gestor de ela biblioteca
 *
 * @property catalogo el catalogo con todos los libros de la biblioteca
 * @property registroPrestamos registro de los prestamos que ha habido
 * @property utilidadesBiblioteca utilidades pequeñas y especificas de la biblioteca
 */
class GestorBiblioteca(
    val catalogo: Catalogo,
    val registroPrestamos: RegistroPrestamos,
    val utilidadesBiblioteca: UtilidadesBiblioteca,
    val gestorEstados: GestorEstados,
    val usuarios:List<Usuario>) {

    /**
     * Añade un libro al catalogo
     */
    fun agregarAlCatalogo(libro: Libro){
        libro.cambiarId(utilidadesBiblioteca.generarIdentificadorUnico())
        catalogo.listaDeLibros.add(libro)
    }

    /**
     * Elimina un libro del catalogo
     */
    fun eliminarDelCatalogo(libro: Libro){
        val libroaEliminar = catalogo.listaDeLibros.find {  it == libro  }
        if (libroaEliminar != null){
            catalogo.listaDeLibros.remove(libroaEliminar)
        }
    }

    /**
     * Registra un prestamo
     */
    fun registrarPrestamo(libro: Libro,nombreUsuario: String){

        val usuarioaPrestarle = usuarios.find { it.nombre == nombreUsuario }
        val libroaPrestar = catalogo.listaDeLibros.find {  it == libro  }

        if (libroaPrestar != null && usuarioaPrestarle != null && libro.consultarDisponibilidad()){
            libroaPrestar.cambiarEstado()

            val prestamo = Prestamo(libroaPrestar,usuarioaPrestarle)

            registroPrestamos.registrarPrestamo(prestamo)
            usuarioaPrestarle.agregaraListaPrestamos(prestamo)

        }
    }

    /**
     * devuelve el estado de un libro a disponible
     */
    fun devolverLibro(libro: Libro,nombreUsuario: String){

        val usuarioaDevolver = usuarios.find { it.nombre == nombreUsuario }
        val libroaDevolver = catalogo.listaDeLibros.find {  it == libro  }

        if (libroaDevolver != null && usuarioaDevolver != null){
            libroaDevolver.cambiarEstado()


            val prestamo = Prestamo(libroaDevolver,usuarioaDevolver)

            registroPrestamos.devolverLibro(prestamo)
            usuarioaDevolver.eliminardeListaPrestamos(prestamo)
        }

    }


    // HE QUITADO LA FUNCION QUE RETORNABA CADA LIBRO CON SU ESTADO Y LA HE DIVIDO EN TRES Y UNA CLASE
    fun retornarTodos() = catalogo.listaDeLibros

    fun retornarPrestados() = gestorEstados.retornarPrestados(catalogo.listaDeLibros)

    fun retornarDisponibles() = gestorEstados.retornarDisponibles(catalogo.listaDeLibros)

    fun consultarHistorialLibro(libro: Libro) = registroPrestamos.consultarHistorialLibro(libro)

    fun consultarHistorialUsuario(nombre:String) = registroPrestamos.consultarHistorialUsuario(nombre)

}

