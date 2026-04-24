package solid_principles.v0;
/* Problems
Violates SRP
 */
public class Bird {
    private String name;
    private String color;
    private String type;

    public void fly(){
        System.out.println(this.name + " of type " + this.type + " is flying");
    }

    public void makeSound(){
        System.out.println(this.name + " of type " + this.type + " is making Sound");
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }




}
