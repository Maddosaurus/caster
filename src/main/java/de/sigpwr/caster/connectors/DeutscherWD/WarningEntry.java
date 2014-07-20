package de.sigpwr.caster.connectors.DeutscherWD;

/**
 * Created by Shivy on 20.07.2014.
 */
public class WarningEntry {
    String title;
    String city;
    String from;
    String to;
    String author;
    String date;
    String text;
    String forecastCenter;

    public WarningEntry() {
    }

    public void set(int line, String value){
        switch(line){
            case 0: setTitle(value); break;
            case 1: setCity(value); break;
            case 2: setFrom(value); break;
            case 3: setTo(value); break;
            case 4: setAuthor(value); break;
            case 5: setDate(value); break;
        }
    }

    @Override
    public String toString() {
        return title + "\n" +
                city + "\n" +
                from + "\n" +
                to + "\n" +
                author + "\n" +
                date + "\n" +
                text + "\n" +
                forecastCenter + "\n";
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void addText(String text) {
        if(this.text == null)
            this.text=text;
        else
            this.text += text;
    }

    public String getForecastCenter() {
        return forecastCenter;
    }

    public void setForecastCenter(String forecastCenter) {
        this.forecastCenter = forecastCenter;
    }
}
