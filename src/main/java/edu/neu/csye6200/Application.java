package edu.neu.csye6200;

import edu.neu.csye6200.helper.FileUtils;
import edu.neu.csye6200.helper.Log;
import edu.neu.csye6200.manager.DatabaseManager;
import edu.neu.csye6200.manager.GUIManager;
import org.apache.commons.cli.*;

import javax.swing.*;
import java.nio.file.Paths;

public class Application {

	public static String name = "DayCare";

	/**
	 * Entry Point
	 *
	 * Arguments include:
	 * -db filePath : specify an existing db file
	 * -verbose : enable verbose logging
	 * -help : print help manual
	 *
	 * @author Haotian Zheng
	 * @param args commandline args
	 */
	public static void main(String[] args)
	{
		System.setProperty("log4j.saveDirectory", FileUtils.getPath());
		Options options = new Options();
		options.addOption(Option.builder("db").argName( "pathFile" ).hasArg().desc("The alternative path of the db file").build());
		options.addOption(Option.builder("verbose").desc("Enable extensive logging").build());
		options.addOption(Option.builder("help").desc("Print help").build());
		CommandLineParser parser = new DefaultParser();
		try {
			CommandLine cmd = parser.parse( options, args);
			if (cmd.hasOption("help"))
			{
				HelpFormatter formatter = new HelpFormatter();
				formatter.printHelp( name, options );
				return;
			}
			Log.verbose = cmd.hasOption("verbose");
			DatabaseManager.getInstance().use(cmd.hasOption("db") ? cmd.getOptionValue("db") : Paths.get(FileUtils.getPath(),"prod.sqlite3").toAbsolutePath().toString());
			GUIManager.getInstance().show();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
