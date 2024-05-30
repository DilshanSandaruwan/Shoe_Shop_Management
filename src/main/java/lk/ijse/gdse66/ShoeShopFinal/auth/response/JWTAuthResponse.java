package lk.ijse.gdse66.ShoeShopFinal.auth.response;

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
public class JWTAuthResponse {
    private String token;
}
