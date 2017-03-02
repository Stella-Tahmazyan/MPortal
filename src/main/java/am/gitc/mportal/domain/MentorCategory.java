package am.gitc.mportal.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by RuBen on 30.11.2016.
 */
@Entity
@Table(name = "mentor_category")
public class MentorCategory {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "category_id")
    private int categoryId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MentorCategory that = (MentorCategory) o;

        if (userId != that.userId) return false;
        return categoryId == that.categoryId;

    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + categoryId;
        return result;
    }

    @Override
    public String toString() {
        return "MentorCategory{" +
                "id=" + id +
                ", userId=" + userId +
                ", categoryId=" + categoryId +
                '}';
    }
}
