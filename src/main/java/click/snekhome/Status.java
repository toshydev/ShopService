package click.snekhome;

public enum Status {
    ACTIVE(200, "Active"),
    DONE(201, "Done");
    private int code;
    private String message;

    Status(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
