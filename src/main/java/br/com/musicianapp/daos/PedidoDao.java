package br.com.musicianapp.daos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.musicianapp.Enum.Status;
import br.com.musicianapp.adapter.IAdapter;
import br.com.musicianapp.adapter.PedidoAdapter;
import br.com.musicianapp.domain.Endereco;
import br.com.musicianapp.domain.EntidadeDominio;
import br.com.musicianapp.domain.Pedido;
import br.com.musicianapp.repository.PedidosRepository;

@Service
public class PedidoDao extends AbstractDao {
	@Autowired 
	private PedidosRepository repository;
	
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
		entidades = new ArrayList<EntidadeDominio>();
		String parametro=super.getParametro().toLowerCase();
		
		adapter.setAdapter(entidade);
		
		Pedido pedido = adapter.getObject();
		
		if(pedido!=null) {

			if(parametro.equals("all")){
				parametro = null;
				return consultarTodos();
			}
		}
		return null;
	}
	private List<EntidadeDominio> consultarTodos(){
		List<Pedido> pedidos = repository.findAll();
		for (Pedido pedido : pedidos) {
			entidades.add(pedido);
		}
		return entidades;
	}
//	private List<EntidadeDominio> consultarIdUsuario(int id){
//		List<Pedido> pedidos = repository.findAll();
//		for (Pedido pedido : pedidos) {
//			entidades.add(pedido);
//		}
//		return entidades;
//	}

	@Override
	public void apagar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub

	}

}
