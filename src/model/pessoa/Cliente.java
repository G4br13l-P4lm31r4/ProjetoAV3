package model.pessoa;

public class Cliente extends Pessoa {

    private String numeroCnh;
    private String categoriaCnh;
    private String dataNascimento;
    private int totalLocacoes;

    public Cliente(int id, String nome, String cpf, String telefone,
            String email, String endereco,
            String numeroCnh, String categoriaCnh, String dataNascimento) {
        super(id, nome, cpf, telefone, email, endereco);
        this.numeroCnh = numeroCnh;
        this.categoriaCnh = categoriaCnh;
        this.dataNascimento = dataNascimento;
        this.totalLocacoes = 0;
    }

    @Override
    public String getDescricaoCompleta() {
        return String.format(
                "CLIENTE\n" +
                        "  ID................: %d\n" +
                        "  Nome..............: %s\n" +
                        "  CPF...............: %s\n" +
                        "  Telefone..........: %s\n" +
                        "  E-mail............: %s\n" +
                        "  Endereço..........: %s\n" +
                        "  Nº CNH............: %s\n" +
                        "  Categoria CNH.....: %s\n" +
                        "  Data de Nascimento: %s\n" +
                        "  Total de Locações.: %d",
                getId(), getNome(), getCpf(), getTelefone(),
                getEmail(), getEndereco(), numeroCnh, categoriaCnh,
                dataNascimento, totalLocacoes);
    }

    public void incrementarLocacoes() {
        this.totalLocacoes++;
    }

    public String getNumeroCnh() {
        return numeroCnh;
    }

    public void setNumeroCnh(String n) {
        this.numeroCnh = n;
    }

    public String getCategoriaCnh() {
        return categoriaCnh;
    }

    public void setCategoriaCnh(String c) {
        this.categoriaCnh = c;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String d) {
        this.dataNascimento = d;
    }

    public int getTotalLocacoes() {
        return totalLocacoes;
    }

    public void setTotalLocacoes(int t) {
        this.totalLocacoes = t;
    }
}
