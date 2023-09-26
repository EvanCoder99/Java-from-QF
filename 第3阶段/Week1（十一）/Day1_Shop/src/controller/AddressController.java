package controller;

import entity.Address;
import entity.User;
import org.apache.commons.beanutils.BeanUtils;
import service.AddressService;
import service.impl.AddressServiceImpl;
import utils.ConstUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@WebServlet("/address")
public class AddressController extends BaseServlet {
    private AddressService addressService = new AddressServiceImpl();

    //添加地址
    public String add(HttpServletRequest request, HttpServletResponse respons) throws InvocationTargetException, IllegalAccessException {
        //获取前端参数的集合
        Map<String, String[]> map = request.getParameterMap();
        Address address = new Address();
        //将map存储的值，注入到地址实体，确保map的属性名和实体的属性名一致
        BeanUtils.populate(address, map);
        int res = addressService.addAddress(address);
        System.out.println("修改地址" + res);

        return ConstUtils.REDIRECT + "/address?action=show";
    }

    //展示地址
    public String show(HttpServletRequest request, HttpServletResponse respons) throws InvocationTargetException, IllegalAccessException {
        User user = (User) request.getSession().getAttribute(ConstUtils.LOGIN);
        List<Address> addresses = addressService.showAddress(user.getU_id());
        request.setAttribute("addList", addresses);  //self_info.jsp获取

        return ConstUtils.FORWARD + "/self_info.jsp";
    }

    //删除地址
    public String delete(HttpServletRequest request, HttpServletResponse respons) {
        String aid = request.getParameter("aid");
        int res = addressService.deleteById(aid);
        System.out.println("删除地址："+res);

        return ConstUtils.REDIRECT + "/address?action=show";
    }

    //修改地址
    public String update(HttpServletRequest request, HttpServletResponse respons) throws InvocationTargetException, IllegalAccessException {
        //获取前端参数集合
        Map<String, String[]> map = request.getParameterMap();
        Address address = new Address();

        //将map存储的值，注入到地址address实体，确保map的属性名和实体的属性名一致
        BeanUtils.populate(address,map);
        int res = addressService.updateAddress(address);
        System.out.println("修改地址：" + res);

        return ConstUtils.REDIRECT + "/address?action=show";
    }

    //创建默认地址
    public String createDefault(HttpServletRequest request, HttpServletResponse respons) {
        String aid = request.getParameter("aid");
        User user = (User) request.getSession().getAttribute(ConstUtils.LOGIN);
        int res = addressService.createDefault(aid, user.getU_id());

        return ConstUtils.REDIRECT + "/address?action=show";
    }
}