package com.armoury.backend.service;

import com.armoury.backend.config.BaseException;
import com.armoury.backend.dao.userModel.GetUserRes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.armoury.backend.dao.UserDao;

import static com.armoury.backend.config.BaseResponseStatus.DATABASE_ERROR;

@Service
public class UserService {

    final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public GetUserRes getUsersByIdx(int userIdx) throws BaseException {
        try{
            GetUserRes getUsersRes = userDao.getUsersByIdx(userIdx);
            return getUsersRes;
        }
        catch (Exception exception) {
            throw new BaseException(DATABASE_ERROR);
        }
    }
}
