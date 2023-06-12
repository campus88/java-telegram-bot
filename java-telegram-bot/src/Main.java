import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;

import java.util.List;

public class Main {
    public static final String BOT_TOKEN = "6289004426:AAFvyK1WhcJJpqZudIQIBWInXiKWy0nZiM8";

    public static void main(String[] args) {
        System.out.println("Hello world!");

        TelegramBot telegramBot = new TelegramBot(BOT_TOKEN);
        telegramBot.setUpdatesListener(new UpdatesListener() {
            @Override
            public int process(List<Update> list) {

                for(Update update : list){
                    SendMessage sendMessage = new SendMessage(update.message().from().id(), "Hello World!");
                    telegramBot.execute(sendMessage);
                }

                return UpdatesListener.CONFIRMED_UPDATES_ALL;
            }
        });

    }
}