package edu.mum.service;

import java.util.List;

import edu.mum.domain.Vehicle;

public interface VehicleService {
	
	public void save(Vehicle vehicle);
	public void update(Vehicle vehicle);
	public List<Vehicle> findAll();
	public Vehicle findOne(Long id);
	public void delete(Long id);
	public List<String> getVehicleBrand();
	public List<String> getVehicleModel(String carBrand);
	public List<String> getColor();
	public List<String> getTypeofCar();
	public  List<Vehicle> findVehicleByMemberId(Long memberId);
	

}
