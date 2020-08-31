package com.iiht.evaluation.coronakit.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.iiht.evaluation.coronakit.dao.ProductMasterDao;
import com.iiht.evaluation.coronakit.ims.exception.ImsException;
import com.iiht.evaluation.coronakit.model.CoronaKit;
import com.iiht.evaluation.coronakit.model.ProductMaster;
import com.iiht.evaluation.coronakit.service.ItemService;
import com.iiht.evaluation.coronakit.service.ItemServiceImpl;
import com.iiht.evaluation.coronakit.service.KitService;
import com.iiht.evaluation.coronakit.service.KitServiceImpl;

@WebServlet({ "/newUser", "/showproducts", "/addtocart", "/addaddress", "/placeorder"})
public class UserController extends HttpServlet {
	
	HttpSession session;
	private static final long serialVersionUID = 1L;
	private ProductMasterDao productMasterDao;
	private ItemService itemService;
	private KitService kitService;

//	public void setKitDAO(KitDao kitDAO) {
//		this.kitDAO = kitDAO;
//	}

	public void setProductMasterDao(ProductMasterDao productMasterDao) {
		this.productMasterDao = productMasterDao;
	}

	public void init(ServletConfig config) {
		String jdbcURL = config.getServletContext().getInitParameter("jdbcUrl");
		String jdbcUsername = config.getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = config.getServletContext().getInitParameter("jdbcPassword");
		itemService = new ItemServiceImpl(jdbcURL, jdbcUsername, jdbcPassword);
		kitService = new KitServiceImpl(jdbcURL, jdbcUsername, jdbcPassword);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getServletPath(); //because of which request servlet has come
		String viewName=""; // or errorpage.jsp
		try {
		switch(url) {
		case "/newUser":viewName = showNewUserForm(request, response);break;
		case "/showproducts":viewName=showAllProducts(request, response);break;
		case "/addtocart":viewName=addNewItemToKit(request, response); break;
		case "/addaddress":viewName=showPlaceOrderForm(request, response);break;
		case "/placeorder":viewName=saveOrderForDelivery(request, response);break;
//		case "/saveItem":viewName=doSaveItem(request, response);break;
		default : viewName = "notfound.jsp"; break;	
		}
		
	} catch (Exception ex) {
		
		throw new ServletException(ex.getMessage());
	}
		RequestDispatcher dispatch = 
				request.getRequestDispatcher(viewName);
		dispatch.forward(request, response);

}
		
		

			

	private String showOrderSummary(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return "";
	}

	private String saveOrderForDelivery(HttpServletRequest request, HttpServletResponse response) {
		
		String view="";
		
		try {
			
			CoronaKit coronaKit = new CoronaKit();
			coronaKit.setId(new Random().nextInt());
			coronaKit.setDeliveryAddress(request.getParameter("deliveryAddress"));
			
			coronaKit.setContactNumber((String)session.getAttribute("contactNumber"));
			coronaKit.setEmail((String)session.getAttribute("email"));
			int quantity = (Integer.parseInt((String)session.getAttribute("quantity")));
			coronaKit.setPersonName((String)session.getAttribute("personName"));
			coronaKit.setQuantity(quantity);
			
			//KitDetail kitDetail = new KitDetail();
			//kitDetail.setId(new Random().nextInt());
			
			String str[] = ((String[])session.getAttribute("selectedItems"));
			List<String> al = new ArrayList<String>();
			al = Arrays.asList(str);
			List<Integer> prods = al.stream().map(Integer::parseInt).collect(Collectors.toList());
			
			coronaKit.setProductId(prods);
			Double totalProducsAmount = (Double) session.getAttribute("totalAmount");
			
			coronaKit.setTotalAmount(totalProducsAmount * quantity);

			
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
			   LocalDateTime now = LocalDateTime.now();  
			   System.out.println(dtf.format(now));  
			   
			coronaKit.setOrderDate(dtf.format(now));
			System.out.println("contact number: "+coronaKit.getContactNumber());
			
			
			
			kitService.validateAndAddCoronaKit(coronaKit);
			
			request.setAttribute("coronakit", coronaKit);
			//request.setAttribute("kitDetail", kitDetail);
			
			view="ordersummary.jsp";
		} catch (Exception e) {
			request.setAttribute("errMsg", e.getMessage());
			view="errPage.jsp";
		}
		
		return view;
		  
	}

	private String showPlaceOrderForm(HttpServletRequest request, HttpServletResponse response) {
		String view="";
		
		try {
			
			session.setAttribute("quantity", request.getParameter("quantity"));
			CoronaKit coronaKit = new CoronaKit();
			request.setAttribute("coronakit", coronaKit);
			view="showkit.jsp";
		} catch (Exception e) {
			request.setAttribute("errMsg", e.getMessage());
			view="errPage.jsp";
		}
		
		return view;
	}

	private String showKitDetails(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return "";
	}

	private String deleteItemFromKit(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return "";
	}

	private String addNewItemToKit(HttpServletRequest request, HttpServletResponse response) throws ImsException {
		String view="";
		
		try {
			String[] selectedItems = request.getParameterValues("selectedItems");
			for (String selectedItem : selectedItems) {
				System.out.println("selected are: "+selectedItem);
			    //String mileage = request.getParameter("mileage_" + selectedItem);
			    // ...
			}
			
		      int size = selectedItems.length;
		      Integer [] arr = new Integer [size];
		      for(int i=0; i<size; i++) {
		         arr[i] = Integer.parseInt(selectedItems[i]);
		      }
		      
			List<ProductMaster> items = itemService.getItemsByIds(arr);
			Double totalAmount = 0d;
			for (ProductMaster productMaster : items) {
				totalAmount = totalAmount + productMaster.getCost();
			}
			request.setAttribute("items", items);
			
			session.setAttribute("selectedItems", selectedItems);
			session.setAttribute("totalAmount", totalAmount);
			
			view="selectedproducts.jsp";
		} catch (Exception e) {
			request.setAttribute("errMsg", e.getMessage());
			view="errPage.jsp";
		}
		
		return view;
	}

	private String showAllProducts(HttpServletRequest request, HttpServletResponse response) {
		String view="";
		
		//CoronaKit coronaKit = new CoronaKit();
		//coronaKit.setContactNumber((String) request.getParameter("contactNumber"));
		
		
		
		session = request.getSession();
		//System.out.println("from session: "+session.getAttribute("contactNumber"));
	    String contactNumber = (String)request.getParameter("contactNumber");
	    session.setAttribute("contactNumber", contactNumber);
	    
	    String personName = (String)request.getParameter("personName");
	    session.setAttribute("personName", personName);
	    
	    String email = (String)request.getParameter("email");
	    session.setAttribute("email", email);
	    
		//System.out.println("in showprod java: "+coronaKit.getContactNumber());
		try {
			List<ProductMaster> items = itemService.getAllItems();
			request.setAttribute("items", items);
			//request.setAttribute("coronakit", coronaKit);
			view="listproductstouser.jsp";
		} catch (Exception e) {
			request.setAttribute("errMsg", e.getMessage());
			view="errPage.jsp";
		}
		
		return view;
	}

	private String insertNewUser(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return "";
	}

	private String showNewUserForm(HttpServletRequest request, HttpServletResponse response) {
		CoronaKit coronaKit = new CoronaKit();
		//coronaKit.setContactNumber((String)request.getAttribute("pconatct"));
		request.setAttribute("coronakit", coronaKit);
		
		return "newuser.jsp";
	}
	
}