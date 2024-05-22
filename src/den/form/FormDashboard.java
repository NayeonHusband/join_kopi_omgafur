package den.form;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.ui.FlatLineBorder;
import java.awt.Color;
import java.awt.Component;

import java.awt.Font;
import java.awt.Insets;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import java.util.Random;

//import javafx.scene.control.ComboBox;

import javax.swing.BorderFactory;

import javax.swing.JComboBox;
import javax.swing.JLabel;

import javax.swing.JPanel;
import utils.Panel;

import raven.chart.data.category.DefaultCategoryDataset;
import net.miginfocom.swing.MigLayout;
import raven.chart.line.LineChart;
import utils.DateCalculator;
import raven.chart.ChartLegendRenderer;

/**
 *
 * @author den
 */
public class FormDashboard extends javax.swing.JPanel {

    private LineChart lineChart;
    private JPanel Bawah ;

    public FormDashboard() {
        initComponents();
        setLayout(new MigLayout("insets 10", "grow,push"));
//        setBackground(Color.decode("#e6e6e6"));
//        putClientProperty(FlatClientProperties.STYLE, "arc:20");
       
        init();
    }

    
    private void init() {
        JPanel panel1 = new JPanel(new MigLayout("","grow,push"));
        Bawah = new JPanel(new MigLayout("","grow,push"));
        Bawah.setOpaque(true);
        Bawah.putClientProperty(FlatClientProperties.STYLE, "background: tint(@background,50%);"
                + "border: 16,16,16,16,shade(@background,10%),,8");


//        panel1.setBackground(Color.black);
        panel1.putClientProperty(FlatClientProperties.STYLE, "arc: 20");
        JLabel OverviewText = new JLabel("Overview");
//        OverviewText.setForeground(Color);
        OverviewText.putClientProperty(FlatClientProperties.STYLE, "font: bold $h2.font;");

       
        add(OverviewText,"grow,wrap");
        
        //baris 2
//        panel1.add(OverviewText, "grow,wrap");

            

        String[] teks = {"Test", "Anjay", "ASDASD", "ASDSADAA", "ASDSAAAAAADAA", "ASDSADAA", "ASDSADAA", "ASDSADAA", "ASDSADAA", "ASDSADAA", "ASDSADAA", "ASDSADAA", "ASDSADAA", "ASDSADAA", "ASDSADAA"};
        
        JComboBox combobox = new JComboBox(teks) {
            class MyComboBoxEditor extends javax.swing.plaf.basic.BasicComboBoxEditor {

                private JLabel label = new JLabel();
                private JPanel panel = new JPanel();
                private JPanel panel1 = new JPanel();
                private JPanel panel2 = new JPanel();
                private Object selectedItem;
                
                

                public MyComboBoxEditor() {

                    label.setFont(new Font("Arial", Font.PLAIN, 14));

                    panel1.setLayout(new MigLayout("insets 2 4 2 4"));
                    panel1.putClientProperty(FlatClientProperties.STYLE, "arc:10;background:#da6225");
                    panel1.setOpaque(true); // Ensure panel1 is opaque

                    panel2.add(panel1);
                    panel2.setOpaque(true);

                    panel.setLayout(new MigLayout ("insets 0 20 0 100","push,grow"));
                    JLabel labelApp = new JLabel("App");
                    labelApp.setFont(new Font("Roboto",Font.BOLD,15));
                    panel.add(labelApp, "split 2");
                    panel.add(panel2);
                    
                }

                @Override
                public Component getEditorComponent() {
                    return this.panel;
                }

                @Override
                public Object getItem() {
                    return selectedItem == null ? null : selectedItem.toString();
                }

                @Override
                public void setItem(Object item) {
                    this.selectedItem = item;
                    if (item != null) {

                        label.setText(item.toString());
                        label.setForeground(Color.white);
                        panel1.add(label);
                    } else {
                        label.setText("");
                    }
//                    panel1.revalidate();
//                    panel1.repaint();
                }
            }

            {

                setEditor(new MyComboBoxEditor());
                setEditable(true);
                setMaximumRowCount(3);

            }
        };
        combobox.putClientProperty(FlatClientProperties.STYLE, "buttonSeparatorWidth:1;");

        
        add(combobox,"span");
//        panel1.add(combobox);
//        add(panel1, "wrap,grow");
        add(Bawah,"grow");
       
        Bawah.add(new Panel(),"split 3,gapright 20");
        Bawah.add(new Panel(),"gapright 20");
        Bawah.add(new Panel(),"wrap");

        createLineChart();

    }

    private void createLineChartData() {
        DefaultCategoryDataset<String, String> categoryDataset = new DefaultCategoryDataset<>();
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("MMM dd");
        Random ran = new Random();
        int randomDate = 30;
        for (int i = 1; i <= randomDate; i++) {
            String date = df.format(cal.getTime());
            categoryDataset.addValue(ran.nextInt(1000000) + 5, "Income", date);
            categoryDataset.addValue(ran.nextInt(1000000) + 5, "Expense", date);
            categoryDataset.addValue(ran.nextInt(1000000) + 5, "Profit", date);
            categoryDataset.addValue(ran.nextInt(1000000) + 5, "Test", date);

            cal.add(Calendar.DATE, 1);
        }

        /**
         * Control the legend we do not show all legend
         */
        try {
            Date date = df.parse(categoryDataset.getColumnKey(0));
            Date dateEnd = df.parse(categoryDataset.getColumnKey(categoryDataset.getColumnCount() - 1));

            DateCalculator dcal = new DateCalculator(date, dateEnd);
            long diff = dcal.getDifferenceDays();

            double d = Math.ceil((diff / 10f));
            lineChart.setLegendRenderer(new ChartLegendRenderer() {
                @Override
                public Component getLegendComponent(Object legend, int index) {
                    if (index % d == 0) {
                        return super.getLegendComponent(legend, index);
                    } else {
                        return null;
                    }
                }
            });

        } catch (ParseException e) {
            System.err.println(e);
        }

        lineChart.setCategoryDataset(categoryDataset);
        lineChart.getChartColor().addColor(Color.decode("#38bdf8"), Color.decode("#fb7185"), Color.decode("#FFBF00"), Color.decode("#FFBF00"));

        JLabel header = new JLabel("Data Pendapatan");
        header.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:+1;"
                + "border:0,0,5,0");
        lineChart.setHeader(header);
    }

    private void createLineChart() {
        lineChart = new LineChart();
        lineChart.setChartType(LineChart.ChartType.CURVE);
        lineChart.putClientProperty(FlatClientProperties.STYLE, ""
                + "border:5,5,5,5,$Component.borderColor,,20"); //
//        add(lineChart, "growx, wrap");
        Bawah.add(lineChart,"growx,wrap");
        createLineChartData();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 218, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 93, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
