import java.time.LocalDate

fun main() {
    val LojaMalvaLopes = LojaDeRoupa("AzeméisSport")
    val clientes = mutableListOf<Cliente>()

    // Adicionando alguns produtos ao estoque
    val sapatilhasNike = Sapatilhas("Nike Air", 199.99, "Mesh", 20, 42)
    val camisola1 = CamisolaMangaCurta("Camisola Técnica", 39.99, "Poliamida", 30, "Preta")
    val camisola2 = CamisolaTermica("Camisola Térmica", 49.99, "Poliamida", 15, "Preta")
    val camisola3 = CamisolaMangaComprida("Camisola Manga Comprida", 39.99, "Fibra Sintética", 12, "Azul")
    val bonesAdidas = Bones("Adidas Classic", 29.99, "Algodão", 15, "Preto")
    val meias = Meias("Nike", 10.99, "Porcelana", 20, "Branco", 38)
    val manguitos = Manguitos("Reebok", 15.50, "Licra", 15, "Roxo")
    val impermeaveis = Impermeaveis("Zara", 25.95, "Tecido", 15, "Verde")

    LojaMalvaLopes.adicionarProduto(sapatilhasNike, 10)
    LojaMalvaLopes.adicionarProduto(camisola1, 20)
    LojaMalvaLopes.adicionarProduto(camisola2, 18)
    LojaMalvaLopes.adicionarProduto(camisola3, 19)
    LojaMalvaLopes.adicionarProduto(bonesAdidas, 5)
    LojaMalvaLopes.adicionarProduto(meias, 10)
    LojaMalvaLopes.adicionarProduto(manguitos, 15)
    LojaMalvaLopes.adicionarProduto(impermeaveis, 12)

    // Criar um desconto fixo de R$ 20 válido durante abril de 2024
    val dataInicioDesconto = LocalDate.of(2024, 4, 1)
    val dataFimDesconto = LocalDate.of(2024, 4, 30)
    val descontoFixo = Desconto(
        TipoDesconto.FIXO,
        20.0,
        listOf(sapatilhasNike, camisola1),
        dataInicioDesconto,
        dataFimDesconto
    )

    while (true) {
        println("\nBem-vindo à ${LojaMalvaLopes.nome}")
        println("1. Listar produtos")
        println("2. Cadastrar cliente")
        println("3. Realizar compra")
        println("4. Ver histórico de compras")
        println("5. Sair")
        print("Selecione uma opção: ")

        when (readLine()?.toIntOrNull()) {
            1 -> listarProdutos(LojaMalvaLopes)
            2 -> cadastrarCliente(clientes, descontoFixo)
            3 -> realizarCompra(LojaMalvaLopes, clientes)
            4 -> verHistoricoDeCompras(clientes)
            5 -> {
                println("Saindo...")
                return
            }
            else -> println("Opção inválida. Tente novamente.")
        }
    }
}

fun listarProdutos(loja: LojaDeRoupa) {
    println("\nProdutos disponíveis:")
    loja.listarProdutos()
}

fun cadastrarCliente(clientes: MutableList<Cliente>, desconto: Desconto) {
    print("Nome: ")
    val nome = readLine().orEmpty()
    print("Endereço: ")
    val endereco = readLine().orEmpty()
    print("Email: ")
    val email = readLine().orEmpty()
    print("Telefone: ")
    val telefone = readLine().orEmpty()

    val novoCliente = Cliente(nome, endereco, email, telefone, descontosDisponiveis = mutableListOf(desconto))
    clientes.add(novoCliente)
    println("Cliente $nome cadastrado com sucesso.")
}

fun realizarCompra(loja: LojaDeRoupa, clientes: List<Cliente>) {
    if (clientes.isEmpty()) {
        println("Nenhum cliente cadastrado. Por favor, cadastre um cliente primeiro.")
        return
    }

    print("Digite o nome do cliente: ")
    val nomeCliente = readLine().orEmpty()
    val cliente = clientes.find { it.nome == nomeCliente }

    if (cliente == null) {
        println("Cliente não encontrado.")
        return
    }

    println("Produtos disponíveis para compra:")
    loja.listarProdutos()
    print("Digite o nome do produto para comprar: ")
    val nomeProduto = readLine().orEmpty()
    val produto = loja.listarProdutos().keys.filter { it.nome == nomeProduto } [0]

    if (produto == null) {
        println("Produto não encontrado.")
        return
    }

    print("Digite a quantidade a comprar: ")
    val quantidade = readLine()?.toIntOrNull() ?: 0

    if (quantidade <= 0 || quantidade > produto.quantidadeEstoque) {
        println("Quantidade inválida.")
        return
    }

    val precoFinal = cliente.aplicarDescontoAoProduto(produto)
    val venda = Venda(listOf(produto), listOf(quantidade), LocalDate.now())
    cliente.adicionarCompra(venda)
    produto.quantidadeEstoque -= quantidade
    println("Compra realizada com sucesso. Preço final: R$$precoFinal")
}

fun verHistoricoDeCompras(clientes: List<Cliente>) {
    if (clientes.isEmpty()) {
        println("Nenhum cliente cadastrado.")
        return
    }

    print("Digite o nome do cliente: ")
    val nomeCliente = readLine().orEmpty()
    val cliente = clientes.find { it.nome == nomeCliente }

    if (cliente == null) {
        println("Cliente não encontrado.")
        return
    }

    cliente.exibirHistoricoCompras()
}