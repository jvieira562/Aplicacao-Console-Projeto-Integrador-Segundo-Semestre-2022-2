package potterpg.containers;

import potterpg.core.regras.CapituloRegra;
import potterpg.core.regras.JogadorRegra;
import potterpg.core.regras.PerguntaRegra;
import potterpg.core.regras.interfaces.ICapituloRegra;
import potterpg.core.regras.interfaces.IJogadorRegra;
import potterpg.core.regras.interfaces.IPerguntaRegra;

public class ContainerDI {
	
	public IJogadorRegra getDependencia(IJogadorRegra regra) {
		regra = new JogadorRegra();
		return regra;
	}
	public IPerguntaRegra getDependencia(IPerguntaRegra regra) {
		regra = new PerguntaRegra();
		return regra;
	}
	public ICapituloRegra getDependencia(ICapituloRegra regra) {
		regra = new CapituloRegra();
		return regra;
	}
}
