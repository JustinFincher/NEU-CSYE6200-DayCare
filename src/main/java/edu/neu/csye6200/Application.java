package edu.neu.csye6200;

import edu.neu.csye6200.helper.Log;
import edu.neu.csye6200.manager.DatabaseManager;
import edu.neu.csye6200.manager.GUIManager;
import org.apache.commons.cli.*;

import java.nio.file.Paths;

public class Application {

	public static String name = "DayCare";
	public static String version = "0.0.1";

	/**
	 * Entry Point
	 *
	 * Arguments include:
	 * -db <filePath> : specify an existing db file
	 * -verbose : enable verbose logging
	 * -help : print help manual
	 *
	 * @author Haotian Zheng
	 * @param args commandline args
	 */
	public static void main(String[] args)
	{
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
			DatabaseManager.getInstance().use(cmd.hasOption("db") ? cmd.getOptionValue("db") : Paths.get("","prod.db").toAbsolutePath().toString());
			GUIManager.getInstance().show();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
