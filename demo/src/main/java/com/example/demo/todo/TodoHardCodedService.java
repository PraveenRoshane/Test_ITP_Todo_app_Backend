package com.example.demo.todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoHardCodedService {
	
	private static List<Todo> todos = new ArrayList<Todo>();
	private static Long IDCounter = (long) 0;
	
	static{
		todos.add(new Todo(++IDCounter, "Chamal", "Learn to Dance", new Date(), false));
		todos.add(new Todo(++IDCounter, "Chamal", "Learn to Sing", new Date(), false));
		todos.add(new Todo(++IDCounter, "Chamal", "Learn to Gaming", new Date(), false));
		todos.add(new Todo(++IDCounter, "Chamal", "Learn about Anguler", new Date(), false));
	}
	
	public List<Todo> findAll(){
		return todos;
	}
	
	public Todo deleteById(long id) {
		Todo todo = findById(id);
		
		if(todo==null)return null;

		else if(todos.remove(todo)) {
			return todo;
		}
		
		return null;
	}

	public Todo findById(long id) {
		for(Todo todo:todos) {
			if(todo.getId()==id) {
				return todo;			}
		}
		return null;
	}
	
	public Todo save(Todo todo) {
		if(todo.getId()==-1 || todo.getId()==0) {
			todo.setId(++IDCounter);
			todos.add(todo);
		}else {
			deleteById(todo.getId());
			todos.add(todo);
		}
		return todo;
	}

}
