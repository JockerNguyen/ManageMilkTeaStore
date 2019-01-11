package app.util;

import app.bean.UserInfo;
import app.model.User;
import app.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class ConvertNewUserUtils {

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    private RoleService roleService;


    public User convertNewUser(UserInfo userInfo) {
        User newUser = new User();
        newUser.setEmail(userInfo.getEmail());
        newUser.setPassword(encoder.encode(userInfo.getPassword()));
        newUser.setRole(roleService.findByName("ROLE_CUSTOMER"));

        return newUser;

    }
}
