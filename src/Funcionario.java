/**
 * Classe Funcionario
 * Representa um funcionário da locadora.
 * Estende Pessoa e acrescenta dados profissionais:
 * matrícula, cargo, salário e data de admissão.
 */
public class Funcionario extends Pessoa {

    // --- Atributos específicos ---
    private String matricula;      // Código de matrícula interno
    private String cargo;          // Cargo ocupado (ex.: Atendente, Gerente)
    private double salario;        // Salário mensal em reais
    private String dataAdmissao;   // Data de admissão no formato dd/MM/aaaa

    /**
     * Construtor completo de Funcionario.
     * @param id            identificador único
     * @param nome          nome completo
     * @param cpf           CPF do funcionário
     * @param telefone      telefone de contato
     * @param email         e-mail corporativo
     * @param endereco      endereço residencial
     * @param matricula     código de matrícula
     * @param cargo         cargo ocupado
     * @param salario       salário mensal em reais
     * @param dataAdmissao  data de admissão (dd/MM/aaaa)
     */
    public Funcionario(int id, String nome, String cpf, String telefone,
                       String email, String endereco, String matricula,
                       String cargo, double salario, String dataAdmissao) {
        // Chama o construtor da superclasse Pessoa
        super(id, nome, cpf, telefone, email, endereco);
        this.matricula     = matricula;
        this.cargo         = cargo;
        this.salario       = salario;
        this.dataAdmissao  = dataAdmissao;
    }

    // --- Implementação do método abstrato ---

    /**
     * Retorna descrição completa do funcionário com todos os dados.
     * @return String formatada com os dados do funcionário
     */
    @Override
    public String getDescricaoCompleta() {
        return String.format(
            "FUNCIONÁRIO\n" +
            "  ID................: %d\n"  +
            "  Nome..............: %s\n"  +
            "  CPF...............: %s\n"  +
            "  Telefone..........: %s\n"  +
            "  E-mail............: %s\n"  +
            "  Endereço..........: %s\n"  +
            "  Matrícula.........: %s\n"  +
            "  Cargo.............: %s\n"  +
            "  Salário...........: R$ %.2f\n" +
            "  Data de Admissão..: %s",
            getId(), getNome(), getCpf(), getTelefone(),
            getEmail(), getEndereco(), matricula, cargo,
            salario, dataAdmissao
        );
    }

    /**
     * Aplica um aumento percentual sobre o salário atual.
     * @param percentual percentual de aumento (ex.: 10 para 10%)
     */
    public void aplicarAumento(double percentual) {
        this.salario += this.salario * (percentual / 100.0);
    }

    // --- Getters e Setters ---

    /** @return matrícula do funcionário */
    public String getMatricula() { return matricula; }

    /** @param matricula nova matrícula */
    public void setMatricula(String matricula) { this.matricula = matricula; }

    /** @return cargo ocupado */
    public String getCargo() { return cargo; }

    /** @param cargo novo cargo */
    public void setCargo(String cargo) { this.cargo = cargo; }

    /** @return salário mensal */
    public double getSalario() { return salario; }

    /** @param salario novo salário */
    public void setSalario(double salario) { this.salario = salario; }

    /** @return data de admissão */
    public String getDataAdmissao() { return dataAdmissao; }

    /** @param dataAdmissao nova data de admissão */
    public void setDataAdmissao(String dataAdmissao) { this.dataAdmissao = dataAdmissao; }
}
