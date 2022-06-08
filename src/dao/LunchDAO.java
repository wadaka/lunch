package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import model.Lunch;

public class LunchDAO {
	private Connection db;
	private PreparedStatement ps;
	private ResultSet rs;

	//接続共通処理
	private void connect() throws NamingException, SQLException {
		Context context = new InitialContext();
		DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/jsp");
		this.db = ds.getConnection();
	}

	//切断共通処理
	private void disconnect() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (db != null) {
				db.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Lunch> findAll() {
		List<Lunch> list = new ArrayList<>();
		try {
			this.connect();
			ps = db.prepareStatement("SELECT * FROM lunches");
			rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String menu = rs.getString("menu");
				Lunch lunch = new Lunch(id, name, menu);
				list.add(lunch);
			}
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		}finally {
			this.disconnect();
		}

		return list;
	}

	public void insertOne(Lunch lunch) {
		try {
			this.connect();
			ps=db.prepareStatement("INSERT INTO lunches(name,menu) VALUES(?,?)");
			ps.setString(1, lunch.getName());
			ps.setString(2, lunch.getMenu());
			ps.executeUpdate();
			System.out.println(ps);
		} catch (NamingException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}finally {
			this.disconnect();
		}

	}

	public Lunch findOne(int id) {
		Lunch lunch = null;
		try {
			this.connect();
			ps=db.prepareStatement("SELECT * FROM lunches WHERE id =?");
			ps.setInt(1, id);
			rs=ps.executeQuery();
			if(rs.next()) {
				String name=rs.getString("name");
				String menu=rs.getString("menu");
				lunch = new Lunch(id,name,menu);
			}
		} catch (NamingException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}finally {
			this.disconnect();
		}
		return lunch;
	}

	public void updateOne(Lunch lunch) {
		try {
			this.connect();
			ps=db.prepareStatement("UPDATE lunches SET name=?,menu=? WHERE id=?");
			ps.setString(1, lunch.getName());
			ps.setString(2, lunch.getMenu());
			ps.setInt(3, lunch.getId());
			ps.executeUpdate();
		} catch (NamingException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}finally {
			this.disconnect();
		}
	}

	public void deleteOne(int id) {
		try {
			this.connect();
			ps=db.prepareStatement("DELETE FROM lunches WHERE id=?");
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		}finally {
			this.disconnect();
		}
	}
}


