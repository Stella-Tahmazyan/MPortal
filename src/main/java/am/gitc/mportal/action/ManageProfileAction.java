package am.gitc.mportal.action;

import am.gitc.mportal.dao.impl.MentorCategoryImpl;
import am.gitc.mportal.dao.impl.UserDaoImpl;
import am.gitc.mportal.domain.MentorCategory;
import am.gitc.mportal.domain.User;
import com.opensymphony.xwork2.ModelDriven;

/**
 * Created by gtc-user29 on 12/19/2016.
 */
public class ManageProfileAction extends GlobalAction implements ModelDriven<User> {

    private User user;
    private UserDaoImpl userDao;
    private int categoryId;
    private MentorCategoryImpl mentorCategoryImpl;


    public ManageProfileAction() throws Exception {
        userDao = new UserDaoImpl();
        mentorCategoryImpl = new MentorCategoryImpl();
    }

    @Override
    public String execute() throws Exception {
        User users = super.getUserFromSession();
        MentorCategory mentorCategory = new MentorCategory();
        mentorCategory.setCategoryId(categoryId);
        mentorCategory.setUserId(user.getId());
        mentorCategoryImpl.create(mentorCategory);
        users.setDescription(user.getDescription());
        users.setSkills(user.getSkills());
        users.setExperience(user.getExperience());
        userDao.update(user);
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


    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }


    @Override
    public User getModel() {
        return user;
    }


    @Override
    public void validate() {
        try {
            User user = super.getUserFromSession();
            if (mentorCategoryImpl.getById(user.getId()) == null) {
                addFieldError("category", "choose your category");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
