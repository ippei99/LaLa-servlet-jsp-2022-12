package model.logic;

import java.util.List;

import dao.DeptDAO;
import model.Dept;

public class GetDeptListLogic {
	public List<Dept> execute(){
		DeptDAO dao = new DeptDAO();		
		return dao.findAll();
	}

}
