package minhquyen.controller;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import minhquyen.modals.Response;
import minhquyen.modals.ResponseObject;
import minhquyen.modals.User;
import minhquyen.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/login")
public class AuthController {

    private final AuthService _auth;

    @Autowired
    public AuthController(AuthService auth){
        _auth = auth;
    }

    @PostMapping()
    @ApiOperation("Login")
    public ResponseObject Login(@RequestBody User user){
        ResponseObject data = _auth.Login(user);
        return data;
    }

}
