package com.iiht.evaluation.coronakit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import com.iiht.evaluation.coronakit.ims.exception.ImsException;
import com.iiht.evaluation.coronakit.model.ProductMaster;



public class ProductMasterDao implements Product {

	private String jdbcURL;
	private String jdbcUsername;
	private String jdbcPassword;
//	private Connection jdbcConnection;
	
	public ProductMasterDao() {
		// TODO Auto-generated constructor stub
	}
	
		public ProductMasterDao(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }

//	protected void connect() throws SQLException {
//		String jdbcURL="jdbc:mysql://localhost:3306/coronakitDb";
//		String jdbcUsername="root";
//		String jdbcPassword="root";
//		if (jdbcConnection == null || jdbcConnection.isClosed()) {
//			try {
//				Class.forName("com.mysql.cj.jdbc.Driver");
//			} catch (ClassNotFoundException e) {
//				throw new SQLException(e);
//			}
//			jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
//		}
//	}

//	protected void disconnect() throws SQLException {
//		if (jdbcConnection != null && !jdbcConnection.isClosed()) {
//			jdbcConnection.close();
//		}
//	}

	public static final String INS_ITEM_QRY = "INSERT INTO coronakititems(productCode,productName,productCost ,productDescription) values(?,?,?,?)";
	public static final String UPD_ITEM_QRY = "UPDATE coronakititems SET productName=?,productCost =?,productDescription=? WHERE productCode=?";
	public static final String SEL_ALL_ITEMS_QRY = "SELECT productCode,productName,productCost ,productDescription FROM coronakititems ";
	public static final String SEL_ITEM_QRY_BY_ID = "SELECT productCode,productName,productCost ,productDescription FROM coronakititems  WHERE productCode=?";
	public static final String SEL_ITEMS_QRY_BY_IDS = "SELECT productCode,productName,productCost ,productDescription FROM coronakititems  WHERE productCode = ?";
	public static final String DEL_ITEM_QRY = "DELETE FROM coronakititems WHERE productCode=?";
	
	
	@Override
	public ProductMaster add(ProductMaster item) throws ImsException {
		
		if (item != null) {
			try (Connection con = ConnectionFactory.getConnection();
					PreparedStatement pst = con.prepareStatement(INS_ITEM_QRY); )
					{	pst.setInt(1, item.getId());
						pst.setString(2, item.getProductName());
						pst.setDouble(3, item.getCost());
						pst.setString(4, item.getProductDescription());

				pst.executeUpdate();

			} catch ( Exception e ) {
				e.printStackTrace();
				throw new ImsException("Saving the item failed!");
			}
		}
		return item;
		
	}

	@Override
	public ProductMaster save(ProductMaster item) throws ImsException {
		if (item != null) {
			try(Connection con = ConnectionFactory.getConnection();
					PreparedStatement pst = con.prepareStatement(UPD_ITEM_QRY)) {
				pst.setString(1, item.getProductName());
				pst.setDouble(2, item.getCost());
				pst.setString(3, item.getProductDescription());
				pst.setInt(4, item.getId());

				pst.executeUpdate();

			} catch ( Exception e ) {
				e.printStackTrace();
				throw new ImsException("Saving the item failed!");
			}
		}
		return item;
	}
	
	
	@Override
	public ProductMaster getById(Integer id) throws ImsException {
		ProductMaster item = null;

		try (Connection con = ConnectionFactory.getConnection();
				PreparedStatement pst = con.prepareStatement(SEL_ITEM_QRY_BY_ID))
		{
			pst.setInt(1, id);

			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				item = new ProductMaster();
				item.setId(rs.getInt(1));
				item.setProductName(rs.getString(2));
				item.setCost(rs.getDouble(3));
				item.setProductDescription(rs.getNString(4));
			}

		} catch ( Exception e ) {
			e.printStackTrace();
			throw new ImsException("Retrival the item failed!");
		}

		return item;
	}


	@Override
	public List<ProductMaster> getAll() throws ImsException {
		List<ProductMaster> items = new ArrayList<>();
		
		try(Connection con = ConnectionFactory.getConnection();
				PreparedStatement pst =  con.prepareStatement(SEL_ALL_ITEMS_QRY))
				{
		ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				ProductMaster item = new ProductMaster();
				item.setId(rs.getInt(1));
				item.setProductName(rs.getString(2));
				item.setCost(rs.getDouble(3));
				item.setProductDescription(rs.getString(4));
				
							
				items.add(item);
			}
			
			if(items.isEmpty()) {
				items=null;
			}
		} catch ( Exception e ) {
			e.printStackTrace();
			throw new ImsException("Retrival the item failed!");
		}
		
		
		return items;
	}
	
	
	
	@Override
	public List<ProductMaster> getByIds(Integer[] ids) throws ImsException {
		List<ProductMaster> items = new ArrayList<ProductMaster>();

		try (Connection con = ConnectionFactory.getConnection();
				PreparedStatement pst = con.prepareStatement(SEL_ITEMS_QRY_BY_IDS))
		{
			for(int id : ids){
				pst.setInt(1, id);

			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				ProductMaster item = new ProductMaster();
				item = new ProductMaster();
				item.setId(rs.getInt(1));
				item.setProductName(rs.getString(2));
				item.setCost(rs.getDouble(3));
				item.setProductDescription(rs.getNString(4));
				
				items.add(item);
			}
			}

		} catch ( Exception e ) {
			e.printStackTrace();
			throw new ImsException("Retrival the item failed!");
		}

		return items;
	}

	@Override
	public boolean deleteById(Integer icode) throws ImsException {
		boolean isDeleted = false;
		try (Connection con = ConnectionFactory.getConnection();
				PreparedStatement pst = con.prepareStatement(DEL_ITEM_QRY)) {

			pst.setInt(1, icode);

			int rowsCount = pst.executeUpdate();

			isDeleted = rowsCount > 0;

		} catch (SQLException | NamingException exp) {
			exp.printStackTrace();
			throw new ImsException("Deleting the item failed!");
		}

		return isDeleted;
	}
	
	
	
	}

