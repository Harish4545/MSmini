package in.nareshit.raghu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.nareshit.raghu.entity.User;
import in.nareshit.raghu.entity.UserRequest;
import in.nareshit.raghu.entity.UserResponse;
import in.nareshit.raghu.service.IUserService;
import in.nareshit.raghu.util.JwtUtil;

@RestController
@RequestMapping("/auth")
public class UserController {

	@Autowired
	private IUserService service;

	@Autowired
	private JwtUtil jwtUtil;

	@PostMapping("/register")
	public ResponseEntity<String> saveUser(@RequestBody User user) {
		Integer id=service.saveUser(user);
		return ResponseEntity.ok("User saved with id"+id);
	}

	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody UserRequest userRequest)
	{
		if(service.isUserExist(userRequest))
		{
			String token=jwtUtil.generateToken(userRequest.getUsername());
			return ResponseEntity.ok(new UserResponse(token,"GENERATED BY MR.RAGHU -NIT"));
		} else {
			return ResponseEntity.ok(new UserResponse("NO TOKEN","USER NOT EXIST!!"));
		}
	}


}
