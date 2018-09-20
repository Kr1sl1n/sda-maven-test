package ee.sda.maven;

public class Calculator {

    public int sum() {
        return 0;
    }

    public int sum(String input) {
        if (input == null) {
            return 0;
        }
        String[] numbers = input.split("\\+");
        int sum = 0;
        for (String number : numbers) {
            try {
            sum += Integer.valueOf(number);
        }catch(NumberFormatException ignore){
// ignored on purpose
        }
    }
return sum;

}

}

