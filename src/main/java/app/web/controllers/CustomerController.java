package app.web.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashSet;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.web.models.BriefCustomerReadModel;
import app.web.models.CustomerCreateModel;
import app.web.models.CustomerUpdateModel;
import app.web.models.DetailedCustomerReadModel;
import app.web.models.PageModel;

@RequestMapping("customers")
@RestController
public class CustomerController {
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> openBankAccount(@RequestBody CustomerCreateModel customerCreateModel) {
		
		/* 
		 * # What should be done:
		 * - validating the inputs (customerCreateModel object)
		 * - transforming the model into a persistent-entity that will be stored later in the DB
		 * - calling the domain layer to handle the storage process of the transformed customerCreateModel
		 * - return Http-Status 201-CREATED that means successful creation of a resource in the backend-side
		 * 
		 * */	
		
		return new ResponseEntity<Object>(HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "{nationalId}")
	public ResponseEntity<DetailedCustomerReadModel> getDetailedViewByNationalId(@PathVariable String nationalId) {
			
		/* 
		 * # What should be done:
		 * - validating the inputs (nationalId text)
		 * - calling the domain layer to load the requested data from the data storage
		 * - transforming the loaded persistent-entity into a model that will be returned later to the client-side
		 * - return Http-Status 200-OK that means the data is found in the backend-side, along with the requested data 
		 *   in the response-body
		 * 
		 * */		
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		DetailedCustomerReadModel detailedCustomerReadModel = new DetailedCustomerReadModel();
		detailedCustomerReadModel.setId(1);
		detailedCustomerReadModel.setName("Elizabeth james");		
		detailedCustomerReadModel.setNationalId("99996670580000");
		detailedCustomerReadModel.setDateOfBirth(dateFormat.format("1990-03-01"));	
		detailedCustomerReadModel.setCellPhone("07700900603");
		detailedCustomerReadModel.setEmail("elizabeth.james.2023@gmail.com");
		detailedCustomerReadModel.setMailingAddress("3a High Street, Hedge End, SOUTHAMPTON, SO31 4NG");		
		detailedCustomerReadModel.setAccountNumber("34589582");
		detailedCustomerReadModel.setBalance(18000.55f);
		
		return new ResponseEntity<DetailedCustomerReadModel>(detailedCustomerReadModel, HttpStatus.OK);
	}
		
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<PageModel<BriefCustomerReadModel>> getPageOfCustomers(@RequestParam int pageIndex) {
			
		/* 
		 * # What should be done:
		 * - calling the domain layer to load the requested data from the data storage
		 * - transforming the loaded persistent-entities into a page of models that will be returned later to the client-side
		 * - return Http-Status 200-OK that means the data is found in the backend-side, along with the requested data 
		 *   in the response-body
		 * 
		 * */	

		HashSet<BriefCustomerReadModel> briefCustomerReadModels = new HashSet<BriefCustomerReadModel>();
		
		BriefCustomerReadModel briefCustomerReadModel1 = new BriefCustomerReadModel();
		briefCustomerReadModel1.setName("Elizabeth james");
		briefCustomerReadModel1.setNationalId("99996670580000");
		briefCustomerReadModel1.setAccountNumber("34589582");
		briefCustomerReadModel1.setBalance(18000.55f);
		briefCustomerReadModels.add(briefCustomerReadModel1);
		
		BriefCustomerReadModel briefCustomerReadModel2 = new BriefCustomerReadModel();
		briefCustomerReadModel2.setName("Eleanor david");
		briefCustomerReadModel2.setNationalId("99996670580011");
		briefCustomerReadModel2.setAccountNumber("24195459");
		briefCustomerReadModel2.setBalance(17000.55f);
		briefCustomerReadModels.add(briefCustomerReadModel2);
		
		BriefCustomerReadModel briefCustomerReadModel3 = new BriefCustomerReadModel();
		briefCustomerReadModel3.setName("Alice john");
		briefCustomerReadModel3.setNationalId("99996670580022");
		briefCustomerReadModel3.setAccountNumber("26376737");
		briefCustomerReadModel3.setBalance(16000.55f);
		briefCustomerReadModels.add(briefCustomerReadModel3);
		
		BriefCustomerReadModel briefCustomerReadModel4 = new BriefCustomerReadModel();
		briefCustomerReadModel4.setName("Amelia michael");
		briefCustomerReadModel4.setNationalId("99996670580033");
		briefCustomerReadModel4.setAccountNumber("28524966");
		briefCustomerReadModel4.setBalance(16500.55f);
		briefCustomerReadModels.add(briefCustomerReadModel4);
		
		BriefCustomerReadModel briefCustomerReadModel5 = new BriefCustomerReadModel();
		briefCustomerReadModel5.setName("Emma joseph");
		briefCustomerReadModel5.setNationalId("99996670580044");
		briefCustomerReadModel5.setAccountNumber("27004681");
		briefCustomerReadModel5.setBalance(17500.55f);
		briefCustomerReadModels.add(briefCustomerReadModel5);
		
		BriefCustomerReadModel briefCustomerReadModel6 = new BriefCustomerReadModel();
		briefCustomerReadModel6.setName("Emily daniel");
		briefCustomerReadModel6.setNationalId("99996670580055");
		briefCustomerReadModel6.setAccountNumber("15668641");
		briefCustomerReadModel6.setBalance(18500.55f);
		briefCustomerReadModels.add(briefCustomerReadModel6);
		
		BriefCustomerReadModel briefCustomerReadModel7 = new BriefCustomerReadModel();
		briefCustomerReadModel7.setName("Grace noah");
		briefCustomerReadModel7.setNationalId("99996670580066");
		briefCustomerReadModel7.setAccountNumber("17734246");
		briefCustomerReadModel7.setBalance(19500.55f);
		briefCustomerReadModels.add(briefCustomerReadModel7);
		
		BriefCustomerReadModel briefCustomerReadModel8 = new BriefCustomerReadModel();
		briefCustomerReadModel8.setName("Olivia henry");
		briefCustomerReadModel8.setNationalId("99996670580077");
		briefCustomerReadModel8.setAccountNumber("20196447");
		briefCustomerReadModel8.setBalance(20500.75f);
		briefCustomerReadModels.add(briefCustomerReadModel8);
		
		BriefCustomerReadModel briefCustomerReadModel9 = new BriefCustomerReadModel();
		briefCustomerReadModel9.setName("Jackson charles");
		briefCustomerReadModel9.setNationalId("99996679980088");
		briefCustomerReadModel9.setAccountNumber("62318263");
		briefCustomerReadModel9.setBalance(21500.75f);
		briefCustomerReadModels.add(briefCustomerReadModel9);
		
		BriefCustomerReadModel briefCustomerReadModel10 = new BriefCustomerReadModel();
		briefCustomerReadModel10.setName("Leo matthew");
		briefCustomerReadModel10.setNationalId("99993370580033");
		briefCustomerReadModel10.setAccountNumber("20643276");
		briefCustomerReadModel10.setBalance(22500.75f);
		briefCustomerReadModels.add(briefCustomerReadModel10);
		
		PageModel<BriefCustomerReadModel> pageOfCustomers = new PageModel<BriefCustomerReadModel>();
		pageOfCustomers.setData(briefCustomerReadModels);
		pageOfCustomers.setFirstPage(true);
		pageOfCustomers.setLastPage(false);
		
		return new ResponseEntity<PageModel<BriefCustomerReadModel>>(pageOfCustomers, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "{id}")
	public ResponseEntity<Object> updateBankAccount(@PathVariable int id, @RequestBody CustomerUpdateModel customerUpdateModel) {

		/* 
		 * # What should be done:
		 * - validating the inputs (customerUpdateModel object)
		 * - transforming the model into a persistent-entity that will be stored later in the DB
		 * - calling the domain layer to handle the storage process of the transformed customerUpdateModel
		 * - return Http-Status 204-NO_CONTENT that means successful update of a resource in the backend-side
		 * 
		 * */
		
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public ResponseEntity<Object> removeBankAccount(@PathVariable int id) {
		
		/* 
		 * # What should be done:
		 * - calling the domain layer to handle the removal process of the requested data
		 * - return Http-Status 204-NO_CONTENT that means successful removal of a resource in the backend-side
		 * 
		 * */
		
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}
	
}