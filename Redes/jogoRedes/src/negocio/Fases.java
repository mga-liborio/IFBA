package negocio;

import java.io.PrintStream;
import java.io.PrintWriter;
import static java.lang.System.*;
import java.util.Random;

public class Fases {

	Random r = new Random();
	String operadorBase;
	PrintWriter out3;

	Fases(PrintWriter out2) {
		this.out3 = out2;
	}

	public float fase1(int x, int y, int w) {
		float resultado;
		String op1;
		String op2;
		resultado = this.calculaOpSimples(x, y);
		op1 = operadorBase;
		resultado = this.calculaOpSimples((int) resultado, w);
		op2 = operadorBase;
		out3.println(x + " " + op1 + " " + y + " " + op2 + " " + w + " = ?");
		return resultado;
	}

	public float fase2(int x, int y) {
		float resultado;
		String op1;
		resultado = this.calculaOpDivi(x, y);
		op1 = operadorBase;
		out3.println(x + " " + op1 + " " + y + " = ?");
		return resultado;
	}

	public float fase3(int x, int y, int w) {
		float resultado;
		String op1;
		String op2;
		resultado = this.calculaOpDivi(x, y);
		op1 = operadorBase;
		resultado = this.calculaOpSimples((int) resultado, w);
		op2 = operadorBase;
		out3.println(x + " " + op1 + " " + y + " " + op2 + " " + w + " = ?");
		return resultado;
	}

	public float calculaOpSimples(int a, int u) {
		float calculado;
		String op = randomOperator();
		operadorBase = op;
		if ("+".equals(op)) {
			calculado = a + u;
		} else
			calculado = a - u;
		return calculado;
	}

	public float calculaOpDivi(int a, int u) {
		float calculado;
		String op = randomOperator2();
		operadorBase = op;
		if ("/".equals(op))
			calculado = a / u;
		else
			calculado = a * u;
		return calculado;
	}

	private String randomOperator() {
		return r.nextBoolean() ? "+" : "-";
	}

	private String randomOperator2() {
		return r.nextBoolean() ? "/" : "*";
	}
}
