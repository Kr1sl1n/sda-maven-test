package ee.sda.maven.Tickets;

import org.apache.commons.lang3.StringUtils;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

// Alternative option to using line.25 'mock.....'
// @RunWith(MockitoJUnitRunner.class)

public class AdultTicketMachineTest {

    //@Mock
    private DiscountCalculator discountCalculator;

    private Clock clock = Clock.fixed(Instant.parse("2018-08-27T10:00:00Z"), ZoneId.of("Europe/Tallinn"));

    @Before
    public void setUp() throws Exception {

        discountCalculator = mock(DiscountCalculator.class);
    }

    @Test
    public void buy_ThrowsNoPersonDataException_IfPersonIsNull() {
        // given
        Person person = null;
        AdultTicketMachine adultTicketMachine = new AdultTicketMachine(discountCalculator, 100, clock);

        // when
        Throwable result = catchThrowable((). > adultTicketMachine.buy(person));


        try {
            adultTicketMachine.buy(person);
            fail("no exception was thrown");
        } catch (NoPersonDataException e) {
            // then

            Assertions.assertThat(result).hasMessage("Sorry no person data");
            Assertions.assertThat(result.getTimestamp()).isEqualTo(LocalDateTime.now(clock));


            verify(discountCalculator, never()).calculate(any());
        }
    }

    @Test
    public void buy_ReturnsFullPriceTicket_IfSubsidizedPersonAndNoDiscountCalculator() throws NoPersonDataException {
        // given
        Person person = new Person(50, PersonStatus.DISABLED);
        DiscountCalculator discountCalculator = null;
        AdultTicketMachine adultTicketMachine = new AdultTicketMachine(discountCalculator, 100, clock);

        // when
        Ticket result = adultTicketMachine.buy(person);

        // then
        assertEquals(100, result.getPrice());
        assertEquals(person, result.getPerson());
        assertEquals(LocalDateTime.now(clock), result.getTimestamp());
        assertNotNull(result.getTimestamp());
    }

    @Test
    public void buy_ReturnsFullPriceTicket_IfSubsidizedPersonAndDiscountCalculator() throws NoPersonDataException {
        // given
        Person person = new Person(50, PersonStatus.DISABLED);
        when(discountCalculator.calculate(person)).thenReturn(90);
        AdultTicketMachine adultTicketMachine = new AdultTicketMachine(discountCalculator, 100, clock);

        // when
        Ticket result = adultTicketMachine.buy(person);

        // then
        assertEquals(10, result.getPrice());
        assertEquals(person, result.getPerson());
        // assertEquals(LocalDateTime.now(), result.getTimestamp());
        assertNotNull(result.getTimestamp());

        verify(discountCalculator).calculate(person);
    }

    @Test
    public void buy_ThrowsForbiddenAgeException_IfPersonAgeIsBelow18() throws NoPersonDataException {
        // given
        Person person = new Person(10);
        AdultTicketMachine adultTicketMachine = new AdultTicketMachine(discountCalculator, 100, clock);

        // when
        try {
            adultTicketMachine.buy(person);
            fail("no exception was thrown");
        } catch (ForbiddenAgeException e) {
            // then
            assertEquals("Ticket sale is not allowed for this age: 10", e.getMessage());
            assertEquals(LocalDateTime.now(clock), e.getTimestamp());
        }
    }

    @Test
    public void buy_ReturnsTicket_IfPersonAgeIs18() throws NoPersonDataException {
        // given
        Person person = new Person(18);
        AdultTicketMachine adultTicketMachine = new AdultTicketMachine(discountCalculator, 100, clock);

        // when
        Ticket result = adultTicketMachine.buy(person);

        // then
        assertEquals(100, result.getPrice());
        assertEquals(person, result.getPerson());
    }

    @Test

    public void buy_ReturnsOneEntry_IfOneTicketSold() throws NoPersonDataException {
        Person person = new Person(20);
        AdultTicketMachine adultTicketMachine = new AdultTicketMachine(discountCalculator, 100, clock);
        adultTicketMachine.buy(person);

        //when
        List<Ticket> result = adultTicketMachine.getHistory();

        //then
        assertEquals(1, result.size());
        assertEquals(new Ticket(person, 100, LocalDateTime.now(clock)), result.get(0));

    }

    @Test

