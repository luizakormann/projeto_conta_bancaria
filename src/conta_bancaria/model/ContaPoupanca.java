package conta_bancaria.model;

public class ContaPoupanca extends Conta {

	private int aniver;

	public ContaPoupanca(int numero, int agencia, int tipo, String titular, float saldo, int aniver) {
		super(numero, agencia, tipo, titular, saldo);
		this.aniver = aniver;
	}

	public int getAniver() {
		return aniver;
	}

	public void setAniver(int aniver) {
		this.aniver = aniver;
	}

	public void visualizar() {
		super.visualizar();
		System.out.printf(
				"Celebrar para fortalecer!\nSua conta faz aniversário todo dia %d, quando é acrescida do rendimento + lucros do banco, camarada.", this.aniver);
	}
}
