/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package sistemreservasihotel;

import com.github.lgooddatepicker.components.DatePicker;
import java.awt.CardLayout;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import javax.swing.JOptionPane;
import java.sql.Connection;
import sistemreservasihotel.dialog.GuestsDataMasterDialog;
import sistemreservasihotel.helper.DatabaseConnection;
import java.sql.PreparedStatement;
import java.util.Arrays;
import java.util.List;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import sistemreservasihotel.helper.service.GuestService;
import sistemreservasihotel.helper.service.RoomService;
import sistemreservasihotel.model.Guest;
import sistemreservasihotel.model.Room;
import sistemreservasihotel.model.User;
import java.sql.Date;
import java.util.HashMap;
import sistemreservasihotel.helper.service.PaymentService;
import sistemreservasihotel.helper.service.ReservationService;
import sistemreservasihotel.model.Reservation;
import sistemreservasihotel.model.ReservationOption;
import sistemreservasihotel.utils.CurrencyUtil;
import sistemreservasihotel.utils.ReportUtil;

/**
 *
 * @author fdn-user
 */
public class DashboardFrame extends javax.swing.JFrame {
    
    private final User userLoggedIn;
    private int roomId = -1;
    DatePicker checkInDate = new DatePicker();
    DatePicker checkOutDate = new DatePicker();

    /**
     * Creates new form DashboardFrame
     * @param user
     */
    public DashboardFrame(User user) {
        this.userLoggedIn = user;
        initComponents();
        initUserData();
        initUIGuest();
        initListener();
    }
    
    private void initListener() {
        cbRoom.addActionListener(e -> {
            String cbStatusRoomValue = (String) cbRoom.getSelectedItem();
            switch (cbStatusRoomValue) {
                case "Single":
                    tvPriceRoom.setText("Rp. 100.000");
                    break;
                case "Double":
                    tvPriceRoom.setText("Rp. 150.000");
                    break;
                case "Suite":
                    tvPriceRoom.setText("Rp. 200.000");
                    break;
                default:
                    break;
            }
        });
    }
    
    private void initReservationDate(){
        pickerCheckIn.setLayout(new java.awt.BorderLayout());
        pickerCheckIn.add(checkInDate);
        pickerCheckOut.setLayout(new java.awt.BorderLayout());
        pickerCheckOut.add(checkOutDate);
    }
    
    private void initUserData() {
        tvUserInfo.setText("Hai, " + userLoggedIn.getUsername());
        if(!"Admin".equals(userLoggedIn.getRole())) {
            btnMenuRoom.setVisible(false);
            btnMenuReport.setVisible(false);
        }
    }
    