    public void buy_ReturnsOneEntry_IfFiveTicketSold() throws NoPersonDataException {
        Person person = new Person(20);
        AdultTicketMachine adultTicketMachine = new AdultTicketMachine(discountCalculator, 100, clock);
        adultTicketMachine.buy(new Person(19));
        adultTicketMachine.buy(new Person(21));
        adultTicketMachine.buy(new Person(22));
        adultTicketMachine.buy(new Person(32));
        adultTicketMachine.buy(new Person(59));
        //when
        List<Ticket> result = adultTicketMachine.getHistory();

        //then
        assertEquals(5, result.size());
        assertEquals(new Ticket(new Person(19), 100, LocalDateTime.now(clock)), result.get(0));
        assertEquals(new Ticket(new Person(21), 100, LocalDateTime.now(clock)), result.get(1));
        assertEquals(new Ticket(new Person(22), 100, LocalDateTime.now(clock)), result.get(2));
        assertEquals(new Ticket(new Person(32), 100, LocalDateTime.now(clock)), result.get(3));
        assertEquals(new Ticket(new Person(59), 100, LocalDateTime.now(clock)), result.get(4));

        assertThat(result).containsOnly(
                (new Ticket(new Person(19), 100, LocalDateTime.now(clock)),
                (new Ticket(new Person(21), 100, LocalDateTime.now(clock)),
                (new Ticket(new Person(22), 100, LocalDateTime.now(clock)),
                (new Ticket(new Person(32), 100, LocalDateTime.now(clock)),
                new Ticket(new Person(59), 100, LocalDateTime.now(clock)));
    }

}


// Somewhere in here I have mistakes that don't match above

//package ee.sda.maven.tickets;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import java.time.Clock;
//import java.time.Instant;
//import java.time.LocalDateTime;
//import java.time.ZoneId;
//
//import static org.junit.Assert.*;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//
////@RunWith(MockitoJUnitRunner.class)
//
//public class AdultTicketMachineTest {
//
//    //  @Mock
//    private DiscountCalculator discountCalculator;
//
//    private Clock clock = Clock.fixed(Instant.parse("2018-08-27T10:00:00Z"), ZoneId.of("Europe/Tallinn"));
//
//    @Before
//    public void setUp() throws Exception {
//        discountCalculator = mock(DiscountCalculator.class);
//    }
//
//
//    @Test
//    public void buy_ThrowsNoPersonDataException_IfPersonIsNull() {
//        // given
//
//
//        Person person = null;
//        // no longer needed because of Mock
//        // DiscountCalculator discountCalculator = new DiscountCalculator();
//        AdultTicketMachine adultTicketMachine = new AdultTicketMachine(discountCalculator, 100, clock);
//
//        // when
//        try {
//            adultTicketMachine.buy(person);
//            fail("no exception was thrown");
//        } catch (NoPersonDataException e) {
//            // then
//            assertEquals("Sorry, no person data", e.getMessage());
//            assertNotNull(e.getTimestamp());
//            assertEquals(LocalDateTime.now(clock), e.getTimestamp());
//        }
//
//    }
//
//    @Test
//    public void buy_ReturnsFullPriceTicket_IfSubsidizedPersonAndNoDiscountCalculator() throws NoPersonDataException {
//        // given
//        Person person = new Person(50, PersonStatus.DISABLED);
//        DiscountCalculator discountCalculator = new DiscountCalculator();
//        AdultTicketMachine adultTicketMachine = new AdultTicketMachine(discountCalculator, 100, clock);
//
//        // when
//        // good convention to name it 'result' every time to find it easily later
//        Ticket result = adultTicketMachine.buy(person);
//
//        // then
//        assertEquals(100, result.getPrice());
//        assertEquals(person, result.getPerson());
//        //assertEquals(LocalDateTime.now(clock), result.getTimestamp());
//        assertNotNull(result.getTimestamp());
//    }
//
//    @Test
//    public void buy_ReturnsFullPriceTicket_IfSubsidizedPersonAndDiscountCalculator() throws NoPersonDataException {
//        // given
//        Person person = new Person(50, PersonStatus.DISABLED);
//        // mock the behaviour for a discount
//        when(discountCalculator.calculate(person)).thenReturn(90);
//        AdultTicketMachine adultTicketMachine = new AdultTicketMachine(discountCalculator, 100, clock);
//
//        // when
//        // good convention to name it 'result' every time to find it easily later
//        Ticket result = adultTicketMachine.buy(person);
//
//        // then
//        assertEquals(10, result.getPrice());
//        assertEquals(person, result.getPerson());
//        //assertEquals(LocalDateTime.now(clock), result.getTimestamp());
//        assertNotNull(result.getTimestamp());
//    }
//
//}


