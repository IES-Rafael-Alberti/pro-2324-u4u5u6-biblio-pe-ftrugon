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
    private val titulo:String,
    private val anoPublicacion:String,
    private val tematica:String,
    private var estado: Estado = Estado.DISPONIBLE,
    private var id:String = "") {

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

    fun cambiarEstado(){
        if (this.estado == Estado.DISPONIBLE){
            this.estado = Estado.PRESTADO
        }else{
            this.estado = Estado.DISPONIBLE
        }
    }

    fun cambiarId(id: String){
        this.id = id
    }

    fun obtenerTitulo() = this.titulo

    fun obtenerAnoPublicacion() = this.anoPublicacion

    fun obtenerTematica() = this.tematica

    fun obtenerEstado() = this.estado

    fun obtenerId() = this.id

    fun consultarDisponibilidad():Boolean{
        return if (this.estado == Estado.DISPONIBLE) true else false
    }
}

/**
 * La clase que representa los estados de los libros
 */
enum class Estado{
    DISPONIBLE,
    PRESTADO
}