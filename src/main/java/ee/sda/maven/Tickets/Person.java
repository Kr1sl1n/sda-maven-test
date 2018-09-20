package ee.sda.maven.Tickets;

public class Person {

    private int age;
    private PersonStatus status;

    public Person(int age) {
        this(age, PersonStatus.COMMON);
    }

    public Person(int age, PersonStatus status) {
        this.age = age;
        this.status = status;
    }

    public int getAge() {
        return age;
    }

    public PersonStatus getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", status=" + status +
                '}';
    }

}