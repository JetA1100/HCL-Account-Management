package com.HCL.eCommerce.controller;
import javax.validation.Valid;
import javax.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.HCL.eCommerce.service.AccountService;
import com.HCL.eCommerce.vo.AccountVO;
import com.HCL.eCommerce.exception.ErrorMessage;

@Validated
@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	AccountService accountService;
	
	@RequestMapping(method = RequestMethod.GET, name = "Get Account By Name and URL", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAccount(@RequestParam(name = "name") String name, @RequestParam(name = "url") String url) {
		return new ResponseEntity<>(accountService.get(name, url), HttpStatus.OK);
	}
	
	@GetMapping(name = "Get Account By ID", value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAccountById(@PathVariable @Positive(message = "Invalid ID") int id) {
		return new ResponseEntity<>(accountService.findById(id), HttpStatus.OK);
	}
	
	@PostMapping(name = "Add Account", value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addAccount(@RequestBody @Valid AccountVO accountVO) {
		return new ResponseEntity<>(accountService.add(accountVO), HttpStatus.OK);
	}
	
	@GetMapping(name = "Get Accounts", value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAccounts() {
		return new ResponseEntity<>(accountService.getAll(), HttpStatus.OK);
	}
	
	@DeleteMapping(name = "Delete Account By Name and URL", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> delete(@RequestParam(name = "name") String name, @RequestParam(name = "url") String url) {
		return new ResponseEntity<>(accountService.delete(name, url), HttpStatus.OK);
	}
	
	@DeleteMapping(name = "Delete Account By ID", value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> deleteAccountById(@PathVariable @Positive(message = "Invalid ID") int id) {
		return new ResponseEntity<>(accountService.deleteById(id), HttpStatus.OK);
	}
	
	@PutMapping(name = "Update Account By ID", value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateAccountById(@PathVariable @Positive(message = "Invalid ID") int id, @RequestBody @Valid AccountVO accountVO) {
		AccountVO existAccount = accountService.findById(id);
		return new ResponseEntity<>(accountService.updateById(accountVO, id), HttpStatus.OK);
	}
}
