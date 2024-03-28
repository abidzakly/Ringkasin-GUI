package view.pembaca;

import controller.Application;
import java.awt.Color;
import java.awt.Cursor;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import model.Buku;
import model.Ringkasan;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author fawwa
 */
public class Perpustakaan extends javax.swing.JFrame {

    private static String current_user;
    private static final Application APP = new Application();
    private final Color darkRed = new Color(153, 0, 51);
    private final Color darkBlue = new Color(25, 4, 130);
    private final DefaultTableModel model1 = new DefaultTableModel();
    private final DefaultTableModel model2 = new DefaultTableModel();

    /**
     * Creates new form
     */
    public Perpustakaan(String username) {
        initComponents();
        Perpustakaan.current_user = username;
        System.out.println(Perpustakaan.current_user);
        model1.addColumn("Judul");
        model1.addColumn("Penulis");
        model1.addColumn("Genre");
        model1.addColumn("Tahun Publikasi");
        model1.addColumn("Peringkas");
        tableBook.setModel(model1);
        populateTableBacaan();
//
        model2.addColumn("Judul");
        model2.addColumn("Penulis");
        model2.addColumn("Genre");
        model2.addColumn("Status");
        tableRingkasan.setModel(model2);
        populateTableRingkasan();
        titleContainer1.requestFocusInWindow();
        btnSearchBacaan.setSvgImage("view/images/btnCari.svg", 25, 25);
        btnSearchRingkasan.setSvgImage("view/images/btnCari.svg", 25, 25);

        this.setLocationRelativeTo(null);
    }

    private void populateTableBacaan() {
        model1.setRowCount(0);
        try {
            int userId = APP.getCurrentPengguna().get(0).getUserId();
            System.out.println("User ID pada Perpustakaan: " + userId);
            ArrayList<Ringkasan> daftar = APP.getVisitedBooks(userId);

            for (Ringkasan r : daftar) {
                System.out.println(r.getTitle());
                Object[] isiData = {r.getTitle(), r.getAuthor(), r.getGenre(), r.getPub_year(), r.getPeringkas()};
                model1.addRow(isiData);
            }
        } catch (SQLException ex) {
            System.out.println("Eksepsi: " + ex.getMessage());
            JOptionPane.showMessageDialog(null, "Exception: "
                    + ex.getMessage());
        }
    }

