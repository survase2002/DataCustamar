package com.example.demo.Contaroll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Custamer;
import com.example.demo.Service.CustamerService;

@RestController
public class CustomerController {

	@Autowired
	private CustamerService cs;
	
	@PostMapping("add")
	public void add(@RequestBody Custamer c) {
		cs.add(c);
	}

	@PostMapping("addAll")
	public void addAll(@RequestBody List<Custamer> list) {
		list.forEach(x -> cs.add(x));
	}

	@GetMapping("Display")
	public List<Custamer> Display() {
		return cs.Display();
	}

	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {

		Custamer temp = cs.Delete(id);
		if (temp == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("NOT FOUND");
		}

		return ResponseEntity.ok(temp);
	}

	@PostMapping("search/{id}")
	public ResponseEntity<?> search(@PathVariable Integer id) {
		Custamer temp = cs.Search(id);
		if (temp == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("NOT Found..!");
		}
		return ResponseEntity.ok(temp);
	}

	@PostMapping("search/mob/{mob}")
	public Custamer searchMob(@PathVariable String mob) {
		return cs.findMob(mob);
	}

	@PostMapping("search/name/{name}")
	public List<Custamer> searchName(@PathVariable String name) {
		return cs.findByName(name);
	}

}
