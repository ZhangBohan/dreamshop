package me.nengzhe.utils.message;

/**
 * User: bohan
 * Date: 8/25/13
 * Time: 3:18 PM
 */
public enum MessageLevel {
    success("success", "恭喜！"),
    information("info", "信息！"),
    warning("warning", "注意！"),
    danger("danger", "错误！");

    private String level;
    private String title;

    MessageLevel(String level, String tilte) {
        this.level = level;
        this.title = tilte;
    }

    String getTitle() {
        return title;
    }

    void setTitle(String title) {
        this.title = title;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
