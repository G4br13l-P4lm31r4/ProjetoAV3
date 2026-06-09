package locadora.service;

import model.veiculo.Carro;
import locadora.util.InputUtil;

import java.util.List;
import java.util.Scanner;

public class CarroService {

    public static void incluir(Scanner sc, List<Carro> lista, int[] proxId) {
        System.out.println("\n-- INCLUIR CARRO --");
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
        Carro c = new Carro(proxId[0]++, placa, marca, modelo, ano, km, portas, comb, pm);
        lista.add(c);
        System.out.println("Carro ID " + c.getId() + " incluído com sucesso!");
    }

    public static void alterar(Scanner sc, List<Carro> lista) {
        System.out.print("\nID do Carro a alterar: ");
        int id = InputUtil.lerInt(sc);
        Carro c = VeiculoService.buscarPorId(lista, id);
        if (c == null) {
            System.out.println("Não encontrado.");
            return;
        }
        System.out.println("Deixe em branco para manter o valor atual.");
        System.out.print("Placa [" + c.getPlaca() + "]: ");
        String v = sc.nextLine().trim();
        if (!v.isEmpty())
            c.setPlaca(v);
        System.out.print("Marca [" + c.getMarca() + "]: ");
        v = sc.nextLine().trim();
        if (!v.isEmpty())
            c.setMarca(v);
        System.out.print("Modelo [" + c.getModelo() + "]: ");
        v = sc.nextLine().trim();
        if (!v.isEmpty())
            c.setModelo(v);
        System.out.print("Ano [" + c.getAno() + "] (0=manter): ");
        int n = InputUtil.lerInt(sc);
        if (n > 0)
            c.setAno(n);
        System.out.print("Nº de Portas [" + c.getNumeroPortas() + "] (0=manter): ");
        n = InputUtil.lerInt(sc);
        if (n > 0)
            c.setNumeroPortas(n);
        System.out.print("Combustível [" + c.getTipoCombustivel() + "]: ");
        v = sc.nextLine().trim();
        if (!v.isEmpty())
            c.setTipoCombustivel(v);
        System.out.println("Carro ID " + id + " alterado com sucesso!");
    }
}
