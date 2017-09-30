package edu.mum.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import edu.mum.validation.NullMinNumber;
import edu.mum.validator.YearConstraint;

@Entity
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	// @Size(min=2, max =10)
	@NotEmpty
	private String plateNumber;

	private String typeOfCar;

	@Transient
	private MultipartFile productImage;
	@NotEmpty
	private String carBrand;

	@NotEmpty
	private String model;

	private Long memberId;

	private String color;

	private String country;

	@NullMinNumber(value=2000)
	
    @YearConstraint()
	private Integer registrationYear;

	private String description;

	public String getTypeOfCar() {
		return typeOfCar;
	}

	public void setTypeOfCar(String typeOfCar) {
		this.typeOfCar = typeOfCar;
	}

	public String getPlateNumber() {
		return plateNumber;
	}

	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getCarBrand() {
		return carBrand;
	}

	public Long getId() {
		return id;
	}

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCarBrand(String carBrand) {
		this.carBrand = carBrand;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Integer getRegistrationYear() {
		return registrationYear;
	}

	public void setRegistrationYear(Integer registrationYear) {
		this.registrationYear = registrationYear;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	// @XmlTransient
	public MultipartFile getProductImage() {
		return productImage;
	}

	public void setProductImage(MultipartFile productImage) {
		this.productImage = productImage;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((carBrand == null) ? 0 : carBrand.hashCode());
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + ((plateNumber == null) ? 0 : plateNumber.hashCode());
		result = prime * result + ((registrationYear == null) ? 0 : registrationYear.hashCode());
		result = prime * result + ((typeOfCar == null) ? 0 : typeOfCar.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		if (carBrand == null) {
			if (other.carBrand != null)
				return false;
		} else if (!carBrand.equals(other.carBrand))
			return false;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (plateNumber == null) {
			if (other.plateNumber != null)
				return false;
		} else if (!plateNumber.equals(other.plateNumber))
			return false;
		if (registrationYear == null) {
			if (other.registrationYear != null)
				return false;
		} else if (!registrationYear.equals(other.registrationYear))
			return false;
		if (typeOfCar == null) {
			if (other.typeOfCar != null)
				return false;
		} else if (!typeOfCar.equals(other.typeOfCar))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", plateNumber=" + plateNumber + ", typeOfCar=" + typeOfCar + ", carBrand="
				+ carBrand + ", model=" + model + ", color=" + color + ", country=" + country + ", registrationYear="
				+ registrationYear + ", description=" + description + "]";
	}

}
