import java.time.LocalDate

fun main() {
    // Criar alguns produtos
    val sapatilhasNike = Sapatilhas("Nike Air", 199.99, "Mesh", 20, 42)
    val camisola1 = CamisolaMangaCurta("Camisola Técnica", 39.99, "Poliamida", 30, "Preta")

    // Criar uma lista de produtos elegíveis para desconto
    val produtosElegiveisDesconto = listOf(sapatilhasNike, camisola1)

    // Definir datas de validade para os descontos
    val dataInicioDesconto = LocalDate.of(2024, 6, 13)
    val dataFimDesconto = LocalDate.of(2024, 6, 15)

    // Criar um desconto fixo de R$ 20 válido durante abril de 2024
    val descontoFixo = Desconto(
        TipoDesconto.FIXO,
        20.0,
        produtosElegiveisDesconto,
        dataInicioDesconto,
        dataFimDesconto
    )

    // Aplicar o desconto às sapatilhas Nike (dentro do período de validade)
    val dataCompra = LocalDate.of(2024, 6, 13)
    val precoOriginalSapatilhas = sapatilhasNike.preco
    val precoComDesconto = descontoFixo.aplicarDesconto(precoOriginalSapatilhas)

    println("Preço original das Sapatilhas Nike: R$$precoOriginalSapatilhas")
    println("Preço com desconto aplicado: R$$precoComDesconto")

    // Tentar aplicar o mesmo desconto à camisola técnica (fora do período de validade)
    val precoOriginalCamisola = camisola1.preco
    val precoComDescontoCamisola = descontoFixo.aplicarDesconto(precoOriginalCamisola)

    println("\nPreço original da Camisola Técnica: R$$precoOriginalCamisola")
    println("Preço com desconto aplicado (fora do período de validade): R$$precoComDescontoCamisola")
}