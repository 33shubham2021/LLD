package design_patterns.copy_constructor;

public class IntelligentPerson extends Person {
    private int iq;

    public IntelligentPerson(String name, int age, int iq) {
        super(name, age); //setting the name and age through the parent constructor
        this.iq = iq; //setting the parameter exclusive to child class
    }

    public IntelligentPerson(IntelligentPerson other){
        super(other);
        this.iq = other.iq;
    }





    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        this.iq = iq;
    }
}
