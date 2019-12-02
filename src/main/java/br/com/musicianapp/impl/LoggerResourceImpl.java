package br.com.musicianapp.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.musicianapp.repository.LoggerResourceRepository;

@Service
public class LoggerResourceImpl {
	
	private LoggerResource logger;
	
	@Autowired
	private LoggerResourceRepository repository;
	
	public void salvarLoggerResource(Class<?> classe, Object objeto, String nomeMetodo) {
		if(logger==null) {
			logger = new LoggerResource();
		}

		logger.setData(new Date());
		logger.setNomeClasse(classe.getName());
		logger.setNomeObjeto(objeto.getClass().getName());
		logger.setOcorrencia(nomeMetodo);
		
		repository.save(logger);
		
	}
	public void salvarLoggerResource(int id, Class<?> classe, Object objeto, String nomeMetodo) {
		logger = new LoggerResource();
		logger.setIdRequisitado(id);
		salvarLoggerResource(classe, objeto, nomeMetodo);
	}
	
}
