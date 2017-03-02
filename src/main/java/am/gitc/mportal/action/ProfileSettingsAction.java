package am.gitc.mportal.action;

import am.gitc.mportal.action.utils.MD5;
import am.gitc.mportal.dao.impl.CountryDaoImpl;
import am.gitc.mportal.dao.impl.UserDaoImpl;
import am.gitc.mportal.domain.Country;
import am.gitc.mportal.domain.User;
import am.gitc.mportal.util.Global_Keys;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import java.io.File;

/**
 * Created by gtc-user29 on 12/16/2016.
 */
public class ProfileSettingsAction extends GlobalAction implements ModelDriven<User> {

    private User user;
    private String newPassword;
    private UserDaoImpl userDao;
    private int countryId;
    private CountryDaoImpl countryDao;
    private String pictureFileName;
    private File picture;
    private String pictureContentType;


    public ProfileSettingsAction() throws Exception {
        userDao = new UserDaoImpl();
        countryDao = new CountryDaoImpl();
    }

//    public String execute() throws Exception {
//        super.getUserFromSession();
//        return SUCCESS;
//    }

    public String updateProfile() throws Exception {
        if(pictureFileName!=null){
            String filePath = "C:\\Users\\gtc-user29\\Desktop\\MPortal\\web\\images";
            String extension = FilenameUtils.getExtension(pictureFileName);
            pictureFileName = System.currentTimeMillis() + "_" + user.getName()+"."+extension;
            FileUtils.copyFile(picture, new File(filePath, pictureFileName));
        }
        Country country = countryDao.getById(countryId);
        int id = (Integer) mapSession.get(Global_Keys.LOGIN);
        User users = userDao.getById(id);
        users.setName(user.getName());
        users.setSurname(user.getSurname());
        users.setBirthDate(user.getBirthDate());
        if(!newPassword.isEmpty()){
            users.setPassword(MD5.encryptPassword(newPassword));
        }
        users.setCountry(country);
        if(pictureFileName!=null){
            users.setImageSRC(pictureFileName);
        }
        userDao.update(users);
        super.getUserFromSession();
        return SUCCESS;
    }

    @Override
    public User getUser() {
        return user;
    }

    @Override
    public void setUser(User user) {
        this.user = user;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }


    public File getPicture() {
        return picture;
    }

    public void setPicture(File picture) {
        this.picture = picture;
    }

    public String getPictureContentType() {
        return pictureContentType;
    }

    public void setPictureContentType(String pictureContentType) {
        this.pictureContentType = pictureContentType;
    }

    public String getPictureFileName() {
        return pictureFileName;
    }

    public void setPictureFileName(String pictureFileName) {
        this.pictureFileName = pictureFileName;
    }

    @Override
    public void validate() {
        int id = (Integer) mapSession.get(Global_Keys.LOGIN);
        try {
            if (!(user.getPassword().isEmpty()) && !(userDao.getById(id).getPassword()).equals(MD5.encryptPassword(user.getPassword()))) {
                if (newPassword.isEmpty()) {
                    addFieldError("user.password", "Please enter your right passsword");
                } else if (newPassword.length() < 2 || newPassword.length() > 20) {
                    addFieldError("newPassword", "Please enter valid new password");
                } else if (!newPassword.equals(user.getConfirmPassword())) {
                    addFieldError("user.confirmPassword", "Please enter valid confirmPassword");
                }
            } else if (!newPassword.isEmpty()) {
                if (user.getConfirmPassword().isEmpty()) {
                    addFieldError("user.confirmPassword", "Please enter confirmPassword");
                } else if (!newPassword.equals(user.getConfirmPassword())) {
                    addFieldError("user.confirmPassword", "Please enter valid confirmPassword");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getModel() {
        return user;
    }
}
