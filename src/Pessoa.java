/**
 * Classe abstrata Pessoa
 * Representa uma pessoa genérica no sistema da locadora.
 * Serve de base para Cliente e Funcionario, centralizando
 * os dados comuns a qualquer indivíduo: nome, CPF,
 * telefone, e-mail e endereço.
 */
public abstract class Pessoa {

    // --- Atributos ---
    private int    id;        // Identificador único da pessoa
    private String nome;      // Nome completo
    private String cpf;       // CPF no formato 000.000.000-00
    private String telefone;  // Telefone de contato
    private String email;     // Endereço de e-mail
    private String endereco;  // Endereço residencial/comercial

    /**
     * Construtor completo de Pessoa.
     * @param id       identificador único
     * @param nome     nome completo
     * @param cpf      CPF da pessoa
     * @param telefone telefone de contato
     * @param email    e-mail
     * @param endereco endereço
     */
    public Pessoa(int id, String nome, String cpf,
                  String telefone, String email, String endereco) {
        this.id       = id;
        this.nome     = nome;
        this.cpf      = cpf;
        this.telefone = telefone;
        this.email    = email;
        this.endereco = endereco;
    }

    // --- Método abstrato ---

    /**
     * Cada subclasse deve implementar este método para retornar
     * uma descrição detalhada incluindo seus atributos próprios.
     * @return String com os dados completos da pessoa
     */
    public abstract String getDescricaoCompleta();

    // --- Getters e Setters ---

    /** @return id da pessoa */
    public int getId() { return id; }

    /** @param id novo id */
    public void setId(int id) { this.id = id; }

    /** @return nome completo */
    public String getNome() { return nome; }

    /** @param nome novo nome */
    public void setNome(String nome) { this.nome = nome; }

    /** @return CPF */
    public String getCpf() { return cpf; }

    /** @param cpf novo CPF */
    public void setCpf(String cpf) { this.cpf = cpf; }

    /** @return telefone de contato */
    public String getTelefone() { return telefone; }

    /** @param telefone novo telefone */
    public void setTelefone(String telefone) { this.telefone = telefone; }

    /** @return e-mail */
    public String getEmail() { return email; }

    /** @param email novo e-mail */
    public void setEmail(String email) { this.email = email; }

    /** @return endereço */
    public String getEndereco() { return endereco; }

    /** @param endereco novo endereço */
    public void setEndereco(String endereco) { this.endereco = endereco; }

    /**
     * Retorna linha resumida com os dados principais da pessoa.
     * @return String formatada com id, nome e CPF
     */
    @Override
    public String toString() {
        return String.format("[%d] %s - CPF: %s - Tel: %s", id, nome, cpf, telefone);
    }
}
