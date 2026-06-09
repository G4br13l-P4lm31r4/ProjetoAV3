package locadora.service;

import model.veiculo.CarroEconomico;
import locadora.util.InputUtil;

import java.util.List;
import java.util.Scanner;

public class CarroEconomicoService {

    public static void incluir(Scanner sc, List<CarroEconomico> lista, int[] proxId) {
        System.out.println("\n-- INCLUIR CARRO ECONÔMICO --");
        System.out.print("Placa: ");
        String placa = sc.nextLine().trim();
        System.out.print("Marca: ");
        String marca = sc.nextLine().trim();
        System.out.print("Modelo: ");
        String modelo = sc.nextLine().trim();
        System.out.print("Ano: ");
        int ano = InputUtil.lerInt(sc);
        System.out.print("Quilometragem: ");
        double km = InputUtil.lerDouble(sc);
        System.out.print("Nº de Portas: ");
        int portas = InputUtil.lerInt(sc);
        System.out.print("Combustível: ");
        String comb = sc.nextLine().trim();
        System.out.print("Porta-malas (L): ");
        double pm = InputUtil.lerDouble(sc);
        System.out.print("Consumo (km/L): ");
        double cons = InputUtil.lerDouble(sc);
        CarroEconomico ce = new CarroEconomico(proxId[0]++, placa, marca, modelo, ano, km, portas, comb, pm, cons);
        lista.add(ce);
        System.out.println("Carro Econômico ID " + ce.getId() + " incluído com sucesso!");
    }

    public static void alterar(Scanner sc, List<CarroEconomico> lista) {
        System.out.print("\nID do Carro Econômico a alterar: ");
        int id = InputUtil.lerInt(sc);
        CarroEconomico ce = VeiculoService.buscarPorId(lista, id);
        if (ce == null) {
            System.out.println("Não encontrado.");
            return;
        }
        System.out.println("Deixe em branco para manter o valor atual.");
        System.out.print("Placa [" + ce.getPlaca() + "]: ");
        String v = sc.nextLine().trim();
        if (!v.isEmpty())
            ce.setPlaca(v);
        System.out.print("Marca [" + ce.getMarca() + "]: ");
        v = sc.nextLine().trim();
        if (!v.isEmpty())
            ce.setMarca(v);
        System.out.print("Modelo [" + ce.getModelo() + "]: ");
        v = sc.nextLine().trim();
        if (!v.isEmpty())
            ce.setModelo(v);
        System.out.print("Ano [" + ce.getAno() + "] (0=manter): ");
        int n = InputUtil.lerInt(sc);
        if (n > 0)
            ce.setAno(n);
        System.out.print("Quilometragem [" + ce.getQuilometragem() + "] (0=manter): ");
        double d = InputUtil.lerDouble(sc);
        if (d != 0)
            ce.setQuilometragem(d);
        System.out.print("Nº de Portas [" + ce.getNumeroPortas() + "] (0=manter): ");
        n = InputUtil.lerInt(sc);
        if (n > 0)
            ce.setNumeroPortas(n);
        System.out.print("Combustível [" + ce.getTipoCombustivel() + "]: ");
        v = sc.nextLine().trim();
        if (!v.isEmpty())
            ce.setTipoCombustivel(v);
        System.out.print("Porta-malas [" + ce.getCapacidadePortaMalas() + "] (0=manter): ");
        d = InputUtil.lerDouble(sc);
        if (d != 0)
            ce.setCapacidadePortaMalas(d);
        System.out.print("Consumo [" + ce.getConsumoMedio() + "] (0=manter): ");
        d = InputUtil.lerDouble(sc);
        if (d != 0)
            ce.setConsumoMedio(d);
        System.out.println("Carro Econômico ID " + id + " alterado com sucesso!");
    }
}
