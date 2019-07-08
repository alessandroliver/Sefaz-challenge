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

	public String saveEntity() {
		daoGeneric.save(userEntity);
		userEntity = new UserEntity();
		getUserList();

		return "";
	}

	public String merge() {
		userEntity = daoGeneric.merge(userEntity);
		getUserList();
		return "";
	}

	public void getUserList() {
		users = daoGeneric.getGenericList(UserEntity.class);

	}

	public List<UserEntity> getUsers() {
		return users;
	}

	public void setUsers(List<UserEntity> users) {
		this.users = users;
	}

	public String delete() {
		daoGeneric.deleteID(userEntity);
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
