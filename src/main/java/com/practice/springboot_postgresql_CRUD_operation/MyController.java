package com.practice.springboot_postgresql_CRUD_operation;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController 
{
	@Autowired
	HospitalRepository hrepo;

	//########By simple method##########//


	/*
	@RequestMapping("/test")
	public String test()
	{
		return "Hello! this is CRUD operation in postgreSQL";
	}
	@RequestMapping("/save")
	public String saveData(@RequestBody Hospital hospital)
	{
	hrepo.save(hospital);
	return "Data is save";
	}
	@RequestMapping("/all")
	public List<Hospital> allData()
	{
		return hrepo.findAll();
	}
	@PutMapping("/upd/{id}")
	public String update(@RequestBody Hospital hospital,@PathVariable int id)
	{
		Hospital h=hrepo.findById(id).get();
		h.setPname(hospital.getPname());
		h.setRoomno(hospital.getRoomno());
		h.setAddress(hospital.getAddress());
		h.setAge(hospital.getAge());
		hrepo.save(h);
		return "Data is updated";
	}
	@DeleteMapping("/del/{id}")
	public String deleteData(@PathVariable int id)
	{
		Hospital h=hrepo.findById(id).get();
		hrepo.deleteById(id);
		return "Data is deleted";
	}
	@RequestMapping("/{id}")
	public Optional<Hospital> byId(@PathVariable int id)
	{
		return hrepo.findById(id);
	}
	@RequestMapping("/pname/{pname}")
	public List<Hospital> byPname(@PathVariable String pname)
	{
		return hrepo.findByPname(pname);
	}
	*/
	
	//###By DTO Method#####//
	
	@RequestMapping("/test")
	public String test()
    {
		return "Hello! From DTO method";
	}
	@RequestMapping("/save")
	public String saveData(@RequestBody HospitalDTO hospitaldto)
	{
		Hospital hospital=new Hospital();
		hospital.setPname(hospitaldto.getPname());
		hospital.setRoomno(hospitaldto.getRoomno());
		hospital.setAddress(hospitaldto.getAddress());
		hospital.setAge(hospitaldto.getAge());
		hrepo.save(hospital);
		return "Data is saved into the database";
	}
	@RequestMapping("/all")
	public List<HospitalDTO> allData()
	{
		return hrepo.findAll()
				    .stream()
				    .map(hospital->{
				    	HospitalDTO hospitaldto=new HospitalDTO();
				    	hospitaldto.setPname(hospital.getPname());
				    	hospitaldto.setRoomno(hospital.getRoomno());
				    	hospitaldto.setAddress(hospital.getAddress());
				    	hospitaldto.setAge(hospital.getAge());
	
				    	return hospitaldto;
				    })
				    .collect(Collectors.toList());
	}
	
	@PutMapping("/upd/{id}")
	public String update(@RequestBody HospitalDTO hospitaldto,@PathVariable int id)
	{
	
		Hospital hospital=hrepo.findById(id).get();
		hospital.setPname(hospitaldto.getPname());
		hospital.setRoomno(hospitaldto.getRoomno());
		hospital.setAddress(hospitaldto.getAddress());
		hospital.setAge(hospitaldto.getAge());
		hrepo.save(hospital);
		return "Data is updated";
	}

	@DeleteMapping("/del/{id}")
	public String deleteData(@PathVariable int id)
	{
		Hospital h=hrepo.findById(id).get();
		hrepo.deleteById(id);
		return "Data is deleted";
	}
	
}
