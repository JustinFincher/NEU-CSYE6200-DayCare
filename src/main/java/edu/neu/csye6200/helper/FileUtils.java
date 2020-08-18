package edu.neu.csye6200.helper;

import edu.neu.csye6200.Application;
import edu.neu.csye6200.manager.DatabaseManager;
import edu.neu.csye6200.model.CrudDao;
import edu.neu.csye6200.model.DBObject;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileWriter;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.CodeSource;

public class FileUtils {

    public static <MODEL extends DBObject, DAO extends CrudDao<MODEL>> void importCSV(Class<MODEL> dbCls, Class<DAO> daoCls)
    {
        JFileChooser jfc=new JFileChooser();
        jfc.setFileFilter(new FileNameExtensionFilter("CSV Files","csv"));
        jfc.setFileSelectionMode(JFileChooser.FILES_ONLY );
        jfc.showDialog(new JLabel(), "Select");
        File file = jfc.getSelectedFile();
        if(file.isFile())
        {
            try {
                String s = new String(Files.readAllBytes(file.toPath()));
                DatabaseManager.getDB().onDemand(daoCls).importCSV(s, dbCls);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Failed due to " + e.getMessage());
            }
        }
        JOptionPane.showMessageDialog(null, "Success");
    }

    public static <MODEL extends DBObject, DAO extends CrudDao<MODEL>> void exportCSV(Class<MODEL> dbCls, Class<DAO> daoCls)
    {
        String s = DatabaseManager.getDB().onDemand(daoCls).exportCSV(dbCls);
        String fileName = SQLUtils.getKeyInString(dbCls.getSimpleName()) + ".csv";
        String home = System.getProperty("user.home");
        Path path = Paths.get(home,"Downloads", fileName);
        File file = path.toFile();
        try {
            if (file.exists()) {
                boolean delete = file.delete();
            }
            FileWriter writer = new FileWriter(path.toString());
            writer.write(s);
            writer.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Failed due to " + e.getMessage());
            e.printStackTrace();
        }
        JOptionPane.showMessageDialog(null, "Saved to " + path);
    }

    public static String getPath()
    {
        CodeSource codeSource = Application.class.getProtectionDomain().getCodeSource();
        File jarFile = null;
        try {
            jarFile = new File(codeSource.getLocation().toURI().getPath());
            return jarFile.getParentFile().getParentFile().getParentFile().getPath();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }
}
