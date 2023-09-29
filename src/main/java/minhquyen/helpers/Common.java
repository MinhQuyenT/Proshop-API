package minhquyen.helpers;

public enum Common {
    DEV("https://deezerdevs-deezer.p.rapidapi.com/infos"),
    LOGIN("http://localhost:81/api/beginsession"),
    USERNAME("ProShop"),
    PASSWORD("ProShop"),
    SCOPE("ProShop");
    private String url;
    private String info;
    Common(String envUrl) {
        this.url = envUrl;
        this.info = envUrl;
    }
    public String getUrl() {
        return url;
    }
    public String getinfo() {
        return info;
    }
}
