package gmh.springmvc.demo.ecommerce.service;

import gmh.springmvc.demo.ecommerce.model.Author;
import gmh.springmvc.demo.ecommerce.repository.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HomeService {

    @Autowired
    AuthorRepo authorRepo;

    public List<Author> getAllAuthors(){
        return authorRepo.getAuthorList();
    }

    public List<Author> addOrEditAuthor(Author author){
        return authorRepo.addOrEditAuthor(author);
    }

    public List<Author> deleteAuthorByID(int authorID){
        return authorRepo.deleteAuthorByID(authorID);
    }
}
