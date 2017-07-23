package prs.c5.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import prs.c5.it.SpitterDao;
import prs.c5.model.Spitter;

@Repository("spitterDao")
public class SpitterDaoImpl implements SpitterDao{
	
	private static final String SQL_INSERT = "insert into spitter(`id`,`username`,`password`)"
			+ "values (?,?,?);";
	
	private static final String SQL_GETBYID = "select `id`,`username`,`password` from spitter where id=?";

	@Resource(name="jdbcTemplate")
	private JdbcTemplate template;
	

	@Override
	public Spitter getById(String id) {
		Spitter r = template.queryForObject(SQL_GETBYID,new RowMapper<Spitter>() {

			@Override
			public Spitter mapRow(ResultSet rs, int col) throws SQLException {
				Spitter sp = new Spitter();
				sp.setId(rs.getString("id"));
				sp.setUsername(rs.getString("username"));
				sp.setPassword(rs.getString("password"));
				return sp;
			}
		},id);
		return r;
	}

	@Override
	public void insert(String name, String password) {
		template.update(SQL_INSERT, UUID.randomUUID().toString(),name,password);
	}

}
