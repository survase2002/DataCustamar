package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Contaroll.GlobalException;
import com.example.demo.Exception.InvaliMobileno;
import com.example.demo.Exception.InvalidName;
import com.example.demo.Exception.Invalidid;
import com.example.demo.Model.Custamer;
import com.example.demo.Repository.CustomerRepository;

@Service
public class CustamerServiceImpl implements CustamerService {

	// private final Contaroll.GlobalException globalException;

	@Autowired
	private CustomerRepository cr;

//    CustamerServiceImpl(Contaroll.GlobalException globalException) {
//        this.globalException = globalException;
//    }

	@Override
	public void add(Custamer custamer) {
		// TODO Auto-generated method stub
		Integer id = custamer.getId();
		Custamer temp = Search(id);
		if (id == null || id <= 0)
			throw new Invalidid("ID must be greater than zero");
		if (cr.existsById(id))
			throw new Invalidid("ID already exists");

		String name=custamer.getName().trim();
		List<Custamer> nm=cr.findByName(name);
		
		if(!nm.isEmpty())
			throw new InvalidName("name are same");
		
		
		String mob = custamer.getMob().trim();
		if (mob.startsWith("+91"))
			mob = mob.substring(3);

		if (mob.length() == 10) {
			if (mob.charAt(0) == '0' || mob.charAt(0) == '1' || mob.charAt(0) == '2' || mob.charAt(0) == '3'
					|| mob.charAt(0) == '4')
				throw new InvaliMobileno("invalid mobile no");
			for (int i = 0; i < mob.length(); i++) {
				if (!Character.isDigit(mob.charAt(i)))
					throw new InvaliMobileno("invalid mobile no..!");
			}
		} else
			throw new InvaliMobileno("invalid mobile no..!");

		cr.save(custamer);

	}

	@Override
	public List<Custamer> Display() {
		// TODO Auto-generated method stub
		return cr.findAll();
	}

	@Override
	public Custamer Delete(Integer id) {

		if (cr.findById(id).isPresent()) {
			Custamer temp = cr.findById(id).get();
			cr.deleteById(id);
			return temp;
		}
		return null;
	}

	@Override
	public void Update(Custamer custamer, Integer id) {
		custamer.setId(id);
		cr.save(custamer);

	}

	@Override
	public Custamer Search(Integer id) {
		// TODO Auto-generated method stub
		if (cr.findById(id).isPresent()) {
			Custamer temp = cr.findById(id).get();
			return temp;
		}
		return null;
	}

	@Override
	public void addAll(List<Custamer> list) {
		// TODO Auto-generated method stub
		cr.saveAll(list);
	}

	@Override
	public Custamer findMob(String mob) {
		// TODO Auto-generated method stub

		return cr.findByMob(mob);
	}

	@Override
	public List<Custamer> findByName(String name) {
		// TODO Auto-generated method stub
		return cr.findByName(name);
	}

}
