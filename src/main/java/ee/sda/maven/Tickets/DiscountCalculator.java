package ee.sda.maven.Tickets;

public class DiscountCalculator {

    public int calculate(Person person) {
        if (person == null) {
            throw new IllegalArgumentException("Given person is null");
        }
        if (person.getAge() < 0) {
            throw new IllegalArgumentException("Negative age is not allowed: " + person.getAge());
        }
        if (person.getAge() <= 6 || person.getStatus() == PersonStatus.VIP) {
            return 100;
        }
        if (person.getStatus() == PersonStatus.DISABLED) {
            return 90;
        }
        if (person.getAge() > 6 && person.getAge() < 18) {
            return 75;
        }
        if (person.getStatus() == PersonStatus.STUDENT
                && person.getAge() >= 18 && person.getAge() <= 26) {
            return 50;
        }
        if (person.getAge() >= 70) {
            return 90;
        }

        return 0;
    }

}
