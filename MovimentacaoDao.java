package br.com.caelum.financas.dao;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class MovimentacaoDao {

	private EntityManager manager;

	public MovimentacaoDao(EntityManager manager) {
		this.manager = manager;
	}

	public Double mediaDaContaPeloTipo(Conta conta, TipoMovimentacao tipo) {
		
		TypedQuery<Double> query = manager.createQuery("select avg(m.valor) from movimentacoes m where m.conta.id-:pConta" 
				+ "and m.tipoMovimentacao-:pTipo", Double.class);
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", tipo);
		
		Double media = query.getSingleResult();
		
		return media;
	}
	
}
