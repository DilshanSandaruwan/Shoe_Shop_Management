package lk.ijse.gdse66.ShoeShopFinal.api;

import lk.ijse.gdse66.ShoeShopFinal.auth.request.SignInRequest;
import lk.ijse.gdse66.ShoeShopFinal.auth.request.SignUpRequest;
import lk.ijse.gdse66.ShoeShopFinal.auth.response.JWTAuthResponse;
import lk.ijse.gdse66.ShoeShopFinal.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Dilshan Sandaruwan,
 * @Runtime version: 11.0.11+9-b1341.60 amd64
 **/

@RestController
@RequestMapping("api/v0/auth")
@RequiredArgsConstructor
public class LoginAPI {
    private final AuthenticationService authenticationService;

    @PostMapping("/signin")
    public ResponseEntity<JWTAuthResponse> signIn(
            @RequestBody SignInRequest signInRequest){
        System.out.println("Signing in");
        return ResponseEntity.ok(
                authenticationService.signIn(signInRequest));
    }

    @PostMapping("/signup")
    public ResponseEntity<JWTAuthResponse> signUp(
            @RequestBody SignUpRequest signUpRequest){
        return ResponseEntity.ok(
                authenticationService.signUp(signUpRequest));
    }
}
