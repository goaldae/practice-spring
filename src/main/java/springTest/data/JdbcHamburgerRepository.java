package springTest.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.*;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import springTest.Hamburger;

@Repository
public class JdbcHamburgerRepository implements HamburgerRepository{
	private JdbcTemplate jdbc;
	
	public JdbcHamburgerRepository(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}
	
	@Override
	public Hamburger save(Hamburger hamburger) {
		
		long hamburgerId = saveHamburgerInfo(hamburger);
		hamburger.setId(hamburgerId);
		
		return hamburger;
	}
	
	private long saveHamburgerInfo(Hamburger hamburger) {
		hamburger.setCreatedAt(new Date());
		PreparedStatementCreator psc = new PreparedStatementCreatorFactory("insert into hamburger (name, createdAt) values (?, ?)"
				, Types.VARCHAR, Types.TIMESTAMP).newPreparedStatementCreator(Arrays.asList(hamburger.getName(),
						new Timestamp(hamburger.getCreatedAt().getTime())));
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		jdbc.update(psc, keyHolder);
		
		return keyHolder.getKey().longValue();
	}

	@Override
	public Iterable<Hamburger> findAll() {		
		return jdbc.query("select id, name, createdAt from Hamburger", this::mapRowToHamburger);		
	}
	
	private Hamburger mapRowToHamburger(ResultSet rs, int rowNum) throws SQLException{
		return new Hamburger(rs.getLong("id"), rs.getString("name"), rs.getTime("createdAt"));
	}

}
