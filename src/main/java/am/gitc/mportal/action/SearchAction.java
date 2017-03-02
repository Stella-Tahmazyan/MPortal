package am.gitc.mportal.action;

import am.gitc.mportal.dao.impl.CategoryDaoImpl;
import am.gitc.mportal.dao.impl.CountryDaoImpl;
import am.gitc.mportal.dao.impl.MentorCategoryImpl;
import am.gitc.mportal.dao.impl.UserDaoImpl;
import am.gitc.mportal.domain.Category;
import am.gitc.mportal.domain.Status;
import am.gitc.mportal.domain.User;
import am.gitc.mportal.util.Global_Keys;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.validation.SkipValidation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SearchAction extends GlobalAction implements ApplicationAware {
//region fields
    private UserDaoImpl userDao;
    private String searchKeyword;
    private List<User> userList;
    private CountryDaoImpl countryDaoImpl;
    private int countryId;
    private CategoryDaoImpl categoryDao;
    private MentorCategoryImpl mentorCategory;
    private int categoryId;
    private String userName;
    private List<User> searchList;
    private User user = new User();
    private List<User> userStatusList;
    private boolean searchStatus;

    Map<String, Object> mapApp;
    Map<String, List<Category>> map;
    //endregion
    public SearchAction() throws Exception{
        try {
            userDao = new UserDaoImpl();
            countryDaoImpl = new CountryDaoImpl();
            categoryDao = new CategoryDaoImpl();
            mentorCategory = new MentorCategoryImpl();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String execute() throws Exception {
        int id = (Integer) mapSession.get(Global_Keys.LOGIN);
        user = userDao.getById(id);

        userList = userDao.getSearchUserListByName(searchKeyword);
        if(userList.size()==0){
            addFieldError("searchKeyword","Nothing is find");
        }
        return SUCCESS;
    }

    @SkipValidation
    public String mentorSearch(){
        userStatusList = new ArrayList<User>();
        searchList = new ArrayList<User>();
        searchList = userDao.getUserByStatus(Status.MENTOR.name());
       if (searchList != null) {
           for (User userByStatus : searchList) {
               userStatusList.add(userByStatus);
           }
       }
        try {
            super.getUserFromSession();
        } catch (Exception e) {
            e.printStackTrace();
        }
       searchStatus = true;
        return SUCCESS;
    }

    @SkipValidation
    public String menteeSearch(){
        userStatusList = new ArrayList<User>();
        searchList = new ArrayList<User>();
        searchList = userDao.getUserByStatus(Status.MENTEE.name());
        if (searchList != null) {
            for (User userByStatus : searchList) {
                userStatusList.add(userByStatus);
            }
        }
        try {
            super.getUserFromSession();
        } catch (Exception e) {
            e.printStackTrace();
        }
        searchStatus = false;
        return SUCCESS;
    }

    @SkipValidation
    public String subCategorySearch()throws Exception{

        return SUCCESS;
    }

    @SkipValidation
    public String advancedSearch() throws Exception{
        int sessionUserId = (Integer) mapSession.get(Global_Keys.LOGIN);
        searchList = new ArrayList<User>();
        List<Integer> userIdList = mentorCategory.getUserIdByCategoryId(categoryId);
        for (int userId : userIdList) {
            User userObj=null;
            if (userName == null) {
                userObj = userDao.getUserAdvanceSearch(userId, "");
            } else if (userName != null) {
                userObj = userDao.getUserAdvanceSearch(userId, userName);
            }
            if (sessionUserId != userId) {
                searchList.add(userObj);
            }
        }
        if(searchList.size()==0){
            addFieldError("searchKeyword","Nothing is find");
        }
        return SUCCESS;
    }

    @Override
    public void setApplication(Map<String, Object> map) {
        mapApp = map;
    }
//region geter And seter
    public String getSearchKeyword() {
        return searchKeyword;
    }

    public void setSearchKeyword(String searchKeyword) {
        this.searchKeyword = searchKeyword;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<User> getSearchList() {
        return searchList;
    }

    public void setSearchList(List<User> searchList) {
        this.searchList = searchList;
    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getUserStatusList() {
        return userStatusList;
    }

    public void setUserStatusList(List<User> userStatusList) {
        this.userStatusList = userStatusList;
    }

    public boolean isSearchStatus() {
        return searchStatus;
    }

    public void setSearchStatus(boolean searchStatus) {
        this.searchStatus = searchStatus;
    }

    //endregion
}
