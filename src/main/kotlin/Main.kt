fun main() {
    val gestor = GestorBiblioteca(Catalogo(),RegistroPrestamos())
    val libro1 = Libro("1","hola","2020","aventura")
    val libro2 = Libro("2","que","2020","aventura")
    val libro3 = Libro("3","tal","2020","aventura")


    gestor.agregarAlCatalogo(libro1)
    gestor.agregarAlCatalogo(libro2)
    gestor.agregarAlCatalogo(libro3)

    gestor.registrarPrestamo(libro1)
    gestor.registrarPrestamo(libro2)

    gestor.devolverLibro(libro2)
    gestor.devolverLibro(libro3)

    gestor.retornarEstados()

}