package com.iiht.evaluation.coronakit.dao;

import java.util.List;

import com.iiht.evaluation.coronakit.model.ProductMaster;
import com.iiht.evaluation.coronakit.ims.exception.*;

public interface Product {
	
	ProductMaster add(ProductMaster item) throws ImsException;
	ProductMaster save(ProductMaster item) throws ImsException;
	ProductMaster getById(Integer id) throws ImsException;
	List<ProductMaster> getAll() throws ImsException;
	List<ProductMaster> getByIds(Integer[] id) throws ImsException;
	boolean deleteById(Integer id) throws ImsException;

}
