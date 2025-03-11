package com.LucaP111.ProiectJava;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class CartiDBRepository implements CarteRepository {

    private JdbcUtils dbUtils;
    private static final Logger logger = LogManager.getLogger();

    public CartiDBRepository(Properties props) {
        logger.info("Initializing com.LucaP111.ProiectJava.CartiDBRepository with properties: {} ", props);
        dbUtils = new JdbcUtils(props);
    }

    private Connection getConnection() {
        return dbUtils.getConnection();
    }

    @Override
    public List<Carte> findByManufacturer(String author) {
        logger.traceEntry("Finding books by author: {}", author);
        List<Carte> carti = new ArrayList<>();

        String query = "SELECT * FROM Carte WHERE author = ?";
        try (Connection con = getConnection();
             PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, author);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                carti.add(mapResultSetToCarte(rs));
            }
        } catch (SQLException e) {
            logger.error("Error finding books by author", e);
        }

        return carti;
    }

    @Override
    public List<Carte> findBetweenYears(int min, int max) {
        logger.traceEntry("Finding books published between {} and {}", min, max);
        List<Carte> carti = new ArrayList<>();

        String query = "SELECT * FROM Carte WHERE publication BETWEEN ? AND ?";
        try (Connection con = getConnection();
             PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setInt(1, min);
            stmt.setInt(2, max);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                carti.add(mapResultSetToCarte(rs));
            }
        } catch (SQLException e) {
            logger.error("Error finding books by publication years", e);
        }

        return carti;
    }

    @Override
    public void add(Carte carte) {
        logger.traceEntry("Adding book: {}", carte);

        String query = "INSERT INTO Carte (author, publication, nr_pages) VALUES (?, ?, ?)";
        try (Connection con = getConnection();
             PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, carte.getAuthor());
            stmt.setInt(2, carte.getPublication());
            stmt.setInt(3, carte.getNrPages());
            stmt.executeUpdate();
        } catch (SQLException e) {
            logger.error("Error adding book", e);
        }
    }

    @Override
    public void update(Integer id, Carte carte) {
        logger.traceEntry("Updating book with id: {}", id);

        String query = "UPDATE Carte SET author = ?, publication = ?, nr_pages = ? WHERE id = ?";
        try (Connection con = getConnection();
             PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, carte.getAuthor());
            stmt.setInt(2, carte.getPublication());
            stmt.setInt(3, carte.getNrPages());
            stmt.setInt(4, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            logger.error("Error updating book", e);
        }
    }

    @Override
    public Iterable<Carte> findAll() {
        logger.traceEntry("Finding all books");
        List<Carte> carti = new ArrayList<>();

        String query = "SELECT * FROM Carte";
        try (Connection con = getConnection();
             PreparedStatement stmt = con.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                carti.add(mapResultSetToCarte(rs));
            }
        } catch (SQLException e) {
            logger.error("Error finding all books", e);
        }

        return carti;
    }

    private Carte mapResultSetToCarte(ResultSet rs) throws SQLException {
        Carte c = new Carte(rs.getString("author"), rs.getInt("publication"), rs.getInt("nr_pages"));
        c.setId(rs.getInt("id"));
        return c;

    }
}