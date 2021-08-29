package DAO;

import java.util.List;

import Model.Boardnew;

public interface BoardnewDao {
	void insert(Boardnew boardnew);

	void edit(Boardnew boardnew);

	void delete(int id);

	Boardnew get(int id);
	
	Boardnew get(String name);

	List<Boardnew> getAll();
}
