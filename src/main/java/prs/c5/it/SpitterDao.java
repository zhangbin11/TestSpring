package prs.c5.it;

import prs.c5.model.Spitter;

public interface SpitterDao {
	void insert(String name ,String password);
	
	Spitter getById(String id);
}
