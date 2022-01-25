package interoperability.data;


import org.jetbrains.annotations.NotNull;

public class CustomerJava {
    private int id;
    private String name;
    private String email;

    public void prettyPrint(){
        System.out.printf("id: %d - Name - %s",id,name);
    }

    /**
     * this @NotNull annotation will tell the kotlin compiler that it will never be null and so
     * when using this code in java we can be sure that this fun will return a non-null value
     * @return non null String
     */
public @NotNull
String neverBeNull(){
        return "non null value";
    }
    public  String canBeNull(){
        return "non null value";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
