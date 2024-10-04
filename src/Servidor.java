import java.net.ServerSocket;

public class Servidor {
    public static void main(String[] args) {
        try {
            ServerSocket servidor = new ServerSocket(7000); //Socket Servidor
            System.out.println("Servidor Iniciado...\nAguardando Mensagens...");
            System.out.println("--------------------------");

            while (true) {
                  new ThreadResposta(servidor.accept()).start(); //Thread Resposta
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro");
        }
    }
}
