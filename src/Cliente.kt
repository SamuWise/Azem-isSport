class Cliente(
    val nome: String,
    val endereco: String,
    val email: String,
    val telefone: String,
    val historicoCompras: MutableList<Venda> = mutableListOf()
) {
    fun adicionarCompra(venda: Venda) {
        historicoCompras.add(venda)
    }

    fun exibirHistoricoCompras() {
        println("Histórico de Compras de $nome:")
        historicoCompras.forEachIndexed { index, venda ->
            println("Compra ${index + 1}:")
            println(venda.exibirDetalhes())
        }
    }
    fun aplicarDescontoAoProduto(descontosDisponiveis: List<Desconto>,produto: Produto): Double {
        // Verifica se o cliente tem descontos aplicáveis ao produto
        val descontoAplicavel: Desconto = descontosDisponiveis.find { it.produtosElegiveis.contains(produto) }

        // Se encontrar um desconto aplicável, calcula o novo preço com desconto
        return if (descontoAplicavel != null) {
            val precoOriginal = produto.preco
            descontoAplicavel.aplicarDesconto(precoOriginal, LocalDate.now())
        } else {
            // Se não houver desconto aplicável, retorna o preço original
            return produto.preco
        }
    }
}
