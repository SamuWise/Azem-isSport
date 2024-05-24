import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Venda(
    val itensVendidos: List<Produto>,
    val quantidades: List<Int>,
    val dataVenda: LocalDateTime = LocalDateTime.now()
) {
    init {
        require(itensVendidos.size == quantidades.size) { "O número de itens vendidos deve corresponder ao número de quantidades" }
    }

    fun calcularTotal(): Double {
        var total = 0.0
        for (i in itensVendidos.indices) {
            val item = itensVendidos[i]
            val quantidade = quantidades[i]
            total += item.preco * quantidade
        }
        return total
    }

    fun exibirDetalhes(): String {
        val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")
        val dataFormatada = dataVenda.format(formatter)

        val sb = StringBuilder()
        sb.appendln("Detalhes da Venda:")
        sb.appendln("Data da Venda: $dataFormatada")
        sb.appendln("Itens Vendidos:")
        for (i in itensVendidos.indices) {
            val item = itensVendidos[i]
            val quantidade = quantidades[i]
            sb.appendln("- ${item.nome} x $quantidade")
        }
        sb.appendln("Total da Venda: ${calcularTotal()}")

        return sb.toString()
    }
}
