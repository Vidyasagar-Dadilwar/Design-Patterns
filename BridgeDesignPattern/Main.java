public class Main {
    public static void main(String[] args) {
        Device radio = new Radio();
        Device tv = new TV();

        Remote basicRemote = new Remote(radio);
        AdvancedRemote advancedRemote = new AdvancedRemote(tv);

        basicRemote.togglePower(); 
        basicRemote.volumeUp(); 
        basicRemote.channelUp(); 
        basicRemote.togglePower(); 
        System.out.println(); 
        
        advancedRemote.togglePower(); 
        advancedRemote.volumeDown(); 
        advancedRemote.mute(); 
        advancedRemote.channelDown(); 
        advancedRemote.togglePower();
    }
} 