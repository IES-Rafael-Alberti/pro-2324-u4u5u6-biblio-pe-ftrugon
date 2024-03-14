interface IGestorCatalogo{
    val listaDeElementos:MutableList<ElementoBiblioteca>
    fun agregarAlCatalogo(elemento:ElementoBiblioteca)
    fun eliminarDelCatalogo(elemento:ElementoBiblioteca)

}

/**
 * catalogo de elementos que tiene la libreria
 */
class Catalogo :IGestorCatalogo{
    override val listaDeElementos = mutableListOf<ElementoBiblioteca>()

    override fun agregarAlCatalogo(elemento:ElementoBiblioteca) {

        this.listaDeElementos.add(elemento)
    }

    override fun eliminarDelCatalogo(elemento:ElementoBiblioteca) {
        val elementoaEliminar = listaDeElementos.find {  it == elemento  }
        if (elementoaEliminar != null){
            listaDeElementos.remove(elementoaEliminar)
        }
    }
}