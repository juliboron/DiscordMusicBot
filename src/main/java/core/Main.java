package core;

import commands.Music;
import commands.cmdAdmin;
import commands.cmdPing;
import listeners.commandListener;
import listeners.voiceListener;
import listeners.readyListener;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Game;
import util.SECRETS;

import javax.security.auth.login.LoginException;

public class Main {

    public static JDABuilder builder;

    public static void main(String[] args){

        builder = new JDABuilder(AccountType.BOT);

        builder.setToken(SECRETS.getTOKEN());
        builder.setAutoReconnect(true);
        builder.setStatus(OnlineStatus.ONLINE);
        builder.setGame(Game.playing("v. 1.0.1"));

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
        builder.addEventListener(new readyListener());
        builder.addEventListener(new voiceListener());
        builder.addEventListener(new commandListener());

        System.out.println("Listeners initialized");
    }

    public static void initCommadns(){
        commandHandler.commands.put("ping", new cmdPing());
        commandHandler.commands.put("admin", new cmdAdmin());
        commandHandler.commands.put("m", new Music());
        commandHandler.commands.put("music", new Music());

        System.out.println("Commands initialized");
    }
}
