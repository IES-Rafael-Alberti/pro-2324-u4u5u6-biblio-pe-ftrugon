class GestorElementos <T:ElementoBiblioteca>{
    val listaElementos = mutableListOf<T>()

    fun <T:ElementoBiblioteca>agregarElemento(elemento:T){
        listaElementos.add(T)
    }

    fun <T:ElementoBiblioteca>eliminarElementoPorID(id: String){
        val elementoAEliminar = listaElementos.find { it.id == id }
        if (elementoAEliminar != null){
            listaElementos.remove(T)
        }
    }

    fun filtrarPorCriterio<T>(elementos: T[], criterio: (elemento: T) => boolean): T[]{

    }
}