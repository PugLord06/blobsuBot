package xyz.blobsu.commands;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;

import java.awt.*;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

// Add your Score and ScoreResponse models
import org.jetbrains.annotations.NotNull;
import xyz.blobsu.scoreData.Score;
import xyz.blobsu.scoreData.ScoreResponse;
import xyz.blobsu.userData.*;


public class OsuTop extends ListenerAdapter {

    private static final String OSU_API_URL = "https://api.blobsu.xyz/v1/get_player_scores?scope=best&mode=";
    private final String[] gamemodes = new String[]{"std", "taiko", "ctb", "mania", "rxStd", "rxTaiko"
            , "rxCatch", "rxMania", "autoStd", "autoTaiko", "autoCatch", "autoMania"};

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        event.deferReply().queue();
        if (event.getName().equals("osutop")) {
            OptionMapping usernameOption = event.getOption("name");
            OptionMapping gamemodeOption = event.getOption("mode");
            if (usernameOption != null && gamemodeOption != null) {
                String username = usernameOption.getAsString();
                int mode = getModeNumber(gamemodeOption.getAsString());
                System.out.println(gamemodeOption.getAsString());
                System.out.println(mode);
                fetchAndDisplayOsuTopScores(event, username, mode);
            } else {
                event.reply("Please provide a valid Blobsu! username.").queue();
            }
        }
    }

    private void fetchAndDisplayOsuTopScores(SlashCommandInteractionEvent event, String username, int mode) {
        try {
            // Encode the username
            String encodedUsername = URLEncoder.encode(username, StandardCharsets.UTF_8);
            String endcodedMode = URLEncoder.encode(String.valueOf(mode), StandardCharsets.UTF_8);
            URL url = new URL(OSU_API_URL + endcodedMode + "&name=" + encodedUsername);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            // Read response
            Scanner scanner = new Scanner(url.openStream());
            StringBuilder response = new StringBuilder();
            while (scanner.hasNext()) {
                response.append(scanner.nextLine());
            }
            scanner.close();

            // Parse JSON response
            Gson gson = new Gson();
            ScoreResponse scoreResponse = gson.fromJson(response.toString(), ScoreResponse.class);

            System.out.println(url);
            if ("success".equals(scoreResponse.getStatus())) {
                List<Score> scores = scoreResponse.getScores();
                if (scores.isEmpty()) {
                    event.reply("No scores found for this user.").queue();
                } else {
                    // Limit to 5 scores or less
                    List<Score> limitedScores = scores.size() > 5 ? scores.subList(0, 5) : scores;
                    MessageEmbed embed = createScoreEmbed(limitedScores, username, mode);
                    event.getHook().editOriginalEmbeds(embed).queue();
                }
            } else {
                event.reply("Failed to retrieve scores.").queue();
            }

        } catch (IOException | JsonSyntaxException e) {
            event.reply("Error occurred while fetching scores: " + e.getMessage()).queue();
        }
    }

    private MessageEmbed createScoreEmbed(List<Score> scores, String username, int mode) {

        PlayerInfoResponse response = PlayerInfoFetcher.fetchPlayerInfo(username);

        if (response != null && response.getStatus().equals("success")) {
            EmbedBuilder embedBuilder = getEmbedBuilder(username, mode, response);

            String beatmapURlSkeleton = "https://osu.ppy.sh/beatmapsets/";

            for (Score score : scores) {
                int index = 1;
                if (score.getMode() == mode) {


                    embedBuilder.addField(
                             " ",
                            "**[" + score.getBeatmap().getArtist() + " - "
                                    + score.getBeatmap().getTitle() + "]("
                                    +beatmapURlSkeleton + score.getBeatmap().getSet_id() + ")**\n"+
                            "Score: " + score.getScore() + "\n" +
                                    "PP: " + score.getPp() + "\n" +
                                    "Accuracy: " + score.getAcc() + "%\n" +
                                    "Combo: x" + score.getMaxCombo() + "/" + score.getBeatmap().getMaxCombo() + "\n" +
                                    "Mods: " + score.getMods() + "\n",

                            false
                    );
                }
            }
            return embedBuilder.build();
        }

        return null;
    }

    private @NotNull EmbedBuilder getEmbedBuilder(String username, int mode, PlayerInfoResponse response) {
        Player player = response.getPlayer();
        Info playerInfo = player.getInfo();
        Map<String, ModeStats> stats = player.getStats();

        String userURL = "https://blobsu.xyz/user/" + playerInfo.getId();
        String userCountryCode = playerInfo.getCountry();
        String flagAPI = String.format("https://flagsapi.com/%s/flat/64.png", userCountryCode.toUpperCase());
        String iconURL = "https://cdn.discordapp.com/attachments/1257066623899144323/1257686870322843812/discordidk.png?ex=66a0566c&is=669f04ec&hm=48c9e28deac236f407125616f0041a1da5af3ac02b4f0baa7460126578ead2d4&";


        EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setAuthor("Top osu!" + getModeName(mode) + " Plays for " + playerInfo.getName(), userURL, flagAPI);
        embedBuilder.setColor(Color.cyan);
        embedBuilder.setThumbnail("https://a.blobsu.xyz/" + playerInfo.getId());
        embedBuilder.setFooter("On Blobsu Server", iconURL);
        return embedBuilder;
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

    private int getModeNumber(String gamemode) {
        int result = 0;

        for (int i = 0; i < gamemodes.length; i++) {
            if (gamemode.equalsIgnoreCase(gamemodes[i])) {
                result = i;
                System.out.println(result);
            }
        }
        return result;
    }

}
