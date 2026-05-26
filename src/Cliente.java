/**
 * Classe Cliente
 * Representa um cliente cadastrado na locadora.
 * Estende Pessoa e acrescenta dados específicos de um locatário:
 * número de CNH, categoria de habilitação, data de nascimento
 * e total de locações realizadas.
 */
public class Cliente extends Pessoa {

    // --- Atributos específicos ---
    private String numeroCnh;           // Número da Carteira Nacional de Habilitação
    private String categoriaCnh;        // Categoria: A, B, AB, C, D, E
    private String dataNascimento;      // Data no formato dd/MM/aaaa
    private int    totalLocacoes;       // Quantidade de locações já realizadas

    /**
     * Construtor completo de Cliente.
     * @param id              identificador único
     * @param nome            nome completo
     * @param cpf             CPF do cliente
     * @param telefone        telefone de contato
     * @param email           e-mail
     * @param endereco        endereço residencial
     * @param numeroCnh       número da CNH
     * @param categoriaCnh    categoria da CNH (A, B, AB, etc.)
     * @param dataNascimento  data de nascimento (dd/MM/aaaa)
     */
    public Cliente(int id, String nome, String cpf, String telefone,
                   String email, String endereco,
                   String numeroCnh, String categoriaCnh, String dataNascimento) {
        // Chama o construtor da superclasse Pessoa
        super(id, nome, cpf, telefone, email, endereco);
        this.numeroCnh       = numeroCnh;
        this.categoriaCnh    = categoriaCnh;
        this.dataNascimento  = dataNascimento;
        this.totalLocacoes   = 0; // Começa com zero locações
    }

    // --- Implementação do método abstrato ---

    /**
     * Retorna descrição completa do cliente com todos os dados.
     * @return String formatada com os dados do cliente
     */
    @Override
    public String getDescricaoCompleta() {
        return String.format(
            "CLIENTE\n" +
            "  ID................: %d\n"  +
            "  Nome..............: %s\n"  +
            "  CPF...............: %s\n"  +
            "  Telefone..........: %s\n"  +
            "  E-mail............: %s\n"  +
            "  Endereço..........: %s\n"  +
            "  Nº CNH............: %s\n"  +
            "  Categoria CNH.....: %s\n"  +
            "  Data de Nascimento: %s\n"  +
            "  Total de Locações.: %d",
            getId(), getNome(), getCpf(), getTelefone(),
            getEmail(), getEndereco(), numeroCnh, categoriaCnh,
            dataNascimento, totalLocacoes
        );
    }

    /**
     * Incrementa em 1 o contador de locações do cliente.
     * Deve ser chamado sempre que uma nova locação for confirmada.
     */
    public void incrementarLocacoes() {
        this.totalLocacoes++;
    }

    // --- Getters e Setters ---

    /** @return número da CNH */
    public String getNumeroCnh() { return numeroCnh; }

    /** @param numeroCnh novo número de CNH */
    public void setNumeroCnh(String numeroCnh) { this.numeroCnh = numeroCnh; }

    /** @return categoria da CNH */
    public String getCategoriaCnh() { return categoriaCnh; }

    /** @param categoriaCnh nova categoria de CNH */
    public void setCategoriaCnh(String categoriaCnh) { this.categoriaCnh = categoriaCnh; }

    /** @return data de nascimento */
    public String getDataNascimento() { return dataNascimento; }

    /** @param dataNascimento nova data de nascimento */
    public void setDataNascimento(String dataNascimento) { this.dataNascimento = dataNascimento; }

    /** @return total de locações realizadas */
    public int getTotalLocacoes() { return totalLocacoes; }

    /** @param totalLocacoes novo total de locações */
    public void setTotalLocacoes(int totalLocacoes) { this.totalLocacoes = totalLocacoes; }
}
