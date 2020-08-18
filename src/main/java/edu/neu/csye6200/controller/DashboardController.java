package edu.neu.csye6200.controller;

import edu.neu.csye6200.manager.DatabaseManager;
import edu.neu.csye6200.model.Student;
import edu.neu.csye6200.model.StudentDao;
import edu.neu.csye6200.view.DashboardPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DashboardController
{
    public DashboardController() {
        this.panel = new DashboardPanel();
        panel.refreshTableButton.addActionListener(e -> refresh());
        refresh();
    }

    public DashboardPanel getPanel() { return panel; }
    private DashboardPanel panel;

    public void refresh()
    {
        DefaultPieDataset studentPieDataset = new DefaultPieDataset();
        List<Student> students = DatabaseManager.getDB().onDemand(StudentDao.class).list(Student.class);
        Map<Double, Long> map = students.stream().collect(Collectors.groupingBy(e -> Math.ceil(e.getGrade() / 10.0), Collectors.counting()));
        map.forEach((range, count) -> studentPieDataset.setValue((range*10) + "+", count));
        JFreeChart studentChart = ChartFactory.createPieChart(
                "Student Grades",
                studentPieDataset,
                true,
                true,
                false);
        panel.studentChartPanel.removeAll();
        ChartPanel studentChartPanel = new ChartPanel(studentChart);
        panel.studentChartPanel.add(studentChartPanel);
        panel.studentChartPanel.revalidate();
        panel.studentChartPanel.repaint();
    }
}
