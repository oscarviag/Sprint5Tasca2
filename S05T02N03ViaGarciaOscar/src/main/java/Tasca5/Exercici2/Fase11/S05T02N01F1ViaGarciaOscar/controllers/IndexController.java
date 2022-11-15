package Tasca5.Exercici2.Fase11.S05T02N01F1ViaGarciaOscar.controllers;



import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController implements ErrorController{
	
    private final static String PATH = "/error";
    
    @RequestMapping(PATH)
    @ResponseBody
    public String getErrorPath() {
        
        return "Operació no trobada";
    }
	
	

}
