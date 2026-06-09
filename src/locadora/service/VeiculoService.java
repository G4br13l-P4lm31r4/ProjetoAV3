package locadora.service;

import model.veiculo.*;
import locadora.util.InputUtil;

import java.util.List;
import java.util.Scanner;

public class VeiculoService {

    public static <T extends Veiculo> T buscarPorId(List<T> lista, int id) {
        for (T v : lista)
            if (v.getId() == id)
                return v;
        return null;
    }

    public static <T extends Veiculo> void listar(List<T> lista, String titulo) {
        System.out.println("\n=== " + titulo + " ===");
        if (lista.isEmpty()) {
            System.out.println("Nenhum registro.");
            return;
        }
        for (T v : lista)
            System.out.println(v);
    }

    public static <T extends Veiculo> void excluir(List<T> lista, String titulo, Scanner sc) {
        System.out.print("\nID do " + titulo + " a excluir: ");
        int id = InputUtil.lerInt(sc);
        T alvo = buscarPorId(lista, id);
        if (alvo == null) {
            System.out.println("Não encontrado.");
            return;
        }
        if (!alvo.isDisponivel()) {
            System.out.println("Veículo está locado e não pode ser excluído.");
            return;
        }
        System.out.print("Confirma exclusão de '" + alvo.getMarca() + " " + alvo.getModelo() + "'? (s/n): ");
        if (sc.nextLine().trim().equalsIgnoreCase("s")) {
            lista.remove(alvo);
            System.out.println(titulo + " excluído.");
        } else
            System.out.println("Exclusão cancelada.");
    }

    public static <T extends Veiculo> void buscar(List<T> lista, String titulo, Scanner sc) {
        System.out.println("\n-- BUSCAR " + titulo.toUpperCase() + " --");
        System.out.println("1. Por ID   2. Por Placa   3. Por Marca");
        System.out.print("Opção: ");
        int op = InputUtil.lerInt(sc);
        boolean achou = false;
        switch (op) {
            case 1:
                System.out.print("ID: ");
                int id = InputUtil.lerInt(sc);
                for (T v : lista) {
                    if (v.getId() == id) {
                        System.out.println("\n" + v.getDescricaoCompleta());
                        achou = true;
                    }
                }
                break;
            case 2:
                System.out.print("Placa: ");
                String placa = sc.nextLine().trim().toUpperCase();
                for (T v : lista) {
                    if (v.getPlaca().equalsIgnoreCase(placa)) {
                        System.out.println("\n" + v.getDescricaoCompleta());
                        achou = true;
                    }
                }
                break;
            case 3:
                System.out.print("Marca (parcial): ");
                String marca = sc.nextLine().trim().toLowerCase();
                for (T v : lista) {
                    if (v.getMarca().toLowerCase().contains(marca)) {
                        System.out.println("\n" + v.getDescricaoCompleta());
                        achou = true;
                    }
                }
                break;
        }
        if (!achou)
            System.out.println("Nenhum resultado encontrado.");
    }

    public static void listarDisponiveis(List<CarroEconomico> carrosEco, List<CarroLuxo> carrosLuxo,
            List<Carro> carros, List<Moto> motos, List<Van> vans) {
        System.out.println("\n=== VEÍCULOS DISPONÍVEIS ===");
        System.out.println("-- Carros Econômicos --");
        for (CarroEconomico ce : carrosEco)
            if (ce.isDisponivel())
                System.out.println(ce);
        System.out.println("-- Carros de Luxo --");
        for (CarroLuxo cl : carrosLuxo)
            if (cl.isDisponivel())
                System.out.println(cl);
        System.out.println("-- Carros --");
        for (Carro c : carros)
            if (c.isDisponivel())
                System.out.println(c);
        System.out.println("-- Motos --");
        for (Moto m : motos)
            if (m.isDisponivel())
                System.out.println(m);
        System.out.println("-- Vans --");
        for (Van v : vans)
            if (v.isDisponivel())
                System.out.println(v);
    }
}
