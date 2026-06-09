package model.veiculo;

public class Van extends Veiculo {

    private int capacidadePassageiros;
    private boolean arCondicionado;
    private String finalidade;

    private static final double DIARIA_BASE_VAN = 200.0;

    public Van(int id, String placa, String marca, String modelo, int ano,
            double quilometragem, int capacidadePassageiros,
            boolean arCondicionado, String finalidade) {
        super(id, placa, marca, modelo, ano, quilometragem);
        this.capacidadePassageiros = capacidadePassageiros;
        this.arCondicionado = arCondicionado;
        this.finalidade = finalidade;
    }

    @Override
    public String getDescricaoCompleta() {
        return String.format(
                "VAN\n" +
                        "  ID................: %d\n" +
                        "  Placa.............: %s\n" +
                        "  Marca.............: %s\n" +
                        "  Modelo............: %s\n" +
                        "  Ano...............: %d\n" +
                        "  Quilometragem.....: %.0f km\n" +
                        "  Capacidade........: %d passageiros\n" +
                        "  Ar-condicionado...: %s\n" +
                        "  Finalidade........: %s\n" +
                        "  Disponível........: %s\n" +
                        "  Diária............: R$ %.2f\n" +
                        "  Última Manutenção.: %s\n" +
                        "  Custo Total Manut.: R$ %.2f",
                getId(), getPlaca(), getMarca(), getModelo(), getAno(),
                getQuilometragem(), capacidadePassageiros,
                arCondicionado ? "Sim" : "Não", finalidade,
                isDisponivel() ? "Sim" : "Não",
                calcularValorDiaria(), getUltimaManutencao(), getCustoTotalManutencao());
    }

    @Override
    public double calcularValorDiaria() {
        double diaria = DIARIA_BASE_VAN;
        if (capacidadePassageiros > 12)
            diaria *= 1.20;
        if (arCondicionado)
            diaria *= 1.15;
        return diaria;
    }

    public int getCapacidadePassageiros() {
        return capacidadePassageiros;
    }

    public void setCapacidadePassageiros(int c) {
        this.capacidadePassageiros = c;
    }

    public boolean isArCondicionado() {
        return arCondicionado;
    }

    public void setArCondicionado(boolean a) {
        this.arCondicionado = a;
    }

    public String getFinalidade() {
        return finalidade;
    }

    public void setFinalidade(String f) {
        this.finalidade = f;
    }
}
