package DB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Models.SaleOrder;

public class SaleOrderDB implements SaleOrderDBIF {

	public List<SaleOrder> getAll() throws SQLException {
		String sql = "select * from ";
		try (Statement s = DBConnection.getInstance().getConnection().createStatement()){
			ResultSet rs = s.executeQuery(sql);
			List<SaleOrder> res = buildObjects(rs);
			return res;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public SaleOrder create(SaleOrder saleOrder) throws SQLException {
		//String sql = String.format("insert into table_students (id, name) values ('%s', '%s')", saleOrder.getId(), saleOrder.getName());
		String sql = "";
		int id = DBConnection.getInstance().executeUpdate(sql);
		//saleOrder.setId(id);
		return saleOrder;
	}
	
	public SaleOrder update(SaleOrder saleOrder) throws SQLException {
		//String sql = "update table_students set name='" + saleOrder.getName() + "'" + "where id = " + saleOrder.getId() + "";
		String sql = "";
		int res = DBConnection.getInstance().executeUpdate(sql);
		return res == 1 ? saleOrder : null;
	}


	public boolean delete(int id) throws SQLException {
		String sql = "delete from table_students where id = " + id;
		int res = DBConnection.getInstance().executeUpdate(sql);
		return res > 0;
	}
	
	public SaleOrder findByName(String name) throws SQLException {
		SaleOrder res = null;
		String sql = "select * from table_students where name = " + name;
		System.out.println("StudentDb, Query: " + sql);
		try(Statement s = DBConnection.getInstance().getConnection().createStatement()) {
			ResultSet rs = s.executeQuery(sql);
			if(rs.next()) {
				res = buildObject(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		return res;				
	}
	
	private List<SaleOrder> buildObjects(ResultSet rs) throws SQLException {
		ArrayList<SaleOrder> res = new ArrayList<>();
		while(rs.next()) {
			SaleOrder b = buildObject(rs);
			res.add(b);
		}
		return res;
	}

	private SaleOrder buildObject(ResultSet rs) throws SQLException {
		SaleOrder b = null;
		//b = new SaleOrder(rs.getLong("id"), rs.getDate("createDate"), rs.getInt("discount"), rs.getFloat("amount"), rs.getBoolean("deliveryStatus"), rs.getBoolean("deliveryStatus"), rs.getLong("invoiceId"), rs.getLong("customerId"));
		return null;
	}
}
