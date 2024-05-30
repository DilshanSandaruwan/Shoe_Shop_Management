package lk.ijse.gdse66.ShoeShopFinal.service;


import lk.ijse.gdse66.ShoeShopFinal.auth.request.SignInRequest;
import lk.ijse.gdse66.ShoeShopFinal.auth.request.SignUpRequest;
import lk.ijse.gdse66.ShoeShopFinal.auth.response.JWTAuthResponse;

/**
 * @author: Dilshan Sandaruwan,
 * @Runtime version: 11.0.11+9-b1341.60 amd64
 **/

public interface AuthenticationService {
    JWTAuthResponse signIn(SignInRequest signInRequest);
    JWTAuthResponse signUp(SignUpRequest signUpRequest);
}
