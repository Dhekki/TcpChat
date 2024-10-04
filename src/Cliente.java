import java.io.PrintStream;
import java.net.Socket;
import java.util.Objects;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {

        try {
            Socket cliente = new Socket("127.0.0.1", 7000);
            //Socket Cliente (Se for uma máquina diferente, use o ip da máquina servidor)

            Scanner scOut = new Scanner(System.in); //Saida de dados com entrada do teclado
            Scanner scIn = new Scanner(cliente.getInputStream()); //Chegada de dados com entrada do servidor
            PrintStream saida = new PrintStream(cliente.getOutputStream()); //Fluxo de saída de dados

            String msg = "";

            while (true){
                System.out.println("Digite a mensagem:");
                msg = scOut.nextLine();
                saida.println(msg);
                if (Objects.equals(msg, "")) break;
                System.out.println("Mensagem Enviada!");


                String respostaServidor = scIn.nextLine();
                System.out.println("\nResposta recebida: ");
                System.out.println(respostaServidor);
                System.out.println("---------------------------------------------------------------------");
            }

            cliente.close();
            System.out.println("Cliente finalizado.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Ocorreu um erro durante a conexão!");
        }
    }
}


