class Remote {
    Device d;

    Remote(Device d) {
        this.d = d;
    }

    void togglePower() { 
        if (d.isEnabled()) {
            d.disable();
            System.out.println("Device turned off");
        } else {
            d.enable();
            System.out.println("Device turned on");
        }
    }

    void volumeDown() {
        if (d.isEnabled()) {
            System.out.println("Volume reduced by 1");
            d.setVolume(d.getVolume() - 1);
        } else {
            System.out.println("Enable the device first");
        }
    }

    void volumeUp() {
        if (d.isEnabled()) {
            System.out.println("Volume increased by 1");
            d.setVolume(d.getVolume() + 1);
        } else {
            System.out.println("Enable the device first");
        }
    }

    void channelDown() {
        if (d.isEnabled()) {
            System.out.println("Channel reduced by 1");
            d.setChannel(d.getChannel() - 1);
        } else {
            System.out.println("Enable the device first");
        }
    }

    void channelUp() {
        if (d.isEnabled()) {
            System.out.println("Channel increased by 1");
            d.setChannel(d.getChannel() + 1);
        } else {
            System.out.println("Enable the device first");
        }
    }
}