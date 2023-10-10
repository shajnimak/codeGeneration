package kz.shady.assignment.util;

public class ObjectCheck {
    public static boolean isBlank(Object object) {
        return (object == null || object.equals(""));
    }
}
