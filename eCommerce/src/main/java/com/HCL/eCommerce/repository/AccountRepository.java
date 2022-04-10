package com.HCL.eCommerce.repository;
import org.springframework.data.repository.CrudRepository;
import com.HCL.eCommerce.entity.Account;
import java.util.Optional;

public interface AccountRepository extends CrudRepository<Account, Integer> {
	Optional<Account> findByNameAndUrl(String name, String url);
}
