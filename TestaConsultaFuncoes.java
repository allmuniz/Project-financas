package br.com.caelum.financas.testes;

import br.com.caelum.financas.dao.MovimentacaoDao;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class TestaConsultaFuncoes {

	public static void main(String[] args) {
		
		EntityManager manager = new JPAUtil().getEntityManager();
		
		Conta conta = new Conta();
		conta.setId(3);
		
		MovimentacaoDao dao = new MovimentacaoDao(manager);
		Double media = dao.mediaDaContaPeloTipo(conta, TipoMovimentacao.ENTRADA);
		System.out.println(media);
		
		TypedQuery<Double> query = manager.createNamedQuery("mediaDaContaPeloTipoMovimentacao", Double.class);
		
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", TipoMovimentacao.SAIDA);
		
		Double media2 = query.getSingleResult();
		System.out.println(media2);
	}
}
