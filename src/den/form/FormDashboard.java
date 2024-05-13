package den.form;

import com.formdev.flatlaf.FlatClientProperties;
import java.awt.Color;
import java.awt.Component;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JPanel;

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

    public FormDashboard() {
        initComponents();
        setLayout(new MigLayout("fill,wrap,insets 30", "fill", "push[][grow,push,top ]"));
        init();
        lineChart.startAnimation();

    }

    private void init() {
        JPanel panel1 = new JPanel(new MigLayout("", "left top",""));
        panel1.putClientProperty(FlatClientProperties.STYLE, "arc:20");
        panel1.setBackground(Color.BLACK);
        JLabel label = new JLabel("Overview");
        label.setForeground(Color.white);
        panel1.add(label);
        add(panel1);
        createLineChart();

    }

    private void createLineChartData() {
        DefaultCategoryDataset<String, String> categoryDataset = new DefaultCategoryDataset<>();
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("MMM dd, yyyy");
        Random ran = new Random();
        int randomDate = 30;
        for (int i = 1; i <= randomDate; i++) {
            String date = df.format(cal.getTime());
            categoryDataset.addValue(ran.nextInt(2000000), "Pemasukan", date);
            categoryDataset.addValue(ran.nextInt(2000000), "Pengeluaran", date);
            categoryDataset.addValue(ran.nextInt(2000000), "Keuntungan", date);

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

            double d = Math.ceil((diff / 7f));
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
        lineChart.getChartColor().addColor(Color.decode("#0096FF"), Color.decode("#FFBF00"),
                Color.decode("#FFBF00"));

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
        add(lineChart);
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
