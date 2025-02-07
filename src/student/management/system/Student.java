
package student.management.system;

import db.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Student {
    Connection con = DatabaseConnection.getConnection();
    PreparedStatement ps;

    // get table max row
    public int getMax() {
        int id = 0;
        Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery("select max(id) from student");
            while (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id+1;
    }
    
    //Insert data to the student Table 
public void insert(int id, String sname, String date, String gender, String email, 
                   String phone, String father, String mother, String address1, String address2)
        
{
        String sql = "insert into student values (?,?,?,?,?,?,?,?,?,?)";

try (Connection con = DatabaseConnection.getConnection();
     PreparedStatement ps = con.prepareStatement(sql)) {

    ps.setInt(1, id);
    ps.setString(2, sname);
    ps.setString(3, date);
    ps.setString(4, gender);
    ps.setString(5, email);
    ps.setString(6, phone);
    ps.setString(7, father);
    ps.setString(8, mother);
    ps.setString(9, address1); 
    ps.setString(10, address2);
   

    if (ps.executeUpdate() > 0) {
        JOptionPane.showMessageDialog(null, "New Student added successfully");
    }

} catch (SQLException ex) {
    Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
    JOptionPane.showMessageDialog(null, "Error adding student: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE); // Show error message to user
}
}

//Check student email address is already exists
public boolean isEmailExist(String email) {
    String query = "SELECT * FROM student WHERE email =?"; 

    try (Connection con = DatabaseConnection.getConnection(); 
         PreparedStatement ps = con.prepareStatement(query)) { 

        ps.setString(1, email);
        ResultSet rs = ps.executeQuery();

        return rs.next(); 

    } catch (SQLException ex) {
        Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        return false; 
    }
}

public boolean isphoneExist(String phone) {
    String query = "SELECT * FROM student WHERE email =?"; 

    try (Connection con = DatabaseConnection.getConnection(); 
         PreparedStatement ps = con.prepareStatement(query)) { 

        ps.setString(1, phone);
        ResultSet rs = ps.executeQuery();

        return rs.next(); 

    } catch (SQLException ex) {
        Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        return false; 
    }
}
  
        }