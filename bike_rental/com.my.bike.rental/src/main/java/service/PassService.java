package service;

import dao.PassDAO;
import model.Pass;

import java.util.List;

public class PassService {
	private PassDAO passDAO;

	public PassService() {
		passDAO = new PassDAO();
	}

	public void insertPass(Pass pass) {
		passDAO.save(pass);
	}

	public Pass selectPass(int passId) {
		return passDAO.getById(passId);
	}

	public List<Pass> selectAllPasses() {
		return passDAO.getAll();
	}

	public void updatePass(Pass pass) {
		passDAO.update(pass);
	}

	public void deletePass(int passId) {
		passDAO.delete(passId);
	}
}
