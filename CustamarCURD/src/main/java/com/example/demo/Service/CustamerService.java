package com.example.demo.Service;

import java.util.List;

import com.example.demo.Model.Custamer;

public interface CustamerService {

	void add(Custamer custamer);

	List<Custamer> Display();

	Custamer Delete(Integer id);

	void Update(Custamer custamer, Integer id);

	Custamer Search(Integer id);

	void addAll(List<Custamer> list);
	
	Custamer findMob(String mob);
	
	List<Custamer>findByName( String name);

}
