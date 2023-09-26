package service.impl;

import dao.AddressDao;
import dao.impl.AddressDaoImpl;
import entity.Address;
import service.AddressService;

import java.util.List;

public class AddressServiceImpl implements AddressService {
    private AddressDao addressDao = new AddressDaoImpl();
    @Override
    public List<Address> showAddress(int u_id) {
        try {
            return addressDao.selectAddress(u_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int addAddress(Address address) {
        try {
            return addressDao.addAddress(address);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteById(String aid) {
        try {
            return addressDao.deleteByAId(aid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updateAddress(Address address) {
        try {
            return addressDao.updateAddress(address);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int createDefault(String aid, int uId) {
        int res = 0;
        try {
            //1、设置当前所有用户状态为0
            res = addressDao.updateNoDefaultByUid(uId);
            System.out.println("设置非默认："+res);

            //2、设置当前a_id状态为1
            res = addressDao.updateDefaultByUid(aid);
            System.out.println("设置默认："+res);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
}
