package edu.mum.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class Repositorydata {
	
	
	private static  List<String>color=new ArrayList<>();
	private static  List<String>typeofCar=new ArrayList<>();
    private static  List<String>volkswagenBrand=new ArrayList<>();
	private static  List<String>fordBrand=new ArrayList<>();
	private static  List<String>bmwBrand=new ArrayList<>();
	private static  List<String>vauxhallBrand=new ArrayList<>();
	private static  List<String>audiBrand=new ArrayList<>();
	private static  List<String>otherBrand=new ArrayList<>();
	
    private static  Map<String,List<String>>brandAndModel=new HashMap<>();
    
 
	static{
		
		color.add("Red");
		color.add("Brown");
		color.add("Black");
		color.add("Yellow");
		color.add("Blue");
		color.add("Green");
		color.add("Grey");
		color.add("White");
		color.add("Darkblue");
		color.add("Others");

		typeofCar.add("Hatchback");
		typeofCar.add("Saloon");
		typeofCar.add("Convertible");
		typeofCar.add("Estate");
		typeofCar.add("SUV");
		typeofCar.add("Station wagon");
		typeofCar.add("Minivan");
		typeofCar.add("Van");
		typeofCar.add("others");

		volkswagenBrand.add("POLO");
		volkswagenBrand.add("PASSAT");
		volkswagenBrand.add("GOLF");
		volkswagenBrand.add("GOLF IV");
		volkswagenBrand.add("GOLF V");
		volkswagenBrand.add("others");
		fordBrand.add("FOCUS");
		fordBrand.add("FIESTA");
		fordBrand.add("MONDEO");
		fordBrand.add("C-MAX");
		fordBrand.add("TRANSIT");

		bmwBrand.add("320");
		bmwBrand.add("3 series");
		bmwBrand.add("318");
		bmwBrand.add("1");
		bmwBrand.add("530");

		vauxhallBrand.add("ASTRA");
		vauxhallBrand.add("CORSA");
		vauxhallBrand.add("VECTRA");
		vauxhallBrand.add("ZAFIRA");
		vauxhallBrand.add("INSIGNIA");

		audiBrand.add("A4");
		audiBrand.add("A3");
		audiBrand.add("A6");
		audiBrand.add("A3 SPORTBACK");
		audiBrand.add("A1");
		otherBrand.add("OTHERS");

		brandAndModel.put("FORD", fordBrand);
		brandAndModel.put("BMW", bmwBrand);
		brandAndModel.put("VOLKSWAGEN", volkswagenBrand);
		brandAndModel.put("VAUXHALL", vauxhallBrand);
		brandAndModel.put("AUDI", audiBrand);
		brandAndModel.put("OTHERS", otherBrand);
		/// brand

	}


	public static List<String> getColor() {
		return color;
	}


	public static List<String> getTypeofCar() {
		return typeofCar;
	}


	public static List<String> getVolkswagenBrand() {
		return volkswagenBrand;
	}


	public static List<String> getFordBrand() {
		return fordBrand;
	}


	public static List<String> getBmwBrand() {
		return bmwBrand;
	}


	public static List<String> getVauxhallBrand() {
		return vauxhallBrand;
	}


	public static List<String> getAudiBrand() {
		return audiBrand;
	}


	public static List<String> getOtherBrand() {
		return otherBrand;
	}


	public static Map<String, List<String>> getBrandAndModel() {
		return brandAndModel;
	}
    
	
	
	
	
}
