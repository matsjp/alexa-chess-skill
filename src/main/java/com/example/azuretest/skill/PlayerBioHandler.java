package com.example.azuretest.skill;

import com.amazon.speech.slu.Intent;
import com.amazon.speech.speechlet.Session;
import com.amazon.speech.speechlet.SpeechletResponse;
import com.amazon.speech.ui.PlainTextOutputSpeech;
import com.example.azuretest.helper.AskResponseHelper;

import java.util.ArrayList;
import java.util.Arrays;

public class PlayerBioHandler {

    private ArrayList<String> playerList = new ArrayList<>(Arrays.asList("jose raul capablanca", "mikhail tal", "bobby fisher", "garry kasparov"));

    private ArrayList<String> playerBios = new ArrayList<>(Arrays.asList("Jose Raul Capablanca y Graupera (November 19, 1888 - March 8, 1942) was a Cuban chess player who was world chess champion from 1921 to 1927.",

            "Mikhail Nekhemyevich Tal (November 9, 1936 - June 28, 1992) was a Soviet Latvian chess Grandmaster and the eighth World Chess Champion from 1960 to 1961.",

            "Robert James Fischer (March 9, 1943 - January 17, 2008) was an American chess grandmaster and the eleventh World Chess Champion.",

            "Garry Kimovich Kasparov (April 3, 1963) is a Russian chess grandmaster, former world chess champion, writer, and political activist, who many consider to be the greatest chess player of all time"));

    private Intent intent;
    private Session session;

    private static final String SLOT_DATE = "Date";

    private static final String[] DAY_NAMES = { "sunday", "monday", "tuesday", "wednesday", "thursday", "friday", "saturday", };

    public PlayerBioHandler(Intent intent, Session session) {
        this.intent = intent;
        this.session = session;
    }

    public Intent getIntent() {
        return intent;
    }

    public void setIntent(Intent intent) {
        this.intent = intent;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public SpeechletResponse handleIntent() {
        String playerName = intent.getSlot("player").getValue();

        if (playerName == null){
            PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
            speech.setText("I did not understand the name of that player");
            return AskResponseHelper.newAskResponse(speech.getText(), false, "What do you want to know?", false);
        }

        if (!playerList.contains(playerName)){
            PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
            speech.setText("I did not recognize that name");
            return AskResponseHelper.newAskResponse(speech.getText(), false, "What do you want to know?", false);
        }

        int playerIndex = playerList.indexOf(playerName);
        String playerBio = playerBios.get(playerIndex);

        PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
        speech.setText(playerBio);

        return AskResponseHelper.newAskResponse(speech.getText(), false, "What do you want to know?", false);
    }
}
