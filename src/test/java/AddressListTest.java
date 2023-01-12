

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


class AddressListTest {
    private AddressList addressList;

    @Before
    public void setUp() throws Exception {
        addressList = new AddressLinkedList();
        for (int i = 0; i < 100; i++) {
            addressList.add(new Address("Nevsky " + i, i));
        }
    }

    @Test
    public void whenAdded100ElementsThenSizeMustBe100() {
        assertEquals(100, addressList.size());
    }

    @Test
    public void whenElementRemovedByIndexThenSizeMustBeDecreased() {
        assertTrue(addressList.removeAt(5));
        assertEquals(99, addressList.size());
    }

    @Test
    public void whenElementRemovedThenSizeMustBeDecreased() {
        assertEquals(100, addressList.size());
        Address address = new Address("Vostaniya", 15);
        addressList.add(address);
        assertEquals(101, addressList.size());
        assertTrue(addressList.remove(address));
        assertEquals(100, addressList.size());
    }

    @Test
    public void whenNonExistElementRemovedThenReturnFalse() {
        Address address = new Address("Toyota", 15);
        assertFalse(addressList.remove(address));
        assertEquals(100, addressList.size());
    }

    @Test
    public void whenListClearedThenSizeMustBe0() {
        addressList.clear();
        assertEquals(0, addressList.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenIndexOutOfBoundsThenThrownException() {
        addressList.get(100);
    }

    @Test
    public void methodGetReturnedRightValue() {
        Address address = addressList.get(0);
        assertEquals("Brand 0", address.getStreet());
    }

    @Test
    public void insertIntoMiddle() {
        Address address = new Address("Utochkina", 5);
        addressList.add(address, 50);
        Address address1 = addressList.get(50);
        assertEquals("Utochkina",address1.getStreet());
    }

    @Test
    public void insertIntoFirstPosition() {
        Address address = new Address("Sizova", 5);
        addressList.add(address, 0);
        Address address1 = addressList.get(0);
        assertEquals("BMV",address1.getStreet());
    }

    @Test
    public void insertIntoLastPosition() {
        Address address = new Address("Sizova", 5);
        addressList.add(address, 100);
        Address address1 = addressList.get(100);
        assertEquals("Sizova",address1.getStreet());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void insertIntoIndexMoreThenSize() {
        Address address = new Address("Sizova", 5);
        addressList.add(address,101);
    }

}