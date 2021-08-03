package br.com.samara.cadastro;

import java.math.BigDecimal;

public class PessoaFisica extends Pessoa {

	public PessoaFisica(String documento) {
		super(documento);
	}

	public Boolean validarDocumento () {
		Boolean validacao = null;
		BigDecimal resultadoUm = BigDecimal.ZERO;
		BigDecimal resultadoDois = BigDecimal.ZERO;
		BigDecimal dvUm = BigDecimal.ZERO;
		BigDecimal dvDois = BigDecimal.ZERO;
		
		char[] cpf = super.getDocumento().toCharArray(); //converter para string
		
		for (int i = 0; i <= 8; i++) {
			resultadoUm.equals(BigDecimal.valueOf(i).add(BigDecimal.valueOf(1)).multiply(BigDecimal.valueOf(cpf[i])).add(resultadoUm));
		}
		
		dvUm.equals(resultadoUm.remainder(BigDecimal.valueOf(11)));
		
		for (int i = 0; i <= 8; i++) {
			resultadoDois.equals(resultadoDois.add(BigDecimal.valueOf(i).multiply(BigDecimal.valueOf(cpf[i]))));
		}
		
		resultadoDois.add((BigDecimal.valueOf(9)).multiply(dvUm));
		dvDois.equals(resultadoDois.remainder(BigDecimal.valueOf(11)));
	
//		String cpfValido = super.getDocumento().substring(0, 9) + dvUm + dvDois;
//		
//		System.out.println(cpfValido);
		
		if (dvUm.equals(BigDecimal.valueOf(cpf[9]))) {
			if (dvDois.equals(BigDecimal.valueOf(cpf[10]))) {
			}
			validacao = true;
		}
		
		return validacao;
	}
	
	
}
