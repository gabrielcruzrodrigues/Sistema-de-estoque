package org.example;

import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

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
        System.out.println("4.atualizar dados");
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
        } else if (res == 4){
            updateProduct();
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

        boolean found = false;

        for(int i = 0; i < products.length; i++) {
            if (products[i] != null && products[i].getName().equalsIgnoreCase(item)) {

                for (int j = i; j < products.length - 1; j++) {
                    products[j] = products[j + 1];
                }

                products[products.length - 1] = null;
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("item removido com sucesso.");
        } else {
            System.out.println("Item não encontrado no estoque.");
        }

        menu();
        scan.close();
    }

    public static void updateProduct() {
        Scanner scan = new Scanner(System.in);

        System.out.print("Digite o nome do produto que quer atualizar: ");
        String produto = scan.nextLine();
        System.out.println("----------------------------------------------------");

        boolean confirm = false;

        for (int i = 0; i < products.length; i++) {
            if (products[i] != null && products[i].getName().equalsIgnoreCase(produto)) {
                String name = "";
                double price = 0.0;
                int quantity = 0;

                System.out.println("Quer atualizar o nome? (s/n): ");
                String OptionName = scan.next();

                if (Objects.equals(OptionName, "s")) {
                    System.out.print("Digite o nome do produto: ");
                    scan.nextLine();
                    name = scan.nextLine();

                    products[i].setName(name);
                }

                System.out.println("----------------------------------------------------");
                System.out.println("Quer atualizar o preço? (s/n): ");
                String OptionPrice = scan.next();

                if(Objects.equals(OptionPrice, "s")) {
                    System.out.print("Digite o preço do produto: ");
                    price = scan.nextDouble();

                    products[i].setPrice(price);
                }

                System.out.println("----------------------------------------------------");
                System.out.println("Quer atualizar a quantidade? (s/n): ");
                String OptionQuantity = scan.next();

                if (Objects.equals(OptionQuantity, "s")) {
                    System.out.print("Digite a quantidade de produtos para estoque: ");
                    quantity = scan.nextInt();

                    products[i].setQuantity(quantity);
                }

                System.out.println("----------------------------------------------------");
                confirm = true;
            }
        }

        if (confirm) {
            System.out.println("Produto atualizado com sucesso!");
        } else {
            System.out.println("Nenhum produto foi encontrado com esse nome");
        }

        menu();
        scan.close();
    }

}