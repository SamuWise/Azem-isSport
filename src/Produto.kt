open class Produto(
    val nome: String,
    val preco: Double,
    val material: String,
    var quantidadeEstoque: Int,

)

class Sapatilhas(
    nome: String,
    preco: Double,
    material: String,
    quantidadeEstoque: Int,
    val tamanho: Int
) : Produto(nome, preco, material, quantidadeEstoque)

class Meias(
    nome: String,
    preco: Double,
    material: String,
    quantidadeEstoque: Int,
    val cor: String,
    val tamanho: Int
) : Produto(nome, preco, material, quantidadeEstoque)

abstract class CamisolaDesportiva(
    nome: String,
    preco: Double,
    material: String,
    quantidadeEstoque: Int,
    val cor: String
) : Produto(nome, preco, material, quantidadeEstoque){

    abstract fun obterTipo(): String
}

class CamisolaTermica(
    nome: String,
    preco: Double,
    material: String,
    quantidadeEstoque: Int,
    cor: String,
) : CamisolaDesportiva(nome, preco, material, quantidadeEstoque, cor) {

    override fun obterTipo(): String {
        return "Térmica"
    }
}

class CamisolaMangaCurta(
    nome: String,
    preco: Double,
    material: String,
    quantidadeEstoque: Int,
    cor: String,
) : CamisolaDesportiva(nome, preco, material, quantidadeEstoque, cor) {

    override fun obterTipo(): String {
        return "Manga Curta"
    }
}

class CamisolaMangaComprida(
    nome: String,
    preco: Double,
    material: String,
    quantidadeEstoque: Int,
    cor: String,
) : CamisolaDesportiva(nome, preco, material, quantidadeEstoque, cor) {

        override fun obterTipo(): String {
            return "Manga Comprida"
        }
    }

class Bones(
    nome: String,
    preco: Double,
    material: String,
    quantidadeEstoque: Int,
    val cor: String
) : Produto(nome, preco, material, quantidadeEstoque)

class Manguitos(
    nome: String,
    preco: Double,
    material: String,
    quantidadeEstoque: Int,
    val cor: String
) : Produto(nome, preco, material, quantidadeEstoque)

class Impermeaveis(
    nome: String,
    preco: Double,
    material: String,
    quantidadeEstoque: Int,
    val cor: String
) : Produto(nome, preco, material, quantidadeEstoque)