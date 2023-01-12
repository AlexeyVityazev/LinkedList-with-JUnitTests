public interface AddressList {


        Address get(int index);
        void add(Address address);

        void add(Address address, int index);
        boolean remove(Address address);
        boolean removeAt(int index);
        int size();
        void clear();


}
