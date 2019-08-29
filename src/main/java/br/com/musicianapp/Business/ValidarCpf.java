package br.com.musicianapp.Business;

import org.springframework.stereotype.Service;

import br.com.musicianapp.domain.EntidadeDominio;
import br.com.musicianapp.domain.Pessoa;

@Service
public class ValidarCpf implements IStrategy {
	
	@Override
	public String processar(EntidadeDominio entidade) {
		Pessoa func = (Pessoa) entidade;
		int i, soma, resultado, peso, numero;
		char digito1, digito2;
		
		char vetorCPF[] = func.getCpf().toCharArray();

		//String r = validarCPF(func.getCpf());
		
		// verificar tamanho
		// Formato do CPF = xxx.xxx.xxx-xx
		if (func.getCpf().length() < 14){
			System.out.println("Numero errado de caracteres");
		}
		try {

			soma = 0;
			resultado = 0;
			peso = 10;
			for (i = 0; i < 11; i++, peso--) {
				// pular pontos e traço
				// 1 2 3 . 4 5 6 . 7 8 9 - 0 9
				// 0 1 2 3 4 5 6 7 8 9 10 11 12 13
				if (i == 3 || i == 7 || i == 11)
					i++;

				soma += ((Integer.parseInt("" + vetorCPF[i]) * peso));

			}

			// obter o resultado
			resultado = 11 - (soma % 11);
			System.out.println(resultado + " " + vetorCPF[12]);
//			if (resultado > 9 || resultado > 3)
//				digito1 = '0';
//			else
//				digito1 = (char) (resultado + 48);

			// verificar se o primeiro digito ta certo...
			char primeiroDigito = vetorCPF[12];
			int variavel = Character.getNumericValue(primeiroDigito);
			if (resultado != variavel)
				return "CPF Invalido";

			// Primeiro digito esta certo
			// CALCULAR O SEGUNDO DIGITO
			soma = 0;
			resultado = 0;
			peso = 11;
			for (i = 0; i < 13; i++, peso--) {
				// pular pontos e tra�o
				// 1 2 3 . 4 5 6 . 7 8 9 - 0 9
				// 0 1 2 3 4 5 6 7 8 9 10 11 12 13
				if (i == 3 || i == 7 || i == 11)
					i++;

				soma += ((Integer.parseInt("" + vetorCPF[i]) * peso));

			}

			// obter o resultado
			resultado = 11 - (soma % 11);
			if (resultado > 9 || resultado < 3)
				digito2 = '0';
			else
				digito2 = (char) (resultado + 48);

			// verificar se o segundo digito ta certo...
			if (digito2 != vetorCPF[13])
				return "segundo digito incorreto";

		} catch (Exception e) {
			e.printStackTrace();
			return "Erro";
		}
		return null;
	}
	

}
