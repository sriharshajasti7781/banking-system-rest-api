package in.sriharsha7781.banking_app.mapper;

import in.sriharsha7781.banking_app.dto.AccountDto;
import in.sriharsha7781.banking_app.model.Account;

public class AccountMapper {
	
	public static Account mapToAccount(AccountDto accountdto) {
		Account account=new Account(
				accountdto.getId(),
				accountdto.getAccountHolderName(),
				accountdto.getBalance());
		return account;
	}
	
	public static AccountDto mapToAccountDto(Account account) {
		AccountDto accountdto=new AccountDto(
				account.getId(),
				account.getAccountHolderName(),
				account.getBalance());
		return accountdto;
	}

}
