package locadora.service;

import model.veiculo.CarroLuxo;
import locadora.util.InputUtil;

import java.util.List;
import java.util.Scanner;

public class CarroLuxoService {

    public static void incluir(Scanner sc, List<CarroLuxo> lista, int[] proxId) {
        System.out.println("\n-- INCLUIR CARRO DE LUXO --");
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
        System.out.print("Itens de Conforto: ");
        String itens = sc.nextLine().trim();
        System.out.print("Seguro Incluso (s/n): ");
        boolean seg = sc.nextLine().trim().equalsIgnoreCase("s");
        CarroLuxo cl = new CarroLuxo(proxId[0]++, placa, marca, modelo, ano, km, portas, comb, pm, itens, seg);
        lista.add(cl);
        System.out.println("Carro de Luxo ID " + cl.getId() + " incluído com sucesso!");
    }

    public static void alterar(Scanner sc, List<CarroLuxo> lista) {
        System.out.print("\nID do Carro de Luxo a alterar: ");
        int id = InputUtil.lerInt(sc);
        CarroLuxo cl = VeiculoService.buscarPorId(lista, id);
        if (cl == null) {
            System.out.println("Não encontrado.");
            return;
        }
        System.out.println("Deixe em branco para manter o valor atual.");
        System.out.print("Placa [" + cl.getPlaca() + "]: ");
        String v = sc.nextLine().trim();
        if (!v.isEmpty())
            cl.setPlaca(v);
        System.out.print("Marca [" + cl.getMarca() + "]: ");
        v = sc.nextLine().trim();
        if (!v.isEmpty())
            cl.setMarca(v);
        System.out.print("Modelo [" + cl.getModelo() + "]: ");
        v = sc.nextLine().trim();
        if (!v.isEmpty())
            cl.setModelo(v);
        System.out.print("Ano [" + cl.getAno() + "] (0=manter): ");
        int n = InputUtil.lerInt(sc);
        if (n > 0)
            cl.setAno(n);
        System.out.print("Itens Conforto [" + cl.getItensConforto() + "]: ");
        v = sc.nextLine().trim();
        if (!v.isEmpty())
            cl.setItensConforto(v);
        System.out.print("Seguro Incluso [" + (cl.isSeguroIncluso() ? "s" : "n") + "] (s/n, vazio=manter): ");
        v = sc.nextLine().trim();
        if (v.equalsIgnoreCase("s"))
            cl.setSeguroIncluso(true);
        else if (v.equalsIgnoreCase("n"))
            cl.setSeguroIncluso(false);
        System.out.println("Carro de Luxo ID " + id + " alterado com sucesso!");
    }
}
