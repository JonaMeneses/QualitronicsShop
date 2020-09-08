package com.mpersd.qualitronics.iservice;

import com.mpersd.qualitronics.entities.Articulo;
import com.mpersd.quialitronics.model.Compra;
import com.mpersd.quialitronics.model.ResultBase;

public interface ICompraService {
	public ResultBase agregarArticulo(Articulo articulo);
	public ResultBase eliminarArticulo(Articulo articulo);
	public ResultBase realizarCompra(Compra compra);
}
