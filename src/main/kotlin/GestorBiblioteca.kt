class GestorBiblioteca(val catalogo: Catalogo,val registroPrestamos: RegistroPrestamos) {

    fun agregarAlCatalogo(libro: Libro){
        catalogo.listaDeLibros.add(libro)
    }

    fun eliminarDelCatalogo(libro: Libro){
        val libroaEliminar = catalogo.listaDeLibros.find {  it == libro  }
        if (libroaEliminar != null){
            catalogo.listaDeLibros.remove(libroaEliminar)
        }
    }

    fun registrarPrestamo(libro: Libro){
        val libroaPrestar = catalogo.listaDeLibros.find {  it == libro  }
        if (libroaPrestar != null && consultarDisponibilidad(libroaPrestar)){
            libroaPrestar.estado = Estado.PRESTADO
        }
    }

    fun devolverLibro(libro: Libro){
        libro.estado = Estado.DISPONIBLE
    }

    fun consultarDisponibilidad(libro: Libro):Boolean{
        return if (libro.estado == Estado.DISPONIBLE) true else false
    }


    fun retornarEstados(){
        catalogo.listaDeLibros.forEach { println("${it.titulo}, ${it.estado}") }
    }


}
