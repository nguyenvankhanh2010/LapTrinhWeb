package dao;

import java.util.List;

import models.UserModel;

public interface IUserDao {
	List<UserModel> findAll();

	UserModel findById(int id);

	void insertregister(UserModel user);

	UserModel findByUserName(String username);

	void insert(UserModel user);

	boolean checkExistUsername(String username);
	
    boolean changePassword(String email, String newEncodedPassword);

	boolean checkExistEmail(String email);


}
