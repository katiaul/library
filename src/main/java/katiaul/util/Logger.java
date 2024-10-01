package katiaul.util;

import java.io.*;
import java.util.regex.*;

@SuppressWarnings("unused")
public class Logger {
	private final String name;
	private final String format;
	
	public Logger() {
		this("Logger");
	}
	
	public Logger(String name) {
		this(name, null);
	}
	
	public Logger(String name, String format) {
		this.name = name;
		this.format = parse(format) ? format : "(%s) -> %s\n";
	}
	
	private boolean parse(String format) {
		if (format == null || format.isEmpty()) return false;
		Matcher matcher = Pattern.compile("[^%s]*%s").matcher(format);
		int parsed = 0;
		while (matcher.find()) {
				parsed++;
		}
		return parsed >= 2;
	}
	
	private void format(PrintStream stream, String string) {
		stream.printf(format, name, string);
	}
	
	public void print(String string) {
		format(System.out, string);
	}
	
	public void print(String string, Object... args) {
		print(String.format(string, args));
	}
	
	public void error(String string) {
		format(System.err, string);
	}
	
	public void error(String string, Object... args) {
		error(String.format(string, args));
	}
}