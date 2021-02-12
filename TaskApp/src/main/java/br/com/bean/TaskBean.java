package br.com.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.dao.TaskDAO;
import br.com.entidades.Task;

@ViewScoped
@ManagedBean(name = "taskBean")
public class TaskBean {

	private Task task = new Task();
	private TaskDAO<Task> daoGeneric = new TaskDAO<Task>();
	private List<Task> tasks = new ArrayList<Task>();
	
	
	
	public List<Task> getTarefas(){
		return tasks;
	}
	
	public void carregarTarefas() {
		tasks = daoGeneric.getListEntity(Task.class);
		
	}
	
	public String salvar() {
		task = daoGeneric.merge(task);
		carregarTarefas();
		return " ";
	}

	public String novo() {

		task = new Task();

		return "";
	}

	public String remove() {
		int id = task.getId();
		daoGeneric.remove(id);
		task = new Task();
		carregarTarefas();
		return " ";
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public TaskDAO<Task> getDaoGeneric() {
		return daoGeneric;
	}

	public void setDaoGeneric(TaskDAO<Task> daoGeneric) {
		this.daoGeneric = daoGeneric;
	}

}
