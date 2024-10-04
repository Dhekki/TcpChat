import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ThreadResposta extends Thread{
    Socket cliente;

    ThreadResposta(Socket cli) {
        this.cliente = cli;
    }

    @Override
    public void run() {
        System.out.println("Cliente conectado com thread (" + this.getId() + "): " + cliente.getInetAddress());
        System.out.println("---------------------------------------------------------------------");
        Scanner scOut = new Scanner(System.in); //Saida de dados com entrada do teclado
        Scanner scIn; //Scanner de chegada de dados com entrada do cliente

        try {
            scIn = new Scanner(cliente.getInputStream()); //Chegada de dados do cliente
            PrintStream saida = new PrintStream(cliente.getOutputStream()); //Fluxo de saída de dados

            while (scIn.hasNextLine()) {
                String msgCliente = scIn.nextLine();
                if (msgCliente == "") break;
                System.out.println("Mensagem Recebida: " + msgCliente);
                System.out.print("Resposta: ");
                String msgResposta = scOut.nextLine();
                saida.println(msgResposta);
                System.out.println("---------------------------------------------------------------------");
            }

            System.out.println("Cliente finalizado com " +
                    "thread (" + this.getId() + "): " +
                    cliente.getInetAddress());
            System.out.println("---------------------------");
            cliente.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
