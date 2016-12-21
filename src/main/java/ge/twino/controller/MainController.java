package ge.twino.controller;

import ge.twino.dto.UserDTO;
import ge.twino.exeption.TwinoExeption;
import ge.twino.model.User;
import ge.twino.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
public class MainController {

    @Autowired
    private UserService userService;


    @RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, value = "/saveUser", method = RequestMethod.POST)
    public ResponseEntity<?> saveUser(@RequestBody User user) throws TwinoExeption {
        userService.saveUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/getUserList")
    public Page<User> getClientList(@RequestParam int page,
                                    @RequestParam int count) throws Exception {
        return userService.findAll(new PageRequest(page, count));
    }

    @RequestMapping(value = "/getUserDetails/{userID}")
    public ResponseEntity<User> getUserDetails(@PathVariable Long userID) {
        return new ResponseEntity<>(userService.findUserById(userID), HttpStatus.OK);
    }

    @RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, value = "/updateUser", method = RequestMethod.POST)
    public ResponseEntity<?> updateUser(@RequestBody UserDTO userDTO) throws TwinoExeption {
        userService.updateUser(userDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/getCurrentUser")
    public ResponseEntity<User> getCurrentUser() {
        return new ResponseEntity<>(userService.getCurrentUser(), HttpStatus.OK);
    }


}
