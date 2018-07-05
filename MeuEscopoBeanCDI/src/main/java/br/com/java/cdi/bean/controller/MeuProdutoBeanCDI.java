package br.com.java.cdi.bean.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.java.cdi.bean.CalculadoraPrecoBeanCDI;
  
@Named("meuProdutoBeanCDI")  
//@Dependent     //==>escopo default com CalculadoraPrecoBeanCDI ==> @Dependent 
//@RequestScoped //com CalculadoraPrecoBeanCDI ==> @Dependent 
//@SessionScoped //com CalculadoraPrecoBeanCDI ==> @Dependent precisa implementar serializable desde que  MeuProdutoBeanCDI seja @SessionScoped    /  sera necessario que MeuProdutoBeanCDI implements Serializable
@SessionScoped //com CalculadoraPrecoBeanCDI ==> @ApplicationScoped nao precisa implementar serializable   /  sera necessario que MeuProdutoBeanCDI implements Serializable
//@SessionScoped   //com CalculadoraPrecoBeanCDI ==> @RequestScoped nao precisa implementar serializable    /  sera necessario que MeuProdutoBeanCDI implements Serializable
public class MeuProdutoBeanCDI implements Serializable{
	
	
	// o escopo @Dependent equivale a nao ter escopo, ou seja, o bean eh chamado e morre logo
	// apos a execucao da sua chamada, execucao de um metodo por exemplo, como no caso 
	// #{meuBean.preco} ==> apos a execucao o bean morre, perceba que o metodo anotaddo com 
    // @PostConstruct eh chamado toda vez logo apos a criacao do bean e as dependencias forem
    // resolvidas.
	
	private static final long serialVersionUID = 1L;
	
	
	@Inject
	private CalculadoraPrecoBeanCDI calculadora;//==> isto na realidade eh um proxy.
	
	public MeuProdutoBeanCDI(){
	System.out.println(">>>>>>>>>>>>>>>>>>>>>>> MeuProdutoBeanCDI >>>>>> construtor");
	}
	
	@PostConstruct
	public void init(){
	System.out.println(">>>>>>>>>>>>>>>>>>>>>>> MeuProdutoBeanCDI >>>>>> init()");
	}

	public double getPreco(){
		System.out.println(">>>"+calculadora.getClass());//verificando se calculadora eh da classe CalculadoraPrecoBeanCDI ou um proxy.
		return calculadora.calcularPreco(12, 45.32);
		//return 10.45;
	}
	
	
	
}
