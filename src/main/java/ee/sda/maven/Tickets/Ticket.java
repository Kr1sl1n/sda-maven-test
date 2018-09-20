package ee.sda.maven.Tickets;
import java.time.LocalDateTime;
public class Ticket {


        private Person person;
        private int price;
        private LocalDateTime timestamp;

        public Ticket(Person person, int price, LocalDateTime timestamp) {
            this.person = person;
            this.price = price;
            this.timestamp = timestamp;
        }

        public Person getPerson() {
            return person;
        }

        public int getPrice() {
            return price;
        }

        public LocalDateTime getTimestamp() {
            return timestamp;
        }

        @Override
        public String toString() {
            return "Ticket{" +
                    "person=" + person +
                    ", price=" + price +
                    ", timestamp=" + timestamp +
                    '}';
        }

    }


