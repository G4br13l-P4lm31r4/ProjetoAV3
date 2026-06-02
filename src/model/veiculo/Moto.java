package model.veiculo;

public class Moto extends Veiculo {

    private int    cilindrada;
    private String tipoMoto;
    private boolean exigeHabilitacaoA;

    private static final double DIARIA_BASE_MOTO = 90.0;

    public Moto(int id, String placa, String marca, String modelo, int ano,
                double quilometragem, int cilindrada,
                String tipoMoto, boolean exigeHabilitacaoA) {
        super(id, placa, marca, modelo, ano, quilometragem);
        this.cilindrada        = cilindrada;
        this.tipoMoto          = tipoMoto;
        this.exigeHabilitacaoA = exigeHabilitacaoA;
    }

    @Override
    public String getDescricaoCompleta() {
        return String.format(
            "MOTO\n" +
            "  ID................: %d\n"  +
            "  Placa.............: %s\n"  +
            "  Marca.............: %s\n"  +
            "  Modelo............: %s\n"  +
            "  Ano...............: %d\n"  +
            "  Quilometragem.....: %.0f km\n" +
            "  Cilindrada........: %d cc\n"   +
            "  Tipo..............: %s\n"  +
            "  Exige CNH-A.......: %s\n"  +
            "  Disponível........: %s\n"  +
            "  Diária............: R$ %.2f\n" +
            "  Última Manutenção.: %s\n"  +
            "  Custo Total Manut.: R$ %.2f",
            getId(), getPlaca(), getMarca(), getModelo(), getAno(),
            getQuilometragem(), cilindrada, tipoMoto,
            exigeHabilitacaoA ? "Sim" : "Não",
            isDisponivel() ? "Sim" : "Não",
            calcularValorDiaria(), getUltimaManutencao(), getCustoTotalManutencao()
        );
    }

    @Override
    public double calcularValorDiaria() {
        return cilindrada > 500 ? DIARIA_BASE_MOTO * 1.30 : DIARIA_BASE_MOTO;
    }

    public int getCilindrada()                         { return cilindrada; }
    public void setCilindrada(int c)                   { this.cilindrada = c; }
    public String getTipoMoto()                        { return tipoMoto; }
    public void setTipoMoto(String t)                  { this.tipoMoto = t; }
    public boolean isExigeHabilitacaoA()               { return exigeHabilitacaoA; }
    public void setExigeHabilitacaoA(boolean e)        { this.exigeHabilitacaoA = e; }
}
