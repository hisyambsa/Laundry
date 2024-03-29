package laundry;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Aas1
 */
public class liat_pelanggan extends java.awt.Dialog {

    konek kon = new konek();
    public form_penerimaan_cucian data_pelanggan = null;
//    public form_penerimaan_cucian data_pelanggan = null;
    
    private Object[][] dataPelanggan = null;
    private String[] label = {"Kode Pelanggan", "Nama Pelanggan", "No Telepon","Id Pelanggan"};

    /**
     * Creates new form liat_pelanggan
     */
    public liat_pelanggan(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setTitle("Form Data Pelanggan");
        kon.setKoneksi();
        BacaTabelTransaksi();
    }

    private void BacaTabelTransaksi() {
        try {
            String sql = "Select *From pelanggan order by nama_pelanggan";
            kon.rs = kon.st.executeQuery(sql);
            ResultSetMetaData m = kon.rs.getMetaData();
            int kolom = m.getColumnCount();
            int baris = 0;
            while (kon.rs.next()) {
                baris = kon.rs.getRow();
            }
            dataPelanggan = new Object[baris][kolom];
            int x = 0;
            kon.rs.beforeFirst();
            while (kon.rs.next()) {
                dataPelanggan[x][0] = kon.rs.getString("kode_pelanggan");
                dataPelanggan[x][1] = kon.rs.getString("nama_pelanggan");
                dataPelanggan[x][2] = kon.rs.getString("no_telepon_pelanggan");
                dataPelanggan[x][3] = kon.rs.getString("id_pelanggan");
                
                
                x++;
            }
            j_tabel_pelanggan.getColumnModel().getColumn(3).setWidth(0);
            j_tabel_pelanggan.setModel(new DefaultTableModel(dataPelanggan, label));
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void BacaTabelTransaksi2() {
        try {
            String sql = "Select *From pelanggan where nama_pelanggan like'%" + txt_cari_nama_pelanggan.getText() + "%'";
            kon.rs = kon.st.executeQuery(sql);
            ResultSetMetaData m = kon.rs.getMetaData();
            int kolom = m.getColumnCount();
            int baris = 0;
            while (kon.rs.next()) {
                baris = kon.rs.getRow();
            }
            dataPelanggan = new Object[baris][kolom];
            int x = 0;
            kon.rs.beforeFirst();
            while (kon.rs.next()) {
                dataPelanggan[x][0] = kon.rs.getString("kode_pelanggan");
                dataPelanggan[x][1] = kon.rs.getString("nama_pelanggan");
                dataPelanggan[x][2] = kon.rs.getString("no_telepon_pelanggan");
                dataPelanggan[x][3] = kon.rs.getString("id_pelanggan");
                x++;
            }
            j_tabel_pelanggan.getColumnModel().getColumn(3).setWidth(0);
            j_tabel_pelanggan.setModel(new DefaultTableModel(dataPelanggan, label));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        j_tabel_pelanggan = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txt_cari_nama_pelanggan = new javax.swing.JTextField();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(144, 190, 171));

        jLabel1.setFont(new java.awt.Font("Nyala", 1, 24)); // NOI18N
        jLabel1.setText("Data Pelanggan");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Tabel Data Pelanggan"));

        j_tabel_pelanggan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        j_tabel_pelanggan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                j_tabel_pelangganMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(j_tabel_pelanggan);

        jLabel2.setText("Cari Nama Pelanggan");

        txt_cari_nama_pelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cari_nama_pelangganActionPerformed(evt);
            }
        });
        txt_cari_nama_pelanggan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_cari_nama_pelangganKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_cari_nama_pelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_cari_nama_pelanggan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void txt_cari_nama_pelangganKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cari_nama_pelangganKeyTyped
        // TODO add your handling code here:
        BacaTabelTransaksi2();
    }//GEN-LAST:event_txt_cari_nama_pelangganKeyTyped

    private void txt_cari_nama_pelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cari_nama_pelangganActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cari_nama_pelangganActionPerformed

    private void j_tabel_pelangganMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_j_tabel_pelangganMouseClicked
        // TODO add your handling code here:
        int tabelPelanggan = j_tabel_pelanggan.getSelectedRow();
        form_penerimaan_cucian.idPelanggan = j_tabel_pelanggan.getValueAt(tabelPelanggan, 3).toString();
        form_penerimaan_cucian.namaPelanggan = j_tabel_pelanggan.getValueAt(tabelPelanggan, 1).toString();
        this.dispose();
//        new form_penerimaan_cucian().show();
    }//GEN-LAST:event_j_tabel_pelangganMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                liat_pelanggan dialog = new liat_pelanggan(new java.awt.Frame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable j_tabel_pelanggan;
    private javax.swing.JTextField txt_cari_nama_pelanggan;
    // End of variables declaration//GEN-END:variables
}
