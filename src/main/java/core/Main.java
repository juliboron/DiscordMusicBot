package core;

import commands.CmdPing;
import commands.Command;
import listeners.CommandListener;
import listeners.VoiceListener;
import listeners.ReadyListener;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
import util.SECRETS;

import javax.security.auth.login.LoginException;

public class Main {

    public static JDABuilder builder;

    public static void main(String[] args){

        builder = new JDABuilder(AccountType.BOT);

        builder.setToken(SECRETS.getTOKEN());
        builder.setAutoReconnect(true);
        builder.setStatus(OnlineStatus.ONLINE);

        initListeners();
        initCommadns();

        try {
            JDA jda = builder.buildBlocking();
        } catch (LoginException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }



    public static void initListeners(){
        //TODO: Listeners
        builder.addEventListener(new ReadyListener());
        builder.addEventListener(new VoiceListener());
        builder.addEventListener(new CommandListener());

        System.out.println("Listeners initialized");
    }

    public static void initCommadns(){
        CommandHandler.commands.put("ping", new CmdPing());

        System.out.println("Commands initialized");
    }
}
