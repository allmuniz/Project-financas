package br.com.caelum.financas.testes;

import java.math.BigDecimal;
import java.util.Calendar;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;
import jakarta.persistence.EntityManager;

public class TesteJPARelacionamento {
	
	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		Conta conta = new Conta();
		conta.setTitular("Maria Santos");
		conta.setBanco("Itau");
		conta.setNumero("12345");
		conta.setAgencia("321");
		
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setData(Calendar.getInstance());
		movimentacao.setDescricao("Conta de luz");
		movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		
		movimentacao.setValor(new BigDecimal("123.9"));
		
		movimentacao.setConta(conta);
		
		em.persist(conta);
		em.persist(movimentacao);
		
		em.getTransaction().commit();
		em.close();
	}
}
