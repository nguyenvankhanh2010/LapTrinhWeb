package service;


import models.UserModel;

public interface IUserService {
	UserModel login(String username, String password);
	
	UserModel FindByUserName(String username);
	boolean checkExistUsername(String username);
	UserModel get(String username);
	void insert(UserModel user);
	public boolean register(String email, String password, String username, String fullname, String phone, String images);

	boolean changePassword(String email, String newPassword);

	boolean checkExistEmail(String email);


}
