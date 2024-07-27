package xyz.blobsu.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import xyz.blobsu.userData.*;

import java.awt.*;
import java.time.Instant;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class osu extends ListenerAdapter {

    // rxMania, and all autopilot gamemodes apart from standard are unused
    private final String[] gamemodes = new String[]{"std", "taiko", "ctb", "mania", "rxStd", "rxTaiko"
            , "rxCatch", "rxMania", "autoStd", "autoTaiko", "autoCatch", "autoMania"};


    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        String command = event.getName();
        String userName;
        String mode;

        if (command.equals("osu")) {
            OptionMapping nameOption = event.getOption("name");
            OptionMapping modeOption = event.getOption("mode");
            if (nameOption == null) {

                event.reply("Please provide a valid username.").setEphemeral(true).queue();
                return;
            } else if (modeOption == null) {
                event.reply("Please pick a valid Gamemode").setEphemeral(true).queue();

            }

            userName = nameOption.getAsString();
            mode = modeOption.getAsString();

            event.deferReply().queue();

            CompletableFuture.runAsync(() -> {
                PlayerInfoResponse response = PlayerInfoFetcher.fetchPlayerInfo(userName);

                if (response != null && response.getStatus().equals("success")) {
                    Player player = response.getPlayer();
                    Info playerInfo = player.getInfo();
                    Map<String, ModeStats> stats = player.getStats();

                    //Fields

                    String userURL = "https://blobsu.xyz/user/" + playerInfo.getId();
                    String userCountryCode = playerInfo.getCountry();
                    String userLastSeen = playerInfo.getLatestActivity() + "000";
                    String flagAPI = String.format("https://flagsapi.com/%s/flat/64.png", userCountryCode.toUpperCase());
                    int userId = playerInfo.getId();


                    EmbedBuilder embedOsu = null;
                    for (Map.Entry<String, ModeStats> entry : stats.entrySet()) {
                        ModeStats modeStats = entry.getValue();
                        String modeName = getModeName(modeStats.getMode());

                        int playTime = modeStats.getPlaytime() / 3600;

                        String iconURL = "https://cdn.discordapp.com/attachments/1257066623899144323/1257686870322843812/discordidk.png?ex=66a0566c&is=669f04ec&hm=48c9e28deac236f407125616f0041a1da5af3ac02b4f0baa7460126578ead2d4&";
                        if (modeName.equalsIgnoreCase(mode)) {
                            embedOsu = new EmbedBuilder()
                                    .setColor(Color.CYAN)
                                    .setThumbnail("https://a.blobsu.xyz/" + userId)
                                    .setAuthor(String.format("osu!%s profile for ", modeName) + playerInfo.getName(), userURL, flagAPI)
                                    .setUrl(userURL)
                                    .setDescription(
                                            String.format("- **Rank:** #%d (%s#%d) \n" +
                                                            "- **PP:** %dpp **Acc:** %.2f%%\n" +
                                                            "- **Playcount:** %d (%d hrs) \n"
                                                    , modeStats.getRank(), playerInfo.getCountry().toUpperCase(), modeStats.getCountryRank()
                                                    , modeStats.getPp(), modeStats.getAcc(), modeStats.getPlays(), playTime).replace(",", "."))
                                    .setTimestamp(Instant.ofEpochMilli(Long.parseLong(userLastSeen)))
                                    .setFooter("Last Seen ", iconURL);

                        }


                    }

                    MessageEmbed embed = embedOsu.build();
                    event.getHook().editOriginalEmbeds(embed).queue();
                } else {
                    event.getHook().editOriginal("Player Does Not exist on Blobsu.").queue();

                }
            });
        }
    }

    private String getModeName(int mode) {
        return switch (mode) {
            case 0 -> gamemodes[0];
            case 1 -> gamemodes[1];
            case 2 -> gamemodes[2];
            case 3 -> gamemodes[3];
            case 4 -> gamemodes[4];
            case 5 -> gamemodes[5];
            case 6 -> gamemodes[6];
            case 7 -> gamemodes[8];
            default -> "Unknown";
        };
    }

}





