package me.nengzhe.utils;

import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

/**
 * User: bohan
 * Date: 8/16/13
 * Time: 6:29 PM
 */
public class Messages {
    private List<Message> messages;

    public Messages() {
        messages = new ArrayList<Message>();
    }

    public void addToModel(Model model) {
        model.addAttribute("messages", this.getMessages());
    }

    public void addToRedirectAttributes(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("messages", this.getMessages());
    }

    public List<Message> getMessages() {
        return messages;
    }
}

class Message {
    private MessageLevel level;
    private String message;

    MessageLevel getLevel() {
        return level;
    }

    void setLevel(MessageLevel level) {
        this.level = level;
    }

    String getMessage() {
        return message;
    }

    void setMessage(String message) {
        this.message = message;
    }
}

enum MessageLevel {
    success("success"),
    information("info"),
    warning("warning"),
    error("error");

    private String level;

    MessageLevel(String level) {
        this.level = level;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}