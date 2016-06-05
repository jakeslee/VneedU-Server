package asia.gkc.vneedu.repository;

import asia.gkc.vneedu.model.User;
import tk.mybatis.mapper.common.Mapper;

public interface UserMapper extends Mapper<User> {
    User selectByPhone(String phone);

    User selectByAtId(String atId);
}