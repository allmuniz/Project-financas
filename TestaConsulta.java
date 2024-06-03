package br.com.caelum.financas.testes;

import java.util.List;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class TestaConsulta {

	public static void main(String[] args) {
		
		EntityManager manager = new JPAUtil().getEntityManager();
		
		Conta conta = new Conta();
		conta.setId(2);
		
		Query query = manager.createQuery("select m from movimentacoes m where m.conta.id-:pConta" 
										+ "and m.tipoMovimentacao-:pTipo"
										+ "order by m.valor desc");
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", TipoMovimentacao.SAIDA);
		
		List<Movimentacao> movimentacoes = query.getResultList();
		
		for(Movimentacao m : movimentacoes) {
			System.out.println("\nDescricao ..: " + m.getDescricao());
			System.out.println("Valor ......: R$ " + m.getValor());
		}
	}
}
