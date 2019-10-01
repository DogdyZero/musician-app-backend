package br.com.musicianapp.daos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.musicianapp.adapter.IAdapter;
import br.com.musicianapp.adapter.PedidoAdapter;
import br.com.musicianapp.domain.EntidadeDominio;
import br.com.musicianapp.domain.Pedido;
import br.com.musicianapp.impl.FactoryConsulta;
import br.com.musicianapp.repository.PedidosRepository;

@Service
public class PedidoDao extends AbstractDao {
	@Autowired 
	private PedidosRepository repository;
	@Autowired
	private FactoryConsulta fabrica;
	
	private IAdapter<Pedido> adapter;
	private List<EntidadeDominio> entidades;
	private Optional<Pedido> optPedido;
	public PedidoDao() {
		adapter = new PedidoAdapter<Pedido>();
	}
	
	@Override
	public EntidadeDominio salvar(EntidadeDominio entidade) {
		return null;
	}

	@Override
	public EntidadeDominio alterar(EntidadeDominio entidade) {
		adapter.setAdapter(entidade);
		if(adapter.getObject()!=null) {
			optPedido = repository.findById(adapter.getObject().getId());
			
			Pedido pedBD = optPedido.get();
			
			if(pedBD.getId()==adapter.getObject().getId()) {
				pedBD.setStatusPedido(adapter.getObject().getStatusPedido());
				return repository.save(pedBD);
			}
		}
		return null;	
	}

	@Override
	public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
		return fabrica.fabricarConsulta(Pedido.class.cast(entidade), super.getParametro());
	}

	@Override
	public void apagar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub

	}

}
