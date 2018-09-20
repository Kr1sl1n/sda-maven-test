package ee.sda.maven.Tickets;

import org.junit.Test;

import static org.junit.Assert.*;

public class DiscountCalculatorTest {


    @Test
        public void calculate_ThrowsIllegalArgumentException_IfPersonIsNull() {
            // given
            Person person = null;

            DiscountCalculator discountCalculator = new DiscountCalculator();

            // when
            try {
                discountCalculator.calculate(person);
                fail("no exception was thrown");
            } catch (IllegalArgumentException e) {
                // then
                assertEquals("Given person is null", e.getMessage());
            }
        }

        @Test
        public void calculate_Returns100Percent_IfAgeIs6() {
            // given
            Person person = new Person(6);

            DiscountCalculator discountCalculator = new DiscountCalculator();

            // when
            int result = discountCalculator.calculate(person);

            // then
            assertEquals(100, result);
        }

        @Test
        public void calculate_Returns75Percent_IfAgeMoreThan6() {
            // given
            Person person = new Person(7);

            DiscountCalculator discountCalculator = new DiscountCalculator();

            // when
            int result = discountCalculator.calculate(person);

            // then
            assertEquals(75, result);
        }

        @Test
        public void calculate_Returns100Percent_IfAgeIs0() {
            // given
            Person person = new Person(0);

            DiscountCalculator discountCalculator = new DiscountCalculator();

            // when
            int result = discountCalculator.calculate(person);

            // then
            assertEquals(100, result);
        }

        @Test
        public void calculate_Returns100Percent_IfAgeIs1() {
            // given
            Person person = new Person(1);

            DiscountCalculator discountCalculator = new DiscountCalculator();

            // when
            int result = discountCalculator.calculate(person);

            // then
            assertEquals(100, result);
        }

        @Test
        public void calculate_Returns100Percent_IfAgeIs5() {
            // given
            Person person = new Person(5);

            DiscountCalculator discountCalculator = new DiscountCalculator();

            // when
            int result = discountCalculator.calculate(person);

            // then
            assertEquals(100, result);
        }

        @Test
        public void calculate_ThrowsIllegalArgumentException_IfAgeIsNegative() {
            // given
            Person person = new Person(-1);

            DiscountCalculator discountCalculator = new DiscountCalculator();

            // when
            try {
                discountCalculator.calculate(person);
                fail("no exception was thrown");
            } catch (IllegalArgumentException e) {
                // then
                assertEquals("Negative ages are not allowed: -1", e.getMessage());
            }
        }

        @Test
        public void calculate_Returns75_IfAgeIs17() {
            // given
            Person person = new Person(17);

            DiscountCalculator discountCalculator = new DiscountCalculator();

            // when
            int result = discountCalculator.calculate(person);

            // then
            assertEquals(75, result);
        }

        @Test
        public void calculate_Returns0_IfAgeIs18() {
            // given
            Person person = new Person(18);

            DiscountCalculator discountCalculator = new DiscountCalculator();

            // when
            int result = discountCalculator.calculate(person);

            // then
            assertEquals(0, result);
        }

        @Test
        public void calculate_Returns0_IfAgeIs19() {
            // given
            Person person = new Person(19);

            DiscountCalculator discountCalculator = new DiscountCalculator();

            // when
            int result = discountCalculator.calculate(person);

            // then
            assertEquals(0, result);
        }

        @Test
        public void calculate_Returns75_IfAgeIs17AndStudent() {
            // given
            Person person = new Person(17, PersonStatus.STUDENT);

            DiscountCalculator discountCalculator = new DiscountCalculator();

            // when
            int result = discountCalculator.calculate(person);

            // then
            assertEquals(75, result);
        }

        @Test
        public void calculate_Returns50_IfAgeIs18AndStudent() {
            // given
            Person person = new Person(18, PersonStatus.STUDENT);

            DiscountCalculator discountCalculator = new DiscountCalculator();

            // when
            int result = discountCalculator.calculate(person);

            // then
            assertEquals(50, result);
        }

        @Test
        public void calculate_Returns50_IfAgeIs19AndStudent() {
            // given
            Person person = new Person(19,PersonStatus.STUDENT);

            DiscountCalculator discountCalculator = new DiscountCalculator();

            // when
            int result = discountCalculator.calculate(person);

            // then
            assertEquals(50, result);
        }

        @Test
        public void calculate_Returns0_IfAgeIs25() {
            // given
            Person person = new Person(25);

            DiscountCalculator discountCalculator = new DiscountCalculator();

            // when
            int result = discountCalculator.calculate(person);

            // then
            assertEquals(0, result);
        }

        @Test
        public void calculate_Returns0_IfAgeIs26() {
            // given
            Person person = new Person(26);

            DiscountCalculator discountCalculator = new DiscountCalculator();

            // when
            int result = discountCalculator.calculate(person);

            // then
            assertEquals(0, result);
        }

        @Test
        public void calculate_Returns0_IfAgeIs27() {
            // given
            Person person = new Person(27);

            DiscountCalculator discountCalculator = new DiscountCalculator();

            // when
            int result = discountCalculator.calculate(person);

            // then
            assertEquals(0, result);
        }

        @Test
        public void calculate_Returns50_IfAgeIs25AndStudent() {
            // given
            Person person = new Person(25, PersonStatus.STUDENT);

            DiscountCalculator discountCalculator = new DiscountCalculator();

            // when
            int result = discountCalculator.calculate(person);

            // then
            assertEquals(50, result);
        }

        @Test
        public void calculate_Returns50_IfAgeIs26AndStudent() {
            // given
            Person person = new Person(26, PersonStatus.STUDENT);

            DiscountCalculator discountCalculator = new DiscountCalculator();

            // when
            int result = discountCalculator.calculate(person);

            // then
            assertEquals(50, result);
        }

        @Test
        public void calculate_Returns0_IfAgeIs27AndStudent() {
            // given
            Person person = new Person(27,PersonStatus.STUDENT);

            DiscountCalculator discountCalculator = new DiscountCalculator();

            // when
            int result = discountCalculator.calculate(person);

            // then
            assertEquals(0, result);
        }

        @Test
        public void calculate_Returns0_IfAgeIs69() {
            // given
            Person person = new Person(69);

            DiscountCalculator discountCalculator = new DiscountCalculator();

            // when
            int result = discountCalculator.calculate(person);

            // then
            assertEquals(0, result);
        }

        @Test
        public void calculate_Returns90_IfAgeIs70() {
            // given
            Person person = new Person(70);

            DiscountCalculator discountCalculator = new DiscountCalculator();

            // when
            int result = discountCalculator.calculate(person);

            // then
            assertEquals(90, result);
        }

        @Test
        public void calculate_Returns90_IfAgeIs71() {
            // given
            Person person = new Person(71);

            DiscountCalculator discountCalculator = new DiscountCalculator();

            // when
            int result = discountCalculator.calculate(person);

            // then
            assertEquals(90, result);
        }

        // This gets tricky because we have cases where 90% discount is either better or worse for the customer
        // 4 tests are needed to cover this rule (not 8, because previous rules have covered stuff)
        @Test
        public void calculate_Returns90_IfStatusIsDisabled(){

        }
    }

