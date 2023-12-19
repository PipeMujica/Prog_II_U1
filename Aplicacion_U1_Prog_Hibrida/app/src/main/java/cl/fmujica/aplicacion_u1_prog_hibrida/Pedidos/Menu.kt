package cl.fmujica.aplicacion_u1_prog_hibrida.Pedidos

class Menu(val nombre:String, val precio:String){
    val nombre1 = "Cazuela"
    val nombre2 = "Pastel de Choclo"

}

class Mesa(val cant: Int, val itemMenu: Menu) {
    fun calcularSubTotal(): Int{
        return 10000 * cant

    }
}

private operator fun String.times(cant: Int): Int {

}

class CuentaMesa(val items: MutableList<Mesa>, val aceptaPropina: Boolean = true){

    fun agregarItem(item: Mesa) {
        items.add(item)
    }
    fun calcularTotalSinPropina(): Int {
        override calcularSubTotal(Int)
    }

    fun calcularPropina(): Int {

    }

    fun calcularTotalConPropina():Int {

    }
}

fun main() {
    val total = Menu()

}
