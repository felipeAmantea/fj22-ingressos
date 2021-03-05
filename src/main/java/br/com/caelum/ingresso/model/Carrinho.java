package br.com.caelum.ingresso.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class Carrinho {

	private List<Ingresso> ingressos = new ArrayList<>();

	public void add(List<Ingresso> ingressos) {
		ingressos.addAll(ingressos);
	}

	public void add(Ingresso ingresso) {
		ingressos.add(ingresso);
	}

	public Compra toCompra() {
		return new Compra(ingressos);
	}

	public void limpa() {
		this.ingressos.clear();
	}

	public BigDecimal getTotal() {
		return this.ingressos.stream().map(Ingresso::getPreco).reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
	}

	public boolean isSelecionado(Lugar lugar) {
		return ingressos.stream().map(Ingresso::getLugar).anyMatch(lugarDoIngresso -> lugarDoIngresso.equals(lugar));
	}

	public List<Ingresso> getIngressos() {
		return ingressos;
	}

	public void setIngressos(List<Ingresso> ingressos) {
		this.ingressos = ingressos;
	}

}
