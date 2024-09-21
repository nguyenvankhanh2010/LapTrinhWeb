package service.impl;
import dao.IUserDao;
import dao.impl.UserDaoImpl;
import models.UserModel;
import service.IUserService;

public class UserService implements IUserService {
	IUserDao userDao = new UserDaoImpl();

	@Override
	public UserModel login(String username, String password) {
		UserModel user = this.FindByUserName(username);
		if (user != null && password.equals(user.getPassword())) {
			return user;
		}
		return null;
	}
    @Override
    public UserModel get(String username)
    {
        return userDao.findByUserName(username);
    }
	@Override
	public UserModel FindByUserName(String username) {
		return userDao.findByUserName(username);
	}

	@Override
	public void insert(UserModel user) {
		userDao.insert(user);
		}

	@Override
	public boolean register(String email, String password, String username, String fullname, String phone, String images) {
		if (userDao.checkExistUsername(username)) {
			return false;
			}
			long millis=System.currentTimeMillis();
			java.sql.Date date=new java.sql.Date(millis);
			userDao.insert(new UserModel( username, password, images, fullname, email, phone, 1,date));
			return true;
	}

	@Override
	public boolean checkExistUsername(String username) {
		return userDao.checkExistUsername(username);

	}
	@Override
	public boolean changePassword(String email, String newPassword) {
	        return userDao.changePassword(email, newPassword);
	}
	@Override
	public boolean checkExistEmail(String email) {
		return userDao.checkExistEmail(email);
	}
	


}
