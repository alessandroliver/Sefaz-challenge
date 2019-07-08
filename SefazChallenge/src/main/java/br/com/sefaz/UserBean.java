package br.com.sefaz;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import br.com.dao.DaoGeneric;
import br.com.entities.UserEntity;

@ViewScoped
@ManagedBean(name = "userBean")
public class UserBean {

	private UserEntity userEntity = new UserEntity();
	private DaoGeneric<UserEntity> daoGeneric = new DaoGeneric<>();
	private List<UserEntity> users = new ArrayList<UserEntity>();
	private ArrayList<Phone> phones = new ArrayList<Phone>();

	public String saveEntity() {
		daoGeneric.save(userEntity);
		userEntity = new UserEntity();
		getUserList();

		return "";
	}

	public ArrayList<Phone> getPhones() {
		return phones;
	}

	public void setPhones(ArrayList<Phone> phones) {
		this.phones = phones;
	}

	public String addPhone(String ddd, String number, String type) {
		Phone phone = new Phone(Integer.parseInt(ddd), number, type);
		phones.add(phone);
		return "";

	}

	public String merge(String email, String name, String pass, Long id) {
		UserEntity e = new UserEntity(email, name, pass, id);
		daoGeneric.merge(e);
		getUserList();
		return "";
	}

	public void getUserList() {
		users = daoGeneric.getGenericList(UserEntity.class);

	}

	public String checkLogin(String email, String password) {
		users = daoGeneric.getGenericList(UserEntity.class);
		for (UserEntity user : users) {
			if (email.equals(user.getEmail())) {
				if (password.equals(user.getPassword())) {
					return "RegisterPage";
				}
			}

		}

		return "";

	}

	public List<UserEntity> getUsers() {
		return users;
	}

	public void setUsers(List<UserEntity> users) {
		this.users = users;
	}

	public String delete(String id) {
		daoGeneric.deleteID(id);
		getUserList();
		return "";
	}

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	public DaoGeneric<UserEntity> getDaoGeneric() {
		return daoGeneric;
	}

	public void setDaoGeneric(DaoGeneric<UserEntity> daoGeneric) {
		this.daoGeneric = daoGeneric;
	}

}
