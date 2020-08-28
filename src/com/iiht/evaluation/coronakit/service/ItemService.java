package com.iiht.evaluation.coronakit.service;

import java.util.List;

import com.iiht.evaluation.coronakit.ims.exception.ImsException;
import com.iiht.evaluation.coronakit.model.ProductMaster;


public interface ItemService {
	
	ProductMaster validateAndAdd(ProductMaster item) throws ImsException;
	ProductMaster validateAndSave(ProductMaster item) throws ImsException;
	ProductMaster getItemById(Integer id) throws ImsException;
	List<ProductMaster> getAllItems() throws ImsException;

}
