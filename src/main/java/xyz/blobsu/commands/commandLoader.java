package xyz.blobsu.commands;

import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class commandLoader extends ListenerAdapter {
    private final String[] gamemodes = new String[]{"std", "taiko", "ctb", "mania", "rxStd", "rxTaiko"
            , "rxCatch", "rxMania", "autoStd", "autoTaiko", "autoCatch", "autoMania"};

    @Override
    public void onGuildReady(@NotNull GuildReadyEvent event) {
        List<CommandData> commandData = new ArrayList<>();

        OptionData userName = new OptionData(OptionType.STRING, "name", "the username of the player", true);
        OptionData modeOption = new OptionData(OptionType.STRING, "mode", "Which mode stats are you looking for", false)
                .addChoice("Standard", gamemodes[0])
                .addChoice("Taiko", gamemodes[1])
                .addChoice("Catch the Beat", gamemodes[2])
                .addChoice("Mania", gamemodes[3])
                .addChoice("StandardRX", gamemodes[4])
                .addChoice("TaikoRX", gamemodes[5])
                .addChoice("Catch the beat RX", gamemodes[6])
                .addChoice("StandardAP", gamemodes[8]);

        commandData.add(Commands.slash("osu", "View your osu profile!")
                .addOptions(userName)
                .addOptions(modeOption));
        commandData.add(Commands.slash("osutop", "Get your top 5 plays!")
                .addOptions(userName)
                .addOptions(modeOption));

        event.getGuild().updateCommands().addCommands(commandData).queue();
        System.out.println("Succesfully Loaded commands!");
    }
}
