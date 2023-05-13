package mirosimo_examples.blobs.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import mirosimo_examples.blobs.Util.ImageUtil;
import mirosimo_examples.blobs.model.CarImg;
import mirosimo_examples.blobs.service.CarImgService;

@Controller
public class CarImgController {
	@Autowired
	CarImgService carImgService;
	
	@Autowired
	ImageUtil imgUtil;
	
	/* Display view for adding new image */
	@GetMapping("/add-car-img")
	public String newImgView(Model model) {
		CarImg carImg = new CarImg();
		model.addAttribute("carImg", carImg);
		return "img-new";
	}
	
	/* Save image and another fields into db */
	@PostMapping("/car-img-save")
	public String saveCarImg(@Valid CarImg carImg,
							   @RequestParam("img-main") MultipartFile carImgFile, Model model) throws IOException 
	{
		carImg.setImg(carImgFile.getBytes());
		carImgService.saveEntity(carImg);
		return "redirect:/list-car-img";
	}

	/* Display all images */
	@GetMapping("/list-car-img")
	public String listCarImg(Model model) {
		model.addAttribute("listCarImg", carImgService.getAllEntities());
		model.addAttribute("imgUtil", imgUtil);
		
		return "img-list";
	}
}
