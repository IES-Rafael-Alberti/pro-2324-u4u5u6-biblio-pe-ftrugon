
data class Libro(val id:String,val titulo:String,val anoPublicacion:String,val tematica:String,var estado: Estado = Estado.DISPONIBLE) {

    init {
        requireNoVacio(id)
        requireNoVacio(titulo)
        requireNoVacio(anoPublicacion)
        requireNoVacio(tematica)
    }
    fun requireNoVacio(campo:String){
        require(campo.isNotEmpty()){"El campo $campo no puede estar vacio"}
    }
}

enum class Estado(){
    DISPONIBLE,
    PRESTADO
}