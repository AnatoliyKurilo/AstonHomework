package ru.aston.hometask3;
// Файл Chief.java

interface Chief {

    public Object makeBreakfast();
    public Object makeDinner();
    public Object makeSupper();

}

class Plumber {

    public Object getPipe() {
        return new Object();
    }

    public Object getKey() {
        return new Object();
    }

    public Object getScrewDriver() {
        return new Object();
    }

}

class ChiefAdapter implements Chief {

    private Plumber plumber = new Plumber();

    @Override
    public Object makeBreakfast() {
        return plumber.getKey();
    }

    @Override
    public Object makeDinner() {
        return plumber.getScrewDriver();
    }

    @Override
    public Object makeSupper() {
        return plumber.getPipe();
    }

}

public class Adapter {

    public static void main(String [] args) {
        Chief chief = new ChiefAdapter();

        Object key = chief.makeDinner();
    }

}