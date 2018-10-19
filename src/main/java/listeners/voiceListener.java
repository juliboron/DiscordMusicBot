package listeners;

import net.dv8tion.jda.core.events.guild.voice.GuildVoiceJoinEvent;
import net.dv8tion.jda.core.events.guild.voice.GuildVoiceLeaveEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class voiceListener extends ListenerAdapter {

    @Override
    public void onGuildVoiceJoin(GuildVoiceJoinEvent event){
        event.getGuild().getTextChannelsByName("voicelog", true).get(0).sendMessage(
                "Member " + event.getVoiceState().getMember().getUser().getName() + " joined voice channel " + event.getChannelJoined().getName()
        ).queue();
    }

    @Override
    public void onGuildVoiceLeave(GuildVoiceLeaveEvent event){
        event.getGuild().getTextChannelsByName("voicelog", true).get(0).sendMessage(
                "Member " + event.getVoiceState().getMember().getUser().getName() + " left " + event.getChannelLeft().getName()
        ).queue();
    }

}
