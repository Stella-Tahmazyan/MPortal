package am.gitc.mportal.action;

import am.gitc.mportal.dao.impl.CategoryDaoImpl;
import am.gitc.mportal.dao.impl.CountryDaoImpl;
import am.gitc.mportal.dao.impl.UserDaoImpl;
import am.gitc.mportal.domain.*;
import am.gitc.mportal.util.Global_Keys;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.SessionAware;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by gtc-user34 on 11/17/2016.
 */
public class GlobalAction extends ActionSupport implements SessionAware, ApplicationAware {

    protected Map<String, Object> mapSession;
    protected Map<String, Object> mapApp;
    protected Map<String, List<Category>> map;
    private Gender[] genders = Gender.values();
    private Status[] status = Status.values();
    private CountryDaoImpl countryDaoImpl;
    private CategoryDaoImpl categoryDao;
    private UserDaoImpl userDao;
    private int userId;
   private User user;


    public GlobalAction() throws Exception {
        countryDaoImpl = new CountryDaoImpl();
        categoryDao = new CategoryDaoImpl();
        userDao = new UserDaoImpl();

    }

    @Override
    public void setSession(Map<String, Object> map) {
        mapSession = map;
    }


    @Override
    public void setApplication(Map<String, Object> map) {
        mapApp = map;
    }



    public User getUserFromSession() throws Exception{
        userId = (Integer) mapSession.get(Global_Keys.LOGIN);
        user = userDao.getById(userId);
        return user;
    }
    @Override
    public String execute() throws Exception {
        // get countrylist and Genders list and add to application scope
        List<Country> countries = countryDaoImpl.getAll();
        mapApp.put(Global_Keys.COUNTRY, countries);
        mapApp.put(Global_Keys.STATUS, status);
        mapApp.put(Global_Keys.GENDER, genders);



        //get category map and add application scope
        map = new HashMap<String, List<Category>>();
        List<Category> categoryList = categoryDao.getCategoryByParentId();
        for (Category list : categoryList) {
            String name = list.getName();
            int id = list.getId();
            List<Category> subCategoryList = categoryDao.getSubCategory(id);
            map.put(name, subCategoryList);
        }
        mapApp.put(Global_Keys.CATEGORY, map);
        return SUCCESS;
    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
