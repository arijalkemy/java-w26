package view.options;


public abstract class AbstractOption implements IOption {
    

    protected String messageOption;
    protected int id;

    public String getMessageOption() {
        return messageOption;
    }

    public void setMessageOption(String messageOption) {
        this.messageOption = messageOption;
    }

    @Override
    public String getId() {
        return String.valueOf(id);
    }
}
