package testCommons;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * A class to help testers execute terminal commands
 * @author daniellegolinsky
 *
 */
public class CommandExecutor {

	public static String executeCommand(String command){
		return executeCommand(command, true);
	}
	
	/**
	 * Simple method to execute a bash command
	 * @param command
	 * @param displayError
	 * @return
	 */
	public static String executeCommand(String command, boolean displayError){
		StringBuilder output = new StringBuilder();
		Process p = null;
		
		if (command != null && command.length() > 0){
			// Enter the given command
			try{
				p = Runtime.getRuntime().exec(command);
			}
			catch(Exception e){
				if (displayError){
					System.err.println("\nCould not execute command. Stack trace below.\n");
					e.printStackTrace();
				}
			}

			// Collect the output
			if (p != null){
				try(BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()))){
					String line = "";
					while ((line = br.readLine()) != null){
						output.append(line + "\n");
					}
				}
				catch(Exception e){
					if (displayError){
						System.err.println("\nCould not get output from command.");
						e.printStackTrace();
					}
				}
			}
		}
		
		return output.toString();
	}
}
