package ge.twino.service;
/**
 * Created by SHEMO on 12/21/2016.
 */
import ge.twino.model.SecurityUser;
import ge.twino.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class CustomUserDetailsService implements UserDetailsService {


    @Autowired
    private HttpServletRequest request;

    @Autowired
    private UserService userService;


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        /*String remoteAddr = request.getRemoteAddr();
        boolean ipChecked = false;
        */
        User user = userService.findByUsername(userName);

        if (user == null) {
            throw new UsernameNotFoundException("No Such User Found");
        }

        return new SecurityUser(user);

    }


}
