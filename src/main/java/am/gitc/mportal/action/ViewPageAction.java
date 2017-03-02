package am.gitc.mportal.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by gtc-user29 on 12/13/2016.
 */
public class ViewPageAction extends ActionSupport {


    public String register() throws Exception {
        return "register";
    }

    public String login() throws Exception {
        return "login";
    }

    public String profile() throws Exception{
        return "profile";
    }

    public String allConversation() throws Exception{
        return "allConversation";
    }


    public String message() throws Exception{
        return "message";
    }

    public String dashboard() throws Exception{
        return "dashboard";
    }
}
