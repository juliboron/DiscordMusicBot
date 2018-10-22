package listeners;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageEmbed;
import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import javax.swing.*;
import java.awt.*;

import java.awt.*;

public class readyListener extends ListenerAdapter {

    @Override
    public void onReady(ReadyEvent event){

        String out = "\n[readyListener]:    This bot is running on following Servers:  \n";

        for (Guild g : event.getJDA().getGuilds()) {
            out += "                    " + g.getName() + " (" + g.getId() + ") \n";
        }

        System.out.println(out);



        //TODO: Ready Message and Playing Version Function
        for (Guild g : event.getJDA().getGuilds()) {
            g.getTextChannels().get(0).sendMessage(
                    (Message) new EmbedBuilder()
                    .setColor(new Color(225,255,255))
                    .setDescription("***I'M BACK***")
                    .addField("**Current Verison**", "", false)
            ).queue();
        }


        System.out.println("[readyListener]:    Bot is ready");
    }
}
