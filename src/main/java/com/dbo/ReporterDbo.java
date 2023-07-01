package com.dbo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

//import com.entity.Doctor;
import com.entity.reporter;

public class ReporterDbo {
	
	private Connection conn;

	public ReporterDbo(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public boolean doctorLeaves (reporter d) {
		boolean f = false;

		try {
			String sql = "insert into doct_leaves(doctname,leavesd,leaveed,status) values(?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, d.getDoctname());
			ps.setString(2, d.getLeavesd());
			ps.setString(3, d.getLeaveed());
			ps.setString(4, d.getStatus());
			
			

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}
	
	public List<reporter> getAllDetails() {
		List<reporter> list = new ArrayList<reporter>();
		reporter d = null;
		try {

			String sql = "select * from doct_leaves order by id desc";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				d = new reporter();
				d.setId(rs.getInt(1));
				d.setDoctname(rs.getString(2));
				d.setLeavesd(rs.getString(3));
				d.setLeaveed(rs.getString(4));
				d.setStatus(rs.getString(5));
				list.add(d);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}


}
