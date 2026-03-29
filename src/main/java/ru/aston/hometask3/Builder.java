package ru.aston.hometask3;

// Продукт
class Computer {
    private String cpu;
    private String ram;
    private String storage;
    private String gpuEnabled;
    private boolean wifiEnabled;

    private Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
        this.gpuEnabled = builder.gpuEnabled;
        this.wifiEnabled = builder.wifiEnabled;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "cpu='" + cpu + '\'' +
                ", ram='" + ram + '\'' +
                ", storage='" + storage + '\'' +
                ", gpuEnabled=" + gpuEnabled +
                ", wifiEnabled=" + wifiEnabled +
                '}';
    }

    // Статический вложенный класс Builder
    public static class Builder {
        private String cpu;
        private String ram;
        private String storage;
        private String gpuEnabled;
        private boolean wifiEnabled;

        public Builder setCpu(String cpu) {
            this.cpu = cpu;
            return this;
        }

        public Builder setRam(String ram) {
            this.ram = ram;
            return this;
        }

        public Builder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public Builder enableGpu(String enable) {
            this.gpuEnabled = enable;
            return this;
        }

        public Builder enableWifi(boolean enable) {
            this.wifiEnabled = enable;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}

// Демонстрация
public class Builder {
    public static void main(String[] args) {
        Computer gamingPC = new Computer.Builder()
                .setCpu("Intel i9")
                .setRam("32GB")
                .setStorage("1TB SSD")
                .enableGpu("Nvidia RTX 5090")
                .enableWifi(true)
                .build();

        Computer officePC = new Computer.Builder()
                .setCpu("Intel i5")
                .setRam("16GB")
                .setStorage("512GB SSD")
                .build();

        System.out.println(gamingPC);
        System.out.println(officePC);
    }
}