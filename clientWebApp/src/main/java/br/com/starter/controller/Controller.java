package br.com.starter.controller;

import java.util.List;

import br.com.starter.dao.JpaDao;
import br.com.starter.model.User;

public class Controller {
	private JpaDao jpadao;

	public Controller() {
		jpadao = new JpaDao();
	}

	public void add(Object obj) {
		jpadao.add(obj);
	}

	public void update(Object obj) {
		jpadao.update(obj);
	}
	
	public Object findById(int id, String className){
		return jpadao.findById(id, className);
	}
	
	public List<?> findAll(String className){
		return jpadao.findAll(className);
	}
	
	public void remove(Object obj){
		jpadao.remove(obj);
	}
	
	public void removeById(int id, String className){
		jpadao.removeById(id, className);
	}
	
	public User login(String email, String password){
		return jpadao.login(email, password);
	}
}
