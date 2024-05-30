package lk.ijse.gdse66.ShoeShopFinal.persistence.repository;

import lk.ijse.finalcoursework.shoeshop.persistence.entity.User;
import lk.ijse.gdse66.ShoeShopFinal.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author: Dilshan Sandaruwan,
 * @Runtime version: 11.0.11+9-b1341.60 amd64
 **/

public interface SecurityRepository extends JpaRepository<User,String> {
    Optional<User> findByEmail(String email);
}
