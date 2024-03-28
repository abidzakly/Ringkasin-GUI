package controller;

import java.awt.Component;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.*;
import view.auth.*;
import view.admin.*;
import view.pembaca.*;
import view.penulis.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author HP PAVILION
 */
public class Application {

    private Connection conn;
    private final Koneksi k = new Koneksi();
    private ArrayList<Pembaca> dataPengguna = new ArrayList<>();
    private static String loggedInUsername;

    //SELECT
    public ArrayList<Ringkasan> getCurrentRingkasan(int bookId, int peringkasId) throws SQLException {
        ArrayList<Ringkasan> currentRingkasan = new ArrayList<>();
        conn = k.getConnection();
        String kueri = "SELECT b.*, u.*, r.* "
                + "FROM ringkasan r "
                + "JOIN buku b ON r.book_id = b.id "
                + "JOIN users u ON u.id = r.user_id "
                + "WHERE r.book_id = ? AND r.user_id = ?";
        PreparedStatement ps = conn.prepareStatement(kueri);
        ps.setInt(1, bookId);
        ps.setInt(2, peringkasId);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Ringkasan r = new Ringkasan();
            r.setIdRingkasan(rs.getInt("r.id"));
            r.setBookId(rs.getInt("b.id"));
            r.setTitle(rs.getString("b.title"));
            r.setAuthor(rs.getString("b.author"));
            r.setTotal_page(rs.getString("b.total_page"));
            r.setPub_year(rs.getString("b.pub_year"));
            r.setIsbn(rs.getString("b.isbn"));
            r.setGenre(rs.getString("b.genre"));
            r.setContent(rs.getString("r.content"));
            r.setPeringkas(rs.getString("u.fullname"));
            r.setFilename(rs.getString("b.filename"));
            r.setStatus(rs.getInt("r.status"));
            currentRingkasan.add(r);
        }
        return currentRingkasan;
    }

    public ArrayList<Buku> getAllBuku() throws SQLException {
        ArrayList<Buku> listBuku = new ArrayList<>();
        conn = k.getConnection();
        String kueri = "SELECT b.*, u.fullname, sb.status "
                + "FROM statusbuku sb "
                + "JOIN buku b ON sb.book_id = b.id "
                + "JOIN users u ON sb.user_id = u.id";
        PreparedStatement ps = conn.prepareStatement(kueri);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Buku buku = new Buku();
            buku.setTitle(rs.getString("b.title"));
            buku.setAuthor(rs.getString("b.author"));
            buku.setTotal_page(rs.getString("b.total_page"));
            buku.setPub_year(rs.getString("b.pub_year"));
            buku.setIsbn(rs.getString("b.isbn"));
            buku.setGenre(rs.getString("b.genre"));
            buku.setBookId(rs.getInt("b.id"));
            buku.setPemohon(rs.getString("u.fullname"));
            buku.setFilename(rs.getString("b.filename"));
            buku.setStatus(rs.getInt("sb.status"));
            listBuku.add(buku);
        }
        rs.close();
        ps.close();
        conn.close();
        return listBuku;
    }
    public ArrayList<Buku> getPostedBooks() throws SQLException {
        ArrayList<Buku> listBuku = new ArrayList<>();
        conn = k.getConnection();
        String kueri = "SELECT b.*, u.fullname, sb.status "
                + "FROM statusbuku sb "
                + "JOIN buku b ON sb.book_id = b.id "
                + "JOIN users u ON sb.user_id = u.id "
                + "WHERE NOT sb.status = 0";
        PreparedStatement ps = conn.prepareStatement(kueri);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Buku buku = new Buku();
            buku.setTitle(rs.getString("b.title"));
            buku.setAuthor(rs.getString("b.author"));
            buku.setTotal_page(rs.getString("b.total_page"));
            buku.setPub_year(rs.getString("b.pub_year"));
            buku.setIsbn(rs.getString("b.isbn"));
            buku.setGenre(rs.getString("b.genre"));
            buku.setBookId(rs.getInt("b.id"));
            buku.setPemohon(rs.getString("u.fullname"));
            buku.setFilename(rs.getString("b.filename"));
            buku.setStatus(rs.getInt("sb.status"));
            listBuku.add(buku);
        }
        rs.close();
        ps.close();
        conn.close();
        return listBuku;
    }

    public ArrayList<Pembaca> getCurrentPengguna() throws SQLException {
        ArrayList<Pembaca> currentPengguna = new ArrayList<>();
        //langkah 1
        conn = k.getConnection();
        //langkah 2
        String kueri = "SELECT * FROM users WHERE username = ?";
        PreparedStatement ps = conn.prepareStatement(kueri);
        ps.setString(1, loggedInUsername);
        //langkah 3
        ResultSet rs = ps.executeQuery();
        //langkah 4
        while (rs.next()) {
            int id = rs.getInt("id");
            int type = rs.getInt("type");
            String fullname = rs.getString("fullname");
            String username = rs.getString("username");
            String email = rs.getString("email");
            String password = rs.getString("password");
            Pembaca p = new Pembaca(fullname, username, email, password);
            p.setType(type);
            p.setUserId(id);
            currentPengguna.add(p);
        }
        //langkah 5
        rs.close();
        ps.close();
        conn.close();
        return currentPengguna;
    }

    public ArrayList<Ringkasan> getAllRingkasan() throws SQLException {
        ArrayList<Ringkasan> daftar = new ArrayList<>();
        //langkah 1
        conn = k.getConnection();
        //langkah 2
        String kueri = "SELECT u.*, b.*, b.title, b.genre, r.status, r.content "
                + "FROM ringkasan r "
                + "JOIN users u ON r.user_id = u.id "
                + "JOIN buku b ON r.book_id = b.id "
                + "ORDER BY b.title ASC";
        PreparedStatement ps = conn.prepareStatement(kueri);
        //langkah 3
        ResultSet rs = ps.executeQuery();
        //langkah 4
        while (rs.next()) {
            Ringkasan r = new Ringkasan();
            r.setBookId(rs.getInt("b.id"));
            r.setPeringkas(rs.getString("u.fullname"));
            r.setUserId(rs.getInt("u.id"));
            r.setTitle(rs.getString("b.title"));
            r.setGenre(rs.getString("b.genre"));
            r.setContent(rs.getString("r.content"));
            r.setAuthor(rs.getString("b.author"));
            r.setPub_year(rs.getString("b.pub_year"));
            r.setStatus(rs.getInt("r.status"));
            daftar.add(r);
        }
        //langkah 5
        rs.close();
        ps.close();
        conn.close();
        return daftar;
    }

    public ArrayList<Ringkasan> getAllRingkasan(int status) throws SQLException {
        ArrayList<Ringkasan> daftar = new ArrayList<>();
        //langkah 1
        conn = k.getConnection();
        //langkah 2
        String kueri = "SELECT u.*, b.*, b.title, b.genre, r.status, r.content "
                + "FROM ringkasan r "
                + "JOIN users u ON r.user_id = u.id "
                + "JOIN buku b ON r.book_id = b.id "
                + "WHERE r.status = ? "
                + "ORDER BY b.title ASC";
        PreparedStatement ps = conn.prepareStatement(kueri);
        ps.setInt(1, status);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Ringkasan r = new Ringkasan();
            r.setBookId(rs.getInt("b.id"));
            r.setPeringkas(rs.getString("u.fullname"));
            r.setUserId(rs.getInt("u.id"));
            r.setTitle(rs.getString("b.title"));
            r.setGenre(rs.getString("b.genre"));
            r.setContent(rs.getString("r.content"));
            r.setAuthor(rs.getString("b.author"));
            r.setPub_year(rs.getString("b.pub_year"));
            r.setStatus(rs.getInt("r.status"));
            daftar.add(r);
        }
        //langkah 5
        rs.close();
        ps.close();
        conn.close();
        return daftar;
    }

    public ArrayList<Ringkasan> getRingkasanByUser(int userId) throws SQLException {
        ArrayList<Ringkasan> daftar = new ArrayList<>();
        //langkah 1
        conn = k.getConnection();
        //langkah 2
        String kueri = "SELECT u.*, b.*, r.status, r.content "
                + "FROM ringkasan r "
                + "JOIN users u ON r.user_id = u.id "
                + "JOIN buku b ON r.book_id = b.id "
                + "WHERE r.user_id = ? "
                + "ORDER BY b.title ASC";
        PreparedStatement ps = conn.prepareStatement(kueri);
        ps.setInt(1, userId);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Ringkasan r = new Ringkasan();
            r.setBookId(rs.getInt("b.id"));
            r.setPeringkas(rs.getString("u.fullname"));
            r.setUserId(rs.getInt("u.id"));
            r.setTitle(rs.getString("b.title"));
            r.setGenre(rs.getString("b.genre"));
            r.setContent(rs.getString("r.content"));
            r.setAuthor(rs.getString("b.author"));
            r.setPub_year(rs.getString("b.pub_year"));
            r.setStatus(rs.getInt("r.status"));
            daftar.add(r);
        }
        //langkah 5
        rs.close();
        ps.close();
        conn.close();
        return daftar;
    }

    public boolean insertBuku(Buku b, int userId) throws SQLException {
        conn = k.getConnection();
        //Langkah 0
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM buku");
        int check = 0;
        while (rs.next()) {
            if (rs.getString("title").equals(b.getTitle())) {
                check = 1;
                JOptionPane.showMessageDialog(
                        null,
                        "Buku sudah ada! harap cek lagi data yang anda masukkan.",
                        "Duplicate Data",
                        JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        if (check == 0) {
            //langkah 1
            String kueri1 = "INSERT INTO buku(title, author, total_page, pub_year, isbn, genre) VALUES(?, ?, ?, ?, ?, ?)";
            PreparedStatement ps1 = conn.prepareStatement(kueri1);
            ps1.setString(1, b.getTitle());
            ps1.setString(2, b.getAuthor());
            ps1.setString(3, b.getTotal_page());
            ps1.setString(4, b.getPub_year());
            ps1.setString(5, b.getIsbn());
            ps1.setString(6, b.getGenre());
            ps1.executeUpdate();
            //Langkah 2
            String kueri2 = "SELECT id FROM buku WHERE title = ?";
            PreparedStatement ps2 = conn.prepareStatement(kueri2);
            ps2.setString(1, b.getTitle());
            rs = ps2.executeQuery();
            int bookId = 0;
            while (rs.next()) {
                bookId = rs.getInt("id");
            }
            //langkah 3
            String kueri3 = "INSERT INTO statusbuku(user_id, book_id, status) VALUES( ?,  ?,  ?)";
            PreparedStatement ps3 = conn.prepareStatement(kueri3);
            ps3.setInt(1, userId);
            ps3.setInt(2, bookId);
            ps3.setInt(3, 0);
            ps3.executeUpdate();
            //langkah 3
            ps1.close();
            ps2.close();
            conn.close();
            check = 2;
        }
        return check == 2;
    }

    public boolean isVisited(int ringkasanId, int userId) throws SQLException {
        conn = k.getConnection();
        String kueri0 = "SELECT * FROM visited WHERE ringkasan_id = ? AND user_id = ?";
        PreparedStatement ps0 = conn.prepareStatement(kueri0);
        ps0.setInt(1, ringkasanId);
        ps0.setInt(2, userId);
        ResultSet rs = ps0.executeQuery();
        int check = 0;
        int rowAffected = 0;
        while (rs.next()) {
            check++;
        }
        String kueri1 = "";
        if (check != 0) {
            kueri1 = "UPDATE visited SET updated_at = ? "
                    + "WHERE ringkasan_id = ? "
                    + "AND user_id = ?";
            PreparedStatement ps = conn.prepareStatement(kueri1);
            ps.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
            ps.setInt(2, ringkasanId);
            ps.setInt(3, userId);
            rowAffected = ps.executeUpdate();
        } else {
            kueri1 = "INSERT INTO visited(ringkasan_id, user_id) VALUES(?, ?)";
            PreparedStatement ps = conn.prepareStatement(kueri1);
            ps.setInt(1, ringkasanId);
            ps.setInt(2, userId);
            rowAffected = ps.executeUpdate();
        }
        return rowAffected == 1;
    }

    public ArrayList<Ringkasan> getVisitedBooks(int userId) throws SQLException {
        ArrayList<Ringkasan> daftar = new ArrayList();
        conn = k.getConnection();
        String kueri1 = "SELECT r.id "
                + "FROM visited v "
                + "JOIN ringkasan r ON v.ringkasan_id = r.id "
                + "WHERE v.user_id = ? "
                + "ORDER BY v.updated_at DESC";
        PreparedStatement ps1 = conn.prepareStatement(kueri1);
        ps1.setInt(1, userId);
        System.out.println("userId: " + userId);
        ResultSet rs = ps1.executeQuery();
        while (rs.next()) {
            Ringkasan r = new Ringkasan();
            r.setIdRingkasan(rs.getInt("r.id"));

            String kueri2 = "SELECT b.*, r.content, u.* "
                    + "FROM ringkasan r "
                    + "JOIN buku b ON r.book_id = b.id "
                    + "JOIN users u ON r.user_id = u.id "
                    + "WHERE r.id = ?";
            PreparedStatement ps2 = conn.prepareStatement(kueri2);
            ps2.setInt(1, r.getIdRingkasan());
            ResultSet rs2 = ps2.executeQuery();
            while (rs2.next()) {
                r.setTitle(rs2.getString("b.title"));
                System.out.println(rs2.getString("b.title"));
                r.setAuthor(rs2.getString("b.author"));
                r.setGenre(rs2.getString("b.genre"));
                r.setPub_year(rs2.getString("b.pub_year"));
                r.setPeringkas(rs2.getString("u.fullname"));
                r.setUserId(rs2.getInt("u.id"));
                r.setBookId(rs2.getInt("b.id"));
                daftar.add(r);
            }
        }
        return daftar;
    }

    public boolean insertRingkasan(int userId, int bookId, String content) throws SQLException {
        conn = k.getConnection();
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM ringkasan "
                + "WHERE user_id = ? "
                + "AND book_id = ?");
        stmt.setInt(1, userId);
        stmt.setInt(2, bookId);
        ResultSet rs = stmt.executeQuery();
        int check = 0;
        while (rs.next()) {
            check++;
        }
        int rowAffected = 0;
        if (check != 0) {
            String kueri1 = "UPDATE ringkasan SET content = ?, status = ? "
                    + "WHERE user_id = ? "
                    + "AND book_id = ?";
            PreparedStatement ps1 = conn.prepareStatement(kueri1);
            ps1.setString(1, content);
            ps1.setInt(2, 1);
            ps1.setInt(3, userId);
            ps1.setInt(4, bookId);
            rowAffected = ps1.executeUpdate();
        } else {
            String kueri1 = "INSERT INTO ringkasan(user_id, book_id, content, status) VALUES(?, ?, ?, ?)";
            PreparedStatement ps1 = conn.prepareStatement(kueri1);
            ps1.setInt(1, userId);
            ps1.setInt(2, bookId);
            ps1.setString(3, content);
            ps1.setInt(4, 1);
            rowAffected = ps1.executeUpdate();
        }

        return rowAffected == 1;
    }

    public boolean updatePengguna(Pengguna p) throws SQLException {
        //langkah 1
        conn = k.getConnection();
        String username = p.getUsername();
        if (username.equals("") || username == null) {
            username = loggedInUsername;
        } else {
            loggedInUsername = username;
        }
        //langkah 2
        String kueri = "UPDATE users SET fullname = ?, username = ?, email=? WHERE password = ?";
        PreparedStatement ps = conn.prepareStatement(kueri);
        ps.setString(1, p.getFullname());
        ps.setString(2, username);
        ps.setString(3, p.getEmail());
        ps.setString(4, p.getPassword());
        //langkah 3
        int rowAffected = ps.executeUpdate();
        //langkah 4 & 5
        ps.close();
        conn.close();
        return rowAffected == 1;

    }

    public boolean deletePengguna(String username) throws SQLException {
        //langkah 1
        conn = k.getConnection();
        //langkah 2
        String kueri = "DELETE FROM users WHERE username = ?";
        PreparedStatement ps = conn.prepareStatement(kueri);
        ps.setString(1, username);
        //langkah 3
        int rowAffected = ps.executeUpdate();
        //langkah 4 & 5
        ps.close();
        conn.close();
        return rowAffected == 1;

    }
    
    public ArrayList<Ringkasan> cariBuku(String keyword) throws
            SQLException {
        ArrayList<Ringkasan> result = new ArrayList<>();
        //langkah 1
        conn = k.getConnection();
        //langkah 2
        String kueri = "SELECT b.*, r.status, r.content, u.fullname "
                + "FROM ringkasan r "
                + "JOIN buku b ON r.book_id = b.id "
                + "JOIN users u ON r.user_id = u.id "
                + "WHERE r.status = ? AND title LIKE ? OR r.status = ? AND pub_year LIKE ? OR r.status = ? AND genre LIKE ?";
        PreparedStatement ps = conn.prepareStatement(kueri);
        ps.setInt(1, 1);
        ps.setString(2, "%" + keyword + "%");
        ps.setInt(3, 1);
        ps.setString(4, "%" + keyword + "%");
        ps.setInt(5, 1);
        ps.setString(6, "%" + keyword + "%");
        //langkah 3
        ResultSet rs = ps.executeQuery();
        //langkah 4
        while (rs.next()) {
            Ringkasan r = new Ringkasan();
            r.setBookId(rs.getInt("b.id"));
            r.setTitle(rs.getString("b.title"));
            r.setAuthor(rs.getString("b.author"));
            r.setTotal_page(rs.getString("b.total_page"));
            r.setPub_year(rs.getString("b.pub_year"));
            r.setIsbn(rs.getString("b.isbn"));
            r.setGenre(rs.getString("b.genre"));
            r.setContent(rs.getString("r.content"));
            r.setFilename(rs.getString("b.filename"));
            r.setPeringkas(rs.getString("u.fullname"));
            result.add(r);
        }

        //langkah 5
        rs.close();
        ps.close();
        conn.close();
        return result;
    }

    public void userRegistration(
            JFrame jFrame,
            Component parentComponent,
            String textFullname,
            String textUsername,
            String textEmail,
            String textPassword,
            String textConfirmPassword
    ) {
        try {
            String username = "";
            textFullname = toPascalCase(textFullname);
            conn = k.getConnection();
            String getQuery = "SELECT * FROM users";

            boolean data = textFullname.equals("Silakan masukkan nama...")
                    || textUsername.equals("Silakan masukkan alamat username...")
                    || textEmail.equals("Silakan masukkan alamat email...")
                    || textPassword.equals("Pass");
            boolean validate = textFullname.equals("")
                    || textUsername.equals("")
                    || textEmail.equals("")
                    || textPassword.equals("");

            // Database connections
            Statement state = conn.createStatement();
            ResultSet rset = state.executeQuery(getQuery);

            if (rset.next()) {
                username = rset.getString("username");
            }

            // Check if user name is already exist or not
            if (textUsername.equals(username)) {
                String message = "Username sudah digunakan!";
                validation(parentComponent, message);
            } else {
                // Validate all form data
                if (data) {
                    String message = "Silakan isi data Anda dengan benar!";
                    validation(parentComponent, message);

                    // Validate the password length
                } else if (textPassword.length() < 8) {
                    String message = "Password harus memiliki minimal 8 karakter";
                    validation(parentComponent, message);

                    // Validate all form data
                } else if (!textPassword.equals(textConfirmPassword)) {
                    String message = "Konfirmasi password anda tidak sama!";
                    validation(parentComponent, message);
                } else if (validate) {
                    String message = "Silakan isi data Anda dengan benar!";
                    validation(parentComponent, message);

                    // If all forms are filled, POST data to database
                } else {
                    Pembaca user = new Pembaca(
                            textFullname.toLowerCase(),
                            textUsername,
                            textEmail,
                            textPassword
                    );
                    addUser(user);

                    try {
                        String insertQuery = "INSERT INTO "
                                + "users(fullname, username, email, password, status, type)"
                                + "VALUES(?, ?, ?, ?, ?, ?)";

                        PreparedStatement pstate = conn.prepareStatement(insertQuery);
                        pstate.setString(1, textFullname);
                        pstate.setString(2, textUsername);
                        pstate.setString(3, textEmail);
                        pstate.setString(4, textPassword);
                        pstate.setInt(5, 0);
                        pstate.setInt(6, 1);

                        int rowAffected = pstate.executeUpdate();

                        if (rowAffected > 0) {
                            System.out.println("Insert successfull");

                            JOptionPane.showMessageDialog(
                                    parentComponent,
                                    "Akun Anda berhasil dibuat! Silakan sign-in untuk masuk ke aplikasi menggunakan akun Anda",
                                    "Register",
                                    JOptionPane.INFORMATION_MESSAGE
                            );
                            this.goToLogin(jFrame);
                        }
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                        JOptionPane.showMessageDialog(
                                parentComponent,
                                "Gagal membuat akun! Periksa lagi koneksi Anda!",
                                "Register",
                                JOptionPane.ERROR_MESSAGE
                        );
                    }

                }
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void userLogin(
            JFrame jFrame,
            Component parentComponent,
            String textUsername,
            String textPass
    ) {
        loggedInUsername = textUsername;
        try {
            conn = k.getConnection();
            String getQuery = "SELECT * FROM users WHERE username=?";
            String username = "", pass = "";
            int type = 0;

            PreparedStatement pstate = conn.prepareStatement(getQuery);
            pstate.setString(1, textUsername);
            ResultSet rset = pstate.executeQuery();
            while (rset.next()) {
                username = rset.getString("username");
                pass = rset.getString("password");
                type = rset.getInt("type");
            }
            System.out.format("%s, %s\n", username, pass);
            if (!textUsername.equals(username) || !textPass.equals(pass)) {
                String message = "Pastikan username dan password yang Anda masukan benar!";
                validation(parentComponent, message);

            } else if (textUsername.equals("")
                    || textUsername.equals("Silakan masukkan nama...")
                    || textPass.equals("")
                    || textPass.equals("Pass")) {
                String message = "Silakan isi data Anda dengan benar!";
                validation(parentComponent, message);
            } else {
                String query = "UPDATE users SET status = 1 WHERE username=?";
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, username);
                ps.executeUpdate();

                JOptionPane.showMessageDialog(
                        parentComponent,
                        "Hello, " + username, "Login",
                        JOptionPane.INFORMATION_MESSAGE
                );
                goToDashboard(jFrame, type);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(
                    parentComponent,
                    "Gagal melakukan Sign-in! Periksa lagi koneksi Anda!",
                    "Login",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public void addUser(Pembaca user) {
        dataPengguna.add(user);
    }

    private void validation(Component parentComponent, String message) {
        System.out.println("Debug message: " + message);
        JOptionPane.showMessageDialog(
                parentComponent,
                message,
                "Register",
                JOptionPane.ERROR_MESSAGE
        );
    }

    public boolean reviewRingkasan(String pilihan, int bookId, int userId) throws SQLException {
        System.out.println(pilihan);
        System.out.println(bookId);
        conn = k.getConnection();
        String kueri1 = "UPDATE ringkasan SET status = ? WHERE book_id = ? AND user_id = ?";
        String kueri2 = "UPDATE statusbuku SET status = ? WHERE book_id = ?";
        PreparedStatement ps1 = conn.prepareStatement(kueri1);
        PreparedStatement ps2 = conn.prepareStatement(kueri2);
        if (pilihan.equals("Setujui")) {
            ps1.setInt(1, 2);
            ps1.setInt(2, bookId);
            ps1.setInt(3, userId);
            ps2.setInt(1, 2);
            ps2.setInt(2, bookId);
            ps2.executeUpdate();
        } else {
            ps1.setInt(1, 3);
            ps1.setInt(2, bookId);
            ps1.setInt(3, userId);
        }
        bookIsSummarized(bookId);
        int rowAffected = ps1.executeUpdate();
        //langkah 3
        //langkah 4 & 5
        ps1.close();
        ps2.close();
        conn.close();
        return rowAffected == 1;
    }

    private void bookIsSummarized(int bookId) throws SQLException {
        String kueri0 = "SELECT * FROM ringkasan WHERE status = ? "
                + "AND book_id = ?";
        PreparedStatement ps0 = conn.prepareStatement(kueri0);
        ps0.setInt(1, 2);
        ps0.setInt(2, bookId);
        ResultSet rs3 = ps0.executeQuery();
        int check = 0;
        while (rs3.next()) {
            check++;
        }
        if (check != 0) {
            String kueri1 = "UPDATE statusbuku SET status = ? WHERE book_id = ?";
            PreparedStatement ps1 = conn.prepareStatement(kueri1);
            ps1.setInt(1, 2);
            ps1.setInt(2, bookId);
            ps1.executeUpdate();
        } else {
            String kueri1 = "UPDATE statusbuku SET status = ? WHERE book_id = ?";
            PreparedStatement ps1 = conn.prepareStatement(kueri1);
            ps1.setInt(1, 1);
            ps1.setInt(2, bookId);
            ps1.executeUpdate();
        }
    }

    public boolean hapusRingkasan(int bookId, int userId) throws SQLException {
        System.out.println(bookId);
        conn = k.getConnection();
        String kueri1 = "DELETE FROM ringkasan WHERE book_id = ? "
                + "AND user_id = ?";
        PreparedStatement ps1 = conn.prepareStatement(kueri1);
        ps1.setInt(1, bookId);
        ps1.setInt(2, userId);
        int rowAffected = ps1.executeUpdate();

        String kueri2 = "UPDATE statusbuku SET status = ? WHERE book_id = ?";
        PreparedStatement ps2 = conn.prepareStatement(kueri2);
        ps2.setInt(1, 1);
        ps2.setInt(2, bookId);
        ps2.executeUpdate();
        //langkah 3
        //langkah 4 & 5
        ps1.close();
        conn.close();
        return rowAffected == 1;
    }

    public boolean hapusBuku(int bookId) throws SQLException {
        System.out.println(bookId);
        conn = k.getConnection();
        String kueri1 = "DELETE FROM buku WHERE id = ?";
        PreparedStatement ps1 = conn.prepareStatement(kueri1);
        ps1.setInt(1, bookId);
        int rowAffected = ps1.executeUpdate();
        ps1.close();
        conn.close();
        return rowAffected == 1;
    }

    public boolean reviewBukuBaru(int bookId) throws SQLException {
        conn = k.getConnection();
        String kueri = "UPDATE statusbuku SET status = ? WHERE book_id = ?";
        PreparedStatement ps = conn.prepareStatement(kueri);
        ps.setInt(1, 1);
        ps.setInt(2, bookId);
        int rowAffected = ps.executeUpdate();
        ps.close();
        conn.close();
        return rowAffected == 1;
    }

    public void goToLogin(JFrame jFrame) {
        Login login = new Login();

        jFrame.dispose();
        login.setSize(1920, 1080);
        login.setTitle("Masuk");
        login.setLocationRelativeTo(null);
        login.setVisible(true);
    }

    public void goToRegister(JFrame jFrame) {
        Register register = new Register();

        jFrame.dispose();
        register.setSize(1920, 1080);
        register.setTitle("Daftar");
        register.setLocationRelativeTo(null);
        register.setVisible(true);
    }

    public void goToDashboard(JFrame jFrame, int type) {
        if (type != 2) {
            Dashboard dashboard = new Dashboard(loggedInUsername);
            jFrame.dispose();
            dashboard.setSize(1920, 1080);
            dashboard.setTitle("Beranda");
            dashboard.setLocationRelativeTo(null);
            dashboard.setVisible(true);
        } else {
            DashboardAdmin dashboard = new DashboardAdmin(loggedInUsername);
            jFrame.dispose();
            dashboard.setTitle("Beranda Admin");
            dashboard.setSize(1920, 1080);
            dashboard.setLocationRelativeTo(null);
            dashboard.setVisible(true);
        }
        jFrame.dispose();
    }

    public void goToDashboard(JFrame jFrame) {
        Dashboard dashboard = new Dashboard(loggedInUsername);
        jFrame.dispose();
        dashboard.setSize(1920, 1080);
        dashboard.setTitle("Beranda");
        dashboard.setVisible(true);
        dashboard.setLocationRelativeTo(null);
    }

    public void goToProfile(JFrame jFrame) {
        UserProfile profile = new UserProfile(loggedInUsername);

        jFrame.dispose();
        profile.setSize(1920, 1080);
        profile.setTitle("Profil");
        profile.setVisible(true);
        profile.setLocationRelativeTo(null);
    }

    public void goToProfile(JFrame jFrame, String username) {
        UserProfile profile = new UserProfile(username);
        loggedInUsername = username;

        jFrame.dispose();
        profile.setSize(1920, 1080);
        profile.setTitle("Profil");
        profile.setVisible(true);
        profile.setLocationRelativeTo(null);
    }

    public void goToChooseBook(JFrame jFrame) {
        PilihBuku chooseBook = new PilihBuku(loggedInUsername);

        jFrame.dispose();
        chooseBook.setSize(1920, 1080);
        chooseBook.setTitle("Pilih Buku");
        chooseBook.setVisible(true);
        chooseBook.setLocationRelativeTo(null);
    }

    public void goToWrite(JFrame jFrame, int userId, int bookId, String bookTitle, String bookAuthor, String pubYear) {
        TulisRingkasan write = new TulisRingkasan(loggedInUsername, userId, bookId, bookTitle, bookAuthor, pubYear
        );

        jFrame.dispose();
        write.setSize(1920, 1080);
        write.setTitle("Tulis Ringkasan");
        write.setVisible(true);
        write.setLocationRelativeTo(null);
    }

    public void goToWrite(JFrame jFrame, int userId, int bookId, String bookTitle, String bookAuthor, String pubYear, String content) {
        TulisRingkasan write = new TulisRingkasan(loggedInUsername, userId, bookId, bookTitle, bookAuthor, pubYear, content
        );

        jFrame.dispose();
        write.setSize(1920, 1080);
        write.setTitle("Tulis Ringkasan");
        write.setVisible(true);
        write.setLocationRelativeTo(null);
    }

    public void goToAddBook(JFrame jFrame) {
        TambahBukuBaru addBook = new TambahBukuBaru(loggedInUsername);

        jFrame.dispose();
        addBook.setSize(1920, 1080);
        addBook.setTitle("Tambah Buku");
        addBook.setVisible(true);
        addBook.setLocationRelativeTo(null);
    }

    public void goToBookDetails(JFrame jFrame, int bookId, int peringkasId) {
        DetailBuku bookDetail = new DetailBuku(loggedInUsername, bookId, peringkasId);
        System.out.println("bookId pada BookDetails: " + bookId);
        System.out.println("peringkasId pada BookDetails: " + peringkasId);

        jFrame.dispose();
        bookDetail.setSize(1920, 1080);
        bookDetail.setTitle("Detail Buku");
        bookDetail.setVisible(true);
        bookDetail.setLocationRelativeTo(null);
    }

    public void goToLibrary(JFrame jFrame) {
        Perpustakaan perpus = new Perpustakaan(loggedInUsername);

        jFrame.dispose();
        perpus.setSize(1920, 1080);
        perpus.setTitle("Perpustakaan");
        perpus.setVisible(true);
        perpus.setLocationRelativeTo(null);
    }

    public void goToSumDetails(JFrame jFrame, String bookTitle, String bookAuthor, String pubYear, int userId, int bookId, String content, int status) {
        DetailRingkasan sumDetail = new DetailRingkasan(loggedInUsername, bookTitle, bookAuthor, pubYear, userId, bookId, content, status);

        jFrame.dispose();
        sumDetail.setSize(1920, 1080);
        sumDetail.setTitle("Detail Ringkasan");
        sumDetail.setVisible(true);
        sumDetail.setLocationRelativeTo(null);
    }

    public void goToBookReview(JFrame jFrame) {
        ReviewRingkasan bookReview = new ReviewRingkasan(loggedInUsername);

        jFrame.dispose();
        bookReview.setSize(1920, 1080);
        bookReview.setTitle("Review Ringkasan (Admin)");
        bookReview.setVisible(true);
        bookReview.setLocationRelativeTo(null);
    }

    public void goToBookRequest(JFrame jFrame) {
        DaftarRequestBuku bookRequest = new DaftarRequestBuku(loggedInUsername);

        jFrame.dispose();
        bookRequest.setSize(1920, 1080);
        bookRequest.setTitle("Daftar Request Buku");
        bookRequest.setVisible(true);
        bookRequest.setLocationRelativeTo(null);
    }

    public void goToBacaBuku(JFrame jFrame, String bookTitle, String sumContent) {
        BacaBuku bacaBuku = new BacaBuku(loggedInUsername, bookTitle, sumContent);

        jFrame.dispose();
        bacaBuku.setSize(1920, 1080);
        bacaBuku.setTitle("Baca Buku");
        bacaBuku.setVisible(true);
        bacaBuku.setLocationRelativeTo(null);
    }

    private static String toPascalCase(String s) {
        String[] words = s.split("\\s");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(word.substring(0, 1).toUpperCase()).append(word.substring(1).toLowerCase()).append(" ");
        }
        return sb.toString().trim();
    }

    public void isLoggedIn(JFrame jFrame) {
        if (loggedInUsername == null) {
            JOptionPane.showMessageDialog(
                    null,
                    "Anda belum login! Harap login terlebih dahulu!",
                    "Akses Ilegal",
                    JOptionPane.ERROR_MESSAGE);
            jFrame.dispose();
            goToLogin(jFrame);
        }
    }

    public void isAdmin(JFrame jFrame) {
        try {
            int userType = getCurrentPengguna().get(0).getType();
            if (userType != 2) {
                JOptionPane.showMessageDialog(
                        null,
                        "Anda tidak terdeteksi sebagai Admin!",
                        "Akses Ilegal",
                        JOptionPane.ERROR_MESSAGE);
                jFrame.dispose();
                goToDashboard(jFrame, userType);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Eksepsi: "
                    + e.getMessage());
        }
    }

    public void logoutAccount(
            JFrame jFrame,
            Component parentComponent
    ) {
        try {
            conn = k.getConnection();
            int jawaban = JOptionPane.showConfirmDialog(parentComponent, "Anda yakin ingin keluar ?", "Keluar dari " + loggedInUsername, JOptionPane.YES_NO_OPTION);
            if (jawaban == JOptionPane.YES_OPTION) {
                String updateQuery = "UPDATE users SET status = 0 WHERE username=?";

                PreparedStatement pstate = conn.prepareStatement(updateQuery);
                pstate.setString(1, loggedInUsername);
                pstate.executeUpdate();

                JOptionPane.showMessageDialog(
                        parentComponent,
                        loggedInUsername + " berhasil logout!",
                        "Logout",
                        1
                );
                this.goToLogin(jFrame);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(
                    parentComponent,
                    "Gagal melakukan Sign-out akun! Periksa lagi koneksi Anda!",
                    "Alert",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
}
