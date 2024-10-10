interface Device {
    boolean isEnabled();
    void enable();
    void disable();
    int getVolume();
    void setVolume(int vol);
    int getChannel();
    void setChannel(int channel);
}