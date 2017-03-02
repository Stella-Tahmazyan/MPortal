package am.gitc.mportal.action;

import am.gitc.mportal.dao.UserDao;
import am.gitc.mportal.dao.impl.UserDaoImpl;
import am.gitc.mportal.domain.User;
import org.apache.struts2.interceptor.ServletRequestAware;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

public class ImageAction extends GlobalAction implements ServletRequestAware {

    byte[] imageInByte = null;
    private int id;
    private UserDaoImpl userDao;

    private HttpServletRequest servletRequest;

    public ImageAction() throws Exception {
        userDao= new UserDaoImpl();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String execute() throws Exception {
        return SUCCESS;
    }

    public byte[] getCustomImageInBytes() throws Exception{
        String imgId;
        BufferedImage originalImage;
        try {
            User user=userDao.getById(id);
            imgId=user.getImageSRC();
            originalImage = ImageIO.read(getImageFile(imgId));
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(originalImage, "jpg", baos);
            baos.flush();
            imageInByte = baos.toByteArray();
            baos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return imageInByte;
    }

    private File getImageFile(String imageId) {
        String filePath = "C:\\Users\\gtc-user29\\Desktop\\MPortal\\web\\images\\";
        File file = new File(filePath + imageId);
        return file;
    }

    public String getCustomContentType() {
        return "image/jpeg";
    }

    public String getCustomContentDisposition() {
        return "anyname.jpg";
    }

    public void setServletRequest(HttpServletRequest request) {
        this.servletRequest = request;

    }


}
