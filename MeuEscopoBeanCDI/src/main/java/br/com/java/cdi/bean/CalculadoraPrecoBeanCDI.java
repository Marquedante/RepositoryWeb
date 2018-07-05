package br.com.java.cdi.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;

@Dependent//==>escopo default ==> serializable necessario para trabalhar desde que ProdutoBeanCDI seja SessionScoped 
//@Dependent esta anotacao quer dizer que o bean CalculadoraPrecoBeanCDI ficara dependente do escopo da classe chamadora
//,ou seja, se o escopa da classe chamadora for Request a classe com anotacao Dependent tambem se comportara como request. 

//@ApplicationScoped
//@RequestScoped // nao eh necessario implements serializable mesmo que ProdutoBeanCDI seja SessionScoped
public class CalculadoraPrecoBeanCDI implements Serializable{

	// esta seria uma classe de servico, logo nao seria feita nenhuma chamada
	// nas paginas xhtml com expression language e por isso nao colocamos a
	// anotacao
	// @Named que eh propria para beans que sao chamados nas paginas xhtml.
	// Embora nao tenha a anotacao @Named este tambem eh um bean CDI.

	private static final long serialVersionUID = 1L;

	public CalculadoraPrecoBeanCDI(){
	 System.out.println(">>>>>>>>>>>>>>>>>>>> CalculadoraPrecoBeanCDI >>>>> construtor");
	 }
 
	@PostConstruct
	public void init() {
		System.out.println(">>>>>>>>>>>>>>>>>>>> CalculadoraPrecoBeanCDI >>>>> init()");
	}

	public double calcularPreco(int quantidade, double preco) {
		return quantidade * preco;
	}

}
