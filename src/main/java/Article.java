public class Article {
    private String title;
    private String content;

    public Article() {
        this.title = "";
        this.content = "";
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

}
