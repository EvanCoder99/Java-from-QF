package service.impl;

import dao.TypeDao;
import dao.impl.TypeDaoImpl;
import entity.Type;
import service.TypeService;

import java.sql.SQLException;
import java.util.List;

public class TypeServiceImpl implements TypeService {
    private TypeDao typeDao = new TypeDaoImpl();
    @Override
    public List<Type> showAll() {
        try {
            return typeDao.selectTypes();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
