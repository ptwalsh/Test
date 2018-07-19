package account;


import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;



@RestController
public class AccountResource {
	
	@Autowired
	private AccountRepository accountRepository;
	
	@GetMapping("/accounts")
	public List<Account> retrieveAccounts(){
		return accountRepository.findAll();
	}
	
	@GetMapping("/accounts/{id}")
	public Account retrieveAccount(@PathVariable long id) throws AccountNotFoundException {
		Optional<Account> theAccount = accountRepository.findById(id);

		if (!theAccount.isPresent()) {
			
			throw new AccountNotFoundException("Not Found id-" + id);
		}
		
		return theAccount.get();
	}
	
	
	@GetMapping("/accounts/delete/{id}")
	public void deleteStudent(@PathVariable long id) {
		accountRepository.deleteById(id);
	}
	
	@PostMapping("/accounts")
	public ResponseEntity<Object> createStudent(@RequestBody Account account) {
		Account savedAccount = accountRepository.save(account);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedAccount.getId()).toUri();

		return ResponseEntity.created(location).build();

	}

}
