enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL, INTENSIVO } // "INTENSIVO" adicionado para teste.

// Classe estava vazia, valores foram criados e adicionados.
class Usuario(
    val id: Int, 
    val nome: String, 
    val email: String,
)

data class ConteudoEducacional(
    val id: Int,	// Criado identificador único.
    val nome: String,	// Alteração de variável (var) para valor (val).
    val duracao: Int = 60
)

data class Formacao(
    val nome: String, 
    val conteudos: List<ConteudoEducacional>,	// Alteração de variável (var) para valor (val).
    val nivel: Nivel	// Integração da classe "Nivel" no código.
) {
    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        if (!inscritos.contains(usuario)) {	// Caso o usuário não seja encontrado na lista de matriculados:
            inscritos.add(usuario)			// ... adicione o usuário.
            println("Usuário ${usuario.nome} foi matriculado com sucesso em $nome")
        } else {
            println("Usuário [${usuario.nome}] ***já se encontra matriculado*** em $nome")
        }
    }
    
    // Função para soma da duração dos conteúdos dentro de uma formação.
    fun totalDuracao(): Int {
        return conteudos.sumOf { it.duracao }
    }
    
    // Função para criação de lista ordenada dos conteúdos dentro de uma formação.
    fun listarConteudos() {
        println("Conteúdos da formação $nome:")
        conteudos.forEachIndexed { index, conteudo ->
            println("  ${index + 1}. ${conteudo.nome} (${conteudo.duracao} min)")
        }
    }
    
    // Função para criação de lista ordenada dos usuários matriculados em uma formação.
    fun listarInscritos() {
        println("Alunos matriculados em $nome:")
        if (inscritos.isEmpty()) {
            println("  Nenhum aluno matriculado")
        } else {
            inscritos.forEachIndexed { index, usuario ->
                println("  ${index + 1}. ${usuario.nome} - ${usuario.email}")
            }
        }
    }
}

fun main() {    
    // Criação de usuários
    val usuario1 = Usuario(1, "João Silva", "joao@email.com")
    val usuario2 = Usuario(2, "Maria Santos", "maria@email.com")
    val usuario3 = Usuario(3, "Carlos Souza", "carlos@email.com")
    val usuario4 = Usuario(4, "Ana Oliveira", "ana@email.com")
    val usuario5 = Usuario(5, "Pedro Costa", "pedro@email.com")
    val usuario6 = Usuario(6, "Lucia Mendes", "lucia@email.com")
    val usuario7 = Usuario(7, "Roberto Alves", "roberto@email.com")
    val usuario8 = Usuario(8, "Carla Ferreira", "carla@email.com")
    val usuario9 = Usuario(9, "Paulo Nunes", "paulo@email.com")
    
    // Criação de conteúdos
    val conteudo1 = ConteudoEducacional(1, "Introdução ao Kotlin", 120)
    val conteudo2 = ConteudoEducacional(2, "Classes e Objetos", 90)
    val conteudo3 = ConteudoEducacional(3, "Funções Avançadas", 150)
    val conteudo4 = ConteudoEducacional(4, "Corrotinas", 180)
    val conteudo5 = ConteudoEducacional(5, "Design Patterns em Kotlin", 150)
    val conteudo6 = ConteudoEducacional(6, "Arquitetura de Software", 180)
    
    // Criação de formações
    val formacaoBasica = Formacao("Kotlin Fundamentals", listOf(conteudo1, conteudo2), Nivel.BASICO)
    val formacaoIntermediaria = Formacao("Kotlin Advanced", listOf(conteudo3, conteudo4), Nivel.INTERMEDIARIO)
    val formacaoDificil = Formacao("Kotlin Expert", listOf(conteudo5, conteudo6), Nivel.DIFICIL)
    val formacaoIntensivo = Formacao("Kotlin Extra", listOf(conteudo1, conteudo2, conteudo3, conteudo4, conteudo5, conteudo6), Nivel.INTENSIVO)
    
    // Simulação de matrículas
    println("=== SISTEMA DE MATRÍCULAS ===\n")
    
    formacaoBasica.matricular(usuario1)
    formacaoBasica.matricular(usuario2)
    formacaoBasica.matricular(usuario1) // Teste de matrícula duplicada
    formacaoBasica.matricular(usuario3)
    
    formacaoIntermediaria.matricular(usuario4)
    formacaoIntermediaria.matricular(usuario5)
    formacaoIntermediaria.matricular(usuario6)
    formacaoIntermediaria.matricular(usuario5) // Teste de matrícula duplicada
    
    formacaoDificil.matricular(usuario7)
    formacaoDificil.matricular(usuario8)
    formacaoDificil.matricular(usuario9)
    formacaoDificil.matricular(usuario7) // Teste de matrícula duplicada
    
    println("\n=== RELATÓRIOS ===\n")
    
    // Exibe informações
    println("Formação: ${formacaoBasica.nome} (Nível: ${formacaoBasica.nivel})")
    println("Duração total: ${formacaoBasica.totalDuracao()} minutos")
    formacaoBasica.listarConteudos()
    formacaoBasica.listarInscritos()
    
    println("\n" + "-".repeat(50) + "\n")
    
    println("Formação: ${formacaoIntermediaria.nome} (Nível: ${formacaoIntermediaria.nivel})")
    println("Duração total: ${formacaoIntermediaria.totalDuracao()} minutos")
    formacaoIntermediaria.listarConteudos()
    formacaoIntermediaria.listarInscritos()
    
    println("\n" + "-".repeat(50) + "\n")
    
    println("Formação: ${formacaoDificil.nome} (Nível: ${formacaoDificil.nivel})")
    println("Duração total: ${formacaoDificil.totalDuracao()} minutos")
    formacaoDificil.listarConteudos()
    formacaoDificil.listarInscritos()
    
    println("\n" + "-".repeat(50) + "\n")
    
    // Teste - nenhum aluno matriculado
    println("Formação: ${formacaoIntensivo.nome} (Nível: ${formacaoIntensivo.nivel})")
    println("Duração total: ${formacaoIntensivo.totalDuracao()} minutos")
    formacaoIntensivo.listarConteudos()
    formacaoIntensivo.listarInscritos()
}