package negocio;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;

public class AdvinhaNumero implements Runnable {

	public AdvinhaNumero(Socket client) {
		this.client = client;
	}

	Socket client;
	int sorteado;
	int sorteado2;
	int sorteado3;

	int tentativas;
	int digitado;
	float resultado;

	boolean verifica;
	boolean rodando;

	boolean introducao;
	boolean fase1;
	boolean fase2;
	boolean fase3;
	boolean sair;

	public void run() {

		introducao = true;
		fase1 = true;
		fase2 = false;
		fase3 = false;
		rodando = true;

		while (rodando) {
			sorteiaNumero();
			try {
				PrintWriter out2 = new PrintWriter(this.client.getOutputStream(), true);
				Fases comeco = new Fases(out2);
				if (introducao) {
					out2.println("Esse é Mister Grinaldo - vulgo Grin-Grin ");
					out2.println("  (*.*)");
					out2.println("  /|||\\");
					out2.println("   / \\ ");
					out2.println("Habitante das terras de exatas, Grinaldo vive muitas aventuras...");
					introducao = false;
					out2.flush();
				}
				if (fase1) {
					out2.println();
					out2.println("*************************");
					out2.println("*** INTRODUÇÃO FASE 1 ***");
					out2.println("*************************");
					resultado = comeco.fase1(sorteado, sorteado2, sorteado3);
					out2.println(Float.toString(resultado));					
				}
				if (fase2) {
					out2.println();
					sorteiaNumero();
					out2.println("*************************");
					out2.println("*** INTRODUÇÃO FASE 2 ***");
					out2.println("*************************");
					resultado = comeco.fase2(sorteado, sorteado2);
					out2.println(Float.toString(resultado));
				}
				if (fase3) {
					out2.println();
					sorteiaNumero();
					out2.println("*************************");
					out2.println("*** INTRODUÇÃO FASE 3 ***");
					out2.println("*************************");
					resultado = comeco.fase3(sorteado, sorteado2, sorteado3);
					out2.println(Float.toString(resultado));
				}
				Scanner in = new Scanner(this.client.getInputStream());
				
				out2.println("Resolva a conta e ajude o herói­ --- você tem 5 tentativas");
				out2.println(false);
				out2.flush();
				
				verifica = false;
				while (verifica == false) {
					System.out.println("Esperando numero");
					String numeroenviado = in.nextLine();
					this.digitado = Integer.parseInt(numeroenviado);
					out.println("Numero digitado");
					verifica = this.verificaNumero();
					if (tentativas == 5) {
						out2.println("Você perdeu por número de tentativas");
						break;
					}
					if (verifica) {
						out2.println(" (+_+)/");
						out2.println(" <||| ");
						out2.println("  / \\ ");
						out2.println("Você ganhou com " + tentativas + " tentativas");
						if (fase3) {
							fase3=false;
							sair = true;
							out2.println();
							out2.println("PARABÉNS (independente do resultado)! Com a sua ajuda Mr. Grin-Grin conseguiu finalizar esta aventura!!!");
							break;
						}
						if (fase2) {
							fase2 = false;
							fase3 = true;
						}
						if (fase1) {
							fase1 = false;
							fase2 = true;
						}
					} else {
						out2.println("\\_(o.O)_/");
						out2.println("   ||| ");
						out2.println("  /   \\ ");
						
						out2.println(this.getResultadoCliente() + " ---  Tentativas: " + tentativas++);
						out2.println(false);
						out2.flush();
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
			if(sair) {
				rodando = false;
				break;
			}
		}
	}

	public void sorteiaNumero() {
		Random r = new Random();
		sorteado = r.nextInt(100);
		sorteado2 = r.nextInt(100);
		sorteado3 = r.nextInt(100);
		tentativas = 1;
	}

	public String getResultadoCliente() {
		if (this.digitado > this.resultado)
			return "O numero é menor";
		else
			return "O numero é maior";
	}

	public boolean verificaNumero() {
		return this.digitado == this.resultado;
	}
}