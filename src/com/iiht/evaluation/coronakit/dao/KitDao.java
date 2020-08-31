package com.iiht.evaluation.coronakit.dao;

import com.iiht.evaluation.coronakit.ims.exception.ImsException;
import com.iiht.evaluation.coronakit.model.CoronaKit;

public interface KitDao {
	
	CoronaKit addCoronaKit(CoronaKit coronaKit) throws ImsException;

	//KitDetail addKitDetail(KitDetail kitDetail) throws ImsException; 

}
