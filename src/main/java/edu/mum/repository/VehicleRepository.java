package edu.mum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.mum.domain.Vehicle;
@Repository
public interface VehicleRepository extends CrudRepository<Vehicle, Long>{
	
	@Query("SELECT v    FROM Vehicle v WHERE v.memberId=:memberId")
	List<Vehicle> findVehicleByMemberId(@Param("memberId")Long memberId);

}
