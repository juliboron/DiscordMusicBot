package listeners;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.guild.voice.GuildVoiceJoinEvent;
import net.dv8tion.jda.core.events.guild.voice.GuildVoiceLeaveEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class voiceListener extends ListenerAdapter {

    @Override
    public void onGuildVoiceJoin(GuildVoiceJoinEvent event){
        event.getGuild().getTextChannelsByName("voicelog", true).get(0).sendMessage(
                ":inbox_tray:Member **" + event.getVoiceState().getMember().getUser().getName() + "** joined voice channel **" + event.getChannelJoined().getName() + "**"
        ).queue();
    }

    @Override
    public void onGuildVoiceLeave(GuildVoiceLeaveEvent event){
        event.getGuild().getTextChannelsByName("voicelog", true).get(0).sendMessage(
                ":outbox_tray:Member **" + event.getVoiceState().getMember().getUser().getName() + "** left voice channel **" + event.getChannelLeft().getName() +"**"
        ).queue();
    }

}
