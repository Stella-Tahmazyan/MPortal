package am.gitc.mportal.action;

import am.gitc.mportal.action.GlobalAction;
import am.gitc.mportal.action.utils.MD5;
import am.gitc.mportal.dao.impl.UserDaoImpl;
import am.gitc.mportal.domain.Status;
import am.gitc.mportal.domain.User;
import am.gitc.mportal.util.Global_Keys;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import org.apache.struts2.interceptor.validation.SkipValidation;

import java.util.List;
import java.util.Map;

/**
 * Created by admin on 11/14/2016.
 */
public class LoginAction extends GlobalAction {

    private String email;
    private String password;
    private UserDaoImpl userDaoImpl;

    public LoginAction() throws Exception {
        userDaoImpl = new UserDaoImpl();

    }

    public String execute() throws Exception {
        User user = userDaoImpl.getUserByEmailPassword(email, MD5.encryptPassword(password));
        mapSession.put(Global_Keys.LOGIN, user.getId());
        return SUCCESS;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void validate() {
        try {

            User user = userDaoImpl.getUserByEmailPassword(email, MD5.encryptPassword(password));
            if (email.length() != 0 && password.length() != 0 && user == null) {
                addFieldError("email", "Your login or password is invalid");
            } else if (user != null && !user.isActive()) {
                addFieldError("email", "Please activate your profile ");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
