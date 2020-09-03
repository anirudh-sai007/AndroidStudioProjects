package com.deva.mvsr.trekker;

import java.util.ArrayList;
import java.util.List;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.simpledb.AmazonSimpleDBClient;
import com.amazonaws.services.simpledb.model.Attribute;
import com.amazonaws.services.simpledb.model.CreateDomainRequest;
import com.amazonaws.services.simpledb.model.Item;
import com.amazonaws.services.simpledb.model.PutAttributesRequest;
import com.amazonaws.services.simpledb.model.ReplaceableAttribute;
import com.amazonaws.services.simpledb.model.SelectRequest;
import com.amazonaws.services.simpledb.model.SelectResult;


public class Driver_LatLong_Class {

	protected AmazonSimpleDBClient sdbClient;
	protected String nextToken;
	private static final String NAME_ATTRIBUTE = "DriverId";
	private static final String NUMBER_ATTRIBUTE = "BusLatitude";
	private static final String datea = "BusLong";

	protected int count;
	private static final String REG_DOMAIN = "TrackBus";

	public Driver_LatLong_Class() {
		// TODO Auto-generated constructor stub

		AWSCredentials credentials = new BasicAWSCredentials(
				Constants.ACCESS_KEY_ID, Constants.SECRET_KEY);
		this.sdbClient = new AmazonSimpleDBClient(credentials);
		this.nextToken = null;
		this.count = -1;
	}

	public void createDomain() {
		// TODO Auto-generated method stub
		CreateDomainRequest cdr = new CreateDomainRequest(REG_DOMAIN);
		this.sdbClient.createDomain(cdr);
	}

	public void AddToTable(String name1, String password1, String phoneno) {
		// TODO Auto-generated method stub
		ReplaceableAttribute UserAttribute = new ReplaceableAttribute(
				NAME_ATTRIBUTE, name1, Boolean.TRUE);
		ReplaceableAttribute PassAttribute = new ReplaceableAttribute(
				NUMBER_ATTRIBUTE,password1, Boolean.TRUE);
		ReplaceableAttribute cont = new ReplaceableAttribute(datea,
				phoneno, Boolean.TRUE);
		
		List<ReplaceableAttribute> attrs = new ArrayList<ReplaceableAttribute>(
				2);
		attrs.add(UserAttribute);
		attrs.add(PassAttribute);
		attrs.add(cont);

		PutAttributesRequest par = new PutAttributesRequest(REG_DOMAIN,
				name1, attrs);
		try {
			this.sdbClient.putAttributes(par);
		} catch (Exception exception) {
			System.out.println("EXCEPTION = " + exception);
		}
	}
	
	public List<Others> getAllValues() {
		// TODO Auto-generated method stub

		SelectRequest selectRequest = new SelectRequest(
				"select PHONE_NO from TrackBusReg").withConsistentRead(true);
		selectRequest.setNextToken(this.nextToken);

		SelectResult response = this.sdbClient.select(selectRequest);

		/* List<String> ls= response.getItems(); */

		/* return this.valuesGetting(response.getItems()); */
		// System.out.println("image names            "+valuesGetting(response.getItems()));
		System.out.println("hello          " + response.getItems().toString());
		return valuesGetting(response.getItems());

	}

	private List<Others> valuesGetting(List<Item> items) {
		// TODO Auto-generated method stub
		ArrayList<Others> alldata = new ArrayList<Others>(items.size());

		for (Item item : items) {
			alldata.add(this.individulaData(item));
		}

		System.out.println("all data size        " + alldata.size());
		for (int i = 0; i < alldata.size(); i++) {
			System.out.println(" name  " + alldata.get(i));
		}
		return alldata;
	}

	private Others individulaData(Item item) {
		// TODO Auto-generated method stub
		return new Others(this.getimagenames(item));
	}

	private String getimagenames(Item item) {
		// TODO Auto-generated method stub
		return this.getAllStringAttribute("PHONE_NO", item.getAttributes());
	}

	private String getAllStringAttribute(String usernameAttribute,
			List<Attribute> list) {
		// TODO Auto-generated method stub
		for (Attribute attrib : list) {
			if (attrib.getName().equals(usernameAttribute)) {
				return attrib.getValue();
			}
		}

		return "";
	}

	public List<Others> getAllValues22(String aa) {
		// TODO Auto-generated method stub
		SelectRequest selectRequest = new SelectRequest(
				"select * from TrackBus where DriverId='" + aa + "'")
				.withConsistentRead(true);
		selectRequest.setNextToken(this.nextToken);

		SelectResult response = this.sdbClient.select(selectRequest);
		System.out.println("hello          " + response.getItems().toString());
		return response.getItems();
	}
	
	

}
