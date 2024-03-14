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
    val gestorEstados: GestorEstados) {

    /**
     * Añade un libro al catalogo
     */
    fun agregarAlCatalogo(libro: Libro){
        libro.id = utilidadesBiblioteca.generarIdentificadorUnico()
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
    fun registrarPrestamo(libro: Libro){
        val libroaPrestar = catalogo.listaDeLibros.find {  it == libro  }
        if (libroaPrestar != null && consultarDisponibilidad(libroaPrestar)){
            libroaPrestar.estado = Estado.PRESTADO
            registroPrestamos.listaDeRegistros.add(libro)
        }
    }

    /**
     * devuelve el estado de un libro a disponible
     */
    fun devolverLibro(libro: Libro){
        libro.estado = Estado.DISPONIBLE
    }

    /**
     * mira si el libro esta disponible o no
     */
    fun consultarDisponibilidad(libro: Libro):Boolean{
        return if (libro.estado == Estado.DISPONIBLE) true else false
    }


    // HE QUITADO LA FUNCION QUE RETORNABA CADA LIBRO CON SU ESTADO Y LA E DIVIDO EN TRES Y UNA CLASE
    fun retornarTodos() = catalogo.listaDeLibros

    fun retornarPrestados() = gestorEstados.retornarPrestados(catalogo.listaDeLibros)

    fun retornarDisponibles() = gestorEstados.retornarDisponibles(catalogo.listaDeLibros)


}
