package org.example;
import org.example.Product;

import java.util.Objects;
import java.util.Scanner;
import java.util.Locale;

public class Main {
    static Product[] products = new Product[10];

    public static void main(String[] args) {
        System.out.println("====================================================");
        System.out.println("Bem vindo ao Estoque Mania");
        System.out.println("====================================================");
        menu();
    }

    public static void menu() {
        Locale.setDefault(Locale.US);
        Scanner scan = new Scanner(System.in);

        System.out.println("----------------------------------------------------");
        System.out.println("O que vc deseja fazer?");
        System.out.println("----------------------------------------------------");
        System.out.println("1.listar todos os produtos");
        System.out.println("2.adicionar unidades a um produto já cadastrado");
        System.out.println("3.remover unidades de um produto já cadastrado");
        System.out.println("====================================================");
        System.out.print("Digite a opção desejada: ");
        int res = scan.nextInt();
        System.out.println("----------------------------------------------------");

        if (res == 1) {
            listAll();
        } else if (res == 2) {
            addProduct();
        } else if (res == 3) {
            removeProduct();
        } else {
            System.out.println("Selecione uma opção valida");
            menu();
        }

        scan.close();
    }

    public static void listAll() {
        for (Product i : products) {
            if (i != null) {
                System.out.printf("* %s - R$%.2f - %d unidades%n", i.getName(), i.getPrice(), i.getQuantity());
            } else {
                System.out.println("-----");
            }
        }

        menu();
    }

    public static void addProduct() {
        Scanner scan = new Scanner(System.in);

        System.out.print("Digite o nome do produto: ");
        String name = scan.nextLine();
        System.out.print("Digite o preço do produto: ");
        double price = scan.nextDouble();
        System.out.print("Digite a quantidade de produtos para estoque: ");
        int quantity = scan.nextInt();

        int indice = 0;
        boolean register = false;

        for (Product i : products) {
            if (i == null) {
                products[indice] = new Product(name, price, quantity);
                break;
            }
                indice += 1;
        }

        menu();
        scan.close();
    }

    public static void removeProduct() {
        Scanner scan = new Scanner(System.in);

        System.out.print("qual o nome do item que voçê deseja remover? ");
        String item = scan.nextLine();
        System.out.println("----------------------------------------------------");
        String[] items = new String[10];

        int indice = 0;



//        for (Product i : products) {
//            if (Objects.equals(products[indice].getName(), item)) {
//                String name =  products[indice].getName();
//                items[indice] = name;
//            }
//            indice += 1;
//        }
//
//        for (String i : items) {
//            System.out.println(i);
//        }

        menu();
    }

}