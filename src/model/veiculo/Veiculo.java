package model.veiculo;

import interfaces.Locavel;
import interfaces.Manutivel;

public abstract class Veiculo implements Locavel, Manutivel {

    private int id;
    private String placa;
    private String marca;
    private String modelo;
    private int ano;
    private double quilometragem;
    private boolean disponivel;
    private double custoTotalManutencao;
    private String ultimaManutencao;

    private static final double KM_MANUTENCAO = 10000.0;

    public Veiculo(int id, String placa, String marca, String modelo, int ano, double quilometragem) {
        this.id = id;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.quilometragem = quilometragem;
        this.disponivel = true;
        this.custoTotalManutencao = 0.0;
        this.ultimaManutencao = "Nenhuma registrada";
    }

    @Override
    public void iniciarLocacao() {
        this.disponivel = false;
    }

    @Override
    public void finalizarLocacao() {
        this.disponivel = true;
    }

    @Override
    public void registrarManutencao(String descricao, double custo) {
        this.custoTotalManutencao += custo;
        this.ultimaManutencao = descricao;
    }

    @Override
    public boolean necessitaManutencao() {
        return this.quilometragem >= KM_MANUTENCAO;
    }

    @Override
    public double getCustoTotalManutencao() {
        return this.custoTotalManutencao;
    }

    public abstract String getDescricaoCompleta();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public double getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(double q) {
        this.quilometragem = q;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean d) {
        this.disponivel = d;
    }

    public String getUltimaManutencao() {
        return ultimaManutencao;
    }

    @Override
    public String toString() {
        return String.format("[%d] %s %s (%d) - Placa: %s - %s - KM: %.0f",
                id, marca, modelo, ano, placa,
                disponivel ? "DISPONÍVEL" : "LOCADO", quilometragem);
    }
}
