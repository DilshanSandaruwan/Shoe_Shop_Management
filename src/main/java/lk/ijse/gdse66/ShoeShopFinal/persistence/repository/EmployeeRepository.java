package lk.ijse.gdse66.ShoeShopFinal.persistence.repository;

import lk.ijse.finalcoursework.shoeshop.persistence.entity.Employee;
import lk.ijse.gdse66.ShoeShopFinal.persistence.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: Dilshan Sandaruwan,
 * @Runtime version: 11.0.11+9-b1341.60 amd64
 **/

public interface EmployeeRepository extends JpaRepository<Employee,String> {
    //List<Employee>findAllByAndOrderByDobDesc();
    Boolean existsByEmployeeCode(String id);
    Employee findByEmployeeCode(String id);
    void deleteByEmployeeCode(String id);
}
