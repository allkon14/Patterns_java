class Computer {
    
    private String HDD;
    private String RAM;
    
    private boolean isGraphicsCardEnabled;
    private boolean isBluetoothEnabled;


    public String getHDD() {
        return HDD;
    }

    public String getRAM() {
        return RAM;
    }

    public boolean isGraphicsCardEnabled() {
        return isGraphicsCardEnabled;
    }

    public boolean isBluetoothEnabled() {
        return isBluetoothEnabled;
    }

    private Computer(ComputerBuilder builder) {
        this.HDD=builder.HDD;
        this.RAM=builder.RAM;
        this.isGraphicsCardEnabled=builder.isGraphicsCardEnabled;
        this.isBluetoothEnabled=builder.isBluetoothEnabled;
    }

    public void PrintInfo(){
        System.out.println("Added new computer: \nHDD: "+ getHDD().toString()+
                 "\nRAM: " + getRAM().toString()+"\nGraphics Cart Enabled: "+isGraphicsCardEnabled +
                "\nBluetooth Enabled: "+isBluetoothEnabled);
        System.out.println();
    }
    
    public static class ComputerBuilder{
        private String HDD;
        private String RAM;
        
        private boolean isGraphicsCardEnabled;
        private boolean isBluetoothEnabled;

        public ComputerBuilder(String hdd, String ram){
            this.HDD=hdd;
            this.RAM=ram;
        }

        public ComputerBuilder setGraphicsCardEnabled(boolean isGraphicsCardEnabled) {
            this.isGraphicsCardEnabled = isGraphicsCardEnabled;
            return this;
        }

        public ComputerBuilder setBluetoothEnabled(boolean isBluetoothEnabled) {
            this.isBluetoothEnabled = isBluetoothEnabled;
            return this;
        }

        public Computer build(){
            return new Computer(this);
        }
    }

}
public class Builder {

    public static void main(String[] args) {
        Computer comp = new Computer.ComputerBuilder(
                "500 GB", "2 GB").setBluetoothEnabled(true)
                .setGraphicsCardEnabled(true).build();
        comp.PrintInfo();

        Computer comp2 = new Computer.ComputerBuilder(
                "512 GB", "4 GB").setBluetoothEnabled(false)
                .setGraphicsCardEnabled(true).build();
        comp2.PrintInfo();
    }
}
