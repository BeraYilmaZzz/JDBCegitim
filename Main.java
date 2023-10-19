import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try {
            Connection connect = DriverManager.getConnection(
                    "jdbc:mysql://localhost/jdbcegitim",
                    "root",
                    "mysql"
            );
            String sql = "INSERT INTO employees (name,position,salary) VALUES(?,?,?)";
            PreparedStatement sta = connect.prepareStatement(sql);
            sta.setString(1,"ALİ");
            sta.setString(2,"Mdr");
            sta.setString(3,"10000");
            sta.executeUpdate();

            sta.setString(1,"HALİL");
            sta.setString(2,"Hoca");
            sta.setString(3,"7000");
            sta.executeUpdate();

            sta.setString(1,"SABRİ");
            sta.setString(2,"Çaycı");
            sta.setString(3,"5000");
            sta.executeUpdate();

            sta.setString(1,"VELİ");
            sta.setString(2,"Mdr.Yrd");
            sta.setString(3,"8000");
            sta.executeUpdate();

            sta.setString(1,"MURAT");
            sta.setString(2,"Bekçi");
            sta.setString(3,"5000");
            sta.executeUpdate();

            PreparedStatement st = connect.prepareStatement("SELECT * FROM employees");
            ResultSet res = st.executeQuery();
            while(res.next()){
                System.out.print("-" + res.getInt("id"));
                System.out.print("-" + res.getString("name"));
                System.out.print("-" + res.getString("position"));
                System.out.println("-" + res.getInt("salary"));
            }


        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}