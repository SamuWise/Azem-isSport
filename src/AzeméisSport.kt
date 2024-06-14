import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun main() {
    val LojaMalvaLopes = LojaDeRoupa("AzeméisSport")

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

    val itensVendidos = listOf(sapatilhasNike, camisola1, camisola2, camisola3, bonesAdidas, meias, manguitos, impermeaveis)
    val quantidades = listOf(2, 1, 3, 1, 5, 7, 10, 14) // Quantidades vendidas de cada produto

    val venda = Venda(itensVendidos, quantidades)

    // Exibir detalhes da venda
    println(venda.exibirDetalhes())

    // Atualizar o estoque após a venda
    for (i in itensVendidos.indices) {
        val produto = itensVendidos[i]
        val quantidadeVendida = quantidades[i]
        produto.quantidadeEstoque -= quantidadeVendida
    }
    // Criar um cliente e registrar a compra
    val cliente1 = Cliente(
        nome = "João",
        endereco = "Rua Vilas Boas, 123",
        email = "joaosoulindo@gmail.com",
        telefone = "1234567890"
    )

    // Simular uma compra de sapatilhas Nike pelo cliente
    // Definir datas de validade para os descontos
    val dataInicioDesconto = LocalDate.of(2024, 6, 13)
    val dataFimDesconto = LocalDate.of(2024, 6, 15)

    // Criar um desconto fixo de R$ 20 válido durante abril de 2024
    val descontos = Desconto(
        TipoDesconto.FIXO,
        20.0,
        itensVendidos,
        dataInicioDesconto,
        dataFimDesconto
    )
    val precoSapatilhasComDesconto = cliente1.aplicarDescontoAoProduto(sapatilhasNike, descontos)
        //descontos?.let { cliente1.aplicarDescontoAoProduto(it, sapatilhasNike)}

    println("Preço original das Sapatilhas Nike: R$${sapatilhasNike.preco}")
    println("Preço com desconto aplicado: R$$precoSapatilhasComDesconto")

    // Simular uma compra de camisola técnica pelo cliente
    val precoCamisolaComDesconto = ( cliente1.aplicarDescontoAoProduto(camisola1, descontos))

    println("\nPreço original da Camisola Técnica: R$${camisola1.preco}")
    println("Preço com desconto aplicado: R$$precoCamisolaComDesconto")
    cliente1.adicionarCompra(venda)

    // Exibir histórico de compras do cliente
    cliente1.exibirHistoricoCompras()

    // Verificar o estoque atualizado
    LojaMalvaLopes.listarProdutos()
}