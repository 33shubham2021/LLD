package design_patterns.copy_constructor;

public class Client {
    public static void main(String[] args) {
        Person p1 = new Person("Shubham" , 30);
        Person personCopy = new Person(p1);

        System.out.println("Original Person : name = " + p1.getName() +
                " age = " + p1.getAge());

        System.out.println("Person Copy : name = " + personCopy.getName() +
                " age = " + personCopy.getAge() + "\n\n");

        IntelligentPerson ip = new IntelligentPerson("Ravi" , 60 , 100);
        IntelligentPerson ipCopy = new IntelligentPerson(ip);

        System.out.println("Original Intelligent Person : name = " + ip.getName() +
                " age = " + ip.getAge() + " iq = " + ip.getIq());

        System.out.println("Intelligent Person Copy : name = " + ipCopy.getName() +
                " age = " + ipCopy.getAge() + " iq = " + ipCopy.getIq() + "\n\n");


    }
}
