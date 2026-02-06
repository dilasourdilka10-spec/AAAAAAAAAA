package com.example.AAAAAAAAAA;

import org.springframework.stereotype.Repository;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SongRepository {
    private final String url = "jdbc:postgresql://localhost:12345/musicdb";
    private final String user = "postgres";
    private final String password = "2008";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public List<Song> findAll() {
        List<Song> songs = new ArrayList<>();
        String sql = "SELECT * FROM songs";
        try (Connection c = getConnection(); Statement st = c.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                songs.add(new Song(rs.getString("title"), rs.getString("artist"), rs.getInt("duration"), rs.getString("genre")));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return songs;
    }

    public void save(Song s) {
        String sql = "INSERT INTO songs (title, artist, duration, genre) VALUES (?, ?, ?, ?)";
        try (Connection c = getConnection(); PreparedStatement p = c.prepareStatement(sql)) {
            p.setString(1, s.getTitle());
            p.setString(2, s.getArtist());
            p.setInt(3, s.getDuration());
            p.setString(4, s.getGenre());
            p.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void update(String title, int duration, String genre) {
        String sql = "UPDATE songs SET duration = ?, genre = ? WHERE title = ?";
        try (Connection c = getConnection(); PreparedStatement p = c.prepareStatement(sql)) {
            p.setInt(1, duration);
            p.setString(2, genre);
            p.setString(3, title);
            p.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void delete(String title) {
        String sql = "DELETE FROM songs WHERE title = ?";
        try (Connection c = getConnection(); PreparedStatement p = c.prepareStatement(sql)) {
            p.setString(1, title);
            p.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }
}