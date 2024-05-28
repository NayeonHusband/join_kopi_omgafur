/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;


import com.formdev.flatlaf.FlatClientProperties;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;


/**
 *
 * 
 * @author User
 */
public class Panel extends javax.swing.JPanel{

    public Panel(String txt,String txt2){
//        putClientProperty(FlatClientProperties.STYLE, "arc: 20");
        setLayout(new BorderLayout());
        setOpaque(false);

        

        // Create a label
        JLabel label = new JLabel(txt);
        label.setFont(new Font("SansSerif", Font.PLAIN, 16));
        add(label, BorderLayout.NORTH);

        // Create a label for the installs count
        JLabel installsLabel = new JLabel(txt2);
        installsLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
        installsLabel.setHorizontalAlignment(SwingConstants.LEFT);
        add(installsLabel, BorderLayout.CENTER);

        // Create a progress bar
        JProgressBar progressBar = new JProgressBar();
        progressBar.setValue(60); // Assuming 60% progress for demonstration
        progressBar.setStringPainted(false); // No percentage text
        add(progressBar, BorderLayout.SOUTH);
    }
}
