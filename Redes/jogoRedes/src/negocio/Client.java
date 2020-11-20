package negocio;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		try {
			Socket client = new Socket("", 1234);
			Scanner comunicacaoServidor = new Scanner(client.getInputStream());
			Scanner inUser = new Scanner(System.in);
			PrintWriter out = new PrintWriter(client.getOutputStream(), true);

			while (comunicacaoServidor.hasNextBoolean() == false) {
				System.out.println(comunicacaoServidor.nextLine());
			}

			String a = comunicacaoServidor.nextLine();

			while (true) {
				System.out.println("Digite o resultado: ");
				out.println(inUser.nextLine());

				while (comunicacaoServidor.hasNextBoolean() == false) {
					System.out.println(comunicacaoServidor.nextLine());
				}

				a = comunicacaoServidor.nextLine();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
