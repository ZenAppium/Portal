package com.iiht.evaluation.coronakit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.iiht.evaluation.coronakit.ims.exception.ImsException;
import com.iiht.evaluation.coronakit.model.CoronaKit;

public class KitDaoImpl implements KitDao{
	
	public static final String INS_CORONA_KIT_QRY = "INSERT INTO kitdetail(id,personName,email ,contactNumber,totalAmount,deliveryAddress,orderDate) values(?,?,?,?,?,?,?)";
	

	private String jdbcURL;
	private String jdbcUsername;
	private String jdbcPassword;
	private Connection jdbcConnection;

	public KitDaoImpl(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }


	@Override
	public CoronaKit addCoronaKit(CoronaKit coronaKit) throws ImsException {
		if (coronaKit != null) {
			try (Connection con = ConnectionFactory.getConnection();
					PreparedStatement pst = con.prepareStatement(INS_CORONA_KIT_QRY); )
					{	pst.setInt(1, coronaKit.getId());
						pst.setString(2, coronaKit.getPersonName());
						pst.setString(3, coronaKit.getEmail());
						pst.setString(4, coronaKit.getContactNumber());
						pst.setDouble(5, coronaKit.getTotalAmount());
						pst.setString(6, coronaKit.getDeliveryAddress());
						pst.setString(7, coronaKit.getOrderDate());
						pst.setString(3, coronaKit.getProductId().toString());
						pst.setInt(4, coronaKit.getQuantity());

				pst.executeUpdate();

			} catch ( Exception e ) {
				e.printStackTrace();
				throw new ImsException("Saving the Kit failed!");
			}
		}
		return coronaKit;
	}

//	@Override
//	public KitDetail addKitDetail(KitDetail kitDetail) throws ImsException {
//		if (kitDetail != null) {
//			try (Connection con = ConnectionFactory.getConnection();
//					PreparedStatement pst = con.prepareStatement(INS_KIT_DETAIL_QRY); )
//					{	pst.setInt(1, kitDetail.getId());
//						pst.setInt(2, kitDetail.getCoronaKitId());
//						pst.setString(3, kitDetail.getProductId().toString());
//						pst.setInt(4, kitDetail.getQuantity());
//
//				pst.executeUpdate();
//
//			} catch ( Exception e ) {
//				e.printStackTrace();
//				throw new ImsException("Saving the item failed!");
//			}
//		}
//		return kitDetail;
//	}


}
