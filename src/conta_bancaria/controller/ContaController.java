package conta_bancaria.controller;

import java.util.ArrayList;
import java.util.Optional;

import conta_bancaria.model.Conta;
import conta_bancaria.repository.ContaRepository;

public class ContaController implements ContaRepository {

	// Criar a collection
	private ArrayList<Conta> listaContas = new ArrayList<Conta>();

	// Variável para receber o número da conta para automatizar o processo de
	// definir o número de cada conta.
	int numero = 0;

	@Override
	public void procurarPorNum(int numero) {

		Optional<Conta> conta = buscarNaCollection(numero);
		if (conta.isPresent()) {
			conta.get().visualizar();
		} else
			System.out.println("A conta " + numero + " não foi encontrada!");
	}

	@Override
	public void listarTodas() {
		for (var conta : listaContas) {
			conta.visualizar();
		}

	}

	@Override
	public void cadastrar(Conta conta) {
		listaContas.add(conta);
		System.out.println("A conta número " + conta.getNumero() + " foi criada com sucesso!");

	}

	@Override
	public void atualizar(Conta conta) {
		Optional<Conta> buscaConta = buscarNaCollection(conta.getNumero());

		if (buscaConta.isPresent()) {
			listaContas.set(listaContas.indexOf(buscaConta.get()), conta);
			System.out.println("A conta " + conta.getNumero() + " foi atualizada com sucesso!");
		} else
			System.out.println("A conta " + conta.getNumero() + " não foi encontrada!");

	}

	@Override
	public void delete(int numero) {
		Optional<Conta> conta = buscarNaCollection(numero);

		if (conta.isPresent()) {
			listaContas.remove(conta.get());
			System.out.println("A conta " + numero + " foi excluída com sucesso. Até mais ver, companheiro!");
		} else
			System.out.println("A conta " + numero + " não foi encontrada.");

	}

	@Override
	public void sacar(int numero, float valor) {
		Optional<Conta> conta = buscarNaCollection(numero);

		if (conta.isPresent()) {
			if (conta.get().sacar(valor) == true)
				System.out.printf("O saque de R$ %.2f foi efetuado com sucesso, companheiro!", valor);
			System.out.printf("\nSaldo restante: R$ %.2f.", conta.get().getSaldo());
		} else
			System.out.println("A conta " + numero + " não foi encontrada.");

	}

	@Override
	public void depositar(int numero, float valor) {
		Optional<Conta> conta = buscarNaCollection(numero);

		if (conta.isPresent()) {
			conta.get().depositar(valor);
			System.out.printf("O depósito de R$ %.2f foi efetuado com sucesso!", valor);
			System.out.printf("\nSaldo atual de: R$ %.2f", conta.get().getSaldo());
		} else
			System.out.println("A conta " + numero + " não foi encontrada!");
	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
		Optional<Conta> contaOrigem = buscarNaCollection(numeroOrigem);
		Optional<Conta> contaDestino = buscarNaCollection(numeroDestino);

		if (contaOrigem.isPresent() && contaDestino.isPresent()) {
			if (contaOrigem.get().sacar(valor) == true) {
				contaDestino.get().depositar(valor);
				System.out.println("Transferência efetuada com sucesso!");
				System.out.printf("\nSaldo atual da conta origem: R$ %.2f", contaOrigem.get().getSaldo());
				System.out.printf("\nSaldo atual da conta destino: R$ %.2f", contaDestino.get().getSaldo());
			}
		} else
			System.out.println("Falha na transferência, companheiro! Cheque os dados e tente novamente.");
	}

	// Métodos auxiliares

	public int gerarNumero() {
		return ++numero;
	}

	public Optional<Conta> buscarNaCollection(int numero) {
		for (var conta : listaContas) {
			if (conta.getNumero() == numero) {
				return Optional.of(conta);
			}
		}
		return Optional.empty();
	}
}
