package com.mpersd.qualitronics.idal;

import com.mpersd.qualitronics.entities.Articulo;
import com.mpersd.quialitronics.model.Compra;
import com.mpersd.quialitronics.model.ResultBase;

public interface ICompraDao {
	public ResultBase realizarCompra(Compra compra);
}
