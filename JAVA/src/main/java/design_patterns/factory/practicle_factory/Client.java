package design_patterns.factory.practicle_factory;

public class Client {
    public static void main(String[] args) {
        String input = "Student";
        UserType userType = UserType.MENTOR;

        User u1 = UserFactory.getUserByInput(input);
        User u2 = UserFactory.getUserByType(userType);

        System.out.println(u1.getClass());
        System.out.println(u2.getClass());

        System.out.println("This is the end line ");
    }
}
