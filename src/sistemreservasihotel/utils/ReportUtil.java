/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemreservasihotel.utils;

import java.util.Map;
import sistemreservasihotel.helper.DatabaseConnection;
import java.sql.Connection;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author fdn-user
 */
public class ReportUtil {
    public static void showReport(String reportPath, Map<String, Object> parameters) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            JasperPrint print = JasperFillManager.fillReport(reportPath, parameters, conn);
            JasperViewer.viewReport(print, false);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Gagal menampilkan report: " + e.getMessage());
        }
    }
}
