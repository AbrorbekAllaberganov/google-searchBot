package searchBot;


import image.ImageService;
import imageJson.ImageResponse;
import imageJson.ImageResultsItem;
import imageJson.Link;
import news.NewsService;
import newsJson.EntriesItem;
import newsJson.NewsResponse;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import wikiJson.ResultsItem;
import wikiJson.WikiResponse;
import wikipediya.WikipediyaService;

import java.util.*;

public class ApplicationBot extends TelegramLongPollingBot {

    public static void main(String[] args) {
        ApiContextInitializer.init();

        TelegramBotsApi botsApi = new TelegramBotsApi();
        try {
            botsApi.registerBot(new ApplicationBot());
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }
    }
    private final String USERNAME = "GoogledanTopBot";
    private final String TOKEN = "2122784533:AAGnW5kvbMOIcM0zDRx-LnwNIUDZ64O2qAA";

    @Override
    public String getBotUsername() {
        return this.USERNAME;
    }

    @Override
    public String getBotToken() {
        return this.TOKEN;
    }

    static Map<Long, Integer> user_action = new HashMap<>();

    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();

        SendPhoto sendPhoto = new SendPhoto();

        if (update.hasMessage() && update.getMessage().hasText()) {
            SendMessage sendMessage = new SendMessage();
            String text = message.getText();

            if (text.equals("/start")) {
                sendMessage
                        .setChatId(message.getChatId())
                        .setText("GOOGLE ga xush kelibsiz")
                        .setReplyMarkup(Order());

                try {
                    execute(sendMessage);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
                user_action.put(message.getChatId(), 0);
            }
            else if (text.equals("Rasm qidirish")) {
                user_action.put(message.getChatId(), 1);
                sendMessage
                        .setChatId(message.getChatId())
                        .setText("Rasm mavzusini tanlang");

                try {
                    execute(sendMessage);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            else if (text.equals("Yangiliklar")) {
                user_action.put(message.getChatId(), 2);
                sendMessage
                        .setChatId(message.getChatId())
                        .setText("Mavzuni kiriting");
                try {
                    execute(sendMessage);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            else if (text.equals("Wikipediya")) {
                user_action.put(message.getChatId(), 3);
                sendMessage
                        .setText("Qaysi mavzuda ma'lumot qidiryapsiz")
                        .setChatId(message.getChatId());

                try {
                    execute(sendMessage);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            else if (user_action.get(message.getChatId()) == 1) {
                Link link = getImage(text);
                sendPhoto
                        .setChatId(message.getChatId())
                        .setPhoto(link.getHref())
                        .setCaption(link.getTitle() + "\n" + link.getDomain());


                try {
                    execute(sendPhoto);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }

            }
            else if (user_action.get(message.getChatId()) == 2) {
                EntriesItem entriesItem = getNews(text);
                sendMessage
                        .setChatId(message.getChatId())
                        .setText("Mavzu : " + entriesItem.getTitle() + "\nHavola :"
                                + entriesItem.getLink());
                try {
                    execute(sendMessage);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            else if (user_action.get(message.getChatId()) == 3) {
                ResultsItem result = getWiki(text);

                sendMessage
                        .setChatId(message.getChatId())
                        .setText("Mavzu : " + result.getTitle() + "\n\n" +
                                "Ma'lumot : " + result.getDescription() + "\n\n" +
                                "Havola : " + result.getLink());

                try {
                    execute(sendMessage);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public ReplyKeyboardMarkup Order() {
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setResizeKeyboard(true);

        List<KeyboardRow> rows = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();

        KeyboardButton button = new KeyboardButton().setText("Wikipediya");
        row.add(button);
        button = new KeyboardButton().setText("Rasm qidirish");
        row.add(button);
        rows.add(row);

        row = new KeyboardRow();

        button = new KeyboardButton().setText("Yangiliklar");
        row.add(button);
        rows.add(row);

        markup.setKeyboard(rows);

        return markup;
    }

    public Link getImage(String text) {
        ImageService imageService = new ImageService();

        ImageResponse image = imageService.getImages(text);
        List<ImageResultsItem> imageResults = image.getImageResults();

        Random random = new Random();
        int index = random.nextInt(imageResults.size());

        return imageResults.get(index).getLink();

    }

    public EntriesItem getNews(String text) {
        NewsService newsService = new NewsService();
        NewsResponse newsResponse = newsService.getNews(text);
        List<EntriesItem> entriesItems = newsResponse.getEntries();

        Random random = new Random();
        int index = random.nextInt(entriesItems.size());

        return entriesItems.get(index);
    }

    public ResultsItem getWiki(String text) {
        WikipediyaService wikipediyaService = new WikipediyaService();
        WikiResponse wikiResponse = wikipediyaService.getWikipediya(text);

        List<ResultsItem> resultsItemList = wikiResponse.getResults();

        Random random = new Random();
        int index = random.nextInt(resultsItemList.size());

        return resultsItemList.get(index);
    }

}
