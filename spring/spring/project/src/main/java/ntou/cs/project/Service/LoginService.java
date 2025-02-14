package ntou.cs.project.Service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import ntou.cs.project.repository.*;
import ntou.cs.project.Common.*;

@Service
public class LoginService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {

        User dbUser = userRepository.findByEmail(account);

        if (dbUser == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return new CustomUserDetails(dbUser);
    }

}