    private void initUIGuest() {
        tvGuestName.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (tvGuestName.getText().equals("Masukan Nama Tamu")) {
                    tvGuestName.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (tvGuestName.getText().isEmpty()) {
                    tvGuestName.setText("Masukan Nama Tamu");
                }
            }
        });
        
        tvGuestEmail.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (tvGuestEmail.getText().equals("Masukan Email")) {
                    tvGuestEmail.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (tvGuestEmail.getText().isEmpty()) {
                    tvGuestEmail.setText("Masukan Email");
                }
            }
        });
        
        tvGuestPhone.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (tvGuestPhone.getText().equals("Masukan Nomor Telepon")) {
                    tvGuestPhone.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (tvGuestPhone.getText().isEmpty()) {
                    tvGuestPhone.setText("Masukan Nomor Telepon");
                }
            }
        });
        
        tvGuestAddress.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (tvGuestAddress.getText().equals("Masukan Alamat")) {
                    tvGuestAddress.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (tvGuestAddress.getText().isEmpty()) {
                    tvGuestAddress.setText("Masukan Alamat");
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        menuPanel = new javax.swing.JPanel();
        btnMenuRoom = new javax.swing.JButton();
        btnMenuGuest = new javax.swing.JButton();
        btnMenuReservationRoom = new javax.swing.JButton();
        btnMenuCheckOut = new javax.swing.JButton();
        btnMenuPayment = new javax.swing.JButton();
        btnMenuChckOut = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tvUserInfo = new javax.swing.JLabel();
        btnMenuReport = new javax.swing.JButton();
        btnSignOut = new javax.swing.JButton();
        mainPanel = new javax.swing.JPanel();
        regisPanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        tvGuestPhone = new javax.swing.JTextField();
        tvGuestName = new javax.swing.JTextField();
        tvGuestAddress = new javax.swing.JTextField();
        tvGuestEmail = new javax.swing.JTextField();
        btnShowGuests = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        reservePanel = new javax.swing.JPanel();
        titleReservation = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cbRooms = new javax.swing.JComboBox<>();
        pickerCheckIn = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        pickerCheckOut = new javax.swing.JPanel();
        btnReservation = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblReservation = new javax.swing.JTable();
        cbGuest = new javax.swing.JComboBox<>();
        roomPanel = new javax.swing.JPanel();
        titleFormKamar = new javax.swing.JLabel();
        tvRoomNumber = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cbRoom = new javax.swing.JComboBox<>();
        tvPriceRoom = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cbStatusRoom = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRoom = new javax.swing.JTable();
        btnSaveRoom = new javax.swing.JButton();
        btnDeleteRoom = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        checkin = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblCheckIn = new javax.swing.JTable();
        btnStatusCheckIn = new javax.swing.JButton();
        checkout = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblCheckOut = new javax.swing.JTable();
        btnUpdateStatusCheckOut = new javax.swing.JButton();
        payment = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        cbReservation = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        tfGrandTotal = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        cbPaymentMethod = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tfCatatan = new javax.swing.JTextArea();
        btnPayNow = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblPayment = new javax.swing.JTable();
        report = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        btnReportGuest = new javax.swing.JButton();
        btnReportRooms = new javax.swing.JButton();
        btnReportReservation = new javax.swing.JButton();
        btnReportPayment = new javax.swing.JButton();
        btnReportIncome = new javax.swing.JButton();

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        menuPanel.setBackground(new java.awt.Color(153, 153, 255));

        btnMenuRoom.setBackground(new java.awt.Color(204, 204, 255));
        btnMenuRoom.setText("Form Kamar");
        btnMenuRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuRoomActionPerformed(evt);
            }
        });

        btnMenuGuest.setBackground(new java.awt.Color(204, 204, 255));
        btnMenuGuest.setText("Registrasi Tamu");
        btnMenuGuest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuGuestActionPerformed(evt);
            }
        });

        btnMenuReservationRoom.setBackground(new java.awt.Color(204, 204, 255));
        btnMenuReservationRoom.setText("Reservasi Kamar");
        btnMenuReservationRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuReservationRoomActionPerformed(evt);
            }
        });

        btnMenuCheckOut.setBackground(new java.awt.Color(204, 204, 255));
        btnMenuCheckOut.setText("Check In");
        btnMenuCheckOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuCheckOutActionPerformed(evt);
            }
        });

        btnMenuPayment.setBackground(new java.awt.Color(204, 204, 255));
        btnMenuPayment.setText("Pembayaran");
        btnMenuPayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuPaymentActionPerformed(evt);
            }
        });

        btnMenuChckOut.setBackground(new java.awt.Color(204, 204, 255));
        btnMenuChckOut.setText("Check Out");
        btnMenuChckOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuChckOutActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel1.setText("SELEMAT DATANG");
        jLabel1.setToolTipText("");

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel4.setText("DI RESERVASI HOTEL !");

        tvUserInfo.setFont(new java.awt.Font("Helvetica Neue", 2, 14)); // NOI18N
        tvUserInfo.setText("label name");

        btnMenuReport.setBackground(new java.awt.Color(204, 204, 255));
        btnMenuReport.setText("Report");
        btnMenuReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuReportActionPerformed(evt);
            }
        });

        btnSignOut.setBackground(new java.awt.Color(255, 153, 153));
        btnSignOut.setText("Sign Out");
        btnSignOut.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSignOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignOutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuPanelLayout = new javax.swing.GroupLayout(menuPanel);
        menuPanel.setLayout(menuPanelLayout);
        menuPanelLayout.setHorizontalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menuPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnMenuRoom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnMenuCheckOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnMenuPayment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnMenuChckOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnMenuReservationRoom, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnMenuGuest, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(menuPanelLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1)
                            .addComponent(tvUserInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 45, Short.MAX_VALUE))
                    .addGroup(menuPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnMenuReport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnSignOut, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        menuPanelLayout.setVerticalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(tvUserInfo)
                .addGap(29, 29, 29)
                .addComponent(btnMenuRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnMenuGuest, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnMenuReservationRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnMenuCheckOut, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnMenuChckOut, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnMenuPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnMenuReport, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93)
                .addComponent(btnSignOut, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainPanel.setLayout(new java.awt.CardLayout());

        regisPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel5.setText("Registrasi Data Tamu");

        tvGuestPhone.setText("Masukan Nomor Telepon");
        tvGuestPhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tvGuestPhoneActionPerformed(evt);
            }
        });

        tvGuestName.setText("Masukan Nama Tamu");
        tvGuestName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tvGuestNameActionPerformed(evt);
            }
        });

        tvGuestAddress.setText("Masukan Alamat");
        tvGuestAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tvGuestAddressActionPerformed(evt);
            }
        });

        tvGuestEmail.setText("Masukan Email");
        tvGuestEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tvGuestEmailActionPerformed(evt);
            }
        });

        btnShowGuests.setText("Lihat Data Tamu");
        btnShowGuests.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowGuestsActionPerformed(evt);
            }
        });

        btnSave.setText("Simpan");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout regisPanelLayout = new javax.swing.GroupLayout(regisPanel);
        regisPanel.setLayout(regisPanelLayout);
        regisPanelLayout.setHorizontalGroup(
            regisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, regisPanelLayout.createSequentialGroup()
                .addContainerGap(65, Short.MAX_VALUE)
                .addGroup(regisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(regisPanelLayout.createSequentialGroup()
                        .addComponent(btnShowGuests, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(regisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(tvGuestEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tvGuestName, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tvGuestAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tvGuestPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(125, 125, 125))
            .addGroup(regisPanelLayout.createSequentialGroup()
                .addGap(265, 265, 265)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        regisPanelLayout.setVerticalGroup(
            regisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(regisPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel5)
                .addGap(60, 60, 60)
                .addComponent(tvGuestName, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tvGuestAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tvGuestPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tvGuestEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addGroup(regisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnShowGuests, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(272, Short.MAX_VALUE))
        );

        mainPanel.add(regisPanel, "regisPanel");

        reservePanel.setBackground(new java.awt.Color(255, 255, 255));

        titleReservation.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        titleReservation.setText("Form Reservasi");

        jLabel2.setText("Nama Tamu");

        jLabel7.setText("Pilih Kamar");

        javax.swing.GroupLayout pickerCheckInLayout = new javax.swing.GroupLayout(pickerCheckIn);
        pickerCheckIn.setLayout(pickerCheckInLayout);
        pickerCheckInLayout.setHorizontalGroup(
            pickerCheckInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 386, Short.MAX_VALUE)
        );
        pickerCheckInLayout.setVerticalGroup(
            pickerCheckInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 32, Short.MAX_VALUE)
        );

        jLabel8.setText("Check In");

        jLabel9.setText("Check Out");

        javax.swing.GroupLayout pickerCheckOutLayout = new javax.swing.GroupLayout(pickerCheckOut);
        pickerCheckOut.setLayout(pickerCheckOutLayout);
        pickerCheckOutLayout.setHorizontalGroup(
            pickerCheckOutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 386, Short.MAX_VALUE)
        );
        pickerCheckOutLayout.setVerticalGroup(
            pickerCheckOutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 32, Short.MAX_VALUE)
        );

        btnReservation.setText("Reservasi");
        btnReservation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReservationActionPerformed(evt);
            }
        });

        tblReservation.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nama Tamu", "Nomor Kamar", "Check In", "Check Out", "Status"
            }
        ));
        tblReservation.setBounds(new java.awt.Rectangle(0, 0, 400, 80));
        jScrollPane2.setViewportView(tblReservation);

        javax.swing.GroupLayout reservePanelLayout = new javax.swing.GroupLayout(reservePanel);
        reservePanel.setLayout(reservePanelLayout);
        reservePanelLayout.setHorizontalGroup(
            reservePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reservePanelLayout.createSequentialGroup()
                .addGroup(reservePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(reservePanelLayout.createSequentialGroup()
                        .addGap(267, 267, 267)
                        .addComponent(titleReservation))
                    .addGroup(reservePanelLayout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(reservePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel2))
                        .addGap(50, 50, 50)
                        .addGroup(reservePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pickerCheckOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pickerCheckIn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbRooms, 0, 386, Short.MAX_VALUE)
                            .addComponent(cbGuest, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(reservePanelLayout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(btnReservation, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(reservePanelLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(108, Short.MAX_VALUE))
        );
        reservePanelLayout.setVerticalGroup(
            reservePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reservePanelLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(titleReservation)
                .addGroup(reservePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(reservePanelLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel2))
                    .addGroup(reservePanelLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(cbGuest, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(reservePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbRooms, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(reservePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pickerCheckIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(reservePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pickerCheckOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addComponent(btnReservation, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(105, Short.MAX_VALUE))
        );

        mainPanel.add(reservePanel, "reservePanel");

        roomPanel.setBackground(new java.awt.Color(255, 255, 255));

        titleFormKamar.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        titleFormKamar.setText("Form Kamar");

        tvRoomNumber.setText("Masukan Nomor Kamar");
        tvRoomNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tvRoomNumberActionPerformed(evt);
            }
        });

        jLabel3.setText("Pilih Jenis Kamar");

        cbRoom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Single", "Double", "Suite" }));
        cbRoom.setToolTipText("");

        tvPriceRoom.setText("Rp. 0");

        jLabel6.setText("Pilih Status Kamar");

        cbStatusRoom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Available", "Occupied" }));

        tblRoom.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Room ID", "Room Number", "Type", "Price", "Status"
            }
        ));
        tblRoom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblRoomMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblRoom);

        btnSaveRoom.setText("Simpan");
        btnSaveRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveRoomActionPerformed(evt);
            }
        });

        btnDeleteRoom.setText("Hapus");
        btnDeleteRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteRoomActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout roomPanelLayout = new javax.swing.GroupLayout(roomPanel);
        roomPanel.setLayout(roomPanelLayout);
        roomPanelLayout.setHorizontalGroup(
            roomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roomPanelLayout.createSequentialGroup()
                .addContainerGap(158, Short.MAX_VALUE)
                .addGroup(roomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roomPanelLayout.createSequentialGroup()
                        .addGroup(roomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(roomPanelLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(29, 29, 29)
                                .addComponent(cbStatusRoom, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(roomPanelLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(35, 35, 35)
                                .addComponent(cbRoom, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(tvRoomNumber)
                            .addComponent(tvPriceRoom)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE)
                            .addGroup(roomPanelLayout.createSequentialGroup()
                                .addComponent(btnSaveRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnDeleteRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roomPanelLayout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(titleFormKamar)
                        .addGap(259, 259, 259))))
        );
        roomPanelLayout.setVerticalGroup(
            roomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roomPanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(titleFormKamar)
                .addGap(35, 35, 35)
                .addComponent(tvRoomNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(roomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(tvPriceRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(roomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbStatusRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(roomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSaveRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleteRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(150, 150, 150))
        );

        mainPanel.add(roomPanel, "roomPanel");

        checkin.setBackground(new java.awt.Color(255, 255, 255));

        jLabel10.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        jLabel10.setText("Form Check In");

        tblCheckIn.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nama Tamu", "No Kamar", "Check In", "Check Out"
            }
        ));
        jScrollPane3.setViewportView(tblCheckIn);

        btnStatusCheckIn.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        btnStatusCheckIn.setText("CHECK IN");
        btnStatusCheckIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStatusCheckInActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout checkinLayout = new javax.swing.GroupLayout(checkin);
        checkin.setLayout(checkinLayout);
        checkinLayout.setHorizontalGroup(
            checkinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(checkinLayout.createSequentialGroup()
                .addGroup(checkinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(checkinLayout.createSequentialGroup()
                        .addGap(236, 236, 236)
                        .addComponent(jLabel10))
                    .addGroup(checkinLayout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(checkinLayout.createSequentialGroup()
                        .addGap(199, 199, 199)
                        .addComponent(btnStatusCheckIn, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(115, Short.MAX_VALUE))
        );
        checkinLayout.setVerticalGroup(
            checkinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(checkinLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnStatusCheckIn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(232, Short.MAX_VALUE))
        );

        mainPanel.add(checkin, "checkin");

        checkout.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        jLabel11.setText("FORM CHECK OUT");

        tblCheckOut.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nama Tamu", "No Kamar", "Check In", "Check Out"
            }
        ));
        jScrollPane4.setViewportView(tblCheckOut);

        btnUpdateStatusCheckOut.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        btnUpdateStatusCheckOut.setText("CHECK OUT");
        btnUpdateStatusCheckOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateStatusCheckOutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout checkoutLayout = new javax.swing.GroupLayout(checkout);
        checkout.setLayout(checkoutLayout);
        checkoutLayout.setHorizontalGroup(
            checkoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(checkoutLayout.createSequentialGroup()
                .addGroup(checkoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(checkoutLayout.createSequentialGroup()
                        .addGap(235, 235, 235)
                        .addComponent(jLabel11))
                    .addGroup(checkoutLayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(checkoutLayout.createSequentialGroup()
                        .addGap(267, 267, 267)
                        .addComponent(btnUpdateStatusCheckOut, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        checkoutLayout.setVerticalGroup(
            checkoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(checkoutLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnUpdateStatusCheckOut, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(236, Short.MAX_VALUE))
        );

        mainPanel.add(checkout, "checkout");

        payment.setBackground(new java.awt.Color(255, 255, 255));

        jLabel12.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        jLabel12.setText("Form Pembayaran");

        jLabel13.setText("Reservasi Kamar");

        cbReservation.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbReservationItemStateChanged(evt);
            }
        });
        cbReservation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbReservationActionPerformed(evt);
            }
        });

        jLabel14.setText("Total Tagihan");

        tfGrandTotal.setText("Rp 0");

        jLabel15.setText("Metode Pembayaran");

        cbPaymentMethod.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cash", "Cradit Card", "Debit Card", "Qris" }));

        jLabel16.setText("Catatan");

        tfCatatan.setColumns(20);
        tfCatatan.setRows(5);
        jScrollPane5.setViewportView(tfCatatan);

        btnPayNow.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        btnPayNow.setText("Bayar");
        btnPayNow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPayNowActionPerformed(evt);
            }
        });

        tblPayment.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "No", "Payment ID", "Reservation ID", "Nama Tamu", "Nomor Kamar", "Tanggal Bayar", "Total Tagihan", "Metode Pembayaran", "Catatan"
            }
        ));
        jScrollPane6.setViewportView(tblPayment);

        javax.swing.GroupLayout paymentLayout = new javax.swing.GroupLayout(payment);
        payment.setLayout(paymentLayout);
        paymentLayout.setHorizontalGroup(
            paymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paymentLayout.createSequentialGroup()
                .addGroup(paymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paymentLayout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addGroup(paymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnPayNow, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(paymentLayout.createSequentialGroup()
                                .addGroup(paymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel16))
                                .addGap(28, 28, 28)
                                .addGroup(paymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel12)
                                    .addComponent(cbReservation, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tfGrandTotal)
                                    .addComponent(cbPaymentMethod, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)))))
                    .addGroup(paymentLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        paymentLayout.setVerticalGroup(
            paymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paymentLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addGroup(paymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(cbReservation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(paymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfGrandTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(paymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbPaymentMethod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(paymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addGap(44, 44, 44)
                .addComponent(btnPayNow, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
        );

        mainPanel.add(payment, "payment");

        report.setBackground(new java.awt.Color(255, 255, 255));

        jLabel17.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        jLabel17.setText("Cetak Laporan");

        btnReportGuest.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        btnReportGuest.setText("Cetak Data Tamu");
        btnReportGuest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportGuestActionPerformed(evt);
            }
        });

        btnReportRooms.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        btnReportRooms.setText("Cetak Data Kamar");
        btnReportRooms.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportRoomsActionPerformed(evt);
            }
        });

        btnReportReservation.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        btnReportReservation.setText("Laporan Reservasi");
        btnReportReservation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportReservationActionPerformed(evt);
            }
        });

        btnReportPayment.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        btnReportPayment.setText("Laporan Pembayaran");
        btnReportPayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportPaymentActionPerformed(evt);
            }
        });

        btnReportIncome.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        btnReportIncome.setText("Laporan Pemasukan");
        btnReportIncome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportIncomeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout reportLayout = new javax.swing.GroupLayout(report);
        report.setLayout(reportLayout);
        reportLayout.setHorizontalGroup(
            reportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reportLayout.createSequentialGroup()
                .addGroup(reportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(reportLayout.createSequentialGroup()
                        .addGap(260, 260, 260)
                        .addComponent(jLabel17))
                    .addGroup(reportLayout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addGroup(reportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnReportGuest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnReportRooms, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnReportReservation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnReportPayment, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
                            .addComponent(btnReportIncome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(180, Short.MAX_VALUE))
        );
        reportLayout.setVerticalGroup(
            reportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reportLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel17)
                .addGap(65, 65, 65)
                .addComponent(btnReportGuest, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnReportRooms, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnReportReservation, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnReportPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnReportIncome, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(305, Short.MAX_VALUE))
        );

        mainPanel.add(report, "report");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(menuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMenuRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuRoomActionPerformed
        loadRoom();
        CardLayout card = (CardLayout)mainPanel.getLayout();
        card.show(mainPanel, "roomPanel");
    }//GEN-LAST:event_btnMenuRoomActionPerformed

    private void loadRoom() {
        DefaultTableModel model = (DefaultTableModel) tblRoom.getModel();
        model.setRowCount(0); // clear isi tabel

        List<Room> rooms = RoomService.loadRooms(); // kamu perlu buat fungsi ini

        for (Room room : rooms) {
            model.addRow(new Object[]{
                room.getRoomId(),
                room.getRoomNumber(),
                room.getType(),
                room.getPrice(),
                room.getStatus()
            });
        }
    }
    
    private void btnMenuGuestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuGuestActionPerformed
        // TODO add your handling code here:
        CardLayout card = (CardLayout)mainPanel.getLayout();
        card.show(mainPanel, "regisPanel");
    }//GEN-LAST:event_btnMenuGuestActionPerformed

    private void btnMenuReservationRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuReservationRoomActionPerformed
        // TODO add your handling code here:
        initReservationDate();
        loadGuestsToComboBox();
        loadRoomsToComboBox();
        ReservationService.loadReservationsByStatus(tblReservation, "booked");
        CardLayout card = (CardLayout)mainPanel.getLayout();
        card.show(mainPanel, "reservePanel");
    }//GEN-LAST:event_btnMenuReservationRoomActionPerformed

    private void btnMenuCheckOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuCheckOutActionPerformed
        // TODO add your handling code here:
        ReservationService.loadReservationsByStatus(tblCheckIn, "booked");
        CardLayout card = (CardLayout)mainPanel.getLayout();
        card.show(mainPanel, "checkin");
    }//GEN-LAST:event_btnMenuCheckOutActionPerformed

    private void btnMenuPaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuPaymentActionPerformed
        // TODO add your handling code here:
        ReservationService.loadReservationsToComboBox(cbReservation);
        PaymentService.loadPayments(tblPayment);
        CardLayout card = (CardLayout)mainPanel.getLayout();
        card.show(mainPanel, "payment");
    }//GEN-LAST:event_btnMenuPaymentActionPerformed

    private void btnMenuChckOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuChckOutActionPerformed
        // TODO add your handling code here:
        ReservationService.loadReservationsByStatus(tblCheckOut, "checked_in");
        CardLayout card = (CardLayout)mainPanel.getLayout();
        card.show(mainPanel, "checkout");
    }//GEN-LAST:event_btnMenuChckOutActionPerformed

    private void tvGuestPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tvGuestPhoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tvGuestPhoneActionPerformed

    private void tvGuestNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tvGuestNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tvGuestNameActionPerformed

    private void tvGuestAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tvGuestAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tvGuestAddressActionPerformed

    private void tvGuestEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tvGuestEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tvGuestEmailActionPerformed

    private void btnShowGuestsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowGuestsActionPerformed
        // TODO add your handling code here:
        GuestsDataMasterDialog dialog = new GuestsDataMasterDialog(this, true);
        dialog.setVisible(true);
    }//GEN-LAST:event_btnShowGuestsActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        saveGuest();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void tvRoomNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tvRoomNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tvRoomNumberActionPerformed

    private void btnSaveRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveRoomActionPerformed
        // TODO add your handling code here:
        String roomNumber = tvRoomNumber.getText();
        String cbRoomValue = cbRoom.getSelectedItem().toString();
        String priceValue = tvPriceRoom.getText();
        String cbStatusRoomValue = cbStatusRoom.getSelectedItem().toString();
        double price = Double.parseDouble(priceValue.replace("Rp.", "").replace(".", "").trim());
        Room room = new Room(0, roomNumber, cbRoomValue, price, cbStatusRoomValue);
        boolean success = RoomService.saveRoom(room);
        if (success) {
            JOptionPane.showMessageDialog(this, "Kamar berhasil disimpan.");
            loadRoom();
        } else {
            JOptionPane.showMessageDialog(this, "Gagal menyimpan kamar.");
        }
    }//GEN-LAST:event_btnSaveRoomActionPerformed

    private void tblRoomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblRoomMouseClicked
        // TODO add your handling code here:
        int selectedRow = tblRoom.getSelectedRow();
        if (selectedRow >= 0) {
            roomId = Integer.parseInt( tblRoom.getValueAt(selectedRow, 0).toString());
            tvRoomNumber.setText(tblRoom.getValueAt(selectedRow, 1).toString());
            cbRoom.setSelectedItem(tblRoom.getValueAt(selectedRow, 2).toString());
            tvPriceRoom.setText("Rp. " + tblRoom.getValueAt(selectedRow, 3).toString());
            cbStatusRoom.setSelectedItem(tblRoom.getValueAt(selectedRow, 4).toString());
        }
    }//GEN-LAST:event_tblRoomMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        if(roomId == -1) return;
        String roomNumber = tvRoomNumber.getText();
        String cbRoomValue = cbRoom.getSelectedItem().toString();
        String priceValue = tvPriceRoom.getText();
        String cbStatusRoomValue = cbStatusRoom.getSelectedItem().toString();
        double price = Double.parseDouble(priceValue.replace("Rp.", "").replace(".", "").trim());
        Room room = new Room(roomId, roomNumber, cbRoomValue, price, cbStatusRoomValue);
        boolean success = RoomService.updateRoom(room);
        if (success) {
            JOptionPane.showMessageDialog(this, "Data kamar berhasil diperbarui.");
            loadRoom();
        } else {
            JOptionPane.showMessageDialog(this, "Gagal memperbarui data kamar.");
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteRoomActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblRoom.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Pilih data kamar terlebih dahulu.");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "Yakin ingin menghapus kamar ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            int roomIdDelete = Integer.parseInt(tblRoom.getValueAt(selectedRow, 0).toString());
            boolean success = RoomService.deleteRoom(roomIdDelete);

            if (success) {
                JOptionPane.showMessageDialog(this, "Data kamar berhasil dihapus.");
                loadRoom();
            } else {
                JOptionPane.showMessageDialog(this, "Gagal menghapus data kamar.");
            }
    }
    }//GEN-LAST:event_btnDeleteRoomActionPerformed

    private void btnReservationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReservationActionPerformed
        // TODO add your handling code here:
        
        if (checkInDate.getDate() == null || checkOutDate.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Mohon pilih tanggal check-in dan check-out!");
            return;
        }
        Guest selectedGuest = (Guest) cbGuest.getSelectedItem();
        int guestId = selectedGuest.getGuestId();
        Room selectedRoom = (Room) cbRooms.getSelectedItem();
        int roomId = selectedRoom.getRoomId();
        Date sqlCheckInDate = java.sql.Date.valueOf(checkInDate.getDate());
        Date sqlCheckOutDate = java.sql.Date.valueOf(checkOutDate.getDate());
        boolean isReserved = ReservationService.saveReservation(new Reservation(
        guestId, roomId,sqlCheckInDate,sqlCheckOutDate, "booked"
        ));
        if (isReserved) {
            JOptionPane.showMessageDialog(this, "Reservasi berhasil disimpan.");
            RoomService.updateRoomStatus(roomId, "Occupied");
            ReservationService.loadReservationsByStatus(tblReservation, "booked");
            loadRoomsToComboBox();
        } else {
            JOptionPane.showMessageDialog(this, "Gagal menyimpan kamar.");
        }
    }//GEN-LAST:event_btnReservationActionPerformed

    private void btnStatusCheckInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStatusCheckInActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblCheckIn.getSelectedRow();
        if (selectedRow >= 0) {
            int reservationId = (int) tblCheckIn.getValueAt(selectedRow, 0);
            String roomNumber = (String) tblCheckIn.getValueAt(selectedRow, 2);
            int roomSelected = RoomService.getRoomIdByRoomNumber(roomNumber);

            ReservationService.checkInReservation(reservationId, roomSelected);
            ReservationService.loadReservationsByStatus(tblCheckIn, "booked");
            JOptionPane.showMessageDialog(null, "Check-In berhasil!");
        } else {
            JOptionPane.showMessageDialog(this, "Pilih data terlebih dahulu.");
        }
    }//GEN-LAST:event_btnStatusCheckInActionPerformed

    private void btnUpdateStatusCheckOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateStatusCheckOutActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblCheckOut.getSelectedRow();
        if (selectedRow >= 0) {
            int reservationId = (int) tblCheckOut.getValueAt(selectedRow, 0);
            String roomNumber = (String) tblCheckOut.getValueAt(selectedRow, 2);
            int roomSelected = RoomService.getRoomIdByRoomNumber(roomNumber);

            ReservationService.checkOutReservation(reservationId, roomSelected);
            ReservationService.loadReservationsByStatus(tblCheckOut, "checked_in");
            JOptionPane.showMessageDialog(null, "Check-Out berhasil!");
        } else {
            JOptionPane.showMessageDialog(this, "Pilih data terlebih dahulu.");
        }
    }//GEN-LAST:event_btnUpdateStatusCheckOutActionPerformed

    private void cbReservationItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbReservationItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            ReservationOption selected = (ReservationOption) cbReservation.getSelectedItem();
            if (selected != null) {
                double total = ReservationService.calculateTotalPayment(selected.getReservationId());
                tfGrandTotal.setText(CurrencyUtil.formatRupiah(total));
            }
        }
    }//GEN-LAST:event_cbReservationItemStateChanged

    private void cbReservationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbReservationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbReservationActionPerformed

    private void btnPayNowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPayNowActionPerformed
        // TODO add your handling code here:
        ReservationOption selected = (ReservationOption) cbReservation.getSelectedItem();
        String method = (String) cbPaymentMethod.getSelectedItem(); // ComboBox metode bayar
        String notes = tfCatatan.getText(); // TextArea catatan

        if (selected != null) {
            int reservationId = selected.getReservationId();

            try {
                String grandTotalStr = tfGrandTotal.getText().replace("Rp", "").replace(",00", "").replace(".", "").trim();
                double totalAmount = Double.parseDouble(grandTotalStr);

                PaymentService.savePayment(reservationId, totalAmount, method, notes);
                PaymentService.loadPayments(tblPayment);
                resetFormPembayaran();

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Total tagihan tidak valid.");
            }

        } else {
            JOptionPane.showMessageDialog(this, "Silakan pilih reservasi terlebih dahulu.");
        }
    }//GEN-LAST:event_btnPayNowActionPerformed

    private void btnMenuReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuReportActionPerformed
        // TODO add your handling code here:
        CardLayout card = (CardLayout)mainPanel.getLayout();
        card.show(mainPanel, "report");
    }//GEN-LAST:event_btnMenuReportActionPerformed

    private void btnReportGuestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportGuestActionPerformed
        // TODO add your handling code here:
        ReportUtil.showReport("/Users/fdn-user/JaspersoftWorkspace/LaporanHotel/report_guests.jasper", new HashMap<>());
    }//GEN-LAST:event_btnReportGuestActionPerformed

    private void btnReportRoomsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportRoomsActionPerformed
        // TODO add your handling code here:
        ReportUtil.showReport("/Users/fdn-user/JaspersoftWorkspace/LaporanHotel/report_rooms.jasper", new HashMap<>());
    }//GEN-LAST:event_btnReportRoomsActionPerformed

    private void btnReportPaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportPaymentActionPerformed
        // TODO add your handling code here:
        ReportUtil.showReport("/Users/fdn-user/JaspersoftWorkspace/LaporanHotel/report_payment.jasper", new HashMap<>());
    }//GEN-LAST:event_btnReportPaymentActionPerformed

    private void btnReportReservationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportReservationActionPerformed
        // TODO add your handling code here:
        ReportUtil.showReport("/Users/fdn-user/JaspersoftWorkspace/LaporanHotel/report_reservation.jasper", new HashMap<>());
    }//GEN-LAST:event_btnReportReservationActionPerformed

    private void btnReportIncomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportIncomeActionPerformed
        // TODO add your handling code here:
        ReportUtil.showReport("/Users/fdn-user/JaspersoftWorkspace/LaporanHotel/report_income.jasper", new HashMap<>());
    }//GEN-LAST:event_btnReportIncomeActionPerformed

    private void btnSignOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignOutActionPerformed
        // TODO add your handling code here:
        int confirm = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin keluar?", "Konfirmasi Keluar", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            this.dispose(); // Tutup Dashboard
            new LoginForm().setVisible(true); // Tampilkan Login
        }
    }//GEN-LAST:event_btnSignOutActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeleteRoom;
    private javax.swing.JButton btnMenuChckOut;
    private javax.swing.JButton btnMenuCheckOut;
    private javax.swing.JButton btnMenuGuest;
    private javax.swing.JButton btnMenuPayment;
    private javax.swing.JButton btnMenuReport;
    private javax.swing.JButton btnMenuReservationRoom;
    private javax.swing.JButton btnMenuRoom;
    private javax.swing.JButton btnPayNow;
    private javax.swing.JButton btnReportGuest;
    private javax.swing.JButton btnReportIncome;
    private javax.swing.JButton btnReportPayment;
    private javax.swing.JButton btnReportReservation;
    private javax.swing.JButton btnReportRooms;
    private javax.swing.JButton btnReservation;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSaveRoom;
    private javax.swing.JButton btnShowGuests;
    private javax.swing.JButton btnSignOut;
    private javax.swing.JButton btnStatusCheckIn;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnUpdateStatusCheckOut;
    private javax.swing.JComboBox<Guest> cbGuest;
    private javax.swing.JComboBox<String> cbPaymentMethod;
    private javax.swing.JComboBox<ReservationOption> cbReservation;
    private javax.swing.JComboBox<String> cbRoom;
    private javax.swing.JComboBox<Room> cbRooms;
    private javax.swing.JComboBox<String> cbStatusRoom;
    private javax.swing.JPanel checkin;
    private javax.swing.JPanel checkout;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JPanel payment;
    private javax.swing.JPanel pickerCheckIn;
    private javax.swing.JPanel pickerCheckOut;
    private javax.swing.JPanel regisPanel;
    private javax.swing.JPanel report;
    private javax.swing.JPanel reservePanel;
    private javax.swing.JPanel roomPanel;
    private javax.swing.JTable tblCheckIn;
    private javax.swing.JTable tblCheckOut;
    private javax.swing.JTable tblPayment;
    private javax.swing.JTable tblReservation;
    private javax.swing.JTable tblRoom;
    private javax.swing.JTextArea tfCatatan;
    private javax.swing.JTextField tfGrandTotal;
    private javax.swing.JLabel titleFormKamar;
    private javax.swing.JLabel titleReservation;
    private javax.swing.JTextField tvGuestAddress;
    private javax.swing.JTextField tvGuestEmail;
    private javax.swing.JTextField tvGuestName;
    private javax.swing.JTextField tvGuestPhone;
    private javax.swing.JTextField tvPriceRoom;
    private javax.swing.JTextField tvRoomNumber;
    private javax.swing.JLabel tvUserInfo;
    // End of variables declaration//GEN-END:variables


    
    
