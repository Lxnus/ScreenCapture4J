package screencapture4j;

public class Strings {

    /**
     * Author: Linus Schmidt!
     * All rights reserved!
     */
	
	public static String name = "Ultimatum";
	public static String version = "0.0.1";
	public static String author = "Linus Schmidt";
	
	public static String console = "[" + Strings.Name + "]: ";
	public static String console_Information = "[" + Strings.Name + "-Information]: ";
	public static String console_Error = "[" + Strings.Name + "-Error]: ";
	
	public static void print_Console(String consoleText) {
		System.out.println(Strings.Console + consoleText);
	}
	
	public static void print_Console_Information(String console_Information_Text) {
		System.out.println(Strings.Console_Information + console_Information_Text);
	}
	
	public static void print_Console_Error(String console_Error_Text) {
		System.err.println(Strings.Console_Error + console_Error_Text);
	}
	
	public static void print_Console_Single(String consoleText) {
		System.out.print(Strings.Console + consoleText);
	}
	
	public static void print_Console_Information_Single(String console_Information_Text) {
		System.out.print(Strings.Console_Information + console_Information_Text);
	}
	
	public static void print_Console_Error_Single(String console_Error_Text) {
		System.err.print(Strings.Console_Error + console_Error_Text);
	}

	public static String getName() {
		return name;
	}

	public static void setName(String Name) {
		name = Name;
	}

	public static String getVersion() {
		return version;
	}

	public static void setVersion(String Version) {
		version = Version;
	}

	public static String getAuthor() {
		return author;
	}

	public static void setAuthor(String Author) {
		author = Author;
	}

	public static String getConsole() {
		return console;
	}

	public static void setConsole(String Console) {
		console = Console;
	}

	public static String getConsole_Information() {
		return console_Information;
	}

	public static void setConsole_Information(String Console_Information) {
		console_Information = Console_Information;
	}

	public static String getConsole_Error() {
		return console_Error;
	}

	public static void setConsole_Error(String Console_Error) {
		console_Error = Console_Error;
	}
}