    private void populateTableBacaan(String keyword) {
        model1.setRowCount(0);
        try {
            int userId = APP.getCurrentPengguna().get(0).getUserId();
            ArrayList<Ringkasan> searchResult = APP.getVisitedBooks(userId);
            for (Ringkasan r : searchResult) {
                if (r.getTitle().toLowerCase().contains(keyword)
                        || r.getAuthor().toLowerCase().contains(keyword)
                        || r.getGenre().toLowerCase().contains(keyword)
                        || r.getPub_year().contains(keyword)
                        || r.getPeringkas().toLowerCase().contains(keyword)) {
                    Object[] isiData = {r.getTitle(), r.getAuthor(), r.getGenre(), r.getPub_year(), r.getPeringkas()};
                    model1.addRow(isiData);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Eksepsi: " + ex.getMessage());
            JOptionPane.showMessageDialog(null, "Exception: "
                    + ex.getMessage());
        }
    }

    private void populateTableRingkasan() {
        model2.setRowCount(0);
        try {
            int userId = APP.getCurrentPengguna().get(0).getUserId();
            ArrayList<Ringkasan> daftar = APP.getRingkasanByUser(userId);
            for (Ringkasan r : daftar) {
                String status = "";
                switch (r.getStatus()) {
                    case 1 ->
                        status = "Menunggu direview";
                    case 2 ->
                        status = "Telah disetujui";
                    case 3 ->
                        status = "Ditolak";
                }
                Object[] isiData = {r.getTitle(), r.getAuthor(), r.getGenre(), status};
                model2.addRow(isiData);
            }
        } catch (SQLException ex) {
            System.out.println("Eksepsi: " + ex.getMessage());
            JOptionPane.showMessageDialog(null, "Exception: "
                    + ex.getMessage());
        }
    }

    private void populateTableRingkasan(String keyword) {
        model2.setRowCount(0);
        try {
            int userId = APP.getCurrentPengguna().get(0).getUserId();
            ArrayList<Ringkasan> searchResult = APP.getRingkasanByUser(userId);
            for (Ringkasan r : searchResult) {
                String status = "";
                switch (r.getStatus()) {
                    case 1 ->
                        status = "Menunggu direview";
                    case 2 ->
                        status = "Telah disetujui";
                    case 3 ->
                        status = "Ditolak";
                }
                if (r.getTitle().toLowerCase().contains(keyword)
                        || r.getAuthor().toLowerCase().contains(keyword)
                        || r.getGenre().toLowerCase().contains(keyword)
                        || status.toLowerCase().contains(keyword)) {
                    Object[] isiData = {r.getTitle(), r.getAuthor(), r.getGenre(), status};
                    model2.addRow(isiData);
                } else {
                    System.out.println("failed");
                }
            }
        } catch (SQLException ex) {
            System.out.println("Eksepsi: " + ex.getMessage());
            JOptionPane.showMessageDialog(null, "Exception: "
                    + ex.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        titleContainer1 = new javax.swing.JPanel();
        txtSectionTitle1 = new javax.swing.JLabel();
        tableBacaan = new javax.swing.JScrollPane();
        tableBook = new javax.swing.JTable();
        searchBarBacaan = new javax.swing.JPanel();
        tfKeywordBacaan = new javax.swing.JTextField();
        btnSearchBacaan = new view.images.SVGImage();
        searchBarRingkasan = new javax.swing.JPanel();
        tfKeywordRingkasan = new javax.swing.JTextField();
        btnSearchRingkasan = new view.images.SVGImage();
        titleContainer2 = new javax.swing.JPanel();
        txtSectionTitle2 = new javax.swing.JLabel();
        tableRingkasasn = new javax.swing.JScrollPane();
        tableRingkasan = new javax.swing.JTable();
        navBar = new javax.swing.JMenuBar();
        ringkasinLogo = new javax.swing.JMenu();
        Ringkasin = new javax.swing.JMenu();
        btnBeranda = new javax.swing.JMenu();
        btnPerpustakaan = new javax.swing.JMenu();
        btnTulis = new javax.swing.JMenu();
        btnProfile = new javax.swing.JMenu();
        btnLogout = new javax.swing.JMenu();

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtSectionTitle1.setFont(new java.awt.Font("Poppins", 1, 24)); // NOI18N
        txtSectionTitle1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSectionTitle1.setText("Bacaanmu");

        javax.swing.GroupLayout titleContainer1Layout = new javax.swing.GroupLayout(titleContainer1);
        titleContainer1.setLayout(titleContainer1Layout);
        titleContainer1Layout.setHorizontalGroup(
            titleContainer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, titleContainer1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtSectionTitle1, javax.swing.GroupLayout.DEFAULT_SIZE, 1250, Short.MAX_VALUE)
                .addContainerGap())
        );
        titleContainer1Layout.setVerticalGroup(
            titleContainer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titleContainer1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtSectionTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 24, Short.MAX_VALUE))
        );

        tableBook.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        tableBook.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Judul", "Penulis", "Genre"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableBookMouseClicked(evt);
            }
        });
        tableBacaan.setViewportView(tableBook);

        tfKeywordBacaan.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        tfKeywordBacaan.setText("Cari...");
        tfKeywordBacaan.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfKeywordBacaanFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfKeywordBacaanFocusLost(evt);
            }
        });
        tfKeywordBacaan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfKeywordBacaanActionPerformed(evt);
            }
        });

        btnSearchBacaan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSearchBacaanMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSearchBacaanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSearchBacaanMouseExited(evt);
            }
        });

        javax.swing.GroupLayout searchBarBacaanLayout = new javax.swing.GroupLayout(searchBarBacaan);
        searchBarBacaan.setLayout(searchBarBacaanLayout);
        searchBarBacaanLayout.setHorizontalGroup(
            searchBarBacaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchBarBacaanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tfKeywordBacaan, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSearchBacaan, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        searchBarBacaanLayout.setVerticalGroup(
            searchBarBacaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchBarBacaanLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(searchBarBacaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfKeywordBacaan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchBacaan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tfKeywordRingkasan.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        tfKeywordRingkasan.setText("Cari...");
        tfKeywordRingkasan.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfKeywordRingkasanFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfKeywordRingkasanFocusLost(evt);
            }
        });
        tfKeywordRingkasan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfKeywordRingkasanActionPerformed(evt);
            }
        });

        btnSearchRingkasan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSearchRingkasanMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSearchRingkasanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSearchRingkasanMouseExited(evt);
            }
        });

        javax.swing.GroupLayout searchBarRingkasanLayout = new javax.swing.GroupLayout(searchBarRingkasan);
        searchBarRingkasan.setLayout(searchBarRingkasanLayout);
        searchBarRingkasanLayout.setHorizontalGroup(
            searchBarRingkasanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchBarRingkasanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tfKeywordRingkasan, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSearchRingkasan, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        searchBarRingkasanLayout.setVerticalGroup(
            searchBarRingkasanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchBarRingkasanLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(searchBarRingkasanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfKeywordRingkasan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchRingkasan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        txtSectionTitle2.setFont(new java.awt.Font("Poppins", 1, 24)); // NOI18N
        txtSectionTitle2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSectionTitle2.setText("Ringkasanmu");

        javax.swing.GroupLayout titleContainer2Layout = new javax.swing.GroupLayout(titleContainer2);
        titleContainer2.setLayout(titleContainer2Layout);
        titleContainer2Layout.setHorizontalGroup(
            titleContainer2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, titleContainer2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtSectionTitle2, javax.swing.GroupLayout.DEFAULT_SIZE, 1250, Short.MAX_VALUE)
                .addContainerGap())
        );
        titleContainer2Layout.setVerticalGroup(
            titleContainer2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titleContainer2Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(txtSectionTitle2, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                .addContainerGap())
        );

        tableRingkasan.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        tableRingkasan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Judul", "Penulis", "Genre", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableRingkasan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableRingkasanMouseClicked(evt);
            }
        });
        tableRingkasasn.setViewportView(tableRingkasan);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titleContainer2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tableRingkasasn, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(searchBarRingkasan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(370, 370, 370)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(titleContainer1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tableBacaan, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(searchBarBacaan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(368, 368, 368)))
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(535, Short.MAX_VALUE)
                .addComponent(titleContainer2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(searchBarRingkasan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tableRingkasasn, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(311, 311, 311))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(titleContainer1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(searchBarBacaan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(tableBacaan, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(944, Short.MAX_VALUE)))
        );

        jScrollPane1.setViewportView(jPanel1);

        ringkasinLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/ringkasinLogo.png"))); // NOI18N
        ringkasinLogo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        navBar.add(ringkasinLogo);

        Ringkasin.setText("Ringkasin");
        Ringkasin.setToolTipText("");
        Ringkasin.setFont(new java.awt.Font("Poppins", 1, 28)); // NOI18N
        navBar.add(Ringkasin);

        btnBeranda.setText("Beranda");
        btnBeranda.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        btnBeranda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnBeranda.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBeranda.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                btnBerandaMenuSelected(evt);
            }
        });
        btnBeranda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBerandaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBerandaMouseExited(evt);
            }
        });
        navBar.add(btnBeranda);

        btnPerpustakaan.setText("Perpustakaan");
        btnPerpustakaan.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        btnPerpustakaan.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                btnPerpustakaanMenuSelected(evt);
            }
        });
        btnPerpustakaan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPerpustakaanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPerpustakaanMouseExited(evt);
            }
        });
        navBar.add(btnPerpustakaan);

        btnTulis.setText("Ringkas Buku");
        btnTulis.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        btnTulis.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                btnTulisMenuSelected(evt);
            }
        });
        btnTulis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnTulisMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTulisMouseExited(evt);
            }
        });
        navBar.add(btnTulis);

        btnProfile.setText("Profil");
        btnProfile.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        btnProfile.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                btnProfileMenuSelected(evt);
            }
        });
        btnProfile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnProfileMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnProfileMouseExited(evt);
            }
        });
        navBar.add(btnProfile);

        btnLogout.setText("Keluar");
        btnLogout.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        btnLogout.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                btnbtnLogoutMenuSelected(evt);
            }
        });
        btnLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLogoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLogoutMouseExited(evt);
            }
        });
        navBar.add(btnLogout);

        setJMenuBar(navBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1274, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1260, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableBookMouseClicked
        int row = tableBook.getSelectedRow();
        try {
            int userId = APP.getCurrentPengguna().get(0).getUserId();
            int bookId = APP.getVisitedBooks(userId).get(row).getBookId();
            int peringkasId = APP.getVisitedBooks(userId).get(row).getUserId();
            APP.goToBookDetails(this, bookId, peringkasId);
        } catch (SQLException ex) {
            System.out.println("Eksepsi: " + ex.getMessage());
            JOptionPane.showMessageDialog(null, "Exception: "
                    + ex.getMessage());
        }
    }//GEN-LAST:event_tableBookMouseClicked

    private void tfKeywordBacaanFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfKeywordBacaanFocusGained
        tfKeywordBacaan.setText("");
    }//GEN-LAST:event_tfKeywordBacaanFocusGained

    private void tfKeywordBacaanFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfKeywordBacaanFocusLost
        tfKeywordBacaan.setText("Cari...");
    }//GEN-LAST:event_tfKeywordBacaanFocusLost

    private void tfKeywordBacaanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfKeywordBacaanActionPerformed

    }//GEN-LAST:event_tfKeywordBacaanActionPerformed

    private void btnSearch2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearch2MouseClicked

    }//GEN-LAST:event_btnSearch2MouseClicked

    private void tableRingkasanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableRingkasanMouseClicked
        int row = tableRingkasan.getSelectedRow();

        try {
            int userId = APP.getCurrentPengguna().get(0).getUserId();
            int bookId = APP.getRingkasanByUser(userId).get(row).getBookId();
            String bookTitle = APP.getRingkasanByUser(userId).get(row).getTitle();
            String bookAuthor = APP.getRingkasanByUser(userId).get(row).getAuthor();
            String pubYear = APP.getRingkasanByUser(userId).get(row).getPub_year();
            String bookContent = APP.getRingkasanByUser(userId).get(row).getContent();
            int bookStatus = APP.getRingkasanByUser(userId).get(row).getStatus();
            APP.goToSumDetails(this, bookTitle, bookAuthor, pubYear, userId, bookId, bookContent, bookStatus);
        } catch (SQLException ex) {
            System.out.println("Eksepsi: " + ex.getMessage());
            JOptionPane.showMessageDialog(null, "Exception: "
                    + ex.getMessage());
        }
    }//GEN-LAST:event_tableRingkasanMouseClicked

    private void tfKeywordRingkasanFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfKeywordRingkasanFocusGained
        tfKeywordRingkasan.setText("");
    }//GEN-LAST:event_tfKeywordRingkasanFocusGained

    private void tfKeywordRingkasanFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfKeywordRingkasanFocusLost
        tfKeywordRingkasan.setText("Cari...");
    }//GEN-LAST:event_tfKeywordRingkasanFocusLost

    private void tfKeywordRingkasanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfKeywordRingkasanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfKeywordRingkasanActionPerformed

    private void btnSearch3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearch3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSearch3MouseClicked

    private void btnBerandaMenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_btnBerandaMenuSelected
        APP.goToDashboard(this);
    }//GEN-LAST:event_btnBerandaMenuSelected

    private void btnBerandaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBerandaMouseEntered
        btnBeranda.setOpaque(true);
        btnBeranda.setBackground(this.darkBlue);
        btnBeranda.setForeground(Color.white);
        this.setCursor(Cursor.HAND_CURSOR);
    }//GEN-LAST:event_btnBerandaMouseEntered

    private void btnBerandaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBerandaMouseExited
        btnBeranda.setOpaque(false);
        btnBeranda.setBackground(Color.white);
        btnBeranda.setForeground(Color.black);
        this.setCursor(Cursor.DEFAULT_CURSOR);
    }//GEN-LAST:event_btnBerandaMouseExited

    private void btnPerpustakaanMenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_btnPerpustakaanMenuSelected
        APP.goToLibrary(this);
    }//GEN-LAST:event_btnPerpustakaanMenuSelected

    private void btnPerpustakaanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPerpustakaanMouseEntered
        btnPerpustakaan.setOpaque(true);
        btnPerpustakaan.setBackground(this.darkBlue);
        btnPerpustakaan.setForeground(Color.white);
        this.setCursor(Cursor.HAND_CURSOR);
    }//GEN-LAST:event_btnPerpustakaanMouseEntered

    private void btnPerpustakaanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPerpustakaanMouseExited
        btnPerpustakaan.setOpaque(false);
        btnPerpustakaan.setBackground(Color.white);
        btnPerpustakaan.setForeground(Color.black);
        this.setCursor(Cursor.DEFAULT_CURSOR);
    }//GEN-LAST:event_btnPerpustakaanMouseExited

    private void btnTulisMenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_btnTulisMenuSelected
        APP.goToChooseBook(this);
    }//GEN-LAST:event_btnTulisMenuSelected

    private void btnTulisMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTulisMouseEntered
        btnTulis.setOpaque(true);
        btnTulis.setBackground(this.darkBlue);
        btnTulis.setForeground(Color.white);
        this.setCursor(Cursor.HAND_CURSOR);
    }//GEN-LAST:event_btnTulisMouseEntered

    private void btnTulisMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTulisMouseExited
        btnTulis.setOpaque(false);
        btnTulis.setBackground(Color.white);
        btnTulis.setForeground(Color.black);
        this.setCursor(Cursor.DEFAULT_CURSOR);
    }//GEN-LAST:event_btnTulisMouseExited

    private void btnProfileMenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_btnProfileMenuSelected
        APP.goToProfile(this);
    }//GEN-LAST:event_btnProfileMenuSelected

    private void btnProfileMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProfileMouseEntered
        btnProfile.setOpaque(true);
        btnProfile.setBackground(this.darkBlue);
        btnProfile.setForeground(Color.white);
        this.setCursor(Cursor.HAND_CURSOR);
    }//GEN-LAST:event_btnProfileMouseEntered

    private void btnProfileMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProfileMouseExited
        btnProfile.setOpaque(false);
        btnProfile.setBackground(Color.white);
        btnProfile.setForeground(Color.black);
        this.setCursor(Cursor.DEFAULT_CURSOR);
    }//GEN-LAST:event_btnProfileMouseExited

    private void btnbtnLogoutMenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_btnbtnLogoutMenuSelected
        APP.logoutAccount(this, this);
    }//GEN-LAST:event_btnbtnLogoutMenuSelected

    private void btnLogoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseEntered
        btnLogout.setOpaque(true);
        btnLogout.setBackground(this.darkRed);
        btnLogout.setForeground(Color.white);
        this.setCursor(Cursor.HAND_CURSOR);
    }//GEN-LAST:event_btnLogoutMouseEntered

    private void btnLogoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseExited
        btnLogout.setOpaque(false);
        btnLogout.setBackground(Color.white);
        btnLogout.setForeground(Color.black);
        this.setCursor(Cursor.DEFAULT_CURSOR);
    }//GEN-LAST:event_btnLogoutMouseExited

    private void btnSearchBacaanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchBacaanMouseClicked
        populateTableBacaan(tfKeywordBacaan.getText());
    }//GEN-LAST:event_btnSearchBacaanMouseClicked

    private void btnSearchRingkasanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchRingkasanMouseClicked
        populateTableRingkasan(tfKeywordRingkasan.getText());
    }//GEN-LAST:event_btnSearchRingkasanMouseClicked

    private void btnSearchBacaanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchBacaanMouseEntered
        this.setCursor(Cursor.HAND_CURSOR);
    }//GEN-LAST:event_btnSearchBacaanMouseEntered

    private void btnSearchBacaanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchBacaanMouseExited
        this.setCursor(Cursor.DEFAULT_CURSOR);
    }//GEN-LAST:event_btnSearchBacaanMouseExited

    private void btnSearchRingkasanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchRingkasanMouseEntered
        this.setCursor(Cursor.HAND_CURSOR);
    }//GEN-LAST:event_btnSearchRingkasanMouseEntered

    private void btnSearchRingkasanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchRingkasanMouseExited
        this.setCursor(Cursor.DEFAULT_CURSOR);
    }//GEN-LAST:event_btnSearchRingkasanMouseExited

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Perpustakaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Perpustakaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Perpustakaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Perpustakaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            Perpustakaan app1 = new Perpustakaan(current_user);
            app1.setTitle("Perpustakaan");
            app1.setSize(1920, 1080);
            app1.setLocationRelativeTo(null);
            app1.setVisible(true);
            APP.isLoggedIn(app1);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Ringkasin;
    private javax.swing.JMenu btnBeranda;
    private javax.swing.JMenu btnLogout;
    private javax.swing.JMenu btnPerpustakaan;
    private javax.swing.JMenu btnProfile;
    private view.images.SVGImage btnSearchBacaan;
    private view.images.SVGImage btnSearchRingkasan;
    private javax.swing.JMenu btnTulis;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuBar navBar;
    private javax.swing.JMenu ringkasinLogo;
    private javax.swing.JPanel searchBarBacaan;
    private javax.swing.JPanel searchBarRingkasan;
    private javax.swing.JScrollPane tableBacaan;
    private javax.swing.JTable tableBook;
    private javax.swing.JTable tableRingkasan;
    private javax.swing.JScrollPane tableRingkasasn;
    private javax.swing.JTextField tfKeywordBacaan;
    private javax.swing.JTextField tfKeywordRingkasan;
    private javax.swing.JPanel titleContainer1;
    private javax.swing.JPanel titleContainer2;
    private javax.swing.JLabel txtSectionTitle1;
    private javax.swing.JLabel txtSectionTitle2;
    // End of variables declaration//GEN-END:variables
}
