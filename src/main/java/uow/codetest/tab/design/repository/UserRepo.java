package uow.codetest.tab.design.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uow.codetest.tab.design.model.User;

/**
 * User Repository
 *
 * @author 	Tab Tu
 * @update  Tab Tu on Oct.16 2018
 * @since	1.0
 */

@Repository
public interface UserRepo extends JpaRepository<User, String> {

}