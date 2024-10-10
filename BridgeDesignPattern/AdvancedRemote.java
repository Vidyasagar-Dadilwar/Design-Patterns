class AdvancedRemote extends Remote {
    AdvancedRemote(Device d) {
        super(d);
    }

    void mute() {
        if (d.isEnabled()) {
            System.out.println("Device muted");
            d.setVolume(0);
        }
    }
}