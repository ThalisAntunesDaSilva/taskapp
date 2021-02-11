package br.com.tests;



import br.com.dao.TaskDAO;

public class TestJPA {

	public static void main(String[]args) {
		
		TaskDAO dao = new TaskDAO();
	 
		dao.remove(2);
		
		
	}
}
