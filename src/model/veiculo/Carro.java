package model.veiculo;

public class Carro extends Veiculo {

    private int numeroPortas;
    private String tipoCombustivel;
    private double capacidadePortaMalas;

    private static final double DIARIA_BASE = 120.0;

    public Carro(int id, String placa, String marca, String modelo, int ano,
            double quilometragem, int numeroPortas,
            String tipoCombustivel, double capacidadePortaMalas) {
        super(id, placa, marca, modelo, ano, quilometragem);
        this.numeroPortas = numeroPortas;
        this.tipoCombustivel = tipoCombustivel;
        this.capacidadePortaMalas = capacidadePortaMalas;
    }

    @Override
    public String getDescricaoCompleta() {
        return String.format(
                "CARRO\n" +
                        "  ID................: %d\n" +
                        "  Placa.............: %s\n" +
                        "  Marca.............: %s\n" +
                        "  Modelo............: %s\n" +
                        "  Ano...............: %d\n" +
                        "  Quilometragem.....: %.0f km\n" +
                        "  Nº de Portas......: %d\n" +
                        "  Combustível.......: %s\n" +
                        "  Porta-malas.......: %.0f L\n" +
                        "  Disponível........: %s\n" +
                        "  Diária............: R$ %.2f\n" +
                        "  Última Manutenção.: %s\n" +
                        "  Custo Total Manut.: R$ %.2f",
                getId(), getPlaca(), getMarca(), getModelo(), getAno(),
                getQuilometragem(), numeroPortas, tipoCombustivel,
                capacidadePortaMalas, isDisponivel() ? "Sim" : "Não",
                calcularValorDiaria(), getUltimaManutencao(), getCustoTotalManutencao());
    }

    @Override
    public double calcularValorDiaria() {
        return DIARIA_BASE;
    }

    public int getNumeroPortas() {
        return numeroPortas;
    }

    public void setNumeroPortas(int n) {
        this.numeroPortas = n;
    }

    public String getTipoCombustivel() {
        return tipoCombustivel;
    }

    public void setTipoCombustivel(String t) {
        this.tipoCombustivel = t;
    }

    public double getCapacidadePortaMalas() {
        return capacidadePortaMalas;
    }

    public void setCapacidadePortaMalas(double c) {
        this.capacidadePortaMalas = c;
    }
}
