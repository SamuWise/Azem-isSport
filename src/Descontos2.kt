fun main() {
    // Criar produtos
    val sapatilhasNike = Sapatilhas("Nike Air", 199.99, "Mesh", 20, 42)
    val camisola1 = CamisolaMangaCurta("Camisola Técnica", 39.99, "Poliamida", 30, "Preta")
    val camisola2 = CamisolaTermica("Camisola Térmica", 49.99, "Poliamida", 15, "Preta")
    val camisola3 = CamisolaMangaComprida("Camisola Manga Comprida", 39.99, "Fibra Sintética", 12, "Azul")
    val bonesAdidas = Bones("Adidas Classic", 29.99, "Algodão", 15, "Preto")
    val meias = Meias("Nike", 10.99, "Porcelana", 20, "Branco", 38)
    val manguitos = Manguitos("Reebok", 15.50, "Licra", 15, "Roxo")
    val impermeaveis = Impermeaveis("Zara", 25.95, "Tecido", 15, "Verde")

    // Criar uma lista de produtos elegíveis para desconto
    val produtosElegiveisDesconto = listOf(sapatilhasNike, bonesAdidas,)

    // Criar um desconto fixo de R$ 20 para produtos elegíveis
    val descontoFixo = Desconto(TipoDesconto.FIXO, 20.0, produtosElegiveisDesconto)

    // Aplicar o desconto às sapatilhas Nike
    val precoOriginalSapatilhas = sapatilhasNike.preco
    val precoComDesconto = descontoFixo.aplicarDesconto(precoOriginalSapatilhas)

    println("Preço original das Sapatilhas Nike: R$$precoOriginalSapatilhas")
    println("Preço com desconto aplicado: R$$precoComDesconto")

    // Criar um desconto de 5% para produtos elegíveis
    val descontoPorcentagem = Desconto(TipoDesconto.PORCENTAGEM, 37.0, produtosElegiveisDesconto)

    // Aplicar o desconto Bonés
    val precoOriginalbonesAdidas = bonesAdidas.preco
    val precoComDescontoPorcentagem = descontoPorcentagem.aplicarDesconto(precoOriginalbonesAdidas)

    println("Preço original Bonés: R$$precoOriginalbonesAdidas")
    println("Preço com desconto aplicado: R$$precoComDescontoPorcentagem")
}