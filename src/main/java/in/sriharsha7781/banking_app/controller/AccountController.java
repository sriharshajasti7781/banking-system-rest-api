package in.sriharsha7781.banking_app.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.sriharsha7781.banking_app.dto.AccountDto;
import in.sriharsha7781.banking_app.service.AccountService;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
	private AccountService accountService;
	public AccountController(AccountService accountService) {
		super();
		this.accountService = accountService;
	}
	@PostMapping
	public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto){
		return new ResponseEntity<AccountDto>(accountService.createAccount(accountDto),HttpStatus.CREATED);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id){
		return new ResponseEntity<AccountDto>(accountService.getAccountById(id),HttpStatus.OK);
	}
	
	@PutMapping("/{id}/deposit")
	public ResponseEntity<AccountDto> deposit(@PathVariable Long id,@RequestBody Map<String,Double> request){
		double amount=request.get("deposit");
		AccountDto accountDto=accountService.deposit(id, amount);
		return new ResponseEntity<AccountDto>(accountDto,HttpStatus.OK);
	}
	
	@PutMapping("/{id}/withdraw")
	public ResponseEntity<AccountDto> withdraw(@PathVariable Long id,@RequestBody Map<String,Double> request){
		double amount=request.get("withdraw");
		AccountDto accountDto=accountService.withdraw(id, amount);
		return new ResponseEntity<AccountDto>(accountDto,HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<AccountDto>> getAllAccounts(){
		List<AccountDto> accounts=accountService.getAllAccounts();
		return new ResponseEntity<List<AccountDto>>(accounts,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteAccountById(@PathVariable Long id){
		accountService.deleteAccountById(id);
		return new ResponseEntity<String>("Account Deleted Succesfully",HttpStatus.OK);
	}

}
