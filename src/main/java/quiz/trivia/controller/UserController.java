package quiz.trivia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import quiz.trivia.service.UserService;
import quiz.trivia.utils.Res;
import quiz.trivia.utils.dto.request.UserRequest;
import quiz.trivia.utils.dto.response.UserResponse;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody UserRequest request) {
        UserResponse response = UserResponse.response(userService.create(request));
        return Res.renderJson(response, "User Created", HttpStatus.CREATED);
    } 

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        UserResponse response = UserResponse.response(userService.getUser(id));
        return Res.renderJson(response, "user found", HttpStatus.OK);
    } 

    @PutMapping
    public ResponseEntity<?> update(@RequestBody UserRequest request, @RequestParam Integer id) {
        UserResponse response = UserResponse.response(userService.update(request, id));
        return Res.renderJson(response, "name update successfully", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
