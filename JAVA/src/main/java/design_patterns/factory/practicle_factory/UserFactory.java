package design_patterns.factory.practicle_factory;

public class UserFactory {
    private static String STUDENT = "student";
    private static String TA = "ta";
    private static String MENTOR = "mentor";
    private static String INSTRUCTOR = "instructor";

    public static User getUserByType(Enum userType){
        if (userType.equals(UserType.STUDENT)){
            return new Student();
        }else if (userType.equals(UserType.TA)){
            return new TA();
        }else if(userType.equals(UserType.MENTOR)){
            return new Mentor();
        }else if (userType.equals(UserType.INSTRUCTOR)){
            return new Instructor();
        }else{
            return null;
        }
    }

    public static User getUserByInput(String input){
        if (input.toLowerCase().equals(STUDENT)){
            return new Student();
        }else if (input.toLowerCase().equals(TA)){
            return new TA();
        }else if (input.toLowerCase().equals(MENTOR)){
            return new Mentor();
        } else if (input.toLowerCase().equals(INSTRUCTOR)){
            return new Instructor();
        }else{
            return null;
        }
    }
}
