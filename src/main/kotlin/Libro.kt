/**
 * Clase que interpreta un libro
 *
 * @property titulo El titulo del libro
 * @property anoPublicacion La fecha de publicacion del libro
 * @property tematica la tematica del libro
 * @property estado Si el libro esta disponible o prestado, disponible por defecto
 * @property id La id unica de un elemento
 */
data class Libro(
    val titulo:String,
    val anoPublicacion:String,
    val tematica:String,
    var estado: Estado = Estado.DISPONIBLE,
    var id:String = "") {

    init {
        requireNoVacio(titulo)
        requireNoVacio(anoPublicacion)
        requireNoVacio(tematica)
    }

    /**
     * Una funcion para hacer que no este vacia una propiedad de libro
     *
     * @param campo El campo a requerir que no este vacio
     */
    fun requireNoVacio(campo:String){
        require(campo.isNotEmpty()){"El campo $campo no puede estar vacio"}
    }
}

/**
 * La clase que representa los estados de los libros
 */
enum class Estado{
    DISPONIBLE,
    PRESTADO
}