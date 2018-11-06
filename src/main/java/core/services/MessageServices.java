package core.services;

import core.dao.GroupDao;
import core.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageServices {


    @Autowired
    private GroupDao dao;

    public List getAllUserId() throws Exception {

        List users = dao.selectAll("user");

        return getUserListIds(users);

    }

    public List getUserIdInGroup(int gid) throws Exception {
        List userIds = new ArrayList();
        List users = dao.selectAllGroupUsers(gid);

        return getUserListIds(users);

    }

    private List getUserListIds(List users) throws Exception {
        List userIds = new ArrayList();

        for (Object user : users) {
            if (user instanceof User) {
                userIds.add(((User) user).getUid());
            } else {
                throw new Exception("类型异常");
            }
        }
        return userIds;
    }
}