private void saveGuest() {
    String name = tvGuestName.getText().trim();
    String address = tvGuestAddress.getText().trim();
    String phone = tvGuestPhone.getText().trim();
    String email = tvGuestEmail.getText().trim();
    
    if (name.isEmpty() || phone.isEmpty() || email.isEmpty() || address.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nama, No HP, dan Email wajib diisi.");
            return;
    }
    
    try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO guests (name, address, phone_number, email) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, address);
            stmt.setString(3, phone);
            stmt.setString(4, email);

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(this, "Tamu berhasil terdaftar!");
                resetField(Arrays.asList(tvGuestName, tvGuestAddress, tvGuestPhone, tvGuestEmail));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Gagal menyimpan data tamu.");
        }
    }

private void loadGuestsToComboBox() {
    List<Guest> guests = GuestService.getAllGuests();
    if(cbGuest.getItemCount() != 0) {
        cbGuest.removeAllItems();
    }

    for (Guest g : guests) {
        cbGuest.addItem(g); // akan tampil nama, karena kita override toString
    }
}

private void loadRoomsToComboBox() {
    List<Room> rooms = RoomService.getAvailableRooms();
    if(cbRooms.getItemCount() != 0) {
        cbRooms.removeAllItems();
    }
    

    for (Room r : rooms) {
        cbRooms.addItem(r); // akan tampil nama, karena kita override toString
    }
}

private void resetField(List<JTextField> fields) {
    for (JTextField field : fields) {
        field.setText("");
    }
}

private void resetFormPembayaran() {
    cbReservation.setSelectedIndex(0);
    cbPaymentMethod.setSelectedIndex(0);
    tfGrandTotal.setText("");
    tfCatatan.setText("");
    ReservationService.loadReservationsToComboBox(cbReservation);
}



}