package com.example.summarry.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.summarry.project.service.ClientsService;
import com.example.summarry.project.entity.Accounts;
import com.example.summarry.project.entity.Clients;

@Controller

public class ClientsController {
	
	
	@Autowired
	private ClientsService clientsService;
	
	
	@GetMapping("/show")
	public String getClients(Model themodel) {
		
		
		List<Clients>liste= clientsService.getClients();
		themodel.addAttribute("clients",liste);
		return "clients/show";
		
	}
	

	@GetMapping("/showForm")
	public String addClient(Model theModel) {
		
		Clients client=new Clients();
		theModel.addAttribute("cl",client);
		return "clients/showAddForm";
	}
	
	@PostMapping("/save")
	public String saveClient(@ModelAttribute("cl") Clients theClients ) {
		
		clientsService.saveClient(theClients);
		return "redirect:/show";
		
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate( @RequestParam("clientId") int theId,   Model theModel) {
		
		Clients cli=clientsService.getClient(theId);
		theModel.addAttribute("cl",cli);
		return "clients/showAddForm";
		
	}
	
	@GetMapping("/delete")
	public String delete( @RequestParam("clientId") int theId) {
		
		clientsService.deleteClient(theId);
		return"redirect:/show";
	}
	
	@GetMapping("/getInfo")
	public String getInfo(@RequestParam("clientId") int theId, Model theModel
			) {
		
		
		Clients cli=clientsService.getClient(theId);
		theModel.addAttribute("theId",theId);
		
		theModel.addAttribute("client",cli);
		
		List<Accounts>acc=clientsService.getAcc(theId);
		theModel.addAttribute("account",acc);
		return "clients/showInfo";
	}
	
	@GetMapping("/transferAcc")
	public String transferAcc( Model theModel,@RequestParam("clientId") int theId) {
		List<Accounts> list=clientsService.getAcc(theId);
		theModel.addAttribute("list",list);
		theModel.addAttribute("theId",theId);
		
		Accounts acc=new Accounts();
		theModel.addAttribute("acc",acc);
		return "clients/transferAcc";
	}
	
	@GetMapping("/deposit")
	public String deposit( Model theModel, @RequestParam("clientId") int theId,
			@RequestParam("clientId2") int theId2) {
		
		
		
              Clients cl=new Clients();
              cl.setId(theId);
            
              
              
              theModel.addAttribute("theId2",theId2);
                
   				Accounts acc=new Accounts();
				acc.setId(theId);
				theModel.addAttribute("temp",acc);

				

				return "clients/deposit";
				
				
		
	}
	

	@PostMapping("/saveFunds")
	public String saveFunds( @ModelAttribute("temp") Accounts acc,
			@RequestParam("clientId") int theId2	) {
		

		int amount =(int) acc.getMoney();
		int theId=acc.getId();
		clientsService.deposit(theId, amount);



		String str=String.valueOf(theId2);
		String red="redirect:/getInfo?clientId=";
		red=red+str;
		return red;
		
		
	}
	
	
@PostMapping("/betweenAcc")
public String betweenAcc (@ModelAttribute("acc") Accounts acc,@ModelAttribute("testOrder") int firstId
		,@ModelAttribute("testOrder2") int secId,@RequestParam("clientId") int theId) {
	long summ=acc.getMoney();
	
	clientsService.betweenAcc(firstId, secId, summ);
	
	String str=String.valueOf(theId);
		String red="redirect:/getInfo?clientId=";
		red=red+str;
		
	return red;
}


 @GetMapping("/toSomeone")
 public String toSomeone(@RequestParam("clientId") int theId,Model theModel
		) {
	 Accounts acc=new Accounts();
	 theModel.addAttribute("temp",acc);
	 
	 theModel.addAttribute("theId",theId);
	 
	 List<Accounts>list=clientsService.getAcc(theId);
	 List<Accounts>list2=clientsService.getAccounts();
	 
	 theModel.addAttribute("list",list);
	 theModel.addAttribute("list2",list2);
	 

	 
	return "clients/toSome";
 }
 
 @PostMapping("/toSomeoneTwo")
 public String toSomeoneTwo( @ModelAttribute("testOrder") int theId,@ModelAttribute("testOrder2") int theId2
		 ,@ModelAttribute("temp") Accounts theAcc ,@RequestParam("clientId") int num) {
	 

	 clientsService.betweenAcc(theId, theId2, theAcc.getMoney());
	 
	 String str=String.valueOf(num);
		String red="redirect:/getInfo?clientId=";
		red=red+str;
		
	return red;
 }
	

}
