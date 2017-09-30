package edu.mum.controller;

import java.io.File;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.mum.domain.Vehicle;
import edu.mum.service.VehicleService;

@Controller
@RequestMapping("/vehicle")
@SessionAttributes({"color","typeofCar","carbrand","carModel","vehicleData","vehicleList","update"})
public class VehicleController {
	
	@Autowired
	VehicleService vehicleService;
	
	@Autowired
	ServletContext servletContext;

	@InitBinder
	public void intBin(WebDataBinder binder) {
		//binder.setDisallowedFields(new String[] { "" });
		
	}
	
	//hemak 
	@RequestMapping(value = "/uploadFile/{id}", method = RequestMethod.POST)
	public String processAddNewProductForm(@PathVariable Long id) {
		
		
		  Vehicle vehicle=vehicleService.findOne(id);
		  MultipartFile productImage = vehicle.getProductImage();
				 
		//MultipartFile productImage=newProduct.getProductImage();
 		 String rootDirectory = servletContext.getRealPath("/");
 			
		//isEmpty means file exists BUT NO Content
			if (productImage!=null && !productImage.isEmpty()) {
		       try {
		      	productImage.transferTo(new File(rootDirectory+"\\resources\\images\\"+vehicle.getId()));
		      	System.out.println("######################jguegfj");
		       } catch (Exception e) {
				throw new RuntimeException("Product Image saving failed", e);
		   }
		   }

	   
		return "redirect:/vehicle/vehicleList";
	}
	
	

	
	@RequestMapping(value = "/addvehicle", method = RequestMethod.GET)
	public String getCarform(@ModelAttribute("vehicle") Vehicle vehicle, Model modle, RedirectAttributes redirect) {

		modle.addAttribute("color", vehicleService.getColor());
		modle.addAttribute("typeofCar", vehicleService.getTypeofCar());
		modle.addAttribute("carbrand", vehicleService.getVehicleBrand());
		modle.addAttribute("mode", "NEW_VEHICLE");

		return "vehicle";

	}
	

	@RequestMapping(value = "/carmodel", method = RequestMethod.GET)
	public @ResponseBody List<String> carModel(@RequestParam("carbrand") String carBrand, Model model) {

		
		model.addAttribute("carModel", vehicleService.getVehicleModel(carBrand));
		return vehicleService.getVehicleModel(carBrand);

	}

	@RequestMapping(value = "/addvehicle", method = RequestMethod.POST)
	public String addCar(@Valid @ModelAttribute("vehicle") Vehicle vehicle, BindingResult result, Model model) {
		vehicle.setMemberId(1L);
		
		System.out.println(vehicle.getRegistrationYear());
		if (result.hasErrors()) {

			return "vehicle";

		}
		vehicleService.save(vehicle);
		System.out.println("---"+vehicleService.findVehicleByMemberId(1L));
        return "redirect:/vehicle/vehicleList";

	}
	
	
	@RequestMapping(value = "/updateVehicle/{id}", method = RequestMethod.GET)
	public String updateVehicle(@PathVariable Long id, @ModelAttribute("vehicle") Vehicle vehicle, Model modle) {
		Vehicle updateVehicle = vehicleService.findOne(id);
		modle.addAttribute("mode", "EDIT_VEHICLE");
		modle.addAttribute("update", updateVehicle);
		return "vehicle";
	}
	
	@RequestMapping(value="/deletVehicl/{id}",method=RequestMethod.GET)
	public String deletVehicle(@PathVariable Long id,RedirectAttributes redirect){
		
		vehicleService.delete(id);
		return "redirect:/vehicle/vehicleList";
		
	}
	
	
	


	@RequestMapping(value = "/vehicleList", method = RequestMethod.GET)
	public String getVehicleList(Model model) {

		
		model.addAttribute("vehicleList", vehicleService.findVehicleByMemberId(1L));
		return "vehicleView";
	}

}
