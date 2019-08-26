package br.com.musicianapp.Business;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

import br.com.musicianapp.domain.EntidadeDominio;

@Service
public class CompletarDataCadastro implements IStrategy {
	
	@Override
	public String processar(EntidadeDominio entidade) {
		SimpleDateFormat formatDate = new SimpleDateFormat("yyyy/MM/dd");
		String data = formatDate.format(new Date());
		
		entidade.setDtCadastro(data);
		
		return null;
	}

}
