package com.iiht.evaluation.coronakit.service;

import com.iiht.evaluation.coronakit.ims.exception.ImsException;
import com.iiht.evaluation.coronakit.model.CoronaKit;


public interface KitService {
	
	CoronaKit validateAndAddCoronaKit(CoronaKit coronaKit) throws ImsException;

	//KitDetail validateAndAddKitDetail(KitDetail kitDetail) throws ImsException;

}
