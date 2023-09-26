package service;

import entity.Address;

import java.util.List;

public interface AddressService {
    List<Address> showAddress(int u_id);

    int addAddress(Address address);

    int deleteById(String aid);

    int updateAddress(Address address);

    int createDefault(String aid, int uId);
}
