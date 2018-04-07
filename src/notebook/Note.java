/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notebook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultListModel;

/**
 *
 * @author nihan
 */
public class Note {

    String name;
    String content;

    public String getContent(String name) {
        Connection conn = null;
        try {
            String url = "jdbc:sqlite:notebook.db";
            conn = DriverManager.getConnection(url);
            Statement stmt = null;
            stmt = conn.createStatement();

            String sql = "SELECT content FROM note WHERE name = \"" + name + "\";";
            ResultSet rs = stmt.executeQuery(sql);
            int i = 0;
            while (rs.next()) {
                this.content = rs.getString("content");

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return this.content;
    }

    public void create(String name, String content) {
                Connection conn = null;
        try {
            String url = "jdbc:sqlite:notebook.db";
            conn = DriverManager.getConnection(url);
            Statement stmt = null;
            stmt = conn.createStatement();
            String sql = "INSERT INTO note (name, content) VALUES(\"" + name + "\" , \"" + content + "\");";
            System.out.println(sql);
            stmt.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public void save(String name, String content) {
        Connection conn = null;
        try {
            String url = "jdbc:sqlite:notebook.db";
            conn = DriverManager.getConnection(url);
            Statement stmt = null;
            stmt = conn.createStatement();
            String sql = "UPDATE note SET content = \"" + content + "\"WHERE name = \"" + name + "\";";
            stmt.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public void delete(String name) {
                Connection conn = null;
        try {
            String url = "jdbc:sqlite:notebook.db";
            conn = DriverManager.getConnection(url);
            Statement stmt = null;
            stmt = conn.createStatement();
            String sql = "DELETE FROM note WHERE name = \"" + name + "\";";
            stmt.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
