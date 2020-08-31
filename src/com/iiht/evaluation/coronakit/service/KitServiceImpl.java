package com.iiht.evaluation.coronakit.service;

import java.util.ArrayList;
import java.util.List;

import com.iiht.evaluation.coronakit.dao.KitDao;
import com.iiht.evaluation.coronakit.dao.KitDaoImpl;
import com.iiht.evaluation.coronakit.ims.exception.ImsException;
import com.iiht.evaluation.coronakit.model.CoronaKit;

public class KitServiceImpl implements KitService{
	
	KitDao kitDao;
	public KitServiceImpl() {
		
	}
	
	
public KitServiceImpl(String jdbcURL, String jdbcUsername, String jdbcPassword) {
	kitDao= new KitDaoImpl(jdbcURL, jdbcUsername, jdbcPassword);
	}


@Override
	public CoronaKit validateAndAddCoronaKit(CoronaKit coronaKit) throws ImsException {
	if(coronaKit!=null) {
		if(isValidItem(coronaKit)) {
			kitDao.addCoronaKit(coronaKit);
			
		}
	}

	return coronaKit;
	}

//@Override
//public KitDetail validateAndAddKitDetail(KitDetail kitDetail) throws ImsException {
//if(kitDetail!=null) {
//	if(isValidKitDetail(kitDetail)) {
//		kitDao.addKitDetail(kitDetail);
//		
//	}
//}
//
//return kitDetail;
//}


//private boolean isValidKitDetail(KitDetail kitDetail) {
//	// TODO Auto-generated method stub
//	return true;
//}


private boolean isValidItem(CoronaKit coronaKit) {
	List<String> errMsg= new ArrayList();
	boolean isValid=true;
	
	return isValid;
}

	

}
