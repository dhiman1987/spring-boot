package com.dexter;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepo extends CrudRepository<TodoEntity, Long>{

	public List<TodoEntity> findByTitle(String title);
	public List<TodoEntity> findByDescriptionContains(String description);
	public List<TodoEntity> findByCategory_Name(String name);
	
	@Query("select t from TodoEntity t where t.complete=true and t.dueDate between :startDate and :endDate")
	public List<TodoEntity> findIncompleteTodosInTimeRange(@Param("startDate") Date startDate, @Param("endDate") Date endDate );
}
