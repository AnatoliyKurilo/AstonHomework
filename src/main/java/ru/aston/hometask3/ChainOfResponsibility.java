package ru.aston.hometask3;

abstract class SupportHandler {
    protected SupportHandler next;

    public void setNext(SupportHandler next) {
        this.next = next;
    }

    public abstract void handleRequest(String issue, int severity);
}

class JuniorSupport extends SupportHandler {
    @Override
    public void handleRequest(String issue, int severity) {
        if (severity <= 2) {
            System.out.println("Junior решил проблему: " + issue);
        } else if (next != null) {
            next.handleRequest(issue, severity);
        }
    }
}

class SeniorSupport extends SupportHandler {
    @Override
    public void handleRequest(String issue, int severity) {
        if (severity <= 4) {
            System.out.println("Senior решил проблему: " + issue);
        } else if (next != null) {
            next.handleRequest(issue, severity);
        }
    }
}

class ManagerSupport extends SupportHandler {
    @Override
    public void handleRequest(String issue, int severity) {
        System.out.println("Менеджер решил проблему: " + issue + " (критичность " + severity + ")");
    }
}

public class ChainOfResponsibility {
    public static void main(String[] args) {
        JuniorSupport junior = new JuniorSupport();
        SeniorSupport senior = new SeniorSupport();
        ManagerSupport manager = new ManagerSupport();

        junior.setNext(senior);
        senior.setNext(manager);

        junior.handleRequest("Не запускается приложение", 1);
        junior.handleRequest("База данных недоступна", 3);
        junior.handleRequest("Система не отвечает", 5);
    }
}