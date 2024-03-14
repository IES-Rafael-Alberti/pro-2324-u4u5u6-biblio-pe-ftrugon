/**
 * Los prestamos que ha tenido la libreria
 */
class RegistroPrestamos(
    val listaDePrestamosActuales:MutableList<Prestamo> = mutableListOf(),
    val historialPrestamos: MutableList<Prestamo> = mutableListOf()
){

    fun registrarPrestamo(prestamo: Prestamo){
        listaDePrestamosActuales.add(prestamo)
        historialPrestamos.add(prestamo)
    }

    fun devolverLibro(prestamo: Prestamo){
        listaDePrestamosActuales.remove(prestamo)
    }

    fun consultarHistorialLibro(libro: Libro):List<Prestamo>{
        return historialPrestamos.filter { it.libro == libro }
    }

    fun consultarHistorialUsuario(nombre:String):List<Prestamo>{
        return historialPrestamos.filter { it.usuario.nombre == nombre }
    }



}