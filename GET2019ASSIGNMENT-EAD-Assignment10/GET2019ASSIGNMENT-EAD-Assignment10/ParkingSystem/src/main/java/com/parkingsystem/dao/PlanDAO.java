package com.parkingsystem.dao;

import java.sql.SQLException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import com.parkingsystem.factory.DatabaseQuery;
import com.parkingsystem.model.pojo.PlanPOJO;
import com.parkingsystem.service.SingleIntegerMapper;
import com.parkingsystem.factory.ConnectionFactory;

/**
 * This is dao class for Plan
 * @author Rahul
 *
 */
public class PlanDAO {

	//Singleton object of PlanDAO
	private static PlanDAO planDAO = null;
	//Object of JdbcTemplate
	private static JdbcTemplate jdbcTemplate = null;

	/**
	 * This method return object of PlanDAO class
	 * @return object of PlanDAO class
	 */
	public static PlanDAO getInstance(){

		if(planDAO == null){
			planDAO = new PlanDAO();
		}
		if(jdbcTemplate == null) {
			try {
				jdbcTemplate = new JdbcTemplate(new SingleConnectionDataSource(ConnectionFactory.getConnection() , true));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return planDAO;
	}

	/**
	 * This method add plan details to database
	 * @param planPOJO object of PlanPOJO containing details of plan
	 * @param empId employee id
	 * @return true if plan is added else false
	 * @throws SQLException exception related to database
	 * @throws Exception other general exception
	 */
	public boolean addPlan(PlanPOJO planPOJO, int empId) throws SQLException,Exception{

		int result = jdbcTemplate.update(DatabaseQuery.ADD_PLAN,planPOJO.getCurrency(),planPOJO.getType(),Double.parseDouble(planPOJO.getPrice()),empId);
		if(result > 0){
			return true;
		}else{
			return false;
		}
	}

	/**
	 * This method find and return id of plan from database
	 * @param empId employee id
	 * @return integer plan id
	 * @throws SQLException exception related to database
	 * @throws Exception other general exception
	 */
	public int getPlanId(int empId) throws SQLException,Exception {

		return jdbcTemplate.queryForObject(DatabaseQuery.GET_PLAN_ID,new Object[] {empId},new SingleIntegerMapper());
	}
}
