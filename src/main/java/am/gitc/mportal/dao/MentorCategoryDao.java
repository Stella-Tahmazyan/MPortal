package am.gitc.mportal.dao;

import am.gitc.mportal.domain.MentorCategory;
import java.util.List;

/**
 * Created by RuBen on 01.12.2016.
 */
public interface MentorCategoryDao extends GlobalDao<MentorCategory> {

    List<Integer> getUserIdByCategoryId(int id);

    @Override
    void create(MentorCategory entity) throws Exception;
}
