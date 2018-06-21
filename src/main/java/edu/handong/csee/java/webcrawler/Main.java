package edu.handong.csee.java.webcrawler;

import org.apache.commons.cli.*;

public class Main {
	
	String inputPath;
	String outputPath;
	boolean help;
	
	public static void main(String[] args) {
	    Main runner = new Main();
		runner.run(args);
	}
	
	private void run(String[] args) {
		Options options = createOptions();

		if(parseOptions(options, args)){
			if (help){
				printHelp(options);
				return;
			}

			URLReader reader = new URLReader(inputPath);
			String result="";
			
			try {
				result = reader.getOutput();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			FileWriter writer = new FileWriter(outputPath, result);
			writer.getOutput();
		}
	}
	
	private boolean parseOptions(Options options,String[] args) {
		CommandLineParser parser = new DefaultParser();

		try {
			CommandLine cmd = parser.parse(options, args);

			inputPath = cmd.getOptionValue("i");
			outputPath = cmd.getOptionValue("o");
			help = cmd.hasOption("h");

		} catch (Exception e) {
			printHelp(options);
			return false;
		}

		return true;
	}
	
	private Options createOptions() {
		Options options = new Options();

		options.addOption(Option.builder("u").longOpt("urlPath")
				.desc("Put url-address")
				.hasArg()
				.argName("URL Path")
				.required()
				.build());

		options.addOption(Option.builder("d").longOpt("ouputdir")
				.desc("Set a filename")
				.hasArg()
				.argName("filename")
				.required()
				.build());

		options.addOption(Option.builder("h").longOpt("help")
				.desc("Help")
				.build());

		return options;

	}

	private void printHelp(Options options) {
		HelpFormatter formatter = new HelpFormatter();
		String header = "WebPageCrawler program";
		String footer ="\nPlease report issues to https://github.com/drone8449/WebPageCrawler/issues"; 
		formatter.printHelp("CLIExample", header, options, footer, true);
	}
}
