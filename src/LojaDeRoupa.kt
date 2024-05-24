class LojaDeRoupa (val nome: String) {
    private val estoque = mutableMapOf<Produto, Int>()

    fun adicionarProduto(produto: Produto, quantidade: Int) {
        if (estoque.containsKey(produto)) {
            estoque[produto] = estoque[produto]!! + quantidade
        } else {
            estoque[produto] = quantidade
        }
    }

    fun listarProdutos() {
        println("Produtos disponíveis na loja $nome:")
        estoque.forEach { (produto) ->
            println("${produto.nome} - Preço: ${produto.preco}")
        }
    }
    // Implementar outros métodos como removerProduto, atualizarPreco...
}