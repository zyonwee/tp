package seedu.address.model.trip;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

import seedu.address.model.contact.Name;
import seedu.address.testutil.TripBuilder;

public class TripTest {

    private static final Trip PARIS = new TripBuilder().withName("Paris 2025")
            .withAccommodation("Hotel 81")
            .withItinerary("Eat baguettes")
            .withDate("01/01/2205")
            .withCustomerNames("John Doe", "Jane Doe")
            .build();

    private static final Trip TOKYO = new TripBuilder().withName("Tokyo 2025")
            .withAccommodation("Capsule Inn")
            .withItinerary("Visit Tokyo Tower")
            .withDate("02/02/2205")
            .withCustomerNames("Alice Smith", "Bob Jones")
            .build();

    // Valid values for testing modifications
    private static final String VALID_NAME_TOKYO = "Tokyo 2025";
    private static final String VALID_ACCOMMODATION_TOKYO = "Capsule Inn";
    private static final String VALID_ITINERARY_TOKYO = "Visit Tokyo Tower";
    private static final String VALID_DATE_TOKYO = "02/02/2205";
    private static final String VALID_CUSTOMER_BOB = "Bob Jones";

    @Test
    public void getCustomerNames_modifyList_throwsUnsupportedOperationException() {
        Trip trip = new TripBuilder().build();
        assertThrows(UnsupportedOperationException.class, () -> trip.getCustomerNames().remove(new Name("John Doe")));
    }

    @Test
    public void isSameTrip() {
        // same object -> returns true
        assertTrue(PARIS.isSameTrip(PARIS));

        // null -> returns false
        assertFalse(PARIS.isSameTrip(null));

        // same name, all other attributes different -> returns true
        Trip editedParis = new TripBuilder(PARIS).withAccommodation(VALID_ACCOMMODATION_TOKYO)
                .withItinerary(VALID_ITINERARY_TOKYO)
                .withDate(VALID_DATE_TOKYO)
                .withCustomerNames(VALID_CUSTOMER_BOB)
                .build();
        assertTrue(PARIS.isSameTrip(editedParis));

        // different name, all other attributes same -> returns false
        editedParis = new TripBuilder(PARIS).withName(VALID_NAME_TOKYO).build();
        assertFalse(PARIS.isSameTrip(editedParis));

        // name differs in case, all other attributes same -> returns false
        Trip editedTokyo = new TripBuilder(TOKYO).withName(VALID_NAME_TOKYO.toLowerCase()).build();
        assertFalse(TOKYO.isSameTrip(editedTokyo));

        // name has trailing spaces, all other attributes same -> returns false
        String nameWithTrailingSpaces = VALID_NAME_TOKYO + " ";
        editedTokyo = new TripBuilder(TOKYO).withName(nameWithTrailingSpaces).build();
        assertFalse(TOKYO.isSameTrip(editedTokyo));
    }

    @Test
    public void equals() {
        // same values -> returns true
        Trip parisCopy = new TripBuilder(PARIS).build();
        assertTrue(PARIS.equals(parisCopy));

        // same object -> returns true
        assertTrue(PARIS.equals(PARIS));

        // null -> returns false
        assertFalse(PARIS.equals(null));

        // different type -> returns false
        assertFalse(PARIS.equals(5));

        // different trip -> returns false
        assertFalse(PARIS.equals(TOKYO));

        // different name -> returns false
        Trip editedParis = new TripBuilder(PARIS).withName(VALID_NAME_TOKYO).build();
        assertFalse(PARIS.equals(editedParis));

        // different accommodation -> returns false
        editedParis = new TripBuilder(PARIS).withAccommodation(VALID_ACCOMMODATION_TOKYO).build();
        assertFalse(PARIS.equals(editedParis));

        // different itinerary -> returns false
        editedParis = new TripBuilder(PARIS).withItinerary(VALID_ITINERARY_TOKYO).build();
        assertFalse(PARIS.equals(editedParis));

        // different date -> returns false
        editedParis = new TripBuilder(PARIS).withDate(VALID_DATE_TOKYO).build();
        assertFalse(PARIS.equals(editedParis));

        // different customer names -> returns false
        editedParis = new TripBuilder(PARIS).withCustomerNames(VALID_CUSTOMER_BOB).build();
        assertFalse(PARIS.equals(editedParis));
    }

    @Test
    public void toStringMethod() {
        String expected = Trip.class.getCanonicalName() + "{name=" + PARIS.getName()
                + ", accommodation=" + PARIS.getAccommodation()
                + ", itinerary=" + PARIS.getItinerary()
                + ", date=" + PARIS.getDate()
                + ", customerNames=" + PARIS.getCustomerNames() + "}";
        assertEquals(expected, PARIS.toString());
    }
}
