package lk.ijse.gdse66.ShoeShopFinal.auth.request;

import lk.ijse.gdse66.ShoeShopFinal.service.util.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: Dilshan Sandaruwan,
 * @Runtime version: 11.0.11+9-b1341.60 amd64
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignInRequest {
    private String email;
    private String password;
    private Role role;
}
