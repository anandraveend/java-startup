package com.anand.design.pattern.builder;

public class Computer {
    private String ram;
    private String hdd;

    private Computer(ComputerBuilder cb){
        this.hdd = cb.hdd;
        this.ram=cb.ram;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getHdd() {
        return hdd;
    }

    public void setHdd(String hdd) {
        this.hdd = hdd;
    }

    public static class ComputerBuilder{
        private String hdd;
        private String ram;
        public ComputerBuilder(String hdd, String ram){
            this.hdd = hdd;
            this.ram = ram;
        }
        public Computer build(){
            return new Computer(this);
        }
    }
}
