package conta_bancaria.model;

import conta_bancaria.util.Cores;

public class Conta {

	private int numero;
	private int agencia;
	private int tipo;
	private String titular;
	private float saldo;

	public Conta(int numero, int agencia, int tipo, String titular, float saldo) {
		this.numero = numero;
		this.agencia = agencia;
		this.tipo = tipo;
		this.titular = titular;
		this.saldo = saldo;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public boolean sacar(float valor) {
		if (this.getSaldo() < valor) {
			System.out.println("\n Saldo insuficiente, camarada!");
			return false;
			}
		
			this.setSaldo(this.getSaldo() - valor);
			return true;
		}
	
	public void depositar(float valor) {
		this.setSaldo(this.getSaldo() + valor);
	}
	

	public void visualizar() {
		
		String tipo = "";
		switch(this.tipo) {
		case 1 -> tipo = "Conta Corrente";
		case 2 -> tipo = "Conta Poupança";
		}
		
		System.out.println(Cores.ANSI_YELLOW_BACKGROUND_BRIGHT + Cores.TEXT_RED_BOLD
				+ "**********************************************");
		System.out.println("Dados da conta:");
		System.out.println("**********************************************");
		System.out.println("Número da conta: " + this.numero);
		System.out.println("Agência: " + this.agencia);
		System.out.println("Tipo da Conta: " + tipo);
		System.out.println("Titular da conta: " + this.titular);
		System.out.println("Saldo disponível: " + this.saldo);
	}
}
