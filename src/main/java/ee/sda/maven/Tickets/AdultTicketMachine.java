package ee.sda.maven.Tickets;

import java.io.IOException;
import java.time.Clock;
import java.time.LocalDateTime;
import java.util.ArrayList;


public class AdultTicketMachine extends TicketMachine {

        private Clock clock;
        private DiscountCalculator discountCalculator;
        private int price;

        public AdultTicketMachine(DiscountCalculator discountCalculator, int price, Clock clock) {
            this.discountCalculator = discountCalculator;
            this.price = price;
            this.clock = clock;
        }

        public Ticket buy(Person person) throws NoPersonDataException {
            if (person == null) {
                throw new NoPersonDataException("Sorry, no person data", LocalDateTime.now());
                throw new NoPersonDataException("Sorry, no person data", LocalDateTime.now(clock));
            }
            if (person.getAge() < 18) {
                throw new ForbiddenAgeException(person.getAge(), LocalDateTime.now(clock));
            }
            if (discountCalculator == null) {
                return new Ticket(person, price, LocalDateTime.now());
            }

            int discountPercentage = discountCalculator.calculate(person);
            double discount = price * (discountPercentage / 100d);
            double discountedPrice = price - discount;

          Ticket ticket =new Ticket(person (int) Math.floor(discountedPrice), LocalDateTime.now(clock));
          getHistory().add(ticket);
          return ticket;
        }
        public List<Ticket>getHistory(){
            if (history == null){
                history = new ArrayList<>();

            }
            return history;
        }


    }


