package ge.twino.service;

import ge.twino.dto.UserDTO;
import ge.twino.exeption.TwinoExeption;
import ge.twino.model.ImageVisibilityMode;
import ge.twino.model.SecurityUser;
import ge.twino.model.User;
import ge.twino.repository.UserRepository;
import org.joda.time.DateTime;
import org.joda.time.Years;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public User saveUser(User user) throws TwinoExeption {
        verifyUser(user);
        if (user.getImageVisibilityMode() == null) {
            user.setImageVisibilityMode(ImageVisibilityMode.PRIVATE);
        }
        return userRepository.save(user);
    }


    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    public void verifyUser(User user) throws TwinoExeption {
        int age = Years.yearsBetween(new DateTime(user.getBirthday()), new DateTime()).toPeriod().getYears();

        if (age <= 21) {
            throw new TwinoExeption(1001, "Registration Not Allowed under 21");
        }

        if (age < 21 & age > 75) {
            user.setLimits(BigDecimal.ZERO);
        } else {
            // Calculating using given Formula : ageInYears * 100 + salary - liabilities
            user.setLimits((new BigDecimal(age * 100).add(user.getSalary())).subtract(user.getLiabilities()));
        }

    }

    public User findUserById(Long id) {
        return userRepository.findOne(id);
    }

    public User findByUsername(String name) {
        return userRepository.findByUsername(name);
    }

   /* public Page<User> getUsersList(Pageable pageable) {

        return (Page<User>) userRepository.findAll(pageable);
    }*/

    public void delete(Long id) {
        userRepository.delete(id);
    }

    public void updateUser(UserDTO userDTO) throws TwinoExeption {
        User user = userRepository.getOne(userDTO.getId());
        if(userDTO.getBirthday()!=null){
            if (user.isBirthdayChanged()){
                throw new TwinoExeption(10002,"Birthday change is allowed only ones");
            }
        }
        user.setName(userDTO.getName());
        user.setSalary(userDTO.getSalary());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setLiabilities(user.getLiabilities());
        user.setImageVisibilityMode(userDTO.getImageVisibilityMode());

        if(!user.getBirthday().equals(userDTO.getBirthday())){
            user.setBirthdayChanged(true);
            user.setBirthday(userDTO.getBirthday());
        }

        userRepository.save(user);
    }


    @Transactional(readOnly = true)
    public User getCurrentUser() {
        try {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (principal instanceof UserDetails) {
                String username = ((UserDetails) principal).getUsername();
                User loginUser = findByUsername(username);
                return new SecurityUser(loginUser);
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }

}