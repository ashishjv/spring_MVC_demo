package gmh.springmvc.demo.ecommerce.repository;

import gmh.springmvc.demo.ecommerce.model.Author;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AuthorRepo {

    List<Author> authorList;
    int uniqueID;

    public AuthorRepo(){
        this.authorList = new ArrayList<>();
        this.authorList.add(new Author(
                1,
                "Full Name 1",
                "This is the description of user 1",
                "https://images.unsplash.com/photo-1536164261511-3a17e671d380?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=930&q=80"));
        this.authorList.add(new Author(
                2,
                "Full Name 2",
                "This is the description of user 2",
                "https://images.unsplash.com/photo-1603210119594-b731d958ce31?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=934&q=80"));
        this.authorList.add(new Author(
                3,
                "Full Name 3",
                "This is the description of user 3",
                "https://images.unsplash.com/photo-1574884388045-87094039dab4?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=934&q=80"));
        this.authorList.add(new Author(
                4,
                "Full Name 4",
                "This is the description of user 4",
                "https://images.unsplash.com/photo-1604537370089-3f3e7950e5bc?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=934&q=80"));

        this.uniqueID = 5;
    }

    public List<Author> getAuthorList() {
        return this.authorList;
    }

    public List<Author> addOrEditAuthor(Author author){
        if(author.getProfileID()==0){
            author.setProfileID(this.uniqueID++);
        }
        else{
            this.deleteAuthorByID(author.getProfileID());
        }
        if(author.getProfilePicURL().equalsIgnoreCase("Profile photo URL")){
            author.setProfilePicURL("https://st3.depositphotos.com/15648834/17930/v/600/depositphotos_179308454-stock-illustration-unknown-person-silhouette-glasses-profile.jpg");
        }
        this.authorList.add(author);
        return this.authorList;
    }

    public List<Author> deleteAuthorByID(int authorID){
        for(Author auth : this.authorList ){
            if (auth.getProfileID() == authorID){
                this.authorList.remove(auth);
                break;
            }
        }
        return this.authorList;
    }
}
