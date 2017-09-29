package edu.mum.service.impl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.domain.Vehicle;
import edu.mum.repository.Repositorydata;
import edu.mum.repository.VehicleRepository;
//import edu.mum.repository.VehicleRepository;
import edu.mum.service.VehicleService;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	private VehicleRepository vehicleRepository;


	@Override
	public void save(Vehicle vehicle) {
		vehicleRepository.save(vehicle);

	}

	@Override
	public void update(Vehicle vehicle) {
		vehicleRepository.save(vehicle);

	}

	@Override
	public List<Vehicle> findAll() {

		return (List<Vehicle>) vehicleRepository.findAll();
	}

	@Override
	public Vehicle findOne(Long id) {

		return vehicleRepository.findOne(id);
	}

	@Override
	public void delete(Long id) {
		vehicleRepository.delete(id);
	}

	

	@Override
	public List<String> getColor() {
		
		return  Repositorydata.getColor().stream().sorted().collect(Collectors.toList());
	}

	@Override
	public List<String> getTypeofCar() {
		
		return Repositorydata.getTypeofCar().stream().sorted().collect(Collectors.toList());
	}

	@Override
	public List<String> getVehicleBrand() {
		
		return Repositorydata.getBrandAndModel().keySet()
				.stream().sorted(Comparator.comparing(p->p)).collect(Collectors.toList());
	}

	@Override
	public List<String> getVehicleModel(String carBrand) {
		
		 return Repositorydata.getBrandAndModel().get(carBrand)
				 .stream().sorted(Comparator.comparing(p->p)).collect(Collectors.toList());
	}

	@Override
	public List<Vehicle> findVehicleByMemberId(Long memberId) {
		
		return vehicleRepository.findVehicleByMemberId(memberId);
	}

}
