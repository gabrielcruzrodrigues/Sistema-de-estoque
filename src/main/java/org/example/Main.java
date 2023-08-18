package org.example;
import org.example.Product;

import java.util.Objects;
import java.util.Scanner;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scan = new Scanner(System.in);

        Product[] products = new Product[10];

        System.out.println("====================================================");
        System.out.println("Bem vindo ao Estoque Mania");
        System.out.println("====================================================");
        System.out.println("O que vc deseja fazer?");
        System.out.println("1.listar todos os produtos");
        System.out.println("2.adicionar unidades a um produto já cadastrado");
        System.out.println("3.remover unidades de um produto já cadastrado");
        System.out.println("====================================================");
        System.out.print("Digite a opção desejada: ");
        int res = scan.nextInt();
        System.out.println("----------------------------------------------------");

        if (res == 1) {
            listAll(products);
        } else if (res == 2) {
            addProduct(products);
        } else if (res == 3) {
            removeProduct(products);
        } else {
            System.out.println("Selecione uma opção valida");
        }

        scan.close();
    }

    public static void listAll(Product[] products) {
        for (Product i : products) {
            if (i != null) {
                System.out.println(i.getName());
            } else {
                System.out.println(i);
            }
        }
    }

    public static void addProduct(Product[] products) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Digite o nome do produto: ");
        String name = scan.next();
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

        listAll(products);

        scan.close();
    }

    public static void removeProduct(Product[] products) {

    }

}