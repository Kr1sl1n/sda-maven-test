package ee.sda.maven;


import org.apache.commons.lang3.StringUtils;

public class Main {


    public static void main(String[] args) {
        System.out.println("Hello Maven!");

        String string = "baeldung.com";
        boolean contained1 = StringUtils.containsAny(string, 'a', 'b', 'c');

        System.out.println("contained 1 =" +contained1);
    }
}
