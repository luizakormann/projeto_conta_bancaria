package conta_bancaria.model;

public class ContaCorrente extends Conta {

	private float limite; 
	
	public ContaCorrente(int numero, int agencia, int tipo, String titular, float saldo, float limite) {
		super(numero, agencia, tipo, titular, saldo);
		this.limite = limite;
		
	}

	public float getLimite() {
		return limite;
	}

	public void setLimite(float limite) {
		this.limite = limite;
	}
	
	@Override
	public boolean sacar(float valor) {
		if ((this.getSaldo() + this.getLimite()) < valor) { //o limite complementa o saldo na possibilidade de saque
			System.out.println("\n Saldo insuficiente, camarada!");
			return false;
			}
		
			this.setSaldo(this.getSaldo() - valor);
			return true;
		}
	
	
	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println("Controlar para prosperar, camarada! Seu limite de saque é: " + this.limite);
	}

}
