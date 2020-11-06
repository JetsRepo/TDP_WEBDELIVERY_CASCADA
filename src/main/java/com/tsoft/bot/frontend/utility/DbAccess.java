package com.tsoft.bot.frontend.utility;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbAccess {




   public List<String> selectTable(int column, String orderId, String nameTable) throws ClassNotFoundException, SQLException {

        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        Connection conn = DriverManager.getConnection
                ("jdbc:oracle:thin:@10.30.7.16:1521:SPT04Q", "embo", "qaqa9090");
        List<String> contnt=new ArrayList<>();
        Statement stmt = conn.createStatement();
       ResultSet rset = stmt.executeQuery("Select * from "+nameTable+" where ORDERID in ('"+orderId+"')");
        while (rset.next())
            contnt.add(rset.getString(column));

        stmt.close();

    return contnt;

    }


}
