package test.com.fileupload.controller;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import test.com.fileupload.model.RequestVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	ServletContext sContext;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, String msg) {
		logger.info("Welcome home! The client locale is {}.", locale);
		logger.info("MSG !! :: {}" , msg);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date); 
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/insert.do", method = RequestMethod.GET)
	public String insert() {
		
		
		return "/jsp/insert";
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	@RequestMapping(value = "/insertOK.do", method = RequestMethod.POST)
	public String insertOK(@ModelAttribute("tvo") RequestVO vo) throws IllegalStateException, IOException {
		logger.info("Welcome insertOK! name :  {}", vo.getName());
		logger.info("Welcome insertOK! tel :  {}", vo.getTel());
		
		MultipartFile multipartFile = vo.getMultipartFile();
		String imgName = "";
		String realPath = "";
		
		if(multipartFile != null) {
			imgName = multipartFile.getOriginalFilename();
			vo.setImgName(imgName);
			logger.info("Welcome insertOK! imgName :  {}", vo.getImgName());
			
			// 해당 폴더의 실제 경로 획득(서버가 인식하는 경로)
			realPath = sContext.getRealPath("resources/uploadimg");
			logger.info("Welcome insertOK! realPath :  {}", realPath);
			
			// 폴더경로 + 파일명
			File origin_img = new File(realPath + "\\" + imgName);
			multipartFile.transferTo(origin_img);
			
			// 썸네일 이미지 저장
			BufferedImage original_buffer_img = ImageIO.read(origin_img);
			BufferedImage thumb_buffer_img = new BufferedImage(100, 100, BufferedImage.TYPE_3BYTE_BGR);

			Graphics2D graphic = thumb_buffer_img.createGraphics();
			graphic.drawImage(original_buffer_img, 0, 0, 100, 100, null);

			File thumb_file = new File(realPath + "/thumb_" + imgName);
			ImageIO.write(thumb_buffer_img, "jpg", thumb_file);
		}
		
		String en = URLEncoder.encode(imgName, "utf-8");
		return "redirect:insertIMGview.do?imgName=" + en;
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	// RequestParam을 통해 변수 명을 Mapping 시켜줌
	@RequestMapping(value = "/insertOK2.do", method = RequestMethod.POST)
	public String insertOK2(@RequestParam(value = "key01") String name, @RequestParam(value = "key02") String tel, @RequestParam(value = "key03") MultipartFile multipartFile) throws IllegalStateException, IOException {
		logger.info("Welcome insertOK! name :  {}", name);
		logger.info("Welcome insertOK! tel :  {}", tel);
				
		String imgName = "";
		String realPath = "";
		RequestVO vo = new RequestVO();
		vo.setName(name);
		vo.setTel(tel);
		
		if(multipartFile != null) {
			imgName = multipartFile.getOriginalFilename();
			vo.setImgName(imgName);
			logger.info("Welcome insertOK! imgName :  {}", vo.getImgName());
			
			// 해당 폴더의 실제 경로 획득(서버가 인식하는 경로)
			realPath = sContext.getRealPath("resources/uploadimg");
			logger.info("Welcome insertOK! realPath :  {}", realPath);
			
			// 폴더경로 + 파일명
			File origin_img = new File(realPath + "\\" + imgName);
			multipartFile.transferTo(origin_img);
			
			// 썸네일 이미지 저장
			BufferedImage original_buffer_img = ImageIO.read(origin_img);
			BufferedImage thumb_buffer_img = new BufferedImage(200, 200, BufferedImage.TYPE_3BYTE_BGR);

			Graphics2D graphic = thumb_buffer_img.createGraphics();
			graphic.drawImage(original_buffer_img, 0, 0, 200, 200, null);

			File thumb_file = new File(realPath + "/thumb_" + imgName);
			ImageIO.write(thumb_buffer_img, "jpg", thumb_file);
		}
		
		String en = URLEncoder.encode(imgName, "utf-8");
		return "redirect:insertIMGview.do?imgName=" + en;
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/insertIMGview.do", method = RequestMethod.GET)
	public String insertIMGview() {
		
		
		return "/jsp/insertIMGview";
	}
	
}
