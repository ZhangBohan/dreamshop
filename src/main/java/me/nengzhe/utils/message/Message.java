package me.nengzhe.utils.message;

import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

/**
 * User: bohan
 * Date: 8/25/13
 * Time: 3:18 PM
 */
public class Message {
    private List<Message> messages;

    private MessageLevel level;
    private String message;

    public Message() {
        this.messages = new ArrayList<Message>();
    }

    public void addToModel(Model model) {
        model.addAttribute("messages", this.getMessages());
    }

    public void addToRedirectAttributes(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("messages", this.getMessages());
    }

    private Message(MessageLevel level, String message) {
        this.level = level;
        this.message = message;
    }

    private void add(MessageLevel level, String message) {
        this.messages.add(new Message(level, message));
    }

    public void success(String message) {
        this.add(MessageLevel.success, message);
    }

    public void error(String message) {
        this.add(MessageLevel.danger, message);
    }

    public void info(String message) {
        this.add(MessageLevel.information, message);
    }

    public void warning(String message) {
        this.add(MessageLevel.warning, message);
    }

    public List<Message> getMessages() {
        return messages;
    }

    public MessageLevel getLevel() {
        return level;
    }

    public String getMessage() {
        return message;
    }
}