package design_patterns.prototype;

public class IntelligentStudent extends Student {
    private int iq;

    public IntelligentStudent(String name, int age, String gender, int iq) {
        super(name, age, gender);
        this.iq = iq;
    }

    public IntelligentStudent(IntelligentStudent other) {
        super(other);
        this.iq = other.iq;
    }


    @Override
    public IntelligentStudent copy() {
        return new IntelligentStudent(this);
    }
}
