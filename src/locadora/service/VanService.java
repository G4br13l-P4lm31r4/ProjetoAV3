package locadora.service;

import model.veiculo.Van;
import locadora.util.InputUtil;

import java.util.List;
import java.util.Scanner;

public class VanService {

    public static void incluir(Scanner sc, List<Van> lista, int[] proxId) {
        System.out.println("\n-- INCLUIR VAN --");
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
        System.out.print("Cap. Passageiros: ");
        int cap = InputUtil.lerInt(sc);
        System.out.print("Ar-condicionado (s/n): ");
        boolean ar = sc.nextLine().trim().equalsIgnoreCase("s");
        System.out.print("Finalidade (Passeio/Carga): ");
        String fin = sc.nextLine().trim();
        Van van = new Van(proxId[0]++, placa, marca, modelo, ano, km, cap, ar, fin);
        lista.add(van);
        System.out.println("Van ID " + van.getId() + " incluída com sucesso!");
    }

    public static void alterar(Scanner sc, List<Van> lista) {
        System.out.print("\nID da Van a alterar: ");
        int id = InputUtil.lerInt(sc);
        Van van = VeiculoService.buscarPorId(lista, id);
        if (van == null) {
            System.out.println("Não encontrada.");
            return;
        }
        System.out.println("Deixe em branco para manter o valor atual.");
        System.out.print("Placa [" + van.getPlaca() + "]: ");
        String v = sc.nextLine().trim();
        if (!v.isEmpty())
            van.setPlaca(v);
        System.out.print("Marca [" + van.getMarca() + "]: ");
        v = sc.nextLine().trim();
        if (!v.isEmpty())
            van.setMarca(v);
        System.out.print("Modelo [" + van.getModelo() + "]: ");
        v = sc.nextLine().trim();
        if (!v.isEmpty())
            van.setModelo(v);
        System.out.print("Cap. Passageiros [" + van.getCapacidadePassageiros() + "] (0=manter): ");
        int n = InputUtil.lerInt(sc);
        if (n > 0)
            van.setCapacidadePassageiros(n);
        System.out.print("Ar-condicionado [" + (van.isArCondicionado() ? "s" : "n") + "] (s/n, vazio=manter): ");
        v = sc.nextLine().trim();
        if (v.equalsIgnoreCase("s"))
            van.setArCondicionado(true);
        else if (v.equalsIgnoreCase("n"))
            van.setArCondicionado(false);
        System.out.print("Finalidade [" + van.getFinalidade() + "]: ");
        v = sc.nextLine().trim();
        if (!v.isEmpty())
            van.setFinalidade(v);
        System.out.println("Van ID " + id + " alterada com sucesso!");
    }
}
