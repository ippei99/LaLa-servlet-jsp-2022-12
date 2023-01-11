package util;

import javax.servlet.http.HttpServletRequest;

import model.Dept;
import model.Employee;
import model.Gender;
import model.logic.GetDeptByIdLogic;
import model.logic.GetGenderByIdLogic;

public class MyTool {
	public Employee getEmpByParam(HttpServletRequest request) {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String gender_id = request.getParameter("gender");
		String birthday = request.getParameter("birthday");
		String dept_id = request.getParameter("dept");
		
		Gender gender = new GetGenderByIdLogic().execute(gender_id);
		Dept dept = new GetDeptByIdLogic().execute(dept_id);
		Employee emp = new Employee(id, name, gender, birthday, dept);
		return emp;
	}

}
