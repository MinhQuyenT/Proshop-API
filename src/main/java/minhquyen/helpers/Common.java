package minhquyen.helpers;

public enum Common {
    DEV("https://deezerdevs-deezer.p.rapidapi.com/infos"),
    LOGIN("http://localhost:81/api/beginsession");
    private String url;
    Common(String envUrl) {
        this.url = envUrl;
    }
    public String getUrl() {
        return url;
    }
}
