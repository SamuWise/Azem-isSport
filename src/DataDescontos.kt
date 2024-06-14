import java.time.LocalDate

class Desconto(
    val tipo: TipoDesconto,
    val valor: Double,
    val produtosElegiveis: List<Produto>,
    val dataInicio: LocalDate,
    val dataFim: LocalDate
) {

    fun aplicarDesconto(precoOriginal: Double): Double {
        val dataCompra = LocalDate.now()  // Assume que a data da compra é a data atual
        if (dataCompra !in dataInicio..dataFim) {
            // Fora do período de validade do desconto
            println("Este desconto não é mais válido para esta compra.")
            return precoOriginal
        }

        return when (tipo) {
            TipoDesconto.FIXO -> precoOriginal - valor
            TipoDesconto.PORCENTAGEM -> precoOriginal * (1 - (valor / 100))
        }
    }
}

enum class TipoDesconto {
    FIXO, PORCENTAGEM
}
