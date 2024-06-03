package br.com.caelum.financas.testes;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;
import jakarta.persistence.EntityManager;

public class TesteJPA {
	
	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		//Método para salvar a conta no banco de dados
		Conta conta = new Conta();
		conta.setTitular("Maria Santos");
		conta.setBanco("Itau");
		conta.setNumero("12345");
		conta.setAgencia("321");
	
		em.persist(conta);
		Conta contaFind = em.find(Conta.class, 1);
		em.merge(conta);
		em.remove(contaFind);
		
		//Método para buscar uma conta no banco de dados
//		Conta conta = em.find(Conta.class, 1);
//		System.out.println(conta.getTitular());
		
//		conta.setTitular("Pedro Ferreira");
		
		System.out.println(conta.getId());
		
		em.getTransaction().commit();
		em.close();
	}
}
