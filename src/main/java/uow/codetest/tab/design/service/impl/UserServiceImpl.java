package uow.codetest.tab.design.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uow.codetest.tab.design.repository.UserRepo;
import uow.codetest.tab.design.service.UserService;

/**
 * @author 	Tab Tu
 * @update  Tab Tu on Oct.16 2018
 * @since	1.0
 */

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

}