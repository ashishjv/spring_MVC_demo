package gmh.springmvc.demo.ecommerce.resource;

import gmh.springmvc.demo.ecommerce.model.Author;
import gmh.springmvc.demo.ecommerce.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @Autowired
    private HomeService homeService;

    @GetMapping("/")
    public String showHomePage(Model model){
        String caseType="blank";
        model.addAttribute("author",new Author());
        model.addAttribute("caseType",caseType);
        return "index";
    }

    @PostMapping("/")
    public String showEditPage(Model model,@ModelAttribute Author author){
        String caseType="blank";
        model.addAttribute("authors",author);
        model.addAttribute("caseType",caseType);
        return "index";
    }

    @GetMapping("/dynamic")
    public String showDynamicPage(Model model){
        String caseType="blank";
        model.addAttribute("authors",homeService.getAllAuthors());
        model.addAttribute("caseType",caseType);
        return "dynamic";
    }

    @PostMapping("/dynamic")
    public String refreshDynamicPage(Model model,@ModelAttribute Author author, @ModelAttribute("caseType") String caseType){

        if(caseType.equalsIgnoreCase("edit")){
            return "index";
        }
        else if(caseType.equalsIgnoreCase("add_or_edit")){
            if(author.getName().equalsIgnoreCase("Name")){
                return "index";
            }
            model.addAttribute("authors",this.homeService.addOrEditAuthor(author));
        }
        else if(caseType.equalsIgnoreCase("delete")){
            model.addAttribute("authors",this.homeService.deleteAuthorByID(author.getProfileID()));
        }
        return "dynamic";
    }
}
