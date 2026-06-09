package locadora.service;

import model.veiculo.Moto;
import locadora.util.InputUtil;

import java.util.List;
import java.util.Scanner;

public class MotoService {

    public static void incluir(Scanner sc, List<Moto> lista, int[] proxId) {
        System.out.println("\n-- INCLUIR MOTO --");
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
        System.out.print("Cilindrada (cc): ");
        int cil = InputUtil.lerInt(sc);
        System.out.print("Tipo (Naked/Trail/Scooter/...): ");
        String tipo = sc.nextLine().trim();
        System.out.print("Exige CNH-A (s/n): ");
        boolean cnh = sc.nextLine().trim().equalsIgnoreCase("s");
        Moto m = new Moto(proxId[0]++, placa, marca, modelo, ano, km, cil, tipo, cnh);
        lista.add(m);
        System.out.println("Moto ID " + m.getId() + " incluída com sucesso!");
    }

    public static void alterar(Scanner sc, List<Moto> lista) {
        System.out.print("\nID da Moto a alterar: ");
        int id = InputUtil.lerInt(sc);
        Moto m = VeiculoService.buscarPorId(lista, id);
        if (m == null) {
            System.out.println("Não encontrada.");
            return;
        }
        System.out.println("Deixe em branco para manter o valor atual.");
        System.out.print("Placa [" + m.getPlaca() + "]: ");
        String v = sc.nextLine().trim();
        if (!v.isEmpty())
            m.setPlaca(v);
        System.out.print("Marca [" + m.getMarca() + "]: ");
        v = sc.nextLine().trim();
        if (!v.isEmpty())
            m.setMarca(v);
        System.out.print("Modelo [" + m.getModelo() + "]: ");
        v = sc.nextLine().trim();
        if (!v.isEmpty())
            m.setModelo(v);
        System.out.print("Cilindrada [" + m.getCilindrada() + "] (0=manter): ");
        int n = InputUtil.lerInt(sc);
        if (n > 0)
            m.setCilindrada(n);
        System.out.print("Tipo [" + m.getTipoMoto() + "]: ");
        v = sc.nextLine().trim();
        if (!v.isEmpty())
            m.setTipoMoto(v);
        System.out.print("Exige CNH-A [" + (m.isExigeHabilitacaoA() ? "s" : "n") + "] (s/n, vazio=manter): ");
        v = sc.nextLine().trim();
        if (v.equalsIgnoreCase("s"))
            m.setExigeHabilitacaoA(true);
        else if (v.equalsIgnoreCase("n"))
            m.setExigeHabilitacaoA(false);
        System.out.println("Moto ID " + id + " alterada com sucesso!");
    }
}
