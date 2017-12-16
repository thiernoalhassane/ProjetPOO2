package releve;


import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author barry
 */
public class connection {

    public static Connection con;
    static ResultSet resultat;
    

    public static int Connecter(String url, String username, String pwd) {
        int verif = 1;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("echec");
        }
        try {
            String pilote = "jdbc:mysql://" + url + ":3306/gestiondereleve";
            //con est l'objet de la connection à la base de données
            con = DriverManager.getConnection(pilote, username, pwd);
        } catch (SQLException e) {

            System.out.println("la connexion a la base de donner à échouer");
            verif = 0;
        }
        return verif;
    }

    public static int maj(String requete) {
        int verif = 1;

        try {
            Statement stmt = con.createStatement();

            stmt.executeUpdate(requete);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("echec de la mise à jour");
            verif = 0;
        }
        return verif;
    }

    public static ResultSet interroger(String requete) {
        try {
            Statement stmt = con.createStatement();
            resultat = stmt.executeQuery(requete);
        } catch (SQLException e) {
            System.out.println("Interrogation de la base de donner à échouer");
        }
        return resultat;
    }

    public static ResultSet getResultat() {
        return resultat;
    }

    public static Connection getConnection() {
        return con;
    }

}
