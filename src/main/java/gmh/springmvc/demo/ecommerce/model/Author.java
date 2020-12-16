package gmh.springmvc.demo.ecommerce.model;

public class Author {

    private int profileID = 0;
    private String name = "";
    private String description = "";
    private String profilePicURL = "";

    public Author(){
        this.profileID = 0;
        this.name = "Name";
        this.description = "Description";
        this.profilePicURL = "Profile photo URL";
    }

    public Author(int profileID, String name, String description, String profilePicURL) {
        this.profileID = profileID;

        if(name.equalsIgnoreCase("Name")){
            this.name = "";
        }
        else{
            this.name = name;
        }

        if(description.equalsIgnoreCase("Description")){
            this.description = "";
        }
        else{
            this.description = description;
        }

        if(profilePicURL.equalsIgnoreCase("Profile photo URL")){
            this.profilePicURL = "";
        }
        else{
            this.profilePicURL = profilePicURL;
        }
    }

    public int getProfileID() {
        return profileID;
    }

    public void setProfileID(int profileID) {
        this.profileID = profileID;
    }

    public String getProfilePicURL() {
        return profilePicURL;
    }

    public void setProfilePicURL(String profilePicURL) {
        this.profilePicURL = profilePicURL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
