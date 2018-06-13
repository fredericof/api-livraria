package com.frederico.api.model;

import java.util.Date;

public class Pedido {
	
	private long pedido_id;
	private String session_id;
	private Date dataPedido;
	private String status;
	private Carrinho itemPedido;
	private float valorTotal = 0;
	
	public Pedido() {}

	public Pedido(long pedido_id, String session_id, Date dataPedido, String status, Carrinho itemPedido,
			float valorTotal) {
		super();
		this.pedido_id = pedido_id;
		this.session_id = session_id;
		this.dataPedido = dataPedido;
		this.status = status;
		this.itemPedido = itemPedido;
		this.valorTotal = valorTotal;
	}

	public long getPedido_id() {
		return pedido_id;
	}

	public void setPedido_id(long pedido_id) {
		this.pedido_id = pedido_id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSession_id() {
		return session_id;
	}

	public void setSession_id(String session_id) {
		this.session_id = session_id;
	}

	public Date getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}

	public Carrinho getItemPedido() {
		return itemPedido;
	}

	public void setItemPedido(Carrinho itemPedido) {
		this.itemPedido = itemPedido;
	}

	public float getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(float valorTotal) {
		this.valorTotal = valorTotal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataPedido == null) ? 0 : dataPedido.hashCode());
		result = prime * result + ((itemPedido == null) ? 0 : itemPedido.hashCode());
		result = prime * result + ((session_id == null) ? 0 : session_id.hashCode());
		result = prime * result + Float.floatToIntBits(valorTotal);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		if (dataPedido == null) {
			if (other.dataPedido != null)
				return false;
		} else if (!dataPedido.equals(other.dataPedido))
			return false;
		if (itemPedido == null) {
			if (other.itemPedido != null)
				return false;
		} else if (!itemPedido.equals(other.itemPedido))
			return false;
		if (session_id == null) {
			if (other.session_id != null)
				return false;
		} else if (!session_id.equals(other.session_id))
			return false;
		if (Float.floatToIntBits(valorTotal) != Float.floatToIntBits(other.valorTotal))
			return false;
		return true;
	}
	
}
