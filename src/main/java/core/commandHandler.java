package core;

import commands.Command;

import java.util.HashMap;

public class commandHandler {

    public static final commandParser parse = new commandParser();
    public static HashMap<String, Command> commands = new HashMap<String, Command>();

    public static void handleCommand(commandParser.commandContainer cmd) {

        if (commands.containsKey(cmd.invoke)) {
            boolean safe = commands.get(cmd.invoke).called(cmd.args, cmd.event);
            if (!safe) {
                commands.get(cmd.invoke).action(cmd.args, cmd.event);
                commands.get(cmd.invoke).executed(safe, cmd.event);
            } else {
                commands.get(cmd.invoke).executed(safe, cmd.event);
            }

        }

    }
}
    
    
    /*
    
    public static void handleCommand(commandParser.commandContainer cmd, MessageReceivedEvent event){
        if(commands.containsKey(cmd.invoke)){
            
            boolean safe = commands.get(cmd.invoke).called(cmd.args, cmd.event);

            if (!safe) {
                commands.get(cmd.invoke).action(cmd.args, cmd.event);
                commands.get(cmd.invoke).executed(safe, cmd.event);
            } else {
                commands.get(cmd.invoke).executed(safe, cmd.event);
            }
            
        } else {
            //TODO: !Help Message
            System.out.println("[CMD Handler]:  ERROR");
        }
    }

    */


    

