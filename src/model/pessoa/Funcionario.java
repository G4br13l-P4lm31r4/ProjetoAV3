package model.pessoa;

public class Funcionario extends Pessoa {

    private String matricula;
    private String cargo;
    private double salario;
    private String dataAdmissao;

    public Funcionario(int id, String nome, String cpf, String telefone,
            String email, String endereco, String matricula,
            String cargo, double salario, String dataAdmissao) {
        super(id, nome, cpf, telefone, email, endereco);
        this.matricula = matricula;
        this.cargo = cargo;
        this.salario = salario;
        this.dataAdmissao = dataAdmissao;
    }

    @Override
    public String getDescricaoCompleta() {
        return String.format(
                "FUNCIONÁRIO\n" +
                        "  ID................: %d\n" +
                        "  Nome..............: %s\n" +
                        "  CPF...............: %s\n" +
                        "  Telefone..........: %s\n" +
                        "  E-mail............: %s\n" +
                        "  Endereço..........: %s\n" +
                        "  Matrícula.........: %s\n" +
                        "  Cargo.............: %s\n" +
                        "  Salário...........: R$ %.2f\n" +
                        "  Data de Admissão..: %s",
                getId(), getNome(), getCpf(), getTelefone(),
                getEmail(), getEndereco(), matricula, cargo,
                salario, dataAdmissao);
    }

    public void aplicarAumento(double percentual) {
        this.salario += this.salario * (percentual / 100.0);
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String m) {
        this.matricula = m;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String c) {
        this.cargo = c;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double s) {
        this.salario = s;
    }

    public String getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(String d) {
        this.dataAdmissao = d;
    }
}
