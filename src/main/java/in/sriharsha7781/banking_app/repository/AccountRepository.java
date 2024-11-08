package in.sriharsha7781.banking_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.sriharsha7781.banking_app.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {

}
