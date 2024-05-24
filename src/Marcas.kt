class Marca(
    val nome: String,
    val paisOrigem: String,
    val anoFundacao: Int,
) {
    override fun toString(): String {
        val info = StringBuilder()
        info.append("Nome: $nome\n")
        info.append("País de Origem: $paisOrigem\n")
        info.append("Ano de Fundação: $anoFundacao\n")
        return info.toString()
    }
}