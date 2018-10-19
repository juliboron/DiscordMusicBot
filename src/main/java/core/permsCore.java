package core;

import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import util.STATICS;

import java.lang.reflect.Array;
import java.util.Arrays;

public class permsCore {

    public static boolean check(MessageReceivedEvent event){

        boolean hasPerm = true;

        for (Role r: event.getGuild().getMember(event.getAuthor()).getRoles()) {

            if (Arrays.stream(STATICS.perms).parallel().anyMatch(r.getName()::contains)){
                System.out.println("[permsCore]:        "+ event.getAuthor().getName() +" has permission");
                hasPerm = false;
            }

        }


        if (hasPerm != true){
            return false;
        } else {
            event.getTextChannel().sendMessage(
                    ":warning:  Sorry " + event.getAuthor().getAsMention() + ", you don't have the permission to execute this command!"
            ).queue();
            System.out.println("[permsCore]:        "+ event.getAuthor().getName()+" has no permission");
            return true;
        }

    }

}
