package lk.ijse.gdse66.ShoeShopFinal.service;

import lk.ijse.gdse66.ShoeShopFinal.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * @author: Dilshan Sandaruwan,
 * @Runtime version: 11.0.11+9-b1341.60 amd64
 **/

public interface UserService {
    UserDetailsService userDetailService();
    List<UserDTO> getAllUser();
    UserDTO getUserDetails(String email,String role);
    UserDTO saveUser(UserDTO userDTO);
    void updateUser(String email, UserDTO userDTO);
    void deleteUser(String email);
}
