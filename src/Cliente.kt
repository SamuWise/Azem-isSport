import java.time.LocalDate

class Cliente(
    val nome: String,
    val endereco: String,
    val email: String,
    val telefone: String,
    val historicoCompras: MutableList<Venda> = mutableListOf(),
    val descontosDisponiveis: MutableList<Desconto> = mutableListOf()
) {
    fun adicionarCompra(venda: Venda) {
        historicoCompras.add(venda)
    }

    fun aplicarDescontoAoProduto(produto: Produto): Double {
        val descontoAplicavel = descontosDisponiveis.find { it.produtosElegiveis.contains(produto) && LocalDate.now() in it.dataInicio..it.dataFim }
        return descontoAplicavel?.aplicarDesconto(produto.preco) ?: produto.preco
    }

    fun aplicarDescontoAoProduto(produto: Produto, desconto: Desconto): Double {
        return desconto.aplicarDesconto(produto.preco)
    }
    fun exibirHistoricoCompras() {
        println("Histórico de Compras de $nome:")
        historicoCompras.forEach { println(it.exibirDetalhes()) }
    }
}