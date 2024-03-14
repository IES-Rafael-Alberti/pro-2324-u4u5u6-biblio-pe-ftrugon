class GestorConsola {
    fun mostrarEstadoLibro(lista:List<Libro>){
        lista.forEach { println("${it.obtenerTitulo()},${it.obtenerEstado()},${it.obtenerId()}") }
    }

    fun mostrarHistorialLibro(lista:List<Prestamo>){
        println("*** HISTORIAL DEL LIBRO ${lista[0].libro.obtenerTitulo()} ***")
        lista.forEach { println("${it.libro}, ${it.usuario.nombre}") }
    }

    fun mostrarHistorialPersona(lista:List<Prestamo>){
        println("*** HISTORIAL DE  ${lista[0].usuario.nombre} ***")
        lista.forEach { println("${it.usuario.nombre},${it.libro.obtenerTitulo()}") }
    }
}