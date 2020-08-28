package com.iiht.evaluation.coronakit.service;

import java.util.ArrayList;
import java.util.List;

import com.iiht.evaluation.coronakit.ims.exception.ImsException;
import com.iiht.evaluation.coronakit.model.ProductMaster;
import com.iiht.evaluation.coronakit.dao.Product;
import com.iiht.evaluation.coronakit.dao.ProductMasterDao;

public class ItemServiceImpl implements ItemService{
	
	Product itemDao;
	public ItemServiceImpl() {
		
	}
	
	
public ItemServiceImpl(String jdbcURL, String jdbcUsername, String jdbcPassword) {
	itemDao= new ProductMasterDao(jdbcURL, jdbcUsername, jdbcPassword);
	}


private boolean isIdValid(Integer id) {
	return id>0;
}


private boolean isProductName(String productName) {
	return productName!=null && (productName.length()>=3 || productName.length()<=450);
}


private boolean isCostValid(Double cost) {
	return cost>=0;
}

private boolean isProductDescription(String productDescription) {
	return productDescription!=null && (productDescription.length()>=3 || productDescription.length()<=1000);
}




private boolean isValidItem(ProductMaster item) throws ImsException  {
	List<String> errMsg= new ArrayList();
	boolean isValid=true;
	if(!isIdValid(item.getId())){
		
		isValid=false;
		errMsg.add("productId cannot be null or negative or zero");
	}
	
	
	if(!isProductName(item.getProductName())) {
		isValid=false;
		errMsg.add("Title cannot be blank, Title must be 3 to 20 chars");
	}
	
	if(!isCostValid(item.getCost())) {
		isValid=false;
		errMsg.add("cost price cannot be zero or negative");
		
	}
	
	
	if(!isProductDescription(item.getProductDescription())) {
		isValid=false;
		errMsg.add("Title cannot be blank, Title must be 3 to 20 chars");
	}
	
	return isValid;
	
}
	

@Override
	public ProductMaster validateAndAdd(ProductMaster item) throws ImsException {
	if(item!=null) {
		if(isValidItem(item)) {
			itemDao.add(item);
			
		}
	}

	return item;
	}

	@Override
	public ProductMaster validateAndSave(ProductMaster item) throws ImsException {
		
		System.out.println("in save service");
		if(item!=null) {
			if(isValidItem(item)) {
				itemDao.save(item);
				
			}
		}

		return item;
	}

	@Override
	public ProductMaster getItemById(Integer id) throws ImsException {
		return itemDao.getById(id);
	}
	
	@Override
	public List<ProductMaster> getAllItems() throws ImsException {
		return itemDao.getAll();
	}
	

}
