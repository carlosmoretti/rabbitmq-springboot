package com.teste.messagequeue.model;

import java.io.Serializable;
import java.util.Random;

import lombok.Data;

@Data
public class Parametro implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public Parametro(long id, double valor) {
		this.id = id;
		this.valor = valor;
	}
	
	public static Parametro create() {
		Random rnd = new Random();
		return new Parametro(rnd.nextLong(), rnd.nextDouble());
	}
	
	private Long id;
	private Double valor;
}
